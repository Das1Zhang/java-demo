
> 一般来说，我们使用`tar`命令来进行压缩时，会使用`-c*vf`作为参数，其中`*`依据不同压缩格式选择。
进行解压时，会使用`-x*vf`作为参数，其中`*`依据不同压缩格式选择。


# 压缩到相同的路径
## 1.`tar.gz`（最常见）
压缩
```bash
tar -czvf archive.tar.gz folder/
```

## 2.`.zip`（跨平台常见）
压缩
```bash
zip -r archive.zip folder/
```



## 3.`.gz`（单个文件压缩）
压缩
```bash
gzip file.txt
```
解压
```bash
gunzip file.txt.gz
```
# 压缩并保存到指定目录
## 1. `tar`命令
```bash
tar -czvf /destination/archive.tar.gz  /source_folder/
```
比如：
```bash
tar -czvf /home/user/backups/project.tar.gz  /home/user/project
```
这就会把 `project/` 文件夹压缩为`.tar.gz`，并保存到`/home/user/backups`中
## 2. `.zip`压缩并保存到指定目录
```bash
zip -r /destination/archive.zip /source_folder
```
比如：
```bash
zip -r /home/user/backups/project.zip /home/user/project/
```
会把 `project/`压缩为`project.zip`并保存到`backups`目录下
其中`-r`代表递归式的，可以递归地压缩文件夹中的内容。

# 解压
## 1.`.tar.gz`格式
解压
```bash
tar -xzvf archive.tar.gz
```
解压到指定目录：
```bash
tar -xzvf archive.tar.gz -C /path
```
针对不同的压缩格式会有不同的`tar`命令
```bash
tar -xvf archive.tar                # 只打包未压缩
tar -xzvf archive.tar.gz            # 解压 .tar.gz
tar -xjvf archive.tar.bz2           # 解压 .tar.bz2
tar -xJvf archive.tar.xz            # 解压 .tar.xz
```
## 2.`.zip`格式
解压
```bash
 unzip archive.zip
```
解压到指定目录
```bash
unzip archive.zip -d /path/to/dir
```
## 3.`.gz`格式
解压
```bash
gunzip file.txt.gz
```

# 查看压缩包内容
`.tar.gz`:
```bash
tar -tzf archive.tar.gz
```
`.zip`:
```bash
unzip -l archive.zip
```

# 补充：`tar`命令中的参数意义
| 参数 | 含义     | 说明                                       |
| ---- | -------- | ------------------------------------------ |
| `-c` | create   | 创建归档，用于打包                         |
| `-x` | extract  | 从归档中提取，用于解压                     |
| `-v` | verbose  | 显示详细操作过程，此为可选参数             |
| `-f` | file     | 指定归档文件名                             |
| `-z` | gzip     | 使用gzip压缩或解压`.tar.gz`文件            |
| `-j` | bzip2    | 使用bzip2处理`.tar.bz2`文件                |
| `-J` | xz       | 使用xz处理`.tar.xz`文件                    |
| `-t` | list     | 列出归档文件内容，用于查看但不解压文件内容 |
| `-C` | 指定目录 | 常用于解压目标路径                         |

# 补充：`zip`命令中的常用参数
| 参数  | 含义                           | 示例                             |
| ----- | ------------------------------ | -------------------------------- |
| `-r`  | 递归压缩目录                   | `zip -r archive.zip folder/`     |
| `-j`  | 压缩时去除路径，仅保留文件名   | `zip -j archive.zip folder/*`    |
| `-q`  | 安静模式，不显示压缩过程信息   | `zip -q archive.zip file`        |
| `-9`  | 使用最高压缩等级（0-9）        | `zip -9 archive.zip file`        |
| `-x`  | 排除文件或模式                 | `zip archive.zip * -x "*.log"`   |
| `-m`  | 压缩后删除源文件               | `zip -m archive.zip file1 file2` |
| `-FS` | 增量更新（只压缩新或改动文件） | `zip -FS archive.zip folder/`    |

# 补充：`unzip`命令中的常用参数
| 参数 | 含义                         | 示例                                 |
| ---- | ---------------------------- | ------------------------------------ |
| `-d` | 指定解压目录                 | `unzip archive.zip -d /path/to/dir/` |
| `-l` | 列出压缩包内容（不解压）     | `unzip -l archive.zip`               |
| `-v` | 显示更详细的压缩包内容信息   | `unzip -v archive.zip`               |
| `-o` | 解压时自动覆盖已存在的文件   | `unzip -o archive.zip`               |
| `-n` | 解压时**不覆盖**已存在的文件 | `unzip -n archive.zip`               |
| `-q` | 静默模式（不显示解压过程）   | `unzip -q archive.zip`               |
| `-x` | 解压时排除指定文件           | `unzip archive.zip -x "*.log"`       |
