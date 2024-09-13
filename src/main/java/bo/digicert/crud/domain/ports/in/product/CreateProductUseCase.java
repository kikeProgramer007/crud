package bo.digicert.crud.domain.ports.in.product;

import bo.digicert.crud.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
