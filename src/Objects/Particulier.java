package Objects;

import java.util.ArrayList;

public class Particulier extends User {
    private String nom;
    private String prenom;
    private String adresse;
    private String dateNaissance;
    public static enum Profil{AUDITEUR, ENSEIGNANT, DIRECTION};
    private Profil profil;
    private String dateAjout;
    private String dateMaj;


    public Particulier(){};

    public Particulier(String email, String password) {
        super(email, password, User.Role.PARTICULIER);
    }

    public Particulier(String email, String password, String nom, String prenom, String adresse, String date_naissance, Profil profil, String date_ajout, String date_Maj) {
        super(email, password, User.Role.PARTICULIER);
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = date_naissance;
        this.profil = profil;
        this.dateAjout=date_ajout;
        this.dateMaj=date_Maj;
    }

    //SETTERS AND GETTERS------------------------------------------------------

    public void setNom(String nom) {
        this.nom = nom;
        //this.dateMaj=date();
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateNaissance(String date_naissance) {
        this.dateNaissance = date_naissance;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public void setDateMaj(String dateMaj) {
        this.dateMaj = dateMaj;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDate_naissance() {
        return dateNaissance;
    }

    public Profil getProfil() {
        return profil;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public String getDateMaj() {
        return dateMaj;
    }

    public static boolean isParticulierByEmail(ArrayList<Particulier> particuliers, String email){
        for(Particulier particulier:particuliers){
            if(particulier.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    public static boolean isParticulierByNom(ArrayList<Particulier> particuliers, String nom){
        for(Particulier particulier:particuliers){
            if(particulier.getNom().equalsIgnoreCase(nom)){
                return true;
            }
        }
        return false;
    }
    public static boolean isParticulierByProfil(ArrayList<Particulier> particuliers, Profil profil){
        for(Particulier particulier:particuliers){
            if(particulier.getProfil()==profil){
                return true;
            }
        }
        return false;
    }
}
    //---------------------------------------------------------------------------
