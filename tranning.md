# install ingress-nginx

参照下面的网页安装 ingress-nginx
https://kubernetes.github.io/ingress-nginx/deploy/#docker-for-mac

```
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v0.44.0/deploy/static/provider/cloud/deploy.yaml
```

kubectl get pods -n ingress-nginx
kubectl exec -it ingress-nginx-controller-7fc74cf778-rxrjg -n ingress-nginx -- /nginx-ingress-controller --version

# sample
kubectl apply -f apple.yaml
kubectl apply -f banana.yaml
kubectl apply -f ingress.yaml

localhost/apple
localhost/banana

# java project
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
