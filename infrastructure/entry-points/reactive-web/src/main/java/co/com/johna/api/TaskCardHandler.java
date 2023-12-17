package co.com.johna.api;

import co.com.johna.api.dto.TaskCardDto;
import co.com.johna.usecase.cards.CardsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TaskCardHandler {


    private final CardsUseCase cardsUseCase;


    public Mono<ServerResponse> listenViewAllCardsUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue(cardsUseCase.getAllTaskCards());
    }

    public Mono<ServerResponse> listenViewSigleCardUseCase(ServerRequest serverRequest) {
        String idCard = serverRequest.queryParam("id").orElse("");
        return ServerResponse.ok().bodyValue(cardsUseCase.getSingleTaskCards(Integer.parseInt(idCard)));
    }

    public Mono<ServerResponse> listenCreateCardUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(TaskCardDto.class)
                .map(body -> cardsUseCase.crateTaskCard(
                                body.getTittle(),
                                body.getDescription(),
                                body.getPriorityLevel()
                        )
                )
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

    public Mono<ServerResponse> listenUpdateCardUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(TaskCardDto.class)
                .map(body -> cardsUseCase.updateTaskCard(
                                body.getId(),
                                body.getTittle(),
                                body.getDescription(),
                                body.getPriorityLevel(),
                                body.getStates()
                        )
                )
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }

    public Mono<ServerResponse> listenDeleteCardUseCase(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(TaskCardDto.class)
                .map(body -> cardsUseCase.deleteTaskCard(body.getId()))
                .flatMap(result -> ServerResponse.ok().bodyValue(result));
    }
}
