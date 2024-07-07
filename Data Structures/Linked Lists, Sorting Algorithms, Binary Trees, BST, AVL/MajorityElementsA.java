import java.util.ArrayList;
import java.util.List;

//Exercise 6 A and B
public class MajorityElementsA {
    public List<Integer> majority (int[] nums){
        List<Integer> result= new ArrayList<>();
        if(nums==null || nums.length==0){
            return result;
        }

        int num1=0;
        int num2=0;
        int cnt1=0;
        int cnt2=0;

        for(int num : nums){
            if(num==num1){
                cnt1++;
            }
            else if(num==num2){
                cnt2++;
            }
            else if(cnt1==0){
                num1=num;
                cnt1=1;
            }
            else if(cnt2==0){
                num2=num;
                cnt2=1;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;
        for(int num : nums){
            if(num==num1){
                cnt1++;
            }
            else if(num==num2){
                cnt2++;
            }
        }

        int n=nums.length;
        if(cnt1>n/3){
            result.add(num1);
        }
        if(cnt2>n/3){
            result.add(num2);
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElementsA a= new MajorityElementsA();
        int[] nums1 = {3,2,3};
        System.out.println(a.majority(nums1));

        int[] nums2 = {1};
        System.out.println(a.majority(nums2));

        int[] nums3 = {1,2};
        System.out.println(a.majority(nums3));
    }
}

