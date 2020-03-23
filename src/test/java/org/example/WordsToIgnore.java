package company.tojava;

import java.util.Scanner;

public class WordsToIgnore{
    public String toIngore;
    public WordsToIgnore(){ }
    public String setIngore(){
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
        return this.toIngore;
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
