import com.sun.jdi.Value;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException{
        System.out.print("Введите два числа от 1 до 10 (можно римскими) и действие между ними (всё через пробелы): ");
        Scanner in = new Scanner(System.in);
        String vhod = in.nextLine();
        System.out.println(calc(vhod));
        in.close();
    }
    static String calc(String input) throws IOException {
        String [] rims = "- I II III IV V VI VII VIII IX X".split(" ");
        boolean isXRims = false;
        boolean isyRims = false;
        int x = 0;
        int y = 0;
        String [] a = input.strip().split(" ");
        if (a.length != 3){
            throw new IOException();
        }
        for(int i = 0;i < rims.length; i++){
            if (a[0].equals(rims[i])){
                x = i;
                isXRims = true;
            }
            if (a[2].equals(rims[i])){
                y = i;
                isyRims = true;
            }
        }
        if (isyRims != isXRims){
            throw new IOException();
        }
        if (!isyRims & !isXRims){
            x = Integer.parseInt(a[0]);
            y = Integer.parseInt(a[2]);
        }
        if (x > 10 || x < 1 || y > 10 || y < 1){
            throw new IOException();
        }
        int predres = 0;
        if (a[1].equals("+")) {
            predres = (x + y);
        }
        if (a[1].equals("-")) {
            predres = (x - y);
        }
        if (a[1].equals("*")) {
            predres = (x * y);
        }
        if (a[1].equals("/")) {
            predres = (x / y);
        }
        String result = Integer.toString(predres);
        if (isyRims & isXRims & predres < 0){
            throw new IOException();
        }
        String [] fromRims = "- I II III IV V VI VII VIII IX X XI XII XIII XIV XV XVI XVII XVIII XIX XX XXI XXII XXIII XXIV XXV XXVI XXVII XXVIII XXIX XXX XXXI XXXII XXXIII XXXIV XXXV XXXVI XXXVII XXXVIII XXXIX XL XLI XLII XLIII XLIV XLV XLVI XLVII XLVIII XLIX L LI LII LIII LIV LV LVI LVII LVIII LIX LX LXI LXII LXIII LXIV LXV LXVI LXVII LXVIII LXIX LXX LXXI LXXII LXXIII LXXIV LXXV LXXVI LXXVII LXXVIII LXXIX LXXX LXXXI LXXXII LXXXIII LXXXIV LXXXV LXXXVI LXXXVII LXXXVIII LXXXIX XC XCI XCII XCIII XCIV XCV XCVI XCVII XCVIII XCIX C".split(" ");
        if (isyRims  & isXRims ){
            for(int i = 0; i < fromRims.length; i++){
                if (predres == i){
                    return fromRims[i];
                }
            }
        }
        return result;
    }
}