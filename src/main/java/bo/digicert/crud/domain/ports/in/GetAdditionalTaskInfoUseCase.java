package bo.digicert.crud.domain.ports.in;

import bo.digicert.crud.domain.model.AdditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AdditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
