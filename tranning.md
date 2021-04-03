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

./mvnw clean install
./mvnw spring-boot:run
localhost:8080

cd target
ls -la

# build docker image

docker build -t chenjlsmm/eks-java-cicd:0.0.1 .
docker push chenjlsmm/eks-java-cicd:0.0.1

# create manifest

# deploy app to k8s
kubectl apply -f ./manifest
curl sample-java.local 

# install argocd
