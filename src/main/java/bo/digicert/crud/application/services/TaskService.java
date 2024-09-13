package bo.digicert.crud.application.services;

import bo.digicert.crud.domain.model.AdditionalTaskInfo;
import bo.digicert.crud.domain.model.Task;
import bo.digicert.crud.domain.ports.in.*;

import java.util.List;
import java.util.Optional;

public class TaskService implements  CreateTaskUseCase,  RetrieveTaskUseCase,  UpdateTaskUseCase, DeleteTaskUseCase, GetAdditionalTaskInfoUseCase {
    private final CreateTaskUseCase createTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase;

    public TaskService(
            CreateTaskUseCase createTaskUseCase,
            RetrieveTaskUseCase retrieveTaskUseCase,
            UpdateTaskUseCase updateTaskUseCase,
            DeleteTaskUseCase deleteTaskUseCase,
            GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase
    ) {
        this.createTaskUseCase = createTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.getAdditionalTaskInfoUseCase = getAdditionalTaskInfoUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return getAdditionalTaskInfoUseCase.getAdditionalTaskInfo(taskId);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return retrieveTaskUseCase.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return retrieveTaskUseCase.getAllTasks();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updatedTask) {
        return updateTaskUseCase.updateTask(id, updatedTask);
    }
}