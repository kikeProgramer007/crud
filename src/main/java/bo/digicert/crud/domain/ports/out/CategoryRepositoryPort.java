package bo.digicert.crud.domain.ports.out;

import bo.digicert.crud.domain.model.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {
    Category save(Category category);
    Optional<Category> findById(Long id);
    List<Category> findAll();
    Optional<Category> update(Category category);
    boolean deleteById(Long id);
    List<Category> Search(String name);
}
