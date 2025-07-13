> hello Apollo 基础实验

# 实验流程
1. 创建实验工程目录
2. 编写包管理文件：BUILD 和 cyberfile.xml
3. 编写源文件及BUILD文件
4. 编译
5. 运行可执行文件

# 实验步骤：
## 1. 创建工程目录以及文件
创建文件夹和对应文件，运行：
```bash
mkdir -p cyber_demo/cyber_01/demo_main
touch cyber_demo/cyber_01/demo_main/BUILD
touch cyber_demo/cyber_01/demo_main/main.cc
touch cyber_demo/BUILD
touch cyber_demo/cyberfile.xml
```
工程目录应如下所示：
```
cyber_demo
|-- cyber_01
    |-- demo_main
    |   |-- BUILD
    |   |-- main.cc
|--BUILD
|--cyberfile.xml
```
## 2.编写包管理相关文件
(1)编写 `./cuber_demo/BUILD`文件
内容应如下所示：
```
load("//tools:apollo_package.bzl", "apollo_package")

package(
    default_visibility = ["//visibility:public"],
)

apollo_package()
```
(2)编写`./cyber_demo/cyberfile.xml`文件
如下所示：
```
<package>
  <name>cyber_demo</name>
  <version>1.0.0</version>
  <description>
   cyber_demo
  </description>
  <maintainer email="AD-platform">AD-platform@baidu.com</maintainer>
  <type>module</type>
  <src_path>//cyber_demo</src_path>
  <license>BSD</license>
  <author>Apollo</author>
  <depend type="binary" src_path="//cyber" repo_name="cyber">cyber</depend>
  <builder>bazel</builder>
</package>
```
## 3. 编写源文件及其BUILD文件
(1) 编写`./cyber_demo/cyber_01/demo_main/main.cc`文件
内容应如下所示：
```c
#include<cyber/cyber.h>

int main(int argc, char const *argv[])
{
    apollo::cyber::Init(argv[0]);
    AINFO << "hello Apollo";
    AWARN << "hello Apollo";
    AERROR << "hello Apollo";
    AFATAL << "hello Apollo";
    return 0;
}
```
(2)编写`./cyber_demo/cyber_01/demo_main/BUILD`文件
内容应如下所示：
```
load("//tools:cpplint.bzl", "cpplint")
load("//tools:apollo_package.bzl", "apollo_cc_binary", "apollo_package")
package(default_visibility = ["//visibility:public"])

apollo_cc_binary(
    name = "main",
    srcs = ["main.cc"],
    deps = ["//cyber"], 
)

apollo_package()

cpplint()
```
## 4.进行编译
运行：
```bash
buildtool build -p cyber_demo
```
然后会输出编译信息
## 5.运行可执行文件
输入
```bash
cd /opt/apollo/neo/bin
```
进入 `/opt/apollo/neo/bin` 目录下
然后输入`ls`就可以看到该目录下的文件
如果看到了`main`文件，就说明编译成功


# 遇到的问题
在编译过程中可能会出现下面的Error报错：
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/cyber.png)
这个报错说明`'/apollo_workspace/.cache/bazel/install/cbf972266931ad9fad1857441b832915/A-server.jar'`文件有丢失或者被修改，需要我们把这个文件所在的文件夹删掉，然后重试
运行：
```bash
rm -rf /apollo_workspace/.cache/bazel/install/cbf972266931ad9fad1857441b832915
```
把该文件夹删掉后，再次运行：
```bash
buildtool build -p cyber_demo
```
此时就不会再发生报错了，再次进入`/opt/apollo/neo/bin` 运行 `ls`就会发现 `main`文件已经正常生成了

## 注意
一定要删除文件夹后再重试，而不是直接运行`buildtool build`这样仍然会发生报错

# 运行结果
正常运行后应该会看见以下的内容：
![alt text](https://132-1331126615.cos.ap-guangzhou.myqcloud.com/cyber1.png)