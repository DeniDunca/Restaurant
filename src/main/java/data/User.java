package data;

import java.io.*;
import java.io.FileWriter;


public class User implements Serializable{

    public String getRole(String nume, String parola)
    {
        String role = null;
        try(BufferedReader br = new BufferedReader(new FileReader("user.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
               String[] parts = line.split(" ");

               if(parts[1].equals(nume) && parts[2].equals(parola)) {
                   role = parts[0];
                   System.out.println(role);
               }
               else if (parts[1].equals(nume) || parts[2].equals(parola)) {
                   return "not match";
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return role;
    }

    public void signIn(String nume, String parola) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("user.txt",true)))
        {
            bw.append("\n");
            bw.append("client");
            bw.append(" ");
            bw.append(nume);
            bw.append(" ");
            bw.append(parola);
        }
    }

    public boolean verifyUsername( String nume)
    {
        try(BufferedReader br = new BufferedReader(new FileReader("user.txt")))
        {
            String line;
            while((line = br.readLine()) != null)
            {
                String[] parts = line.split(" ");

                if(parts[1].equals(nume)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
