package co.com.johna.jpa;

import co.com.johna.jpa.helper.AdapterOperations;
import co.com.johna.model.taskcard.PriorityLevel;
import co.com.johna.model.taskcard.StatusCard;
import co.com.johna.model.taskcard.TaskCard;
import co.com.johna.model.taskcard.gateways.TaskCardRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    public List<TaskCard> findAll(){
        return StreamSupport
                .stream(repository.findAll().spliterator(), true)
                .map(this::buildTaskCard)
                .collect(Collectors.toList());


    }

    public TaskCard save(TaskCard taskCard){
        TaskCardData data = new TaskCardData();
        data.setTittle(taskCard.getTittle());
        data.setDescription(taskCard.getDescription());
        data.setPriorityLevel(taskCard.getPriorityLevel().getIntLevel());
        data.setStates(taskCard.getStates().getIdentifier());

        if (taskCard.getId() != 0) data.setId(taskCard.getId());

        return buildTaskCard(this.repository.save(data));
    }

    @Override
    public Optional<TaskCard> findByID(Integer id) {
        return repository.findById(id).map(this::buildTaskCard);
    }

    private TaskCard buildTaskCard(TaskCardData data) {
        return TaskCard.builder()
                .id(data.getId())
                .tittle(data.getTittle())
                .description(data.getDescription())
                .priorityLevel(identifyPriority(data.getPriorityLevel()))
                .states(identifyState(data.getStates()))
                .build();
    }

    private StatusCard identifyState(int state) {
        return switch (state){
            case 0 -> StatusCard.ERASED;
            case 2 -> StatusCard.DOING;
            case 3 -> StatusCard.DONE;
            default -> StatusCard.TODO;
        };
    }

    private PriorityLevel identifyPriority(int priority) {
        return switch (priority){
            case 1 -> PriorityLevel.URGENT;
            case 2 -> PriorityLevel.HIGH;
            default -> PriorityLevel.NORMAL;
        };
    }

}
