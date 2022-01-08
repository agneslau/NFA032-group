package Menus;

import Exceptions.ParticulierException;
import Objects.Particulier;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAnnuaire implements ParticulierInfos {
    public static void displayAnnuaire(ArrayList<Particulier> particuliers, Scanner sc) {
        System.out.println("*================== Voici l'annuaire ==================*");
        String choix = "";

        while(!choix.equals("0")){
            System.out.println("Recherche par nom, tapez 1");
            System.out.println("Recherche par email, tapez 2");
            System.out.println("Recherche par profil, tapez 3");
            System.out.println("Pour quitter, tapez 0");
            System.out.println("Indiquez votre choix : ");
            choix =sc.nextLine();
            try{
                switch(choix){
                    case "1":{
                        searchByNom(particuliers, sc);
                        break;
                    }
                    case "2":{
                        searchByEmail(particuliers, sc);
                        break;
                    }
                    case "3":{
                        searchByProfil(particuliers, sc);
                        break;
                    }
                    case "0":{
                        System.out.println("*======================================================*");
                        break;
                    }
                    default:{
                        System.out.println("Merci de renseigner un chiffre entre 0 et 3");
                    }
                }
            }catch(ParticulierException e){
                System.out.println(e.getMessage());
            }
        }

    }
    public static void searchByNom(ArrayList<Particulier> particuliers, Scanner sc) throws ParticulierException {
        System.out.println("Entrer le nom à chercher : ");
        String nom = sc.nextLine();
        if(Particulier.isParticulierByNom(particuliers, nom)){
            int compteur=0;
            for(int i=particuliers.size()-1;i>=0;i--){
                if(compteur<=10){
                    if(particuliers.get(i).getNom().equalsIgnoreCase(nom)){
                        ParticulierInfos.displayParticulierInfo(particuliers.get(i));
                        compteur++;
                    }
                }
            }
            System.out.println("");
        }
        else{
            throw new ParticulierException("Il n'y a pas de particulier à ce nom dans l'annuaire'.");
        }

    }
    public static void searchByEmail(ArrayList<Particulier> particuliers, Scanner sc) throws ParticulierException {
        System.out.println("Entrer l'e-mail à chercher : ");
        String email = sc.nextLine();
        if(Particulier.isParticulierByEmail(particuliers, email)){
            for(int i=0;i< particuliers.size();i++){
                if(particuliers.get(i).getEmail().equalsIgnoreCase(email)){
                    ParticulierInfos.displayParticulierInfo(particuliers.get(i));
                    break;
                }
            }
        }
        else{
            throw new ParticulierException("Il n'y a pas de particulier correspondant à cet email dans l'annuaire.");
        }
    }

    public static void searchByProfil(ArrayList<Particulier> particuliers, Scanner sc) throws ParticulierException {
        System.out.println("Pour chercher les 10 derniers Auditeurs ajoutés, tapez 1");
        System.out.println("Pour chercher les 10 derniers Enseignants ajoutés, tapez 2");
        System.out.println("Pour chercher les 10 derniers Directeurs ajoutés, tapez 3");
        String numProfil="";
        Particulier.Profil profil = Particulier.Profil.AUDITEUR;


        while(!numProfil.equals("1")||!numProfil.equals("2")||!numProfil.equals("3")){
            numProfil = sc.nextLine();
            switch(numProfil) {
                case "1": {
                    profil = Particulier.Profil.AUDITEUR;
                    break;
                }
                case "2": {
                    profil = Particulier.Profil.ENSEIGNANT;
                    break;
                }
                case "3": {
                    profil = Particulier.Profil.DIRECTION;
                    break;
                }
                default: {
                    System.out.println("Merci d'indiquer un chiffre entre 1 et 3.");
                    break;
                }
            }
        }
        if(Particulier.isParticulierByProfil(particuliers, profil)){
            int compteur=0;
            while(compteur<=10){
                for(int i=particuliers.size()-1;i>=0;i--){
                    if(particuliers.get(i).getProfil()==profil){
                        ParticulierInfos.displayParticulierInfo(particuliers.get(i));
                        compteur++;
                    }
                }
            }
        }
        else{
            throw new ParticulierException("Il n'y a pas de particulier ayant ce profil dans l'annuaire.");
        }
    }
}
