package Objects;

public class User {
    public enum Role{ADMIN, PARTICULIER};
    private String email;
    private String password;
    private Role role;

    public User(){}

    public User(String email, String password, Role role){
        this.email=email;
        this.password=password;
        this.role=role;
    }
    //SETTERS et GETTERS

    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(Role role) {this.role = role;}

    public Role getRole() {return role;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
}
