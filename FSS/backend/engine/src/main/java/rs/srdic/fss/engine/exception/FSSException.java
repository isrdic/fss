package rs.srdic.fss.engine.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FSSException extends RuntimeException {

    private FSSErrorCode errorCode;

    public FSSException(FSSErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
