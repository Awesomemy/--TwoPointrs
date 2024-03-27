package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

0 <= a, b, c, d < n
a、b、c 和 d 互不相同
nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。
 */
public class SumOfFour {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0 ; i<nums.length ; i++){
            /*
            此处剪枝操作不能像三数之和那样只写nums[i]>target
            因为那里target是0
            如果target是负数
            要注意有可能出现两个负数相加变得更小的问题
             */
            if(nums[i]>target && nums[i]>=0){
                return result; //第一次剪枝
            }
            if (i>0 && nums[i]==nums[i-1]) {
                continue; //对nums[i]去重
            }

            for(int j=i+1 ; j<nums.length ; j++){
                if (j>i+1 && nums[j]==nums[j-1]) {
                    continue; //对j去重
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<right) {
                    long sum = (long)(nums[i]+nums[j]+nums[left]+nums[right]);
                    if(sum>target){
                        right--;
                    }else if (sum<target) {
                        left++;
                    }else{
                        result.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[left],nums[right]}));
                        //这里对left与right的去重仍放在获取结果后
                        while (left<right && nums[right]==nums[right-1]) {
                            right--;
                        }
                        while (left<right && nums[left]==nums[left+1]) {
                            left++;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
