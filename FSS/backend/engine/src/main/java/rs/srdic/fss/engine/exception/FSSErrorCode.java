package rs.srdic.fss.engine.exception;

import lombok.Getter;

@Getter
public enum FSSErrorCode {

    ERR_001("Korisnik","USER_DISABLED", MessageKey.ERR_001),
    ERR_002("Korisnik","INVALID_CREDENTIALS", MessageKey.ERR_002);

    FSSErrorCode(String objekat, String opis, MessageKey messageKey){
        this.objekat = objekat;
        this.opis = opis;
        this.messageKey = messageKey;
    }

    private final String objekat;
    private final String opis;
    private final MessageKey messageKey;

    public MessageKey getMessageKey() {
        return messageKey;
    }

}
