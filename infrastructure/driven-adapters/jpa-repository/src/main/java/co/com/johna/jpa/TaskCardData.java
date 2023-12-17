package co.com.johna.jpa;

import co.com.johna.model.taskcard.PriorityLevel;
import co.com.johna.model.taskcard.StatusCard;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tittle;
    private String description;
    private int priorityLevel;
    private int states;

}
