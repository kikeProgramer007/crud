package bo.digicert.crud.application.usecases.product;

import bo.digicert.crud.domain.model.Product;
import bo.digicert.crud.domain.ports.in.product.CreateProductUseCase;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }
}
