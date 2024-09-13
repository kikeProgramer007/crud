package bo.digicert.crud.domain.ports.in.category;

import bo.digicert.crud.domain.model.Category;
import java.util.List;
import java.util.Optional;

public interface RetrieveCategoryUseCase {
    Optional<Category> getCategoryById(Long id);
    List<Category> getCategories();
}
