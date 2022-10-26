package com;
import java.net.*;
import java.io.*;
public class Serveur {
    public static void main(String[] args) {
        try{
            ServerSocket secoute=new ServerSocket(1235);
            System.out.println("Je suis en attente de connexion");

            Socket socket=secoute.accept();
            System.out.println("Connexion accptée");
            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br =new BufferedReader(isr);
            OutputStream os=socket.getOutputStream();
            PrintStream pw=new PrintStream(os,true);
            System.out.println("J'attend une chaine");
            String str=br.readLine();
            String rep="Bonjour Mr "+str;
           
            System.out.println("J'envoie la reponse au client");
            pw.println(rep);   //os.write(res);
            secoute.close();
        }catch(Exception e){
            e.getStackTrace();

        }
    }
}
