package Menus;

import Objects.Particulier;

public interface ParticulierInfos {
    static void displayParticulierInfo(Particulier particulier){
        System.out.print("1. Nom : "+ particulier.getNom());
        System.out.print(" || ");
        System.out.print("2. Prénom : "+particulier.getPrenom());
        System.out.print(" || ");
        System.out.print("3. Adresse : "+particulier.getAdresse());
        System.out.print(" || ");
        System.out.print("4. Date de naissance : "+particulier.getDate_naissance());
        System.out.print(" || ");
        System.out.println("5. e-mail : "+particulier.getEmail());
    }
}
