> 本教程针对git中进行git fetch origin 来获取远程仓库最新状态时发生的`Errors during submodule fetch`的问题，进行解答，同时也是我在做CS61B时进行协作时发生的问题（比如同时用Win主机和wsl进行协作）

# 问题重现
在skeleton-sp21的主仓库中添加了一个`library-sp21`的submodule，然后在另一台主机中运行`git fetch origin`时出现了以下报错Error：
![SubmoduleFetchError](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/SubmodulePullError.png)
报错信息显示在fetch子模块的过程中出现了错误，原因是没有远程仓库中找不到该子模块引用的那条提交，也就是`26c74c...`的这一条


# git子模块的本质
子模块是一个Git仓库里引用另一个Git仓库的方式
在主仓库的`.gitmodules`文件里记录了子模块路径和URL
主仓库本身并不会记录子模块的完整代码，而是**记录该子模块仓库中的某一个commit**
所以主仓库说的是：你这个子模块应该要**checkout到这个特定的commit才对**（比如`26c74c...`）

# 问题核心
主仓库要求子模块`library-sp21`切换到`26c74c...`这个commit，但是Git去子模块仓库一看：这个commit并不存在！

# 解决方案
## 1.手动checkout子模块到一个存在的提交
```bash
cd library-sp21
git fetch
git checkout main    # 或者 master、或你知道的某个 tag/commit
cd ..
git add library-sp21
git commit -m "Fix broken submodule reference"
```
这样我们可以“修正”主项目对子模块的引用，从而避免引用不存在的commit  

## 2.修改`.gitmodule`
在你fork主仓库的情况下，主项目的子模块引用的是它自己的子模块路径，你可能需要更改为自己的fork地址  
```bash
vim .gitmoduls
```
然后修改URL，改为你自己可访问的地址，然后运行：
```bash
git submodule sync
git submodule update --init --recursive --force
```

## 3.重新初始化子模块（尝试自动修复）
```bash
git submodule deinit -f library-sp21
rm -rf .git/modules/library-sp21
git submodule update --init --recursive
```
通过运行上面的命令，我们做了三件事：
1. 取消初始化子模块并删除其git配置和工作目录
2. `git submodule init`
- 读取`.gitmodules`中的子模块信息
- 然后注册到本地的`.git/config`里
3. `git submodule update`
- 去每个子模块的远程仓库拉取
- checkout到主仓库指定的commit

# 我使用的解决方案
运行：
```bash
git submodule update --init --recursive
```
即可完美解决这个问题，再运行`git fetch origin`也没有再发生报错了