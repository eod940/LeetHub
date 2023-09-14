import java.util.*;

class Solution {
    static class MyArr implements Comparable<MyArr> {
        int val, idx;

        public MyArr(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(MyArr o) {
            return this.val - o.val;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        int front = 0, rear = nums.length - 1;
        int[] answer = new int[2];
        MyArr[] arr = new MyArr[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = new MyArr(nums[i], i);
        }

        Arrays.sort(arr);

        while (front != rear) {
            if (arr[front].val + arr[rear].val > target) {
                rear -= 1;
            } else if (arr[front].val + arr[rear].val < target) {
                front += 1;
            } else {
                answer[0] = arr[front].idx;
                answer[1] = arr[rear].idx;
                break;
            }
        }

        return answer;
    }
}