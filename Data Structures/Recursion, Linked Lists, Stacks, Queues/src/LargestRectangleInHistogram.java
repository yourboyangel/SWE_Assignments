import java.util.Stack;

//Exercise 9
public class LargestRectangleInHistogram {
    public static int findLargestArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;

        for (int i = 0; i <= heights.length; i++) {
            int h;
            if (i == heights.length) h = 0;
            else h = heights[i];

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;

                if (stack.isEmpty()) width = 1;
                else width = i - stack.peek() - 1;

                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(findLargestArea(heights));
    }
}
