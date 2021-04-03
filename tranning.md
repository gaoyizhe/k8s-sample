# install ingress-nginx

参照下面的网页安装 ingress-nginx
https://kubernetes.github.io/ingress-nginx/deploy/#docker-for-mac

```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.44.0/deploy/static/provider/cloud/deploy.yaml
```

用下面的命令确认安装状况
```
kubectl get pods -n ingress-nginx
kubectl exec -it ingress-nginx-controller-7fc74cf778-rxrjg -n ingress-nginx -- /nginx-ingress-controller --version
```

# sample
我们在ingress文件夹下面准备了下面的例子，用下面的命令来安装：
```
kubectl apply -f apple.yaml
kubectl apply -f banana.yaml
kubectl apply -f ingress.yaml
```
确认执行状态
```
kubectl get pods
```
当pod处于running的状态以后，访问以下链接

localhost/apple
localhost/banana

# 初始化一个java project
需要大家提前在开发的机器上安装jdk11。
通过下面的页面初始化一个spring boot的项目。

https://start.spring.io/

用以下命令build java项目
```
./mvnw clean install
```
我们用以下命令来查看build出来的jar

```
cd target
ls -la
-----------
drwxr-xr-x  11 jiliangchen  staff       352  4  3 10:27 .
drwxr-xr-x  15 jiliangchen  staff       480  4  3 10:27 ..
drwxr-xr-x   4 jiliangchen  staff       128  4  3 10:27 classes
-rw-r--r--   1 jiliangchen  staff  17064438  4  3 10:27 demo-0.0.1-SNAPSHOT.jar
-rw-r--r--   1 jiliangchen  staff      3173  4  3 10:27 demo-0.0.1-SNAPSHOT.jar.original
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 generated-sources
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 generated-test-sources
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 maven-archiver
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 maven-status
---------
```
我们可以看到生成了demo-0.0.1-SNAPSHOT.jar这个文件。

用以下命令来启动java应用
```
java -jar demo-0.0.1-SNAPSHOT.jar
```


访问以下端口可以获得响应。
localhost:8080

```
cd target
ls -la
drwxr-xr-x  11 jiliangchen  staff       352  4  3 10:27 .
drwxr-xr-x  15 jiliangchen  staff       480  4  3 10:27 ..
drwxr-xr-x   4 jiliangchen  staff       128  4  3 10:27 classes
-rw-r--r--   1 jiliangchen  staff  17064438  4  3 10:27 demo-0.0.1-SNAPSHOT.jar
-rw-r--r--   1 jiliangchen  staff      3173  4  3 10:27 demo-0.0.1-SNAPSHOT.jar.original
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 generated-sources
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 generated-test-sources
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 maven-archiver
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 maven-status
drwxr-xr-x   4 jiliangchen  staff       128  4  3 10:27 surefire-reports
drwxr-xr-x   3 jiliangchen  staff        96  4  3 10:27 test-classes
```

# build docker image

镜像仓库的概念（共有仓库，私有仓库）
本次演示我们用docker hub这个公用仓库。
请大家注册好docker hub的账号。
下面执行docker login的时候需要账号和密码。

```
docker build -t chenjlsmm/eks-java-cicd:0.0.1 .
docker login
docker push chenjlsmm/eks-java-cicd:0.0.1
```

# create manifest

# deploy app to k8s
kubectl apply -f ./manifest
curl sample-java.local 

# install argocd
