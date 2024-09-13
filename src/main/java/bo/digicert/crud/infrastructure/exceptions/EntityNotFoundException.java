package bo.digicert.crud.infrastructure.exceptions;

import lombok.Getter;
import org.zalando.problem.Status;
@Getter
public class EntityNotFoundException extends BaseException {

    private final String entity;

    public EntityNotFoundException(String entityDetail, String entity) {
        super("Entity not found",
                Status.NOT_FOUND,
                entityDetail );
        this.entity = entity;
    }
}
