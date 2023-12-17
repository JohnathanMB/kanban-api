package co.com.johna.jpa;

import co.com.johna.model.taskcard.PriorityLevel;
import co.com.johna.model.taskcard.StatusCard;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TASKCARD")
public class TaskCardData {

    @Id
    private int id;
    private String tittle;
    private String description;
    private int priorityLevel;
    private int states;

}
