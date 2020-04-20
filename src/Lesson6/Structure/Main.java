package Lesson6.Structure;

import Lesson6.Structure.Tree.IllegalLevelException;
import Lesson6.Structure.Tree.TreeMap;

import java.util.ArrayList;

public class Main {
    static final int   TREE_COUNT = 20;
    static final int   TREE_LEVEL = 6;
    static       int   randomValue;
    static       float balancedCount;

    public static void main(String[] args) {
        ArrayList<TreeMap> treeList = new ArrayList<>();

        processTrees(treeList, null);

    }

    static int getRandom(int _from, int _too){
        return (int) (Math.random() * (_too + 1 - _from) + _from);
    }

    static void processTrees(ArrayList _treeList, TreeMap _treeMap){
        for (int i = 0; i < TREE_COUNT;) {
            if (_treeMap == null)
                _treeMap = new TreeMap<>(TREE_LEVEL);

            randomValue = getRandom(-100, 100);

            try{
                _treeMap.put(randomValue,randomValue);
            }catch (IllegalLevelException e){
                System.out.println(String.format("Дерево заполнено - %s", _treeMap.isBalanced()?"сбалансировано":"не сбалансировано"));
                _treeList.add(_treeMap);
                if(_treeMap.isBalanced())
                    balancedCount++;

                _treeMap = null;
                i++;
            }

        }
        System.out.println(String.format("Доля сбалансированных деневьев - %1.2f процентов.", (balancedCount / TREE_COUNT * 100)));
    }
}