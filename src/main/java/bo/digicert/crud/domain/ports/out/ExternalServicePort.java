package bo.digicert.crud.domain.ports.out;

import bo.digicert.crud.domain.model.AdditionalTaskInfo;

public interface ExternalServicePort {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
