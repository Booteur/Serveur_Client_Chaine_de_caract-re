package com;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {

        try{
            Socket sClient=new Socket("localhost",1235);
            InputStream is=sClient.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br =new BufferedReader(isr);
            OutputStream os=sClient.getOutputStream();
            PrintStream pw=new PrintStream(os,true);
            
           
            System.out.println("Veuillez saiisir un nom");
            Scanner Clavier=new Scanner(System.in);
            String nb=Clavier.nextLine();
            pw.println(nb);
            String res=br.readLine();

            System.out.println(res);
            
            sClient.close();
            Clavier.close();
        }catch(Exception e){
            e.getStackTrace();
        }
    }
}
