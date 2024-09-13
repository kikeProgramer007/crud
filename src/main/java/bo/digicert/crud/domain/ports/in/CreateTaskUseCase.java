package bo.digicert.crud.domain.ports.in;

import bo.digicert.crud.domain.model.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
