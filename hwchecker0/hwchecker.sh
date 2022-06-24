#echo "starting"

javac -cp junit-platform-console-standalone-1.3.2.jar:cis110.jar:jackson-annotations-2.13.3.jar:jackson-core-2.13.3.jar:jackson-databind-2.13.3.jar:. HWChecker.java Snapshot.java Student.java

i=0;
#prevFileName=""
find homework -name "*.java" | sort | while read filename
do
    #echo "in loop, file = $filename"
    #remove prevFileName if exists
    echo $i;

    parts=(${filename//\// })
	studentid=${parts[1]}
	classname=${parts[2]%%-*} 
	timestamp=${parts[2]#*-}
	timestamp=${timestamp%.*}

	if [ "$classname" == "HelloWorld" ] || [ "$classname" == "MySketch" ]
	then 

		cleanfilename="${classname}.java"
		classfilename="${classname}.class"
		#prevFileName=${cleanfilename}

		#echo "file names: ${filename} ${cleanfilename}"

		cp ${filename} ${cleanfilename}

		javac -cp junit-platform-console-standalone-1.3.2.jar:cis110.jar:jackson-annotations-2.13.3.jar:jackson-core-2.13.3.jar:jackson-databind-2.13.3.jar:. *.java

		compiled=$?
		#echo $compiled

		java -cp junit-platform-console-standalone-1.3.2.jar:cis110.jar:jackson-annotations-2.13.3.jar:jackson-core-2.13.3.jar:jackson-databind-2.13.3.jar:. HWChecker ${studentid} ${cleanfilename} ${timestamp} ${compiled} &

		sleep 1
		start=$(date +%s)
		current=$(date +%s)
		elapsed=$(($current-$start))
		pid=""

		while [ $elapsed -le 2 ]
		do
			pid=$(ps aux | grep HWChecker | grep -v grep | awk '{print $2}')
			#if pid empty, break
			if [ -z "$pid" ]
			then
	  			break
			fi
			sleep .1
			current=$(date +%s)
			elapsed=$((current-start))
		done
		
		if [ ! -z "$pid" ]
		then
	  		kill $pid
		fi

		rm -f ${cleanfilename} ${classfilename}

	fi
	i=$((i+1))

done







