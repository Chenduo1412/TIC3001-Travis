package company.tojava;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Input {
    public ArrayList<String> ls;

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

    }
}
