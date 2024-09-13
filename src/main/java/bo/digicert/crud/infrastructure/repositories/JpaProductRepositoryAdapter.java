package bo.digicert.crud.infrastructure.repositories;

import bo.digicert.crud.domain.model.Product;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;
import bo.digicert.crud.infrastructure.entities.ProductEntity;
import org.springframework.stereotype.Component;
import bo.digicert.crud.infrastructure.exceptions.EntityNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaProductRepositoryAdapter implements ProductRepositoryPort {
    private final JpaProductRepository jpaProductRepository;
    private final JpaCategoryRepository jpaCategoryRepository;

    public JpaProductRepositoryAdapter(JpaProductRepository jpaProductRepository, JpaCategoryRepository jpaCategoryRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Product save(Product product) {
        return jpaCategoryRepository.findById(product.getCategory_id())
                .map(categoryEntity -> {
                    product.setCategory(categoryEntity.toDomainModel());
                    ProductEntity productEntity = ProductEntity.fromDomainModel(product);
                    ProductEntity savedProductEntity = jpaProductRepository.save(productEntity);
                    return savedProductEntity.toDomainModel();
                })
                .orElseThrow(() -> new EntityNotFoundException("Category with id " + product.getCategory_id() + " not found", "Category"));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return jpaProductRepository.findById(id).map(ProductEntity::toDomainModel);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll().stream()
                .map(ProductEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> update(Product product) {
        if (jpaProductRepository.existsById(product.getId())) {
            ProductEntity productEntity = ProductEntity.fromDomainModel(product);
            ProductEntity updatedProductEntity = jpaProductRepository.save(productEntity);
            return Optional.of(updatedProductEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (jpaProductRepository.existsById(id)) {
            jpaProductRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
