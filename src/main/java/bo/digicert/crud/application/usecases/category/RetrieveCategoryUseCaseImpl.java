package bo.digicert.crud.application.usecases.category;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.in.category.RetrieveCategoryUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;
import java.util.List;
import java.util.Optional;

public class RetrieveCategoryUseCaseImpl implements RetrieveCategoryUseCase {

    private final CategoryRepositoryPort categoryRepositoryPort;

    public RetrieveCategoryUseCaseImpl(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepositoryPort.findById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepositoryPort.findAll();
    }

}
