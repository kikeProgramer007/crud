package bo.digicert.crud.application.usecases.category;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.in.category.SearchCategoryUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;

import java.util.List;

public class SearchCategoryUseCaseImpl implements SearchCategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public SearchCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public List<Category> searchCategory(String name) {
        return categoryRepositoryPort.Search(name);
    }
}
