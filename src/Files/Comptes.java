package Files;

import Objects.Admin;
import Objects.Particulier;
import Objects.User;

import java.io.*;
import java.util.ArrayList;

public class Comptes<T>{
    public static String SEPARATEUR=";";
    public static String PATH = "comptes.txt";

    public static ArrayList<String> getTxtFileInfo(String path) throws IOException{

            FileReader fr = new FileReader(path);
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
    //intanciate Users and put them in an ArrayList
    public static void instanciateAndStoreData(ArrayList<Particulier> particuliers, ArrayList<Admin> admins)throws IOException{
        ArrayList<String> fileLines = getTxtFileInfo(PATH);

        for (int i=0; i<fileLines.size();i++){
            String userData[]=fileLines.get(i).split(SEPARATEUR);

            if(userData[2].equals("ADMIN")){
                Admin admin = new Admin(userData[0],userData[1]);
                admins.add(admin);
                }
            else if(userData[2].equals("PARTICULIER")){
                Particulier particulier = new Particulier(userData[0],userData[1]);
                particuliers.add(particulier);
            }

        }
    }

    public static void updateFile(ArrayList<Particulier> particuliers, ArrayList<Admin> admins) throws IOException{
        FileWriter fw = new FileWriter(PATH);
        BufferedWriter bw = new BufferedWriter(fw);
        for(int i=0; i< particuliers.size();i++){
            bw.write(particuliers.get(i).getEmail()+SEPARATEUR+particuliers.get(i).getPassword()+SEPARATEUR+particuliers.get(i).getRole());
            bw.newLine();
        }
        for(int i=0; i< admins.size();i++){
            bw.write(admins.get(i).getEmail()+SEPARATEUR+admins.get(i).getPassword()+SEPARATEUR+admins.get(i).getRole());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        fw.close();
    }

    //Look for an email-password match in comptes. If it exists, copy the Objects.User in userInSession
    public static boolean existsInComptes (String email, String password, ArrayList<User> comptes, User userInSession){
        for (int i=0; i<comptes.size();i++){
            if(comptes.get(i).getPassword().equals(password) && comptes.get(i).getEmail().equalsIgnoreCase(email)){
                userInSession=comptes.get(i);
                return true;
            }
        }
        return false;
    }
}
