package co.com.johna.api.dto;

import lombok.*;

@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
//@Builder(toBuilder = true)
public class TaskCardDto {
    private int id;
    private String tittle;
    private String description;
    private int priorityLevel;
    private int states;

    public TaskCardDto() {
        this.id = -1;
        this.tittle = null;
        this.description = null;
        this.priorityLevel = -1;
        this.states = -1;
    }
}
