package com.wjd.algorithm.sort;

import java.util.Arrays;

/**
 * 计数排序
 *
 * @author weijiaduo
 * @since 2022/9/5
 */
public class CountSort implements Sort {

    int[] counts;
    int min;
    int max;

    @Override
    public void sort(int[] arr) {
        // 初始化参数
        initCounts(arr);

        // 统计所有数字的数量
        for (int num : arr) {
            counts[countIndex(num)]++;
        }

        // 累计数量和
        for (int i = 1, n = counts.length; i < n; i++) {
            counts[i] += counts[i - 1];
        }

        // 倒序遍历获取排序结果
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = copy.length - 1; i >= 0; i--) {
            int index = countIndex(copy[i]);
            counts[index]--;
            arr[counts[index]] = copy[i];
        }
    }

    /**
     * 初始化一些参数
     *
     * @param arr 数组
     */
    private void initCounts(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        this.min = min;
        this.max = max;
        int n = max - min + 1;
        counts = new int[n];
    }

    private int countIndex(int val) {
        return val - min;
    }

}