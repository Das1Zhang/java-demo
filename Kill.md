> 我们在debug使用较大的随机测试或者进行一些CPU高占用的工作时，如果电脑性能不足很容易发生卡死的情况，这时需要我们强行杀死卡死的进程，以下介绍了Ubuntu中如何杀死进程

# 一、使用系统监视器（图形界面）
## 终端打开
按下 `ctrl + alt + t`新建一个终端，然后在终端中输入：
```bash
gnome-system-monitor
```
就可以打开系统监视器
## 点击图标
按下`Super`(win)键，输入`System Monitor`或者`系统监视器`点击打开即可

# 二、使用`xkill`点击窗口
打开终端输入：
```bash
xkill
```
鼠标会变成一个小叉，然后点击你想关闭的窗口，就会强行关闭
如果提示：`xkill: command not found`
那么输入：
```bash
sudo apt install x11-utils
```
先进行安装即可

# 三、使用 htop (交互式终端工具)
> htop 是一个和 top 类似的终端进程管理工具，但是 htop 具备更加美观的界面， 并且具备交互式，比 top 更加人性化，当然也可以使用 top 不过需要手动记下 PID 再进行 kill

打开终端输入：
```bash
htop
```
就可以在终端中看到 htop 的交互式界面
找到需要杀死的相关进程（可以按下`/`进行搜索，也可以按上下键进行选择）
选中后按下`F9`，再按9（SIGKILL），然后回车，就可以看到相关进程被杀死了
如果没有安装 htop 可以输入：
```bash
sudo apt install htop
```
进行安装

# 四、使用`ps + grep + kill`
在终端中输入：
```bash
ps aux | grep <进程名>
```
找到进程，然后记下 PID
然后执行：
```bash
kill -9 PID
```

# 五、一步到位
输入：
```bash
pkill -9 -f <进程名>
```
直接强行终止所有命令行中包含 <进程名> 的进程