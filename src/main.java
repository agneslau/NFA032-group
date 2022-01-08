import Exceptions.AdminException;
import Exceptions.FilesException;
import Exceptions.ParticulierException;
import Files.Annuaire;
import Files.Comptes;
import Menus.RootMenu;
import Objects.Admin;
import Objects.Particulier;

import java.io.IOException;
import java.util.ArrayList;


public class main {
    //public HashSet<Objects.User> comptes = new HashSet<Objects.User>();
    //public HashSet<Objects.Particulier> annuaire = new HashSet<Objects.Particulier>();
    //public static String path = "comptes.txt";

    public static void main(String[] args) throws IOException, ParticulierException, AdminException {
        ArrayList<Particulier> particuliers = new ArrayList<Particulier>();
        ArrayList<Admin> admins = new ArrayList<Admin>();
        Comptes.instanciateAndStoreData(particuliers, admins);
        try{
            Annuaire.instanciateAndStoreData(particuliers);
        }catch(FilesException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        /*for(int i=0;i<annuaire.getAnnuaire().size();i++) {
            Menus.Menus.displayParticulierInfo((Objects.Particulier) annuaire.getAnnuaire().get(i));
        }*/

        RootMenu.displayRootMenu(particuliers, admins);
    }
}
