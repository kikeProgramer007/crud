package bo.digicert.crud.infrastructure.repositories.specifications;

import bo.digicert.crud.infrastructure.entities.CategoryEntity;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

public class CategoryNameSpecification implements Specification<CategoryEntity> {
    private final String name;

    public CategoryNameSpecification(String name) {
        this.name = name;
    }
    public Predicate toPredicate(Root<CategoryEntity> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (name == null || name.isEmpty()) {
            return builder.conjunction();
        } else {
            Expression<String> nameExpression = builder.lower(root.get("name"));
            return builder.like(nameExpression, "%" + name.toLowerCase() + "%");
        }
    }

}
