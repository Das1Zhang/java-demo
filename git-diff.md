> 本教程介绍如何查看本地Git分支与远程分支之间的差异，不同方法之间取决于你想要了解的具体差异内容（比如提交、文件、状态。。。。）


# 表格总结
| 目的                       | 命令                              |
| -------------------------- | --------------------------------- |
| 查看本地和远程谁多了提交   | `git log master..origin/master`   |
| 查看两者内容变动           | `git diff master origin/master`   |
| 快速知道 ahead/behind 状态 | `git status`                      |
| 图形化查看所有分支提交情况 | `git log --graph --oneline --all` |


# 查看提交差异（谁多谁少）
```bash
git fetch
git log <本地分支>..<远程分支>
git log <远程分支>..<本地分支>
```
例如：
```bash
git fetch
git log origin/master..master    # 本地比远程多的提交
git log master..origin/master    # 远程比本地多的提交
```
比如这里我运行
```bash
git log master..origin/master
```
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/image-3.png)

可以看到这里我的远程分支是比我的本地master分支多一条commit的

如果想要更简洁地查看，可以加上参数`--oneline`
```bash
git log master..origin/master --oneline
```
比如这里可以看到我的提交差异
![](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/image-2.png)
由于我这里只有一条提交不一样，所以这里只显示了一条

# 查看文件差异（实际内容变动）
```bash
git fetch
git diff <本地分支> <远程分支>
```
例如：
```bash
git diff master origin/master
```
比如会看到下面的界面
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/image-1.png)
可以很直观地看到文件内容的实际变动，按下`q`可以退出查看模式



# 简单情况概览（常用）
```bash
git fetch
git status
```
如果有差异的话，会显示类似下面的内容：
![](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/image-4.png)
可以看到非常清楚的`您的分支落后……`这一句话，表示了我这个本地仓库相对于远程仓库落后了多少个commit

# 图形化查看提交的分支情况
```bash
git log --oneline --graph --decorate --all
```
这可以更清晰地显示本地和远程分支是如何分叉或者合并的
会看到如下的命令行界面：
![](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/image.png)
可以看得清晰生动的提交历史和分支合并/分叉的情况，按下`q`可以推出查看模式



