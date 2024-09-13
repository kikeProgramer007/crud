package bo.digicert.crud.domain.ports.in.category;

import bo.digicert.crud.domain.model.Category;

import java.util.List;

public interface SearchCategoryUseCase {
    List<Category> searchCategory(String name);
}
