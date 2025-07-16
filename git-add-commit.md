> 关于`git add`和`git commit`还有一些有点不太清楚的地方，这里写一篇文章好好理一理

# `git add`：添加到暂存区
`git add`实际上是把**工作区中的内容存入“暂存区”**

通俗来讲就是告诉Git：“这些文件我准备好commit了”
```bash
git add file.txt  # 添加单个文件
git add . # 添加当前目录下所有有变动的文件
git add -A # 添加所有变化（包括删除）
```
## 关键
`git add`并不会真正的“保存修改”，只是把想要提交的文件标记出来


# `git commit`：提交到本地仓库
`git commit`就是把**暂存区的内容真正的提交到本地仓库的历史中**，并且生成一个commit的快照，也就是我们可以在`git log`中看到的 commit 记录

通俗来讲就是**”真正地记录一次历史“**

## 关键
只有执行了`git commit`之后，这些改动才变成了真正的 Git 历史的一部分

# 二者类比
|操作|用写文章类比|
|---|---|
|`git add`|把写好的内容放进打印队列中|
|`git commit`|按下打印键，把内容打印出来|

# 一般的操作流程
```bash
# 对文件做修改....
git status
git add <文件名>
git commit -m "change something"
```
我们在协作过程中是先`git add`，将内容放入暂存区之后才`git commit`提交暂存区中的内容，没有通过`git add`加入暂存区的内容不会被我们 commit 到历史记录中

# commit之后
在执行
```bash
git commit -m "some change"
```
之后
Git 会将暂存区中所有内容写入 Git 历史，即提交一个新的 commit
然后暂存区会变成与当前commit相同的状态，也就是暂存区中不再有需要commit的内容了，再运行`git status`会显示：
```bash
nothing to commit, working tree clean
```

所以`git commit`之后暂存区会被“清空”，变成与最新提交一致的状态。
而没有被`add`的修改，不会与 `commit` 产生关联