import java.util.*;

public class Student {
    private String id;
    private ArrayList<Snapshot> snapshots; 
 
    public Student() {}
    
    public Student(String id, ArrayList<Snapshot> snapshots) {
         this.id = id;
         this.snapshots = snapshots;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public void setSnapshots(ArrayList<Snapshot> snapshots) {
        this.snapshots = snapshots;
    }
 
    public String getId() {
        return id;
    }
 
    public ArrayList<Snapshot> getSnapshots() {
        return snapshots;
    }
 }
 
