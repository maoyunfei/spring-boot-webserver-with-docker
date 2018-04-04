# docker-maven插件使用示例项目


## 目的

本项目主要用来展示docker-maven插件的基本用法。

所使用的插件为 [spotify/docker-maven-plugin](https://github.com/spotify/docker-maven-plugin)。详细用法请看 [README](https://github.com/spotify/docker-maven-plugin/blob/master/README.md)。

## 步骤

1. 新建一个Spring Boot项目

2. 在`pom.xml`中添加插件

```xml
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>1.0.0</version>
    <configuration>
        <!-- 注意imageName一定要是符合正则[a-z0-9-_.]的，否则构建不会成功 -->
        <!-- 指定镜像名 -->
        <imageName>${project.artifactId}</imageName>
        <!-- 指定Dockerfile所在的路径 -->
        <dockerDirectory>${project.basedir}/src/main/docker</dockerDirectory>
        <resources>
            <resource>
                <targetPath>/</targetPath>
                <directory>${project.build.directory}</directory>
                <include>${project.build.finalName}.jar</include>
            </resource>
        </resources>
    </configuration>
</plugin>
```

3. 新建`Dockerfile`

插件中配置的`DockerDirector`y为`./src/main/docker`，故将`Dockerfile`置于该目录下。

4. 构建镜像

构建命令为 `mvn clean package docker:build`

5. 查看构建的镜像

`docker images`

## 一些问题

1. 第四步构建镜像时，需要先启动本地Docker deamon。

2. 国内访问DockerHub镜像速度较慢，可以使用国内加速器
（不知道为什么我用aliyun的加速器不行，换成DaoCloud的加速器就OK了。。。）








