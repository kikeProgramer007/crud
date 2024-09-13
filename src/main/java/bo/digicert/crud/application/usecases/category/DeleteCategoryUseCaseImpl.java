package bo.digicert.crud.application.usecases.category;

import bo.digicert.crud.domain.ports.in.category.DeleteCategoryUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;

public class DeleteCategoryUseCaseImpl implements DeleteCategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public DeleteCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public boolean deleteCategory(Long id) {
        return categoryRepositoryPort.deleteById(id);
    }
}
