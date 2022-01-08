package Menus;

import Objects.Admin;
import Objects.Particulier;
import Tools.TodayDate;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAdmin {
    public static void displayAdminMenu(Scanner sc, ArrayList<Admin> admins, ArrayList<Particulier> particuliers){
        System.out.println("*============ MENU ADMINISTRATEUR =============*");
        System.out.println("");
        String choix="";

        while(!choix.equals("0")){
            System.out.println("Pour ajouter un administrateur, tapez 1.");
            System.out.println("Pour ajouter un particulier, tapez 2.");
            System.out.println("Pour revenir au menu principal, tapez 0.");
            System.out.println("");
            System.out.print("--> choix : ");
            choix =sc.nextLine();

            switch(choix){
                case"1":{
                    addAdmin(admins, sc);
                    break;
                }
                case"2":{
                    addParticulier(particuliers, sc);
                    break;
                }
                case"0":{
                    System.out.println("*==============================================*");
                    break;
                }
                default:{
                    System.out.println("Merci de saisir un chiffre entre 0 et 2");
                }
            }
        }
    }
    public static void addAdmin(ArrayList<Admin> admins, Scanner sc){
        System.out.println("*================= Ajout d'un Administrateur =================*");
        String email="";
        String password ="";

        System.out.print("E-MAIL : ");
        email=sc.nextLine();
        System.out.print("MOT DE PASSE : ");
        password=sc.nextLine();
        Admin admin = new Admin(email,password);
        admins.add(admin);
        System.out.println("*================= Administrateur ajouté =================*");
    }
    public static void addParticulier(ArrayList<Particulier> particuliers, Scanner sc){
        System.out.println("*================= Ajout d'un Objects.Particulier =================*");
        String email="";
        String password="";
        String nom="";
        String prenom="";
        String adresse="";
        String dateNaissance = "";
        String numProfil="";
        Particulier.Profil profil = Particulier.Profil.AUDITEUR;

        System.out.print("E-MAIL : ");
        email=sc.nextLine();
        System.out.print("MOT DE PASSE : ");
        password=sc.nextLine();
        System.out.print("NOM : ");
        nom=sc.nextLine();
        System.out.print("PRENOM : ");
        prenom=sc.nextLine();
        System.out.print("ADRESSE : ");
        adresse=sc.nextLine();
        System.out.print("DATE DE NAISSANCE (jj/mm/aa) : ");
        dateNaissance=sc.nextLine();

        while(!numProfil.equals("1") && !numProfil.equals("2") && !numProfil.equals("3")){
            System.out.print("DEINISSEZ DE LE PROFIL : 1-AUDITEUR, 2-ENSEIGNANT, 3-DIRECTEUR : ");
            numProfil=sc.nextLine();

            switch(numProfil) {
                case "1": {
                }
                case "2": {
                    profil = Particulier.Profil.ENSEIGNANT;
                }
                case "3": {
                    profil = Particulier.Profil.DIRECTION;
                }
                default: {
                    System.out.println("Merci de renseigner 1, 2 ou 3");
                }
            }
        }
        Particulier particulier = new Particulier(email,password,nom,prenom,adresse,dateNaissance,profil, TodayDate.TODAY, TodayDate.TODAY);
        particuliers.add(particulier);

        System.out.println("*================= Objects.Particulier ajouté =================*");
    }
}
