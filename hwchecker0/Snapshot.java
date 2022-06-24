

public class Snapshot {
    private String name;
    private String timestamp;
    private boolean compiles;
    private boolean runs;
    private String error;
    private String msg;

 
    public Snapshot() {}
    
    public Snapshot(String name, String timestamp, boolean compiles, boolean runs, String error, String msg) {
        this.name = name;
        this.timestamp = timestamp;
        this.compiles = compiles;
        this.runs = runs;
        this.error = error;
        this.msg = msg;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
 
    public void setCompiles(boolean compiles) {
        this.compiles= compiles;
    }

    public void setRuns(boolean runs) {
        this.runs = runs;
    }

    public void setError(String error) {
        this.error = error;
    }
 
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }
 
    public String getTimestamp() {
        return timestamp;
    }
 
    public boolean getCompiles() {
        return compiles;
    }

    public boolean getRuns() {
        return runs;
    }

    public String getError() {
        return error;
    }
 
    public String getMsg() {
        return msg;
    }
 }
 
