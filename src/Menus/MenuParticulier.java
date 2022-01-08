package Menus;

import Exceptions.ParticulierException;
import Objects.Particulier;
import Tools.TodayDate;

import java.util.Scanner;

public class MenuParticulier implements ParticulierInfos {
    public static void displayUserMenu(Particulier particulier, Scanner sc) throws ParticulierException {
        System.out.println("*============ MENU UTILISATEUR ============*");
        System.out.println("");
        String choix = "";

        while(!choix.equals("0")){
            System.out.println("Pour modifier vos infos personnelles, tapez 1.");
            System.out.println("Pour revenir au menu principal, tapez 0.");
            System.out.println("");
            System.out.print("--> choix : ");
            choix =sc.nextLine();

            switch(choix){
                case "1":{
                    modifyParticulier(particulier, sc);
                    break;
                }
                case "0":{
                    System.out.println("*==========================================*");
                    break;
                }
                default:{
                    System.out.println("Merci de taper un chiffre entre 0 et 1.");
                    break;
                }
            }
        }

    }

    public static void modifyParticulier(Particulier particulier, Scanner sc) throws ParticulierException {

        String choix="";
        while(!choix.equals("0")){
            System.out.println("*============== Voici vos informations personnelles ==============* ");
            ParticulierInfos.displayParticulierInfo(particulier);
            System.out.print("Que souhaitez-vous modifier ? (tapez un chiffre entre 1 et 5, 0 pour quitter)");
            choix = sc.nextLine();
            String nouveau="";

            switch(choix){
                case "1":{
                    System.out.print("Indiquez le nouveau nom : ");
                    nouveau = sc.nextLine();
                    particulier.setNom(nouveau);
                    particulier.setDateMaj(TodayDate.TODAY);
                    System.out.println("Votre nom a été modifié.");
                    break;
                }
                case "2":{
                    System.out.print("Indiquez le nouveau prénom : ");
                    nouveau = sc.nextLine();
                    particulier.setPrenom(nouveau);
                    particulier.setDateMaj(TodayDate.TODAY);
                    System.out.println("Votre prénom a été modifié.");
                    break;
                }
                case "3":{
                    System.out.print("Indiquez la nouvelle adresse : ");
                    nouveau = sc.nextLine();
                    particulier.setAdresse(nouveau);
                    particulier.setDateMaj(TodayDate.TODAY);
                    System.out.println("Votre adresse a été modifiée.");
                    break;
                }
                case "4":{
                    System.out.print("Indiquez la nouvelle date de naissance (format jj/mm/aa) : ");
                    nouveau = sc.nextLine();
                    particulier.setDateNaissance(nouveau);
                    particulier.setDateMaj(TodayDate.TODAY);
                    System.out.println("Votre date de naissance a été modifiée.");
                    break;
                }
                case "5":{
                    System.out.print("Indiquez le nouvel email : ");
                    nouveau = sc.nextLine();
                    particulier.setEmail(nouveau);
                    particulier.setDateMaj(TodayDate.TODAY);
                    System.out.println("Votre email a été modifié.");
                    break;
                }
                case "0":{
                    System.out.println("*=================================================================* ");
                    break;
                }
                default:{
                    System.out.println("Le chiffre indiqué n'est pas compris entre 0 et 5.");
                    break;
                }
            }
        }
    }
}
