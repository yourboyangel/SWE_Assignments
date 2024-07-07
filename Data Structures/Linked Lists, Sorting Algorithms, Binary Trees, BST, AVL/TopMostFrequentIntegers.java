import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Exercise 5
public class TopMostFrequentIntegers {
    public int[] topK (int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int number: nums){
            map.put(number,map.getOrDefault(number,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap= new PriorityQueue<>(
                (a,b)->a.getValue() - b.getValue()
        );

        for (Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.offer(entry);
            if(heap.size()>k){
                heap.poll();
            }
        }

        int[] top = new int[k];
        for(int i=0; i<k; i++){
            top[i]=heap.poll().getKey();
        }
        return top;
    }

    public static void main(String[] args) {
        TopMostFrequentIntegers top = new TopMostFrequentIntegers();
        int[] nums = {1,1,1,2,2,3};
        int k=2;
        System.out.println(Arrays.toString(top.topK(nums,k)));

        int[] nums2 ={1,2};
        System.out.println(Arrays.toString(top.topK(nums2,k)));
    }
}
