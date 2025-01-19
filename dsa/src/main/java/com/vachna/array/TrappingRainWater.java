package com.vachna.array;

public class TrappingRainWater {

    /**
     * https://leetcode.com/problems/trapping-rain-water/description/
     */
    public TrappingRainWater(){
        int[] arr = {1,2,3,2,3,1,0,5,3,1,0};
        int water = trap(arr);
        System.out.println(water);
        System.out.println(trapOptimized(arr));
    }
    public int trapOptimized(int[] height){
        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1];
        int water = 0, l = 0, r = n-1;

        while(l < r){
            if(height[l] <= height[r]){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
            }
        }
        return water;
    }

    public int trap(int[] height) {
        int[] prefix = prefixArray(height);
        int[] suffix = suffixArray(height);
        int water = 0;
        for(int i=0; i<height.length; i++){
            water += (Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return water;
    }

    public int[] prefixArray(int[] arr){
        int l = arr.length;
        int[] prefix = new int[l];
        for(int i = 0; i < l; i++){
            prefix[i] = Math.max(arr[i], i==0? 0 : prefix[i-1]);
        }
        return prefix;
    }

    public int[] suffixArray(int[] arr){
        int l = arr.length;
        int[] suffix = new int[l];
        for(int i = l-1; i >= 0; i--){
            suffix[i] = Math.max(arr[i], i==(l-1)? 0 : suffix[i+1]);
        }
        return suffix;
    }

//    public static void main(String[] args) {
//        new TrappingRainWater();
//    }
}
