package bo.digicert.crud.domain.ports.in;
import bo.digicert.crud.domain.model.Task;
import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
}
