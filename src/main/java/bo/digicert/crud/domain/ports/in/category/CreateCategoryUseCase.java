package bo.digicert.crud.domain.ports.in.category;

import bo.digicert.crud.domain.model.Category;

public interface CreateCategoryUseCase {
    Category createCategory(Category category);
}
