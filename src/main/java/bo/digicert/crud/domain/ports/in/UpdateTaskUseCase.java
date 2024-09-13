package bo.digicert.crud.domain.ports.in;
import bo.digicert.crud.domain.model.Task;
import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task updatedTask);
}
