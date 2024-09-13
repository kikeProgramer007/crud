package bo.digicert.crud.application.usecases.product;

import bo.digicert.crud.domain.model.Product;
import bo.digicert.crud.domain.ports.in.product.RetrieveProductUseCase;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public List<Product> getProducts() {
        return productRepositoryPort.findAll();
    }
}
