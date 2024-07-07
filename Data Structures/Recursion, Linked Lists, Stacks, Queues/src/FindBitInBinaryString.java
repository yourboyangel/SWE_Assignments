//Exercise 3
public class FindBitInBinaryString {
    public static String findString(int n){
        String finalString;
        String previousString;
        if(n==1){
            return "1";
        }
        previousString=findString(n-1);
        finalString=previousString+"0"+invert(reverse(previousString));
        return finalString;
    }

    private static String invert(String string){
        char[] bits=string.toCharArray();
        for (int i=0;i<bits.length;i++){
            if(bits[i]=='0') bits[i]='1';
            else bits[i]='0';
        }
        return new String(bits);
    }

    private static String reverse(String string){
        char[] bits=string.toCharArray();
        char temp;
        for(int i=0,j=bits.length-1;i<j;i++,j--){
            temp=bits[i];
            bits[i]=bits[j];
            bits[j]=temp;
        }
        return new String(bits);
    }

    public static int findBit(int n, int i){
        String bitString=findString(n);
        char[] bits=bitString.toCharArray();
        int result=bits[i-1]-'0';
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findBit(3,1));
        System.out.println(findBit(4,11));

    }
}
