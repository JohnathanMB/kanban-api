package co.com.johna.model.taskcard;
public enum StatusCard {
    TODO(1),
    DOING(2),
    DONE(3),
    ERASED(0);

    private final int identifier;


    StatusCard(int i) {
        this.identifier = i;
    }

    public int getIdentifier(){
        return identifier;
    }

}