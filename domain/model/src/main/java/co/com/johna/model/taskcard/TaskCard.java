package co.com.johna.model.taskcard;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TaskCard {
    private int id;
    private String tittle;
    private String description;
    private PriorityLevel priorityLevel;
    private StatusCard states;
}
