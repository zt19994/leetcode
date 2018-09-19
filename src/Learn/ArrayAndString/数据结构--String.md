### 数据结构--String 字符串
#### 1、介绍字符串
&emsp;&emsp;字符串实际上是一个unicode字符数组。你可以执行几乎所有数组中包含的操作。<br>
&emsp;&emsp;然而，还是有一些不同的特性，不同语言对于字符串的处理也不太一样。
#### 2、比较函数 Compare Function
&emsp;&emsp;字符串有自己的比较函数。

比较字符串能否用“==”，取决于语言是否支持操作符重载：
1. 语言支持操作符重载（C++），可以使用“==”比较两个字符串。
2. 语言不支持操作符重载（java），不能使用“==”比较两个字符串。当我们使用时，实际上是比较两个对象是不是一个对象。
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        // initialize 初始化
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }
}
```
#### 3、不可变或可变 Immutable or Mutable
&emsp;&emsp;不可变意味着，字符串一旦初始化，你就不能改变字符串的内容了（java）。可变意味着你可以像修改数组一样修改字符串（C++）。
1. 在某些语言中（比如C++），字符串是可变的。也就是说，你可以像你在数组中所做的那样修改字符串。
2. 在其他一些语言（如Java）中，字符串是不可变的。这个特性会带来一些问题。

#### 4、额外的操作
&emsp;&emsp;与数组相比，我们可以在一个字符串上执行一些额外的操作。这里有一些例子：
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s1 = "Hello World";
        // 1. concatenate
        s1 += "!";
        System.out.println(s1);
        // 2. find
        System.out.println("The position of first 'o' is: " + s1.indexOf('o'));
        System.out.println("The position of last 'o' is: " + s1.lastIndexOf('o'));
        // 3. get substring
        System.out.println(s1.substring(6, 11));
    }
}
```

您应该了解这些内置操作的时间复杂度。<br>
例如，如果字符串的长度是N，那么查找操作和子串操作的时间复杂度是O（N）。<br>
而且，在字符串是不可变的语言中，您应该小心使用串联操作。<br>
当您计算解决方案的时间复杂度时，请不要忘记将内置操作的时间复杂度考虑在内。

#### 5、不可变字符串 -- 问题和解决方案
&emsp;&emsp;如果字符串是不可变的，那么它将带来一些问题。

##### 1、修改操作
&emsp;&emsp;显然，不可变字符串不能被修改。如果您只想修改其中一个字符，您必须创建一个新的字符串。

##### 2、注意Java中的字符串串联
&emsp;&emsp;您应该对字符串连接非常小心。让我们看一个例子，当我们在for循环中重复做字符串串联时：
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s = "";
        int n = 10000;
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
    }
}
```
&emsp;&emsp;在Java中，由于字符串是不可变的，所以连接工作首先为新字符串分配足够的空间，复制旧字符串的内容并附加到新的字符串。<br>
&emsp;&emsp;因此，总的时间复杂度将是：\
  5 + 5 × 2 + 5 × 3 + … + 5 × n
= 5 × (1 + 2 + 3 + … + n)
= 5 × n × (n + 1) / 2,

即时间复杂度为 O(n2).

##### 3、解决方案
&emsp;&emsp;如果你想让你的字符串是可变的，有一些替换：<br>
1.如果您确实希望字符串是可变的，您可以将其转换为 char 数组。
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s = "Hello World";
        char[] str = s.toCharArray();
        str[5] = ',';
        System.out.println(str);
    }
}
```
2.如果您必须经常连接字符串，那么最好使用一些其他的数据结构，比如 StringBuilder。下面的代码在O（n）复杂度中运行。
```java
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int n = 10000;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append("hello");
        }
        String s = str.toString();
    }
}
```