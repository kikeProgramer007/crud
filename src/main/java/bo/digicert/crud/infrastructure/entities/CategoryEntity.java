package bo.digicert.crud.infrastructure.entities;

import bo.digicert.crud.domain.model.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public static CategoryEntity fromDomainModel(Category category) {
        return new CategoryEntity(
                category.getId(),
                category.getName()
        );
    }

    public Category toDomainModel() {
        return new Category(id, name);
    }
}