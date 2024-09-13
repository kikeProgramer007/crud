package bo.digicert.crud.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data // Genera getters, setters, toString, equals, y hashCode
@AllArgsConstructor // Genera el constructor con todos los parámetros
@NoArgsConstructor // Genera un constructor sin parámetros
public class Task {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;
    private boolean completed;
}
