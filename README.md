# furniture

## Team 7
 - MAKSYM KOVAL (STORAGE SERVICE)

 - PAVLO BILOLYPETSKIY (BUYER SERVICE)

 - VERONIKA SHUKHMAN (ORDER SERVICE)

## How to install (Minikube):
1) Make sure Minikube is installed: https://minikube.sigs.k8s.io/docs/start/
2) Start Kubernetes with `minikube start`
3) Enable Ingress addon with `minikube addons enable ingress`
4) Prebuild Docker images with `chmod +x docker.sh && ./docker.sh`
5) Apply k8s configurations with `kubectl apply -R -f k8s`


## API Requests
`GET /api/order - Get all orders`

`GET /api/storage - Get all storage items`

`GET /api/buyer - Get all customers`

## Docker Hub
order - https://hub.docker.com/repository/docker/veronikashukhman/order2/general
```bash
docker pull veronikashukhman/order2:25
```

order-migrations - https://hub.docker.com/repository/docker/veronikashukhman/order_migrations/general
```bash
docker pull veronikashukhman/order_migrations:25
```

email - https://hub.docker.com/repository/docker/veronikashukhman/email/general
```bash
docker pull veronikashukhman/email:25
```
## For rabbit test

 1.To check the correct work of rabbitmq use this command:
```bash
kubectl port-forward service/rabbitmq 15672:15672 
``` 
2. Go to [http://localhost:15672/#/queues/%2F/create_order] login with username [user] and password [user].
3. After you have to go to [localhost](http://localhost) and make a new order.
4. And go back to rabbitmq console at http://localhost:15672/#/queues/%2F/create_order and you will see that the message has been transmitted.
