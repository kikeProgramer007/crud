package bo.digicert.crud.infrastructure.exceptions;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;

import java.net.URI;

public class BaseException  extends AbstractThrowableProblem  {
    public BaseException(String title, StatusType status, String detail) {
        super(URI.create(""), title, status, detail);
    }

    @Override
    public ThrowableProblem getCause() {
        return super.getCause();
    }
}
