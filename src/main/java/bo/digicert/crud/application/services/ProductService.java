package bo.digicert.crud.application.services;

import bo.digicert.crud.domain.model.Product;
import bo.digicert.crud.domain.ports.in.product.CreateProductUseCase;
import bo.digicert.crud.domain.ports.in.product.DeleteProductUseCase;
import bo.digicert.crud.domain.ports.in.product.RetrieveProductUseCase;
import bo.digicert.crud.domain.ports.in.product.UpdateProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductService implements CreateProductUseCase, RetrieveProductUseCase, UpdateProductUseCase, DeleteProductUseCase {
    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;

    public ProductService(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase, UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
    }

    @Override
    public Product createProduct(Product product) {
        return createProductUseCase.createProduct(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        return deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return retrieveProductUseCase.getProductById(id);
    }

    @Override
    public List<Product> getProducts() {
        return retrieveProductUseCase.getProducts();
    }

    @Override
    public Optional<Product> updateProduct(Long id, Product updatedProduct) {
        return updateProductUseCase.updateProduct(id, updatedProduct);
    }
}
