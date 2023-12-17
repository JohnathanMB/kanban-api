package co.com.johna.model.taskcard.gateways;

import co.com.johna.model.taskcard.TaskCard;

import java.util.List;

public interface TaskCardRepository {

    List<TaskCard> findAll();

}
