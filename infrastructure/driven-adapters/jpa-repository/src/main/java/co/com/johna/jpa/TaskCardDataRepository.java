package co.com.johna.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface TaskCardDataRepository extends CrudRepository<TaskCardData, Integer>, QueryByExampleExecutor<TaskCardData> {
}
