eval $(minikube docker-env)
docker build -t storage -f services/storage/Dockerfile services/storage
docker build -t order -f services/orders/Dockerfile services/orders
docker build -t buyer -f services/buyer/Dockerfile services/buyer

