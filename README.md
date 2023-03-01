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

