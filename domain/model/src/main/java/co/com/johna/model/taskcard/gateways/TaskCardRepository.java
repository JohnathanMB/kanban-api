package co.com.johna.model.taskcard.gateways;

import co.com.johna.model.taskcard.TaskCard;

import java.util.List;
import java.util.Optional;

public interface TaskCardRepository {

    List<TaskCard> findAll();
    TaskCard save(TaskCard taskCard);

    Optional<TaskCard> findByID(Integer id);

}
