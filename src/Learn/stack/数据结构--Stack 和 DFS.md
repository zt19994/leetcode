### Stack and DFS 
#### 1、介绍
&emsp;&emsp;与BFS相似，深度优先搜索（DFS）是另一种重要的算法，可以在树/图中进行搜索/搜索。而且它也可以用于更抽象的场景。<br>
&emsp;&emsp;正如在树形遍历中所提到的，我们可以使用DFS进行前序、中序和后序遍历。这三种遍历顺序有一个共同的特征：除非我们到达最深的节点，否则我们永远不会回溯。<br>
&emsp;&emsp;这也是DFS和BFS之间最大的区别，除非它已经访问了当前级别的所有节点，否则BFS永远不会深入下一级别的节点。<br>
&emsp;&emsp;通常，我们使用递归实现DFS。堆栈在递归中扮演着重要的角色。还需要了解递归的缺点，在没有递归的情况下提供DFS的另一个实现。
#### 2、DFS 模板一
&emsp;&emsp;在大多数情况下，我们也可以在使用BFS时使用DFS。但是有一个重要的区别：遍历顺序。<br>
&emsp;&emsp;与BFS不同的是，您先前访问的节点可能不是更接近根节点的节点。因此，您在DFS中找到的第一个路径可能不是最短路径。

递归：
```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}
```
当我们递归地实现DFS时，似乎我们不需要使用任何堆栈。但实际上，我们使用的是系统提供的隐式堆栈，也称为调用堆栈。

#### 3、DFS 模板二
&emsp;&emsp;递归解决方案的优点是它更容易实现。然而，有一个巨大的缺点：如果递归的深度太高，您将会受到堆栈溢出的影响。在这种情况下，您可能想要使用BFS，或者使用显式堆栈来实现DFS。

这里我们提供了一个使用显式堆栈的模板：
```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(int root, int target) {
    Set<Node> visited;
    Stack<Node> s;
    add root to s;
    while (s is not empty) {
        Node cur = the top element in s;
        return true if cur is target;
        for (Node next : the neighbors of cur) {
            if (next is not in visited) {
                add next to s;
                add next to visited;
            }
        }
        remove cur from s;
    }
    return false;
}
```
递归解决方案的逻辑是完全一样的。但是我们使用while循环和堆栈来模拟递归过程中的系统调用堆栈。手动地运行几个示例肯定会帮助您更好地理解它。
