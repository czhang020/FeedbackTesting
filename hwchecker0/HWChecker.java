import com.fasterxml.jackson.databind.*;
import java.nio.file.*;
import java.util.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class HWChecker {
	
	static boolean runs = false;
	static String error; //error if it does not run 
	static String stackTrace; //stack trace of error if it does not run 
	static Exception exception;
	
	public static void main(String args[]) {
        String id = args[0];
        String filename = args[1];
		int index = filename.indexOf(".");
		filename = filename.substring(0, index);
        String timestamp = args[2];
        String compileString = args[3];
        boolean compiles = true;

		Snapshot snap;

		//only add snapshot for HelloWorld and MySketch files
		//if code doesn't compile, no need to run it
		if (compileString.equals("1")) {
			compiles = false;
			snap = new Snapshot(filename, timestamp, compiles, false, "", "");
		} else {
			runSnapshot(filename);
			if (exception == null) {
				snap = new Snapshot(filename, timestamp, compiles, runs,"", "");
			} else {
				String errorName = exception.getClass().getCanonicalName();
				String msg = findmsg(exception);
				snap = new Snapshot(filename, timestamp, compiles, runs, errorName, msg);
			}
		}
		updateJson(id, snap);

    }
    
    public static void runSnapshot(String filename) { 
		//System.out.println("runSnapshot: " + filename);
		//class loader 
        try (URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { new File("").toURI().toURL() })) {     
        	//load the class and main method 
            Class<?> loadedClass = Class.forName(filename, true, classLoader);
            Method mainMethod = loadedClass.getMethod("main", String[].class);
            if (! Modifier.isStatic(mainMethod.getModifiers()))
                throw new IllegalStateException("main method is not static");
            
            //try to invoke the main method, deal with runtime exception accordingly
            try { 
				//what is this
            	Object returnValue = mainMethod.invoke(null, (Object) new String[0]);
            	runs = true; 
            } 
			catch (IllegalArgumentException e) {
				exception = e;
            	error = "IllegalArgumentException";
            	StringWriter sw = new StringWriter();
            	PrintWriter pw = new PrintWriter(sw); 
            	e.printStackTrace(pw);
            	stackTrace = sw.toString(); 
            }
            catch (RuntimeException e) {
				exception = e;
            	error = "RuntimeException";
            	StringWriter sw = new StringWriter();
            	PrintWriter pw = new PrintWriter(sw); 
            	e.printStackTrace(pw);
            	stackTrace = sw.toString(); 
            } 
			catch (InvocationTargetException e) {
				Exception actual = (Exception) e.getCause();	
				exception = actual;			
				error = actual.getClass().toString();
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw); 
				actual.printStackTrace(pw);
				stackTrace = sw.toString();
			}
            
        // catch blocks for the classloader and mainMethod 
		} catch (Exception e) {
			exception = e;
			error = "MalformedURLException";
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw); 
			e.printStackTrace(pw);
			stackTrace = sw.toString(); 
		}
	}

	public static void updateJson(String id, Snapshot snap) {
		//System.out.println("updateJson: " + id + "  snap:" + snap.getTimestamp());
        String content = "";
        Student[] studentsArr;
		ArrayList<Student> students = new ArrayList<>();
        try{
            content = new String(Files.readAllBytes(Paths.get("Snapshots.json")));
            ObjectMapper mapper = new ObjectMapper();
            studentsArr = mapper.readValue(content, Student[].class);
      		Collections.addAll(students, studentsArr);
            //String errorName = input.getClass().getCanonicalName();
            for (Student student : students) {
                if (id.equals(student.getId())) {
					ArrayList<Snapshot> studentSnaps = student.getSnapshots();
					studentSnaps.add(snap);
					mapper.writeValue(new File("Snapshots.json"), students);
					return;
				}
            }
			ArrayList<Snapshot> studentSnaps = new ArrayList<>();
			studentSnaps.add(snap);
			Student s = new Student(id, studentSnaps);
			students.add(s);
			mapper.writeValue(new File("Snapshots.json"), students);
        }
        catch(Exception e) {
            System.out.println("Exception");
        }
    }

	public static String findmsg(Exception input) {
        String content = "";
        Error[] errors;
        try{
            content = new String(Files.readAllBytes(Paths.get("ErrorMap.json")));
            ObjectMapper mapper = new ObjectMapper();
            errors = mapper.readValue(content, Error[].class);
        
            String errorName = input.getClass().getCanonicalName();
            for (Error error : errors) {
                if (errorName.contains(error.getErr())) {
                    return error.getMsg();
                }
            }
        }
        catch(Exception e) {
            System.out.println("Exception");
        }
        return "error not found";
    }
    
}