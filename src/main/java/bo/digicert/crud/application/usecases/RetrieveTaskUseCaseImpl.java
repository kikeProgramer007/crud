package bo.digicert.crud.application.usecases;

import bo.digicert.crud.domain.model.Task;
import bo.digicert.crud.domain.ports.in.RetrieveTaskUseCase;
import bo.digicert.crud.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepositoryPort.findAll();
    }
}
