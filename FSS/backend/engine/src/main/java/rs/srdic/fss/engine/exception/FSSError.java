package rs.srdic.fss.engine.exception;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"code", "messageCode", "message"})
public class FSSError {

    private String code;
    private String messageCode;
    private String message;

    public FSSError(String message) {
        this.message = message;
    }

    public FSSError(String code, String messageCode, String message) {
        this.code = code;
        this.messageCode = messageCode;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

}
