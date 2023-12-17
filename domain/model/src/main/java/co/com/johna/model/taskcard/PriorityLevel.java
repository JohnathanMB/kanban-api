package co.com.johna.model.taskcard;
public enum PriorityLevel {
    URGENT (1),
    HIGH (2),
    NORMAL (3);

    private final int intLevel;

    PriorityLevel(int i) {
        this.intLevel = i;
    }

    public int getIntLevel(){
     return intLevel;
    }
}