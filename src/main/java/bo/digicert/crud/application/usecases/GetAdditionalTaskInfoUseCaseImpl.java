package bo.digicert.crud.application.usecases;

import bo.digicert.crud.domain.model.AdditionalTaskInfo;
import bo.digicert.crud.domain.ports.in.GetAdditionalTaskInfoUseCase;
import bo.digicert.crud.domain.ports.out.ExternalServicePort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long taskId) {
        return externalServicePort.getAdditionalTaskInfo(taskId);
    }
}
