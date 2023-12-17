package co.com.johna.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class TaskCardRouterRest {
    @Bean
    public RouterFunction<ServerResponse> routerFunction(TaskCardHandler handler) {
        return route(GET("/kanban-api/usecase/view-all-cards"), handler::listenViewAllCardsUseCase)
                .andRoute(GET("/kanban-api/usecase/view-single-card"), handler::listenViewSigleCardUseCase)
                .andRoute(POST("/kanban-api/usecase/create-card"), handler::listenCreateCardUseCase)
                .andRoute(POST("/kanban-api/usecase/update-card"), handler::listenUpdateCardUseCase)
                .andRoute(POST("/kanban-api/usecase/delete-card"), handler::listenDeleteCardUseCase);
    }
}
