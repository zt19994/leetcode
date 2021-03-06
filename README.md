### LeetCode算法和数据结构学习

#### 一、Array and String
##### 1、Array
&emsp;&emsp;数组是一种按顺序存储元素集合的数据结构，并且可以随机访问元素，因为数组中每个元素都有一个唯一索引。<br>
&emsp;&emsp;数组可以有一个和多个维度，一维数组也叫线性数组。
##### 2、String
&emsp;&emsp;字符串实际上是一个unicode字符数组。你可以执行几乎所有数组中包含的操作。

#### 二、Queue and Stack
##### 1、Queue
&emsp;&emsp;Queue 是一个 FIFO 数据结构：第一个元素被最先处理。有两个重要操作：enqueue 和 dequeue。我们使用两个指针和一个动态数组实现 queue。<br>
&emsp;&emsp;可以使用 queue 实现 BFS Breadth-first Search 广度优先搜索。
##### 2、Stack
&emsp;&emsp;Stack 是一个 LIFO 数据结构：最后的元素将被最先处理。有两个重要的操作：push 和 pop。实现 stack 很简单，一个动态数组就够了。<br>
&emsp;&emsp;当LIFO原则得到满足时，我们使用 stack。深度优先搜索（DFS）是堆栈的一个重要应用。
##### 3、概要
总而言之，你应该能够理解和比较以下概念：
1. FIFO and LIFO
2. queue and stack
3. BFS and DFS

#### 三、LinkedList
&emsp;&emsp;有两种链表：单链表和双链表。
##### 1、单链表介绍
&emsp;&emsp;与数组类似，链表也是一个线性数据结构。一个单链表中每个节点不仅包含值，还有一个指向下一个节点的参考字段。通过这种方式，单链表组织了一个序列中的所有节点。

#### 四、HashTable
&emsp;&emsp;哈希表是一种使用散列函数来组织数据的数据结构，用来支持快速插入和搜索。
哈希表有两种不同的类型：散列集(hash set)和散列映射(hash map)。
1. hash set 是一种 set 数据结构的实现，它不存储重复的值。
2. hash map 是一种 map 数据结构的实现，它用来存储键值对 (key,value)。

#### 五、BinaryTree
##### 1、tree
&emsp;&emsp;tree 是用于模拟分层树结构的常用数据结构。<br>
&emsp;&emsp;tree 的每个节点都有一个根值和一些指向其他节点的引用列表。从图表看，一棵树也可以被定义为一个有N个节点和N-1个边的有向无环图。
##### 2、binary tree
&emsp;&emsp;二叉树是最典型的树状结构之一。顾名思义，二叉树是一种树数据结构，其中每个节点最多有两个子节点，它们被称为(left child)左子节点和 (right child)右子节点。
#### 六、BinarySearch
##### 1、介绍
&emsp;&emsp;二分查找是计算机科学中最基本、最实用的算法之一。它描述了在有序集合中搜索特定值的过程。<br>
二分法中的术语：
* Target 你搜索的值
* Index 你正在搜索的当前位置
* Left，Right 我们用来维护我们的搜索空间的独立
* Mid 我们用来判断是否应该向左或向右搜索的一个索引条件

##### 2、二分法的应用
&emsp;&emsp;二分法维护搜索空间的左、右和中间索引，并比较搜索目标和中间值;如果条件不满足或值不相等，一半的搜索空间就会被去掉，而搜索将继续在剩余的一半搜索空间中进行，直到它成功为止。如果搜索以空结束，则表示没有找到目标。

##### 3、模板分析
<img src="https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/Figures/binary_search/Template_Diagram.png" width="80%">

这三个模板各不相同：
* 左、中、右索引赋值
* 循环或递归终止条件
* 后期处理的必要性

模板1和3是最常用的，几乎所有的二分搜索问题都可以很容易地在其中一个中实现。模板2更高级一些，用于某些类型的问题。

这3个提供的模板都提供了一个特定的用例:

模板1 (left <= right):
* 最基本的二分搜索
* 可以在不与元素的邻居进行比较的情况下确定搜索条件(或使用其周围的特定元素)
* 不需要后处理，因为在每个步骤中，您都要检查是否找到了元素。如果到达终点，那么您就知道元素没有找到。

模板2 (left < right):
* 一种实现二分搜索的高级方法。
* 搜索条件需要访问元素的近邻
* 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右
* 搜索空间在每个步骤中至少有2个大小
* 后处理。循环/递归在剩下1个元素时结束。需要评估剩余元素是否满足条件。

模板3 (left + 1 < right):
* 实现二分搜索的另一种方法
* 搜索条件需要访问元素的左邻右舍
* 使用元素的邻居来确定是否满足条件，并决定是向左还是向右
* 搜索空间在每个步骤中至少有3个大小
* 后处理。循环/递归在剩下2个元素时结束。需要评估剩余的元素是否满足条件。
* 后处理。循环/递归在剩下1个元素时结束。需要评估剩余元素是否满足条件。

#### 七、递归
##### 1、介绍
&emsp;&emsp;递归是计算机科学中的一个重要概念。它是许多其他算法和数据结构的基础。

##### 2、递归原理
&emsp;&emsp;递归是一种调用自身为子函数来解决问题的方法。每次递归函数调用自己时，它都将给定的问题简化为子问题，递归调用将继续，直到子问题可以在不进行递归的情况下得到解决为止。

递归函数应该具有以下特性，这样就不会产生无限循环:
1. 一个(或多个)简单的基本情况——不使用递归生成答案的终止场景。
2. 一组规则，也称为递归关系，它将所有其它情况简化为基本情况。
























