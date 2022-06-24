# FeedbackTesting
Important files:
hwchecker.sh : shell script to move snapshots into folder with feedback tool
HWChecker.java : runs snapshot, captures error, writes to JSON
Snapshots.json : json file with student id, snapshot info, and error msg

Instructions:
cd into hwchecker0
make sure there are no HelloWorld.java or MySketch.java files in hwchecker0
copy folder with hw0 snapshots into hwchecker0 folder, label the snapshot folder "homework"
make sure Snapshots.json is empty (only contains empty brackets "[]")
run shell script: ./hwchecker.sh
script will print snapshot num to terminal, there are about 4000 snapshots total :')
errors will be written to Snapshots.json
