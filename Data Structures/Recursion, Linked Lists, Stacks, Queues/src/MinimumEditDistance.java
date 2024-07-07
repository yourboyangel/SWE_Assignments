//Exercise 4
public class MinimumEditDistance {
    public static int minDistance(String s, String t){
        int[][] memo=new int[s.length()][t.length()];
       return recursion(s,t,s.length()-1,t.length()-1,memo);
    }

    private static int recursion(String s, String t, int i, int j, int[][]memo){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(memo[i][j]!=0) return memo[i][j];

        if(s.charAt(i)==t.charAt(j)){
            memo[i][j]=recursion(s,t,i-1,j-1,memo);
        }
        else{
            int substitution=recursion(s,t,i-1,j-1,memo);
            int insertion=recursion(s,t,i,j-1,memo);
            int deletion=recursion(s,t,i-1,j,memo);
            memo[i][j]=1+Math.min(substitution, Math.min(insertion,deletion));
        }

        return memo[i][j];

    }

    public static void main(String[] args) {
        String s="a cat!", t="the cats!";
        System.out.println("The minimum edit distance between '"+s+"' and '"+t+"' is "+minDistance(s,t));

    }

}
