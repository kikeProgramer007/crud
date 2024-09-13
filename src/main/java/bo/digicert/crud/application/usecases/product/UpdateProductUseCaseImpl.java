package bo.digicert.crud.application.usecases.product;

import bo.digicert.crud.domain.model.Product;
import bo.digicert.crud.domain.ports.in.product.UpdateProductUseCase;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;
import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        updatedProduct.setId(id);
        return productRepositoryPort.update(updatedProduct);
    }
}