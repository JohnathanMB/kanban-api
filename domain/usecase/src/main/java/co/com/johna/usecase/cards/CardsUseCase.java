package co.com.johna.usecase.cards;

import co.com.johna.model.taskcard.PriorityLevel;
import co.com.johna.model.taskcard.StatusCard;
import co.com.johna.model.taskcard.TaskCard;
import co.com.johna.model.taskcard.gateways.TaskCardRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class CardsUseCase {

    private final TaskCardRepository taskCardRepository;

    public List<TaskCard> getAllTaskCards(){
        return taskCardRepository.findAll();
    }

    public TaskCard getSingleTaskCards(int idCard){
        return taskCardRepository.findByID(idCard)
                .orElse(TaskCard.builder().id(-1).build());
    }

    public TaskCard crateTaskCard(String tittle,
                                  String description,
                                  int priority){

        TaskCard taskCard = TaskCard.builder()
                .tittle(tittle)
                .description(description)
                .priorityLevel(identifyPriority(priority))
                .states(StatusCard.TODO)
                .build();

        return taskCardRepository.save(taskCard);
    }

    public TaskCard updateTaskCard(int idCard,
                                   String tittle,
                                   String description,
                                   int priority,
                                   int state){



        TaskCard taskCard = taskCardRepository.findByID(idCard).orElseThrow();

        String newTitle = identifyNewValue(tittle, taskCard.getTittle());
        String newDesctiption = identifyNewValue(description, taskCard.getDescription());
        int newPriority = identifyNewValue(priority, taskCard.getPriorityLevel().getIntLevel());
        int newstate = identifyNewValue(state, taskCard.getStates().getIdentifier());

        TaskCard taskCardUpdated = taskCard.toBuilder()
                .tittle(newTitle)
                .description(newDesctiption)
                .priorityLevel(identifyPriority(newPriority))
                .states(identifyState(newstate))
                .build();

        return taskCardRepository.save(taskCardUpdated);
    }

    public TaskCard deleteTaskCard(int idCard){

        TaskCard taskCard = taskCardRepository.findByID(idCard).orElseThrow();
        return taskCardRepository.save(taskCard.toBuilder().states(StatusCard.ERASED).build());
    }

    private String identifyNewValue(String paramValue, String cardValue) {
        return Objects.equals(paramValue, null) ? cardValue : paramValue;
    }

    private int identifyNewValue(int paramValue, int cardValue) {
        return Objects.equals(paramValue, -1) ? cardValue : paramValue;
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
