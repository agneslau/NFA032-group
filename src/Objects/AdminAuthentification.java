package Objects;

import Exceptions.AdminException;
import Objects.Admin;

import java.util.ArrayList;

public class AdminAuthentification extends Authentification {

    private Admin admin;

    public void setAdmin(ArrayList<Admin> admins) throws AdminException {
        if(isAdmin(admins)){
            for(int i=0; i<admins.size();i++){
                if(admins.get(i).getEmail().equals(this.email)){
                    this.admin=(admins.get(i));
                }
            }
        }
        else{
            throw new AdminException("Erreur d'identification");
        }
    }

    public Admin getAdmin(){
        return admin;
    }

    public AdminAuthentification(String email, String password){
        super(email, password);
    }

    public boolean isAdmin(ArrayList<Admin> admins){
        for(int i=0; i<admins.size();i++){
            if(admins.get(i).getEmail().equals(this.email) && admins.get(i).getPassword().equals(this.password)){
                return true;
            }
        }
        return false;

    }
}
