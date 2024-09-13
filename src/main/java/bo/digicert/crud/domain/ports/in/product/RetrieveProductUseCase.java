package bo.digicert.crud.domain.ports.in.product;

import bo.digicert.crud.domain.model.Product;
import java.util.List;
import java.util.Optional;

public interface RetrieveProductUseCase {
    Optional<Product> getProductById(Long id);
    List<Product> getProducts();
}
