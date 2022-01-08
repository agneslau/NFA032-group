package Objects;

import Exceptions.ParticulierException;


import java.util.ArrayList;

public class ParticulierAuthentification extends Authentification {

    private Particulier particulier;

    public void setUser(ArrayList<Particulier> particuliers) throws ParticulierException {
        if(isUser(particuliers)){
            for(int i=0; i<particuliers.size();i++){
                if(particuliers.get(i).getEmail().equals(this.email)){
                    this.particulier =particuliers.get(i);
                }
            }
        }
        else{
            throw new ParticulierException("Erreur d'identification");
        }
    }

    public Particulier getParticulier(){
        return particulier;
    }

    public ParticulierAuthentification(String email, String password){
        super(email,password);
    }

    public boolean isUser(ArrayList<Particulier> particuliers){
        for(int i=0; i<particuliers.size();i++){
            if(particuliers.get(i).getEmail().equals(this.email) && particuliers.get(i).getPassword().equals(this.password)){
                return true;
            }
        }
        return false;
    }
}
