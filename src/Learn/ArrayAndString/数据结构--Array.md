### 数据结构--Array 数组
#### 1、概述
&emsp;&emsp;数组是数据结构的基本块之一。由于字符串是由一组字符组成的，所以它们都是相似的。
#### 2、介绍数组 
##### 2.1 数组

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/20/screen-shot-2018-03-20-at-191856.png" width="60%">

&emsp;&emsp;数组是一种基本数据结构，可以按顺序存储元素集合，并且可以随机访问元素，因为数组中每个元素都有一个唯一索引。<br>
&emsp;&emsp;数组可以有一个和多个维度，一维数组也叫线性数组。

数组中的基本操作：
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. Initialize 初始化
        int[] a0 = new int[5];
        int[] a1 = {1, 2, 3};
        // 2. Get Length 获取数组长度
        System.out.println("The size of a1 is: " + a1.length);
        // 3. Access Element 访问数组
        System.out.println("The first element is: " + a1[0]);
        // 4. Iterate all Elements 遍历数组
        System.out.print("[Version 1] The contents of a1 are:");
        for (int i = 0; i < a1.length; ++i) {
            System.out.print(" " + a1[i]);
        }
        System.out.println();
        System.out.print("[Version 2] The contents of a1 are:");
        for (int item: a1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 5. Modify Element 修改数组
        a1[0] = 4;
        // 6. Sort 数组排序
        Arrays.sort(a1);
    }
}
```
##### 2.2 动态数组（dynamic array）
&emsp;&emsp;数组有固定的容量，初始化数组时必须定义数组的长度。有时会带来不便和浪费。<br>
&emsp;&emsp;因此，大多数编程语言都提供有内置动态数组，它仍然是一个可以随机访问的列表数据结构，但是它的大小事可变的。例如 C++ 的 vector 和 Java 中的 ArrayList。

动态数组的基本操作：
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // 1. initialize 初始化
        List<Integer> v0 = new ArrayList<>();
        List<Integer> v1;                           // v1 == null
        arrayandstring
        Integer[] a = {0, 1, 2, 3, 4};
        v1 = new ArrayList<>(Arrays.asList(a));
        // 3. make a copy 复制
        List<Integer> v2 = v1;                      // another reference to v1
        List<Integer> v3 = new ArrayList<>(v1);     // make an actual copy of v1
        // 3. get length 获取长度
        System.out.println("The size of v1 is: " + v1.size());;
        // 4. access element 访问数组
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 5. iterate the vector 遍历数组
        System.out.print("[Version 1] The contents of v1 are:");
        for (int i = 0; i < v1.size(); ++i) {
            System.out.print(" " + v1.get(i));
        }
        System.out.println();
        System.out.print("[Version 2] The contents of v1 are:");
        for (int item : v1) {
            System.out.print(" " + item);
        }
        System.out.println();
        // 6. modify element 修改
        v2.set(0, 5);       // modify v2 will actually modify v1
        System.out.println("The first element in v1 is: " + v1.get(0));
        v3.set(0, -1);
        System.out.println("The first element in v1 is: " + v1.get(0));
        // 7. sort 排序
        Collections.sort(v1);
        // 8. add new element at the end of the vector 添加
        v1.add(-1);
        v1.add(1, 6);
        // 9. delete the last element 删除
        v1.remove(v1.size() - 1);
    }
}
```
#### 3、介绍二维数组 2D Array
&emsp;&emsp;与一维数组相似，二维数组也由一系列元素组成。但是这些元素可以放在一个矩形的网格中，而不是一条直线上。

```java
// "static void main" must be defined in a public class.
public class Main {
    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
    }
}
```
##### 3.1 原则
&emsp;&emsp;在某些语言中，多维数组实际上是作为一维数组实现的，而在其他语言中，实际上根本没有多维数组。
1. C++将二维数组存储为一维数组。

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/31/screen-shot-2018-03-31-at-161748.png" width="60%">

2. 在Java中，二维数组实际上是一个一维数组，其中包含M个元素，每个元素都是N个整数的数组。

<img src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/03/31/screen-shot-2018-03-31-at-162857.png" width="60%">

##### 3.2 动态二维数组 Dynamic 2D Array
&emsp;&emsp;与一维动态数组相似，我们也可以定义一个动态的二维数组。实际上，它可以是一个嵌套动态数组