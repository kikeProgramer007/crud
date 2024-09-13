package bo.digicert.crud.infrastructure.repositories;

import bo.digicert.crud.infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository  extends JpaRepository<ProductEntity, Long> {
}
