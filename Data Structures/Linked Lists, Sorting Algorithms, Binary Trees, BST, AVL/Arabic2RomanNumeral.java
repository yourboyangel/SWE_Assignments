import java.util.TreeMap;

//Exercise 7
public class Arabic2RomanNumeral {
    public String intToRoman(int num){
        if(num<1 || num>3999) throw new IllegalArgumentException("Out of range");

        TreeMap<Integer, String> roman = new TreeMap<>();
        roman.put(1000,"M");
        roman.put(900,"CM");
        roman.put(500,"D");
        roman.put(400, "CD");
        roman.put(100,"C");
        roman.put(90,"XC");
        roman.put(50, "L");
        roman.put(40,"XL");
        roman.put(10,"X");
        roman.put(9,"IX");
        roman.put(5,"V");
        roman.put(4,"IV");
        roman.put(1,"I");

        StringBuilder romanBuilder = new StringBuilder();
        for(int key: roman.descendingKeySet()){
            while(num>=key){
                num-=key;
                romanBuilder.append(roman.get(key));
            }
        }
        return romanBuilder.toString();
    }

    public static void main(String[] args) {
        Arabic2RomanNumeral convertor = new Arabic2RomanNumeral();
        int number=323;
        System.out.println(number+" becomes "+convertor.intToRoman(number));
    }
}
