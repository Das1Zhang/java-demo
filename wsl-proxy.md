>wsl: 检测到 localhost 代理配置，但未镜像到 WSL。NAT 模式下的 WSL 不支持 localhost 代理
> 本教程根据启动wsl时出现上面的信息给出解决方案

# 问题原因
在 Windows 中设置了代理（比如 Clash、V2RayN、或其他代理工具），其监听地址是 127.0.0.1 或 localhost，但在 WSL 中访问 localhost:xxxx 并不能访问到 Windows 上的这个代理端口，因为它们网络隔离。

# 解决方案
## 1.找到网络接口下的 `IPv4` 地址以及你的代理端口
打开 powershell 输入：
```powershell 
ipconfig
```
然后找到`无线局域网适配器WLAN:`这一块，然后找到`IPv4地址`，例如`192.168.1.123`，这个就是你的Windows主机IP

然后打开你的代理工具，点击设置，可以在设置中看到你的代理端口，比如`7897`

## 2.在wsl中设置代理
然后在 WSL 中设置代理，改用这个IP，而不是`localhost`:
编辑你的终端配置文件，比如我用的是 zsh，我就打开.zshrc：
```bash
nano ~/.zshrc
```
然后在`.zshrc`中加入下面三行
```bash
export http_proxy=http://10.128.128.199:7897
export https_proxy=http://10.128.128.199:7897
export all_proxy=socks5://10.128.128.199:7897
```

然后保存并退出，在终端中使新的配置生效
```bash
source .zshrc
```
3. 测试是否成功设置代理
我们用google来测试一下
```bash
curl www.google.com
```
如果我们看到了`<title>google</title>`这样的内容就说明我们已经成功访问了
比如我看到了这一坨形似乱码的文件：
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/curlGoogle.png)
其实这样我们已经成功访问到了google
