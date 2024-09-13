package bo.digicert.crud.infrastructure.config;

import bo.digicert.crud.application.services.*;
import bo.digicert.crud.application.usecases.category.*;
import bo.digicert.crud.application.usecases.product.*;
import bo.digicert.crud.domain.ports.out.*;
import bo.digicert.crud.infrastructure.repositories.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CategoryService categoryService(CategoryRepositoryPort categoryRepositoryPort) {
        return new CategoryService(
                new CreateCategoryUseCaseImpl(categoryRepositoryPort),
                new RetrieveCategoryUseCaseImpl(categoryRepositoryPort),
                new UpdateCategoryUseCaseImpl(categoryRepositoryPort),
                new DeleteCategoryUseCaseImpl(categoryRepositoryPort),
                new SearchCategoryUseCaseImpl(categoryRepositoryPort)
        );
    }
    @Bean
    public CategoryRepositoryPort categoryRepositoryPort(JpaCategoryRepositoryAdapter jpaCategoryRepositoryAdapter) {
        return jpaCategoryRepositoryAdapter;
    }
    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort) {
        return new ProductService(
                new CreateProductUseCaseImpl(productRepositoryPort),
                new RetrieveProductUseCaseImpl(productRepositoryPort),
                new UpdateProductUseCaseImpl(productRepositoryPort),
                new DeleteProductUseCaseImpl(productRepositoryPort)
        );
    }
    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductRepositoryAdapter jpaProductRepositoryAdapter) {
        return jpaProductRepositoryAdapter;
    }
}
