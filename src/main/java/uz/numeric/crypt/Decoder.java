package uz.numeric.crypt;

import uz.numeric.exception.UnsolvedHashException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder implements Crypt {

    private boolean validate(String text){
        Pattern pattern = Pattern.compile("[a-zA-Z\\_]+");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) return false;
        return true;
    }

    private boolean isDigit(char c){
        int range = (int) c;
        if(range >= 48 && range<=57){
            return true;
        }
        return false;
    }

    private String appendNegative(String text){
        text.replaceAll("\\s+", " ");
        char[] str = text.toCharArray();
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < str.length; i++){
            if(i==0 || i == str.length - 1) continue;
            if(str[i] == ' ' && this.isDigit(str[i-1]) && this.isDigit(str[i+1])){
                str[i] = '-';
            }
        }

        for(char x : str){
            if(x == '-'){
                list.add(' ');
                list.add('-');
                list.add('1');
                list.add(' ');
            }
            list.add(x);
        }

        String temp = "";

        for(Character x : list){
            temp += x;
        }

        return temp;
    }

    private String swap(String hash){
        hash = hash.replaceAll("11", "n");
        hash = hash.replaceAll("12", "k");
        hash = hash.replaceAll("13", "u");
        hash = hash.replaceAll("14", "r");
        hash = hash.replaceAll("15", "ch");
        hash = hash.replaceAll("16", "l");
        hash = hash.replaceAll("17", "e");
        hash = hash.replaceAll("18", "a");
        hash = hash.replaceAll("19", "q");
        hash = hash.replaceAll("20", "g");
        hash = hash.replaceAll("29", "v");
        hash = hash.replaceAll("30", "z");
        hash = hash.replaceAll("31", "g\'");
        hash = hash.replaceAll("35", "f");
        hash = hash.replaceAll("40", "h");
        hash = hash.replaceAll("50", "d");
        hash = hash.replaceAll("60", "ng");
        hash = hash.replaceAll("70", "x");
        hash = hash.replaceAll("80", "m");
        hash = hash.replaceAll("90", "j");
        hash = hash.replaceAll("99", "p");
        hash = hash.replaceAll("\\-1", " ");
        hash = hash.replaceAll("0", "o\'");
        hash = hash.replaceAll("1", "b");
        hash = hash.replaceAll("2", "i");
        hash = hash.replaceAll("5", "sh");
        hash = hash.replaceAll("6", "o");
        hash = hash.replaceAll("7", "y");
        hash = hash.replaceAll("8", "s");
        hash = hash.replaceAll("9", "t");
        return hash;
    }

    @Override
    public String doCrypt(String text){
        if(!this.validate(text)){
            try {
                throw new UnsolvedHashException("cannot decrypt the text you've entered");
            } catch (UnsolvedHashException e) {
                throw new RuntimeException(e);
            }
        }
        String result = this.appendNegative(text);
        result = result.replaceAll(",", " ");
        result = result.replaceAll("\\s+", " ");
        String[] letter = result.split("\\s");
        result = "";
        for(String x : letter){
//            System.out.println(x);
            result += swap(x);
        }
        result = result.replaceAll("\\-", "");
        return result;
    }

}
