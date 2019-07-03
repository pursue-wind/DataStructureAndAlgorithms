# DataStructureAndAlgorithms
### 链表 添加/删除

```java
/**
 * @Description: 在索引位置添加节点
 * @Param: [index, e]
 * @return: void
 */
public void add(int index, E e) {
    if (index < 0 || index > size)
        throw new IllegalArgumentException("add fail , illegal index~");
    else {
        Node prev = dummyHead;
        for (int i = 0; i < index - 1; i++)
            prev = prev.next;
        Node newNode = new Node(e); //创建一个新节点
        newNode.next = prev.next;   //将新节点的下一个设置为prev的下一个节点
        prev.next = newNode;        // 将prev节点的下一个设置为新节点
        //上面三句可以替换为__prev.next = new Node(e , prev.next);
        size++;
    }
}
/**
 * @Description: 删除链表中index位置的元素
 * @Param: [index]
 * @return: E
 */
public E remove(int index) {
    if (index < 0 || index >= size)
        throw new IllegalArgumentException("remove fail , illegal index~");
    Node prev = dummyHead;
    for (int i = 0; i < index; i++)
        prev = prev.next;
    Node retNode = prev.next;
    prev.next = retNode.next;
    retNode.next = null;
    size--;
    return retNode.e;
}
```



### 线段树 创建/查询

```java
/**
 * @Description: 创建线段树
 * @Param: [treeIndex, left, right]
 */
private void buildSegmentTree(int treeIndex, int left, int right) {
    if (left == right) {    //如果到了叶子节点
        tree[treeIndex] = data[left];
        return;
    }
    int leftTreeIndex = leftChild(treeIndex);   //获得左子树的索引
    int rightTreeIndex = rightChild(treeIndex); //获得右子树的索引
    int mid = left + (right - left) / 2;        //中点
    buildSegmentTree(leftTreeIndex, left, mid); //递归创建左右子树
    buildSegmentTree(rightTreeIndex, mid + 1, right);
	//融合左右子树的值到父节点
    tree[treeIndex] = merger.merger(tree[leftTreeIndex], tree[rightTreeIndex]); 
}
/**
 * @Description: 查询操作递归函数
 * @Param: [treeIndex查询的节点, l, r, queryL, queryR]
 * @return: E
 */
private E query(int treeIndex, int l, int r, int queryL, int queryR) {
    //  左右边界恰好等于查询边界
    if (l == queryL && r == queryR)
        return tree[treeIndex];
    //  计算左右孩子索引和中点
    int leftTreeIndex = leftChild(treeIndex);
    int rightTreeIndex = rightChild(treeIndex);
    int mid = l + (r - l) / 2;
    //  如果查询的左边界大于中点,直接去右孩子中查找
    if (queryL >= mid + 1)
        return query(rightTreeIndex, mid + 1, r, queryL, queryR);
    else if (queryR <= mid) //  如果查询的右边界小于中点,直接去左孩子中查找
        return query(leftTreeIndex, l, mid, queryL, queryR);
    //  如果查询区间在左右孩子中都有
    E leftTreeResult = query(leftTreeIndex, l, mid, queryL, mid);
    E rightTreeResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
    //  融合左右查询的结果并返回
    return merger.merger(leftTreeResult, rightTreeResult);
}
```



### 二分搜索树 添加/删除

```java
public Node add(Node node, E e) {
    if (node == null) {
        size++;
        return new Node(e);
    }
    if (e.compareTo(node.e) < 0)
        node.left = add(node.left, e);
    else if (e.compareTo(node.e) > 0)
        node.right = add(node.right, e);
    return node;
}
```

```java
private Node remove(Node node, E e) {
    if (node == null)
        return null;
    else if (e.compareTo(node.e) < 0) {//   如果e小于节点
        node.left = remove(node.left, e);
        return node;
    }
    //  如果e大于节点
    else if (e.compareTo(node.e) > 0) {
        node.right = remove(node.right, e);
        return node;
    }
    // e.compareTo(node.e) = 0
    else {
        //  如果左子树为空时
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        //  如果右子树为空时
        else if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        //  如果左右子树均不为空时
        //找到比删除节点大的最小节点_右节点的最小值(左节点的最大值亦可)
        Node successor = minimum(node.right);
        //用找到的节点顶替删除的节点
        successor.right = removeMin(node.right);//removeMin中有一次size--操作,需要size++
        successor.left = node.left;
        node.left = node.right = null;//此操作需要一次size--,与上面操作抵消
        return successor;
    }
}

```



### 堆 上浮/下沉

```java
///////////////////////////////////////////////////////////////////////
//      0                                                            //
//    /   \        parent(i) = (i-1)/2                               //
//   1    2        leftChild(i) = 2*i+1                              //
//  / \  / \       rightChild(i) = 2*i+2                             //
// 3  4 5  6                                                         //
///////////////////////////////////////////////////////////////////////
```

