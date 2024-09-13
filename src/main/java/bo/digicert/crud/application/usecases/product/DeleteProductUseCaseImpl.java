package bo.digicert.crud.application.usecases.product;

import bo.digicert.crud.domain.ports.in.product.DeleteProductUseCase;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public boolean deleteProduct(Long id) {
        return productRepositoryPort.deleteById(id);
    }
}
