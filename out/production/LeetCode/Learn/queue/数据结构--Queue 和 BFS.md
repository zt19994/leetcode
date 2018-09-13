### Queue 和 BFS
#### 1、广度优先搜索 Breath-first-search (BFS) 介绍
&emsp;&emsp;广度优先搜索-Breath--first-search (BFS) 是一种在数据结构中遍历或搜索的算法，如树或图。我们可以使用BFS来完成树中的层级遍历。我们也可以使用BFS找到一条路径，尤其是最短路径，从起始节点到目标节点。<br>
&emsp;&emsp;我们可以在更抽象的场景中使用BFS来遍历所有可能的状态。在这种情况下，我们可以将状态看作图中的节点，转换关系路径看做图中的边。
#### 2、实现 BFS
##### 1.节点处理的顺序是什么？
&emsp;&emsp;在第一轮中，我们处理根节点，在第二轮，我们处理根节点下最近的节点，在第三轮中，我们处理离根节点两步的节点，诸如此类。<br>
&emsp;&emsp;类似于树的级序遍历，离根节点越近的的节点越早处理。
##### 2.队列的 enqueue 和 dequeue 的顺序？
&emsp;&emsp;我们首先将根节点加入队列。然后在每一轮中，我们一个一个处理已经在队列中的节点，并将它们的所有相邻节点添加到队列中。值得注意的是，新添加的节点不会立即被遍历，但将在下一轮中进行处理。<br>
&emsp;&emsp;节点的处理顺序与它们被添加到队列中的顺序是完全相同的，既先进先出(FIFO)。这就是我们在BFS中使用队列的原因。
#### 3. BFS 模板
&emsp;&emsp;在此之前，我们已经介绍了使用BFS的两种主要场景：**进行遍历**或**查找最短路径**。通常，它发生在树或图中。正如我们在这描述中提到的，BFS也可以用于更抽象的场景。<br>
&emsp;&emsp;在一个特定的问题中，在进行BFS之前确定节点和边是很重要的。通常，节点是一个实际的节点或状态，而边是一个实际的边或一个可能的转换方式。

伪代码实现：
```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                add next to queue;
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}
```
1. 如代码中所示，在每一轮中，队列中的节点都是等待处理的节点。
2. 在每一个外部while循环之后，我们离根节点又远了一步。变量step表示了距离根节点和正在访问的当前节点的距离。

&emsp;&emsp;有时，确保我们从不访问节点两次是很重要的。否则，我们可能会陷入无限循环中。如果是这样，我们可以在上面的代码中添加一个散列集来解决这个问题。下面是修改后的伪代码：
```java
/**
 * Return the length of the shortest path between root and target node.
 */
int BFS(Node root, Node target) {
    Queue<Node> queue;  // store all nodes which are waiting to be processed
    Set<Node> used;     // store all the used nodes
    int step = 0;       // number of steps neeeded from root to current node
    // initialize
    add root to queue;
    add root to used;
    // BFS
    while (queue is not empty) {
        step = step + 1;
        // iterate the nodes which are already in the queue
        int size = queue.size();
        for (int i = 0; i < size; ++i) {
            Node cur = the first node in queue;
            return step if cur is target;
            for (Node next : the neighbors of cur) {
                if (next is not in used) {
                    add next to queue;
                    add next to used;
                }
            }
            remove the first node from queue;
        }
    }
    return -1;          // there is no path from root to target
}
```
有两种情况您不需要使用散列集：
1. 您绝对肯定没有循环，例如，在树遍历中;
2. 您确实希望多次将节点添加到队列中。



