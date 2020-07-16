package sven666.common.bdcommon.utils.tree;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : S_ven
 * @create : 2019-07-10 14:45
 * @describe: TreeTools
 */
public class TreeTools {

    /**
     * 把列表转换为树结构
     *
     * @param originalList 原始list数据
     * @return 组装后的集合
     */
    public static <T extends TreeNodeInterface<T>> List<T> getTree(List<T> originalList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 获取根节点，即找出父节点为空的对象
        List<T> topList = new ArrayList<T>();
        for (T t : originalList) {
            if (t.getNodeParentPk() == null || t.getNodeParentPk().trim().equals("0")) {
                topList.add(t);
            }
        }

        // 将根节点从原始list移除，减少下次处理数据
        originalList.removeAll(topList);

        // 递归封装树
        fillTree(topList, originalList);

        return topList;
    }

    /**
     * 封装树
     *
     * @param parentList   要封装为树的父对象集合
     * @param originalList 原始list数据
     */
    private static <T extends TreeNodeInterface<T>> void fillTree(List<T> parentList, List<T> originalList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        for (T t : parentList) {
            List<T> childList = fillChildren(t, originalList);
            if (childList.isEmpty()) {
                continue;
            }
            originalList.removeAll(childList);
            fillTree(childList, originalList);
        }
    }


    /**
     * 封装子对象
     *
     * @param parent       父对象
     * @param originalList 待处理对象集合
     */
    private static <T extends TreeNodeInterface<T>> List<T> fillChildren(T parent, List<T> originalList) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<T> childList = new ArrayList<T>();

        for (T t : originalList) {
            if (parent.getNodePk().equals(t.getNodeParentPk())) {
                childList.add(t);
            }
        }

        if (!childList.isEmpty()) {
            parent.getNodeChildren().addAll(childList);
        }

        return childList;
    }

    /**
     * 获取目标节点（包含自己）的子节点集合
     *
     * @param originalList 原始list数据
     * @param pk           主键id属性名
     * @param ppk          父节点id属性名
     * @param children     子节点列表属性名
     * @param target       目标节点
     */
    public static <T> List<String> getNodes(List<T> originalList, String pk, String ppk, String children, String target) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<String> result = new ArrayList<String>();
        for (T t : originalList) {
            String pkid = BeanUtils.getProperty(t, pk);
            if (pkid.equals(target)) {
                result.add(pkid);
            }
        }
        return result;
    }

}