package bo.digicert.crud.domain.ports.in.product;

import bo.digicert.crud.domain.model.Product;
import java.util.Optional;

public interface UpdateProductUseCase {
    Optional<Product> updateProduct(Long id, Product updatedProduct);
}
