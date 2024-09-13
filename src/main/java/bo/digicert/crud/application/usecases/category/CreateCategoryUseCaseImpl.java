package bo.digicert.crud.application.usecases.category;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.in.category.CreateCategoryUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;

public class CreateCategoryUseCaseImpl implements CreateCategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public CreateCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepositoryPort.save(category);
    }
}
