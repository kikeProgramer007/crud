package bo.digicert.crud.infrastructure.entities;

import bo.digicert.crud.domain.model.Category;
import bo.digicert.crud.domain.model.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

	public static ProductEntity fromDomainModel(Product product) {
		return new ProductEntity(
				product.getId(),
				product.getName(),
				product.getPrice(),
				new CategoryEntity(product.getCategory().getId(), product.getCategory().getName())
		);
	}

    public Product toDomainModel() {
        return new Product(
                id,
                name,
                price,
                category.getId(),
                new Category(category.getId(), category.getName())
        );
    }
}
