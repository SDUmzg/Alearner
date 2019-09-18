package com.alearner.util;

import com.alearner.model.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeetcodeUtil {




    /**
     * NO.1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     *
     *性能：389ms
     * */
    public static int[] twoSum(int[] nums, int target) {
        Map<String,Integer> numMap = new HashMap<>();
        for (int i = 0 ; i< nums.length;i++){
            numMap.put(nums[i]+","+i,i);
        }

        int [] res = new int[2];
        for (String item:numMap.keySet()){
            String[] temp = item.split(",");
            int other = target-Integer.valueOf(temp[0]);
            for (int i= 0; i< nums.length;i++){
                if (nums[i]==other){
                    res[0]=numMap.get(item);
                    res[1]=i;
                    if (numMap.get(item).intValue()==i){
                        continue;
                    }
                    return res;
                }
            }
        }
        return null;
    }

    /**
     * NO.1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     *
     * 性能 ： 54ms
     * */
    public static int[] twoSum1(int[] nums, int target) {

        for (int i = 0 ; i < nums.length ; i++){
            int nowNum = nums[i];
            for (int j = i+1 ; j < nums.length;j++){
                int nextNum = nums[j];
                if (nowNum+nextNum == target){
                    int[] res={i,j};
                    return res;
                }
            }
        }
        return null;
    }



    /**
     * NO.1
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的 两个 整数。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * 不通用
     * 性能：2ms
     * */
    public static int[] twoSum2(int[] nums, int target) {
        final int len = nums.length;
        int n = len - 1;
        n |= 8191;
        final int hash = n;
        final int bucketSize = n + 1;
        final int[] root = new int[bucketSize];
        final int[] linked = new int[len];

        for (int i = 1; i < len; i++) {
            int self = nums[i];
            int aim = target - self;
            if (aim == nums[0]) {
                return new int[]{0, i};
            }
            int aimRootIndex = root[aim & hash];
            while (aimRootIndex != 0) {
                if (nums[aimRootIndex] == aim) {
                    return new int[]{aimRootIndex, i};
                }
                aimRootIndex = linked[aimRootIndex];
            }
            int thisIndex = self & hash;
            linked[i] = root[thisIndex];
            root[thisIndex] = i;
        }
        return null;

    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(1);
        return null;
    }



}