```java
/**
 * @Description: 添加元素时的操作
 * @Param: [i]
 */
private void siftUp(int index) {
    while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
        swap(index, parent(index));
        index = parent(index);
    }
}
```

```java
/**
 * @Description: 取出堆中的最大值, 下沉操作
 * @Param: [index]
 */
private void siftDown(int index) {
    //当该节点的左孩子节点比size大时,下浮停止
    while (leftChild(index) < data.getSize()) {
        int j = leftChild(index);
        //j+1则为右孩子索引,如果右孩子存在并且大于左孩子,j就变为右孩子的索引
        if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0)
            j++;
        //如果当前的值大于或等于子节点的值,停止下沉
        if (data.get(index).compareTo(data.get(j)) >= 0)
            break;//退出循环
        swap(index, j);
        index = j;
    }
}
```

### 字典树 添加

```java
/**
 * @Description: 向Trie中添加新单词word
 * @Param: [word]
 */
public void add(String word) {
    Node cur = root;    //定义root为当前节点
    for (int i = 0; i < word.length(); i++) {
        char c = word.charAt(i);
        if (cur.next.get(c) == null)
            cur.next.put(c, new Node());
        cur = cur.next.get(c);
    }
    if (!cur.isWord) {
        cur.isWord = true;
        size++;
    }
}
```





### AVL 左旋右旋

    /////////////////////////////////////////////////////
    //     对节点y进行向右旋转操作，返回旋转后新的根节点x  //
    //        y                              x         //
    //       / \                           /   \       //
    //      x   T4     向右旋转 (y)        z     y      //
    //     / \       - - - - - - - ->    / \   / \     //
    //    z   T3                       T1  T2 T3 T4    //
    //   / \                                           //
    // T1   T2                                         //
    /////////////////////////////////////////////////////
```java
    private Node rightRotate(Node y) {
    //  暂存y的左节点x和x的右节点t3
    Node x = y.left;
    Node t3 = x.right;
    //  让y成为x的右孩子, t3成为y的左孩子
    x.right = y;
    y.left = t3;
    //  更新Height值
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

    return x;
}
```


    //////////////////////////////////////////////////
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x   //
    //    y                             x           //
    //  /  \                          /   \         //
    // T1   x      向左旋转 (y)       y     z        //
    //     / \   - - - - - - - ->   / \   / \       //
    //   T2   z                    T1 T2 T3 T4      //
    //       / \                                    //
    //      T3 T4                                   //
    /////////////////////////////////////////////////
```java
private Node leftRotate(Node y) {
    //  暂存y的左节点x和x的左孩子t2
    Node x = y.right;
    Node t2 = x.left;
    //  让y成为x的左孩子, t2成为y的右孩子
    x.left = y;
    y.right = t2;
    //  更新Height值
    y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
    x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

    return x;
}
```

### 红黑树 旋转/添加元素

```
///////////////////////////////////////////////// 
// 对节点y进行向左旋转操作，返回旋转后新的根节点x  //
//    y                             x          //
//  /  \                          /  \         //
// T1   x      向左旋转 (y)       y   T3        //
//     / \   - - - - - - - ->   / \            //
//   T2  T3                    T1 T2           //
/////////////////////////////////////////////////
```
```java
private Node leftRotate(Node y) {
    //  暂存y的左节点x
    Node x = y.right;
    //  让y成为x的左孩子, t2成为y的右孩子
    y.right = x.left;
    x.left = y;
    x.color = y.color;
    y.color = RED;
    return x;
}
```

```java
////////////////////////////////////////////////////
//     对节点y进行右旋转操作，返回旋转后新的根节点x   //
//        y                              x        //
//       / \                            / \       //
//      x  T3      向右旋转 (y)         T1  y      //
//     / \       - - - - - - - ->         / \     //
//    T1 T2                              T2 T3    //
////////////////////////////////////////////////////
```
```java
private Node rightRotate(Node y) {
    //  暂存y的左节点x
    Node x = y.left;
    //  t2成为y的左孩子
    y.left = x.right;
    x.right = y;

    x.color = y.color;
    x.color = RED;
    return x;
}
```
```java
/**
 * @Description: 向以node为根的红黑树中插入元素(key, value)，递归算法
 * @Param: [node, key, value]
 * @return: 返回插入新节点后红黑树的根
 */
public Node add(Node node, K key, V value) {
    if (node == null) {
        size++;
        return new Node(key, value);//默认插入红色节点
    }
    if (key.compareTo(node.key) < 0)
        node.left = add(node.left, key, value);
    else if (key.compareTo(node.key) > 0)
        node.right = add(node.right, key, value);
    else   //key.compareTo(node.key) = 0
        node.value = value;

    if (isRed(node.right) && !isRed(node.left))
        node = leftRotate(node);

    if (isRed(node.left) && isRed(node.left.left))
        node = rightRotate(node);

    if (isRed(node.left) && isRed(node.right))
        flipColors(node);

    return node;
}
```
