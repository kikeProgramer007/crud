package bo.digicert.crud.application.usecases.category;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.in.category.UpdateCategoryUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;

import java.util.Optional;

public class UpdateCategoryUseCaseImpl implements UpdateCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public UpdateCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Optional<Category> updateCategory(Long id, Category updatedCategory) {
        updatedCategory.setId(id);
        return categoryRepositoryPort.update(updatedCategory);
    }
}
