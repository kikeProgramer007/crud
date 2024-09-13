package bo.digicert.crud.domain.ports.in.category;

import bo.digicert.crud.domain.model.Category;

import java.util.Optional;

public interface UpdateCategoryUseCase {
    Optional<Category> updateCategory(Long id, Category updatedCategory);
}
