> 本教程介绍关于git branch 的一些工作流，包括一些branch操作以及多主机对同一主仓库进行协作时的一些操作流

# 设想一个场景
我现在的本地仓库和远程仓库不一致，但是我又想保留这个本地仓库，同时我又想另外创建一个副本，用于在远程仓库的基础上修改，我该如何做呢？

# 工作流
## 更新远程仓库的状态
我们的本地仓库对远程仓库的状态记录并不是实时的，而是每次运行`git fetch`时都会更新一次
所以我们需要先把最新的远程仓库的状态拉下来：
```bash
git fetch origin
```
## 查看分支状态
然后我们需要查看一下我们的本地分支与远程分支的差异，运行：
```bash
git log HEAD..origin/master --oneline
```

## 创建一个新分支（副本）
为了创建一个副本方便我们在远程仓库的基础上进行修改，我们先基于我们的这个本地仓库创建一个副本，然后再把我们原来的仓库用远程仓库的内容进行覆盖
```bash
git checkout -b my-feature
```
上面这行的`-b`参数为branch,创建了一个新的分支my-feature,并切换到了这个新分支

## 将原本的内容更新覆盖
```bash
git checkout master
git reset --hard origin/master
```
这样我们就切换回我们的本地master分支，然后用远程的master分支强制覆盖掉他了

## 合并分支（可选）
如果需要的话，我们可以进行分支的合并，如果我们目前在master分支，想要将my-feature分支的内容合并进来，可以运行：
```bash
git merge my-feature
```

## 查看分支
### 查看本地分支情况
```bash
git branch
```
可以查看本地仓库所拥有的所有分支
### 查看所有分支情况
```bash
git branch -a
```
可以查看本地以及远程仓库的所有分支情况
### 查看当前分支
上面两个分支情况中在分支前有`*`的就是当前分支，例如：
![git-branch](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/gitbranch.png)
在上面的图中可以看到我们这个本地仓库所处的分支为`my-feature`
在远程仓库中的分支情况也为我们列举出来了（红色）
或者运行：
```bash
git status
```
![git-status](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/gitstatus.png)
也可以查看当前处于哪个分支，这里就显示了`On branch my-feature`，告诉我们在`my-feature`分支上
命令行中一般也有显示。

