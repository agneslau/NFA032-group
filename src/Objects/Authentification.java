package Objects;

import java.util.ArrayList;

abstract class Authentification<T> {
    protected String email;
    protected String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    Authentification(String email, String password){
        this.email=email;
        this.password=password;
    }


}
