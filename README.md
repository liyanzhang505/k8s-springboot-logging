# Logging Demo of Springboot Application in Kubernetes
## Tutorial
https://medium.com/@lyzkevin2020/how-to-build-a-log-collection-system-for-springboot-projects-in-kubernetes-3f4c3e09dd6b
## Create Springboot Application Image
- Attach terminal to minikube docker environment
```bash
eval $(minikube docker-env)
```

- Build this spring boot project and create docker image.
```bash
gradle build docker # Equals to gradle build + gradle docker
```
> - Then you can see the docker image: qiusuo/gateway:v1
```bash
  docker images
```

## Deploy all Services
- Deploy springboot application, filebeat
```bash
kubectl create -f ./deploy/
```

## Test 
- Port forwarding kibana service and gateway service
```bash
kubectl port-forward svc/kibana 15601:5601
kubectl port-forward svc/qiusuo-gateway-svc 18040:8040
```
- Visit 127.0.0.1:18040/hello to produce one log record.
- Visit 127.0.0.1:15601 to open Kibana interface
- Create an index "logstash-*"
- Select "kubernetes.pod.name", "message", "fields.log-source" as the target fields to see the demonstration.
- Add a filter "kubernetes.pod.name is \*gateway*" and a filed "msg" to see the demonstration.
