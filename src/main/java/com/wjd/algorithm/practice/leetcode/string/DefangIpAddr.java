package com.wjd.algorithm.practice.leetcode.string;

import com.wjd.algorithm.practice.leetcode.Solution;

/**
 * 1108. IP地址无效化
 * <p>
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * @since 2022/6/21
 * @author weijiaduo
 */
public class DefangIpAddr implements Solution<String> {

    @Override
    public String solve(Object... args) {
        String address = "255.100.50.0";
        String result = defangIpAddr(address);
        System.out.println(result);
        return result;
    }

    /**
     * 思路：直接遍历，碰到.换成[.]
     *
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.8 MB,击败了5.21% 的Java用户
     */
    private String defangIpAddr(String address) {
        StringBuilder sb = new StringBuilder();
        int n = address.length();
        for (int i = 0; i < n; i++) {
            char ch = address.charAt(i);
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
