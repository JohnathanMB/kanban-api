package co.com.johna.jpa;

import co.com.johna.jpa.helper.AdapterOperations;
import co.com.johna.model.taskcard.TaskCard;
import co.com.johna.model.taskcard.gateways.TaskCardRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TaskCardRepositoryAdapter extends AdapterOperations<TaskCard, TaskCardData, Integer, TaskCardDataRepository>
        implements TaskCardRepository
{

    public TaskCardRepositoryAdapter(TaskCardDataRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, TaskCard.TaskCardBuilder.class).build());
    }
}
