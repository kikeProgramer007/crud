package bo.digicert.crud.application.usecases;

import bo.digicert.crud.domain.model.Task;
import bo.digicert.crud.domain.ports.in.CreateTaskUseCase;
import bo.digicert.crud.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl  implements CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
