package juli.vitalco.model.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String idUser;
    private String password;
    private boolean  logged = false;

    public User(String idUser, String password) {
        this.idUser = idUser;
        this.password = password;
    }
}
