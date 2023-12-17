package co.com.johna.api;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TaskCardHandler {
//private  final UseCase useCase;
//private  final UseCase2 useCase2;


    public Mono<ServerResponse> listenViewAllCardsUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Should return list with all the cards");
    }

    public Mono<ServerResponse> listenViewSigleCardUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Should return a SINGLE card");
    }

    public Mono<ServerResponse> listenCreateCardUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Should create and return a confirmation of creation");
    }

    public Mono<ServerResponse> listenUpdateCardUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Should UPDATE and return a confirmation of it");
    }

    public Mono<ServerResponse> listenDeleteCardUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("Should DELETE and return a confirmation of it");
    }
}
