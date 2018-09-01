package Learn.stack;

import org.junit.Test;

import java.util.*;

/**
 * 钥匙和房间
 * @author zhongtao on 2018/9/1
 */
public class KeysAndRooms {

    /**
     * 1、使用stack存储key
     * 2、set存储访问过的房间
     * 3、当访问房间次数小于房间总数，但是key没有时，返回false
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms){
        Stack<Integer> keyStack = new Stack<>();
        Set<Integer> visitStack = new HashSet<>();
        int idx = 0;
        keyStack.push(idx);
        visitStack.add(idx);
        int countRoom = rooms.size();
        while (countRoom>0){
            if (keyStack.isEmpty()){
                return false;
            }
            Integer pop = keyStack.pop();
            List<Integer> curlist = rooms.get(pop);
            visitStack.add(pop);
            for (Integer integer : curlist) {
                if (!visitStack.contains(integer)){
                    keyStack.push(integer);
                }
            }
            countRoom--;
        }
        return true;
    }

    /**
     * 使用DFS方法，递归遍历房间
     */
    public boolean canVisitAllRooms1(List<List<Integer>> rooms) {
        boolean[] v = new boolean[rooms.size()]; //布尔集合
        dfs(v, 0, rooms);
        for (int i = 0; i < rooms.size(); i++) {
            if (v[i] == false) {
                return false;
            }
        }
        return true;
    }
    public void dfs(boolean[] v, int cur, List<List<Integer>> rooms) {
        if (v[cur] == true) {
            return;
        }
        v[cur] = true;
        for (int room : rooms.get(cur)) {
            dfs(v, room, rooms);
        }
    }


    /**
     * 测试
     */
    @Test
    public void test(){
        //{{1},{2},{3},{}}
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        rooms.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        rooms.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(3);
        rooms.add(list3);
        List<Integer> list4 = new ArrayList<>();
        rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * 测试
     */
    @Test
    public void test1(){
        //{{1},{2},{3},{}}
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        rooms.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        rooms.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        rooms.add(list3);
        List<Integer> list4 = new ArrayList<>();
        list4.add(0);
        rooms.add(list4);
        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * 测试
     */
    @Test
    public void test2(){
        // [[1,3],[1,4],[2,3,2,4,1],[],[4,3,2]]
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        rooms.add(list1);
        List<Integer> list2 = new ArrayList<>();
        rooms.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        rooms.add(list3);
        System.out.println(canVisitAllRooms(rooms));
    }

    /**
     * 测试
     */
    @Test
    public void test3(){
        // [[1,3],[1,4],[2,3,2,4,1],[],[4,3,2]]
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        rooms.add(list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(4);
        rooms.add(list2);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(3);
        list3.add(2);
        list3.add(4);
        list3.add(1);
        rooms.add(list3);
        List<Integer> list4 = new ArrayList<>();
        rooms.add(list4);
        List<Integer> list5 = new ArrayList<>();
        list5.add(4);
        list5.add(3);
        list5.add(2);
        rooms.add(list5);
        System.out.println(canVisitAllRooms(rooms));
    }
}
