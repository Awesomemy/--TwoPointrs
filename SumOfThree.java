package test1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
*/
public class SumOfThree {
    /*
    别一看到几个数求和就立马哈希法
    本体由于需要去重,如果使用哈希法那么需要考虑的细节会非常多
    可以看到题目的要求与下标无关
    于是考虑使用双指针法解决(因为本题用双指针法要求必须在有序数组上操作,而一旦排序就会打乱下标对应关系)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); //双指针法必须排序,因此无法处理返回下标相关的要求,以下讨论皆在数组有序情况下进行
        for (int i = 0; i < nums.length; i++) {
            //排序之后若第一个元素大于0,后续三元组无论如何不可能为0,也就不必再找了,因此进行剪枝操作
            if (nums[i] > 0) {
                return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                //去重a,注意如果判断nums[i]==nums[i+1]那就成了三元组内元素不重复,而不是三元组不重复了
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]}));
                    //去重逻辑应该放在找到一个三元组之后，对b 和 c去重,不然可能把还没记录的组合给去掉了
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    while (right > left && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    right--;
                    left++;   //去重后还左右指针还要各移动1位,为的是继续寻找新的三元组
                }
            }
        }
        return result;
    }
}
