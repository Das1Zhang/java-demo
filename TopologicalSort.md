> 本教程介绍 CS61B 图章节中的拓扑排序

# 拓扑排序
考虑这样一个**有向无环图**：
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/TopoSort.png)
这其中的有效排序为有：
- [A,C,B,D,F,E,H,G]
- [C,A,D,F,B,E,G,H]
- ....

这个**顺序是按照箭头的指向**进行排序的，打个比方：你必须先学CS61A 才可以学CS61B,才可以学CS70....
我们的课程学习图就像这种有向无环图一样，必须遵循一定的顺序

## 算法流程
在一个有向无环图中，取一个结点，对其使用**深度优先算法**，然后对DFS算法**返回的顺序（后序）进行倒序**，即可得到拓扑排序的结果，如果结点用完了，必须重新启动DFS（始终从**入度为0的结点**开始）

浅显的解释：
DFS先从较浅的结点开始，然后逐渐深入，比如从A到H，后序将首先列出较深的结点，然后再列出较浅的结点

比如我们在上面给出的图中，从A开始进行DFS
- 在一个 list 中记录下DFS：[H,E,B,D,A,G,F,C]
- 然后对这个 list 进行逆序：[C,F,G,A,D,B,E,H]

# 为什么这被称作排序呢？
对于上面这个图如果我们把他进行一些拖拽处理，会发现：
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/Toposort1.png)
会发现这个图变成一个所**有箭头都指向右边的带有某种顺序的图**，这就是我们**“做事”的顺序**

# 如果有环怎么办？
事实上，如果有环，拓扑排序会告诉你：oh,no,我不能处理有环的情况，**结果就是——没有答案**，这是一个未定义的的问题
所以拓扑排序只适用于有向无环图（directed acyclic graph, DAG）

# 如果边权重有负数呢？
答案是：拓扑排序**仍然可以得到正确的结果**，这一点可比Dijkstra 算法要好多啦！