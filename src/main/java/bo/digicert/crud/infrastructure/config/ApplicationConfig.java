package bo.digicert.crud.infrastructure.config;

import bo.digicert.crud.application.services.CategoryService;
import bo.digicert.crud.application.services.ProductService;
import bo.digicert.crud.application.services.TaskService;
import bo.digicert.crud.application.usecases.*;
import bo.digicert.crud.application.usecases.category.*;
import bo.digicert.crud.application.usecases.product.CreateProductUseCaseImpl;
import bo.digicert.crud.application.usecases.product.DeleteProductUseCaseImpl;
import bo.digicert.crud.application.usecases.product.RetrieveProductUseCaseImpl;
import bo.digicert.crud.application.usecases.product.UpdateProductUseCaseImpl;
import bo.digicert.crud.domain.ports.in.GetAdditionalTaskInfoUseCase;
import bo.digicert.crud.domain.ports.out.CategoryRepositoryPort;
import bo.digicert.crud.domain.ports.out.ExternalServicePort;
import bo.digicert.crud.domain.ports.out.ProductRepositoryPort;
import bo.digicert.crud.domain.ports.out.TaskRepositoryPort;
import bo.digicert.crud.infrastructure.adapters.ExternalServiceAdapter;
import bo.digicert.crud.infrastructure.repositories.JpaCategoryRepositoryAdapter;
import bo.digicert.crud.infrastructure.repositories.JpaProductRepositoryAdapter;
import bo.digicert.crud.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public TaskService taskService(TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase) {
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }

    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter) {
        return jpaTaskRepositoryAdapter;
    }

    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

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
