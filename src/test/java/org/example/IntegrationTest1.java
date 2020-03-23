package org.example;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest1 {

    @org.junit.jupiter.api.Test
    void testCase1() {
        String input="Back to the Future\n" +
                "Desperado\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "Ghostbusters\n" +
                "Cool World\n" +
                "Donnie Darko\n" +
                "Double Indemnity";
        String wordsToIgnore="";
        String wordsRequired="";
        String toIgnore="";
        String required="";
        if(!wordsToIgnore.equals(""))
            toIgnore=convertFormat(wordsToIgnore,"\\n","|");
        if(!wordsRequired.equals(""))
            required=convertFormat(wordsRequired,"\\n","|");
        ArrayList<String> orgls = new ArrayList<String>();
        ArrayList<String> fullStrArr = new ArrayList<String>();
        convertToList(input,orgls);
        CircularShifter cs=new CircularShifter(orgls,wordsToIgnore,wordsRequired);
        cs.shift(orgls,fullStrArr);
        String result = "";
        if(fullStrArr.size()>0) {
            Alphabetizer alp = new Alphabetizer(fullStrArr);
            alp.alpha();

            for (int i = 0; i < fullStrArr.size(); i++) {
                result += (fullStrArr.get(i) + "\n");
            }
        }
        assertEquals("at the Museum Night\n" +
                "Back to the Future\n" +
                "Cool World\n" +
                "Darko Donnie\n" +
                "Desperado\n" +
                "Donnie Darko\n" +
                "Double Indemnity\n" +
                "Future Back to the\n" +
                "Ghostbusters\n" +
                "Indemnity Double\n" +
                "Museum Night at the\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "the Future Back to\n" +
                "the Museum Night at\n" +
                "to the Future Back\n" +
                "World Cool\n",result);
    }


    @org.junit.jupiter.api.Test
    void testCase2() {
        String input="Back to the Future\n" +
                "Desperado\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "Ghostbusters\n" +
                "Cool World\n" +
                "donnie Darko\n" +
                "Double Indemnity";
        String wordsToIgnore="cool\n" +
                "a\n" +
                "the\n" +
                "to\n" +
                "donniE";
        String wordsRequired="";

        String toIgnore="";
        String required="";
        if(!wordsToIgnore.equals(""))
            toIgnore=convertFormat(wordsToIgnore,"\\n","|");
        if(!wordsRequired.equals(""))
            required=convertFormat(wordsRequired,"\\n","|");
        ArrayList<String> orgls = new ArrayList<String>();
        ArrayList<String> fullStrArr = new ArrayList<String>();
        convertToList(input,orgls);
        CircularShifter cs=new CircularShifter(orgls,toIgnore,required);
        cs.shift(orgls,fullStrArr);
        String result = "";
        if(fullStrArr.size()>0) {
            Alphabetizer alp = new Alphabetizer(fullStrArr);
            alp.alpha();

            for (int i = 0; i < fullStrArr.size(); i++) {
                result += (fullStrArr.get(i) + "\n");
            }
        }
        assertEquals("at the Museum Night\n" +
                "Back to the Future\n" +
                "Darko donnie\n" +
                "Desperado\n" +
                "Double Indemnity\n" +
                "Future Back to the\n" +
                "Ghostbusters\n" +
                "Indemnity Double\n" +
                "Museum Night at the\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "World Cool\n",result);
    }

    @org.junit.jupiter.api.Test
    void testCase3() {
        String input="Back to the Future\n" +
                "Desperado\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "Ghostbusters\n" +
                "Cool World\n" +
                "donnie Darko\n" +
                "Double Indemnity";
        String wordsToIgnore="cool\n" +
                "a\n" +
                "the\n" +
                "to\n" +
                "donniE";
        String wordsRequired="world\n" +
                "ghost\n" +
                "robocop";

        String toIgnore="";
        String required="";
        if(!wordsToIgnore.equals(""))
            toIgnore=convertFormat(wordsToIgnore,"\\n","|");
        if(!wordsRequired.equals(""))
            required=convertFormat(wordsRequired,"\\n","|");
        ArrayList<String> orgls = new ArrayList<String>();
        ArrayList<String> fullStrArr = new ArrayList<String>();
        convertToList(input,orgls);
        CircularShifter cs=new CircularShifter(orgls,toIgnore,required);
        cs.shift(orgls,fullStrArr);
        String result = "";
        if(fullStrArr.size()>0){
            Alphabetizer alp=new Alphabetizer(fullStrArr);
            alp.alpha();

            for(int i=0;i<fullStrArr.size();i++){
                result+= (fullStrArr.get(i)+"\n");
            }
        }
        assertEquals("Robocop\n" +
                "World Cool\n",result);
    }

    @org.junit.jupiter.api.Test
    void testCase4() {
        String input="Back to the Future\n" +
                "Desperado\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "Ghostbusters\n" +
                "Cool World\n" +
                "donnie Darko\n" +
                "Double Indemnity";
        String wordsToIgnore="cool\n" +
                "a\n" +
                "the\n" +
                "to\n" +
                "donniE";
        String wordsRequired="ghost";

        String toIgnore="";
        String required="";
        if(!wordsToIgnore.equals(""))
            toIgnore=convertFormat(wordsToIgnore,"\\n","|");
        if(!wordsRequired.equals(""))
            required=convertFormat(wordsRequired,"\\n","|");
        ArrayList<String> orgls = new ArrayList<String>();
        ArrayList<String> fullStrArr = new ArrayList<String>();
        convertToList(input,orgls);

        CircularShifter cs=new CircularShifter(orgls,toIgnore,required);
        cs.shift(orgls,fullStrArr);
        String result = "";
        if(fullStrArr.size()>0){
            Alphabetizer alp=new Alphabetizer(fullStrArr);
            alp.alpha();
            System.out.println("reach here");

            for(int i=0;i<fullStrArr.size();i++){
                result+= (fullStrArr.get(i)+"\n");
            }
        }
        assertEquals("",result);
    }

    @org.junit.jupiter.api.Test
    void testCase5() {
        String input="Back to the Future\n" +
                "Desperado\n" +
                "Night at the Museum\n" +
                "Robocop\n" +
                "Ghostbusters\n" +
                "Cool World\n" +
                "donnie Darko\n" +
                "Double Indemnity";
        String wordsToIgnore="";
        String wordsRequired="ghost\n" +
                "back\n" +
                "cool";

        String toIgnore="";
        String required="";
        if(!wordsToIgnore.equals(""))
            toIgnore=convertFormat(wordsToIgnore,"\\n","|");
        if(!wordsRequired.equals(""))
            required=convertFormat(wordsRequired,"\\n","|");
        ArrayList<String> orgls = new ArrayList<String>();
        ArrayList<String> fullStrArr = new ArrayList<String>();
        convertToList(input,orgls);

        CircularShifter cs=new CircularShifter(orgls,toIgnore,required);
        cs.shift(orgls,fullStrArr);
        String result = "";
        if(fullStrArr.size()>0){
            Alphabetizer alp=new Alphabetizer(fullStrArr);
            alp.alpha();

            for(int i=0;i<fullStrArr.size();i++){
                result+= (fullStrArr.get(i)+"\n");
            }
        }
        assertEquals("Back to the Future\n" +
                "Cool World\n",result);
    }
    void convertToList(String str,ArrayList ls){
        String strArr[] = str.split("\n");
        for(int i=0;i<strArr.length;i++){
            ls.add(strArr[i]);
        }
    }
    public String convertFormat(String str, String delimiter, String newDelimiter ){
        if(str.trim().equals(""))return "";
        String[] temp = str.split(delimiter);
        String fullStr = "";

        for(int i=0;i<temp.length;i++) {
            if(!temp[i].equals(""))
                fullStr += newDelimiter + temp[i] + newDelimiter;

        }

        return fullStr;
    }

}
