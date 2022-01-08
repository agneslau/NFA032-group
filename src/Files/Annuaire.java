package Files;

import Exceptions.FilesException;
import Objects.Particulier;

import java.io.*;
import java.util.ArrayList;

public class Annuaire {
    public static String PATH="annuaire.txt";
    public static String SEPARATEUR=";";

    public static ArrayList<String> getTxtFileInfo() throws IOException {

        FileReader fr = new FileReader(PATH);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        ArrayList<String> fileLines = new ArrayList();
        while(line != null) {
            fileLines.add(line);
            line = br.readLine();
        }
        br.close();
        fr.close();
        return fileLines;

    }

    public static void instanciateAndStoreData(ArrayList<Particulier> particuliers) throws IOException, FilesException {
        ArrayList<String> fileLines = getTxtFileInfo();

        for (int i=0; i<fileLines.size();i++){
            String userData[]=fileLines.get(i).split(SEPARATEUR);

            if(existsInAnnuaire(userData,particuliers)) {
                for (int j = 0; j < particuliers.size(); j++) {
                    if (userData[2].equals(particuliers.get(j).getEmail())) {
                        particuliers.get(j).setNom(userData[0]);
                        particuliers.get(j).setPrenom(userData[1]);
                        particuliers.get(j).setAdresse(userData[3]);
                        particuliers.get(j).setDateNaissance(userData[4]);
                        Particulier.Profil profil = Particulier.Profil.valueOf(userData[5]);
                        particuliers.get(j).setProfil(profil);
                        particuliers.get(j).setDateAjout(userData[6]);
                        particuliers.get(j).setDateMaj(userData[7]);
                    }
                }
            }
            else{
                throw new FilesException("Incohérence de données entre annuaire et comptes, Veuillez contacter l'administrateur.");
            }
        }
    }
    public static void updateFile(ArrayList<Particulier> particuliers) throws IOException {
        FileWriter fw = new FileWriter(PATH);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Particulier particulier : particuliers ){
            bw.write(particulier.getNom()+SEPARATEUR
                    +particulier.getPrenom()+SEPARATEUR
                    +particulier.getEmail()+SEPARATEUR
                    +particulier.getAdresse()+SEPARATEUR
                    +particulier.getDate_naissance()+SEPARATEUR
                    +particulier.getProfil()+SEPARATEUR
                    +particulier.getDateAjout()+SEPARATEUR
                    +particulier.getDateMaj());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();
    }
    public static boolean existsInAnnuaire(String [] userData, ArrayList<Particulier> particuliers){
        for (Particulier particulier:particuliers){
            if(userData[2].equalsIgnoreCase(particulier.getEmail())){
                return true;
            }
        }
        return false;
    }
}
