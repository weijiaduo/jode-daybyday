package com.wjd.structure.tree.general;

import com.wjd.algorithm.tree.general.build.LevelGeneralTreeBuilder;
import com.wjd.algorithm.tree.general.traverse.BuildLevelTraverse;

import java.util.ArrayList;
import java.util.List;

/**
 * 树节点
 *
 * @author weijiaduo
 * @since 2022/12/10
 */
public class Node {

    /**
     * 节点值
     */
    public int val;

    /**
     * 子节点
     */
    public List<Node> children;

    /**
     * @param val 节点值
     */
    public Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }

    /**
     * 构建树
     *
     * @param values 层次遍历的输出结果
     * @return 树根节点
     */
    public static Node build(Integer[] values) {
        return new LevelGeneralTreeBuilder().build(values);
    }

    /**
     * 构建树
     *
     * @param values 层次遍历的输出结果
     * @return 树根节点
     */
    public static Node build(List<Integer> values) {
        return build(values.toArray(new Integer[0]));
    }

    /**
     * 按层次遍历树的数据
     *
     * @param tree 树根节点
     * @return 层次数据
     */
    public static List<Integer> traverse(Node tree) {
        List<Node> list = new BuildLevelTraverse().traverse(tree);
        List<Integer> ret = new ArrayList<>(list.size());
        for (Node node : list) {
            ret.add(node != null ? node.val : null);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "" + val;
    }
}
