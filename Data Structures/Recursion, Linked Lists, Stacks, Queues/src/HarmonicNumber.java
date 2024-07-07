//Exercise 1
public class HarmonicNumber {
    private static double computeHarmonic(int n){
        double harmonic=0;
        if(n==1) return 1;
        else{
            harmonic+=1.0/n+computeHarmonic(n-1);
            return harmonic;
        }
    }

    public static void main(String[] args) {
        System.out.println(computeHarmonic(5));
    }
}
