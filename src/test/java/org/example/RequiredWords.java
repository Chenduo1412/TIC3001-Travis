package company.tojava;

import java.util.Scanner;

public class RequiredWords {
    public String required;
    public RequiredWords(){
    }
    public String setRequired(){
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
