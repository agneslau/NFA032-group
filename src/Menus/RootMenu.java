package Menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Exceptions.AdminException;
import Exceptions.ParticulierException;
import Files.Annuaire;
import Files.Comptes;
import Objects.AdminAuthentification;
import Objects.Particulier;
import Objects.Admin;
import Objects.ParticulierAuthentification;

import static Menus.MenuAdmin.displayAdminMenu;
import static Menus.MenuAnnuaire.displayAnnuaire;
import static Menus.MenuParticulier.displayUserMenu;

public class RootMenu {

    public static void displayRootMenu(ArrayList<Particulier> particuliers, ArrayList<Admin> admins) throws IOException {
        String choix = "";
        Scanner sc = new Scanner(System.in);

        while(!choix.equals("0")){
            System.out.println("*================== MENU ==================*");
            System.out.println("");
            System.out.println("Pour accéder au menu administrateur, tapez 1.");
            System.out.println("Pour accéder au menu utilisateur, tapez 2.");
            System.out.println("Pour consulter l'annuaire, tapez 3.");
            System.out.println("Pour quitter, tapez 0.");
            System.out.print("--> choix : ");

            choix = sc.nextLine();

            switch(choix){
                case "1":{
                    try {
                        AdminAuthentification authentification = adminAuthentification(admins, sc);
                        if (authentification.getAdmin() != null) {
                            displayAdminMenu(sc, admins, particuliers);
                        }
                    }catch(AdminException e){
                        System.out.println(e.getMessage());
                        }
                    break;
                }
                case "2":{
                    try{
                        ParticulierAuthentification authentification = particulierAuthentification(particuliers, sc);
                        if (authentification.getParticulier()!=null){
                            displayUserMenu(authentification.getParticulier(),sc);
                        }
                    }catch(ParticulierException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case "3":{
                    displayAnnuaire(particuliers, sc);
                    break;
                }
                case "0":{
                    saveFiles(particuliers, admins);
                    break;
                }
                default:{
                    System.out.println("Merci de saisir un chiffre entre 0 et 3.");
                }
            }

        }
        sc.close();
    }

    public static ParticulierAuthentification particulierAuthentification(ArrayList<Particulier> particuliers, Scanner sc) throws ParticulierException {
        System.out.println("*== Authentificaton ==*");
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.print("mot de passe : ");
        String password = sc.nextLine();

        ParticulierAuthentification authentification = new ParticulierAuthentification(email, password);
        authentification.setUser(particuliers);

        return authentification;
    }

    public static AdminAuthentification adminAuthentification(ArrayList<Admin> admins, Scanner sc) throws AdminException {
        System.out.println("*== Authentificaton ==*");
        System.out.print("email : ");
        String email = sc.nextLine();
        System.out.print("mot de passe : ");
        String password = sc.nextLine();

        AdminAuthentification authentification = new AdminAuthentification(email, password);
        authentification.setAdmin(admins);

        return authentification;
    }

    public static void saveFiles(ArrayList<Particulier> particuliers, ArrayList<Admin> admins) throws IOException {
        Annuaire.updateFile(particuliers);
        Comptes.updateFile(particuliers, admins);

        System.out.println("*== Les fichiers Comptes et Annuaire ont bien été sauvegardés ==*");
    }

}
