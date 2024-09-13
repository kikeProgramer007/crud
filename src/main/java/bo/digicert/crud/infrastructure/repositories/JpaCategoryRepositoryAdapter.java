package bo.digicert.crud.infrastructure.repositories;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;
import bo.digicert.crud.infrastructure.entities.CategoryEntity;
import bo.digicert.crud.infrastructure.repositories.specifications.CategoryNameSpecification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaCategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;

    public JpaCategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = CategoryEntity.fromDomainModel(category);
        CategoryEntity savedCategoryEntity = jpaCategoryRepository.save(categoryEntity);
        return savedCategoryEntity.toDomainModel();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return jpaCategoryRepository.findById(id).map(CategoryEntity::toDomainModel);
    }

    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll().stream()
                .map(CategoryEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Category> update(Category category) {
        if (jpaCategoryRepository.existsById(category.getId())) {
            CategoryEntity categoryEntity = CategoryEntity.fromDomainModel(category);
            CategoryEntity updatedCategoryEntity = jpaCategoryRepository.save(categoryEntity);
            return Optional.of(updatedCategoryEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaCategoryRepository.existsById(id)) {
            jpaCategoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> Search(String name) {
        return jpaCategoryRepository.findAll(new CategoryNameSpecification(name)).stream()
                .map(CategoryEntity::toDomainModel)
                .collect(Collectors.toList());
    }
}
