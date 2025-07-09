> 本人在写 CS61B sp21 的过程中发现使用 git add 一直无法实现对 library-sp21 这个文件夹的跟踪，于是又重新了解了一下git 的工作原理，知道了git中的**子模块机制**

# 我遇到的问题
![](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/library-sp21.jpg)
在主仓库目录中使用 `git add` 会发现无论如何都无法跟踪到 `library-sp21`.
(Ubuntu 里的微信截图出来不知道为啥这么糊。。。。)

# 什么是子模块？
> 子模块(submodule) 是什么？我手动创建一个文件夹算子模块吗？？？

并不是所有新建文件夹都是子模块，只有在你特意使用`git submodule`命令把某个外部 Git 仓库添加进来，它才是子模块。

## 普通文件夹
手动使用`mkdir myfolder`创建的文件夹只是普通文件夹; 这里面的文件变动用`git add`, `git commit`**可以正常追踪**

## 子模块(submodule)
子模块是一个**嵌套在当前仓库中的 Git 仓库**，本身也有`.git`
它通常**通过命令添加**的，比如：
```bash
git submodule add https://github.com/otheruser/library-sp21
```
当我们执行这条命令之后，项目中就会出现一个`library-sp21`文件夹
这个文件夹是一个**完整的 Git 仓库**（独立版本管理）
主项目**只记录它指向哪个 commit**，并不直接追踪它的改动内容。
同时`.gitmodules`文件也会**自动生成**，用于记录子模块的路径和仓库地址。

# 如何判断是不是子模块
我们可以通过查看 `.gitmodules`文件，在主仓库目录下运行：
```bash
cat .gitmodules
```
比如我这里就输出了
```
[submodule "library-sp21"]
	path = library-sp21
	url = https://github.com/Berkeley-CS61B/library-sp21
```
说明这个 library-sp21 确实是一个子模块，并且这里也给出了**对应的路径和仓库url.**

或者运行命令：
```bash
git submodule status
```
比如我这里输出了`library-sp21`，说明它确实是子模块。

# 如何追踪子模块
必须**单独进入子模块内部进行提交**
比如我这里的 `library-sp21`
首先进入子模块目录，提交
```bash
cd library-sp21
git status
git add .
git commit -m "..."
```
然后回到主仓库，更新对子模块的引用
```bash
cd ..
git add ./library-sp21
git commit -m "..."
```
最后我们再次运行：
```bash
git status
```
就不会出现之前的未追踪情况了。