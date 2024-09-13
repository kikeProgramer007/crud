package bo.digicert.crud.domain.model;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter // Genera getters para todos los campos
@AllArgsConstructor // Genera el constructor con todos los parameter (final)
public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;
}