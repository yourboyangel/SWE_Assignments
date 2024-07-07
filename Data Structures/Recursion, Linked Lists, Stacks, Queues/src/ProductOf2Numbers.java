//Exercise 2
public class ProductOf2Numbers {
    private static long product(int m, int n){
        long result=0;
        if(m==0||n==0) return 0;
        result+=m+product(m,n-1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(product(0,0));
        System.out.println(product(0,6));
        System.out.println(product(6,0));
        System.out.println(product(100,100));
    }
}
