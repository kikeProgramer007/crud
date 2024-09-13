package bo.digicert.crud.application.services;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.in.category.*;

import java.util.List;
import java.util.Optional;

public class CategoryService implements CreateCategoryUseCase, RetrieveCategoryUseCase, UpdateCategoryUseCase, DeleteCategoryUseCase, SearchCategoryUseCase {
    private final CreateCategoryUseCase createCategoryUseCase;
    private final RetrieveCategoryUseCase retrieveCategoryUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;
    private final DeleteCategoryUseCase deleteCategoryUseCase;
    private final SearchCategoryUseCase searchCategoryUseCase;

    public CategoryService(CreateCategoryUseCase createCategoryUseCase, RetrieveCategoryUseCase retrieveCategoryUseCase, UpdateCategoryUseCase updateCategoryUseCase, DeleteCategoryUseCase deleteCategoryUseCase, SearchCategoryUseCase searchCategoryUseCase) {
        this.createCategoryUseCase = createCategoryUseCase;
        this.retrieveCategoryUseCase = retrieveCategoryUseCase;
        this.updateCategoryUseCase = updateCategoryUseCase;
        this.deleteCategoryUseCase = deleteCategoryUseCase;
        this.searchCategoryUseCase = searchCategoryUseCase;
    }

    @Override
    public Category createCategory(Category category) {
        return createCategoryUseCase.createCategory(category);
    }

    @Override
    public boolean deleteCategory(Long id) {
        return deleteCategoryUseCase.deleteCategory(id);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {
        return retrieveCategoryUseCase.getCategoryById(id);
    }

    @Override
    public List<Category> getCategories() {
        return retrieveCategoryUseCase.getCategories();
    }

    @Override
    public Optional<Category> updateCategory(Long id, Category updatedCategory) {
        return updateCategoryUseCase.updateCategory(id, updatedCategory);
    }

    @Override
    public List<Category> searchCategory(String name) {
        return searchCategoryUseCase.searchCategory(name);
    }
}
