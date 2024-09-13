package bo.digicert.crud.application.usecases;

import bo.digicert.crud.domain.model.Task;
import bo.digicert.crud.domain.ports.in.UpdateTaskUseCase;
import bo.digicert.crud.domain.ports.out.TaskRepositoryPort;
import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        updatedTask.setId(id);
        return taskRepositoryPort.update(updatedTask);
    }
}
