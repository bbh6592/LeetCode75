class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = n - 1; i >= 0; i--) {
            // Remove all days from the stack that are not warmer
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If stack is not empty, the top is the next warmer day
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }

            // Push current day onto the stack
            stack.push(i);
        }

        return answer;
    }
}
