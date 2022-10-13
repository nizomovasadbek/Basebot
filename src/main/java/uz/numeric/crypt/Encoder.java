package uz.numeric.crypt;

public class Encoder implements Crypt{

    @Override
    public String doCrypt(String text){
        text = text.replaceAll("g\'", "31, ");
        text = text.replaceAll("o\'", "0, ");
        text = text.replaceAll("ch", "15, ");
        text = text.replaceAll("sh", "5, ");
        text = text.replaceAll("ng", "60, ");
        text = text.replaceAll("a", "18, ");
        text = text.replaceAll("b", "1, ");
        text = text.replaceAll("d", "50, ");
        text = text.replaceAll("e", "17, ");
        text = text.replaceAll("f", "35, ");
        text = text.replaceAll("g", "20, ");
        text = text.replaceAll("h", "40, ");
        text = text.replaceAll("i", "2, ");
        text = text.replaceAll("j", "90, ");
        text = text.replaceAll("k", "12, ");
        text = text.replaceAll("l", "16, ");
        text = text.replaceAll("m", "80, ");
        text = text.replaceAll("n", "11, ");
        text = text.replaceAll("o", "6, ");
        text = text.replaceAll("p", "99, ");
        text = text.replaceAll("q", "19, ");
        text = text.replaceAll("r", "14, ");
        text = text.replaceAll("s", "8, ");
        text = text.replaceAll("t", "9, ");
        text = text.replaceAll("u", "13, ");
        text = text.replaceAll("v", "29, ");
        text = text.replaceAll("x", "70, ");
        text = text.replaceAll("y", "7, ");
        text = text.replaceAll("z", "30, ");

        return text.substring(0, text.length()-2);
    }

}
