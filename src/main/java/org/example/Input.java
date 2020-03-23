package org.example;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public ArrayList<String> ls;
    protected String toIngore;
    protected String required;
    public Input(ArrayList<String> ls){
        this.ls=ls;
    }
    public void input(){
        System.out.println("1.Import a file");
        System.out.println("2.Manually input");
        System.out.println("===Please Choose an options");
        Scanner scanner = new Scanner(System.in);
        int option =Integer.parseInt(scanner.nextLine());
        if(option == 1) {
            System.out.println("File path:");
            Scanner scanner1 = new Scanner(System.in);
            String path =  scanner1.nextLine().trim();
            BufferedReader reader;
            String line;
            try {
                reader = new BufferedReader(new FileReader(path));
                while ((line = reader.readLine()) != null) {
                    ls.add(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else  if(option == 2) {
            System.out.println("Your input:(Type '*' to end input)");
            Scanner scanner2 = new Scanner(System.in);
            String str="";
            while((!str.equals("*"))){
                str=scanner2.nextLine().trim();
                if(!str.equals("*"));
                ls.add(str);
            }
        }
        setIngore();
        setRequired();

    }

    public void setIngore(){
        System.out.println("Words to ignore:(Type '*' to end input)");

        Scanner scanner2 = new Scanner(System.in);
        String str="";
        String toIngore1 ="";
        while((!str.equals("*"))){
            str=scanner2.nextLine().trim();
            if(!str.equals("*")){
                if( toIngore1.equals(""))
                    toIngore1 =  str;
                else
                    toIngore1 += "\n"+str;
            }
        }
        this.toIngore=convertString(toIngore1,"\\n","|");
    }

    public void setRequired(){
        System.out.println("Required Words:");

        Scanner scanner2 = new Scanner(System.in);
        String str="";
        String required1 ="";
        while((!str.equals("*"))){
            str=scanner2.nextLine().trim();
            if(!str.equals("*")){
                if( required1.equals(""))
                    required1 =  str;
                else
                    required1 += "\n"+str;
            }
        }
        this.required=convertString(required1,"\\n","|");
    }

    public String getIngore(){
        return this.toIngore;
    }

    public String getRequired(){
        return this.required;
    }

    public String convertString(String str, String delimiter, String newDelimiter ){
        if(str.trim().equals(""))return "";
        String[] temp = str.split(delimiter);
        String fullStr = "";
        System.out.println(temp.length);
        for(int i=0;i<temp.length;i++) {
            if(!temp[i].equals(""))
                fullStr += newDelimiter + temp[i] + newDelimiter;

        }

        return fullStr;
    }
}
