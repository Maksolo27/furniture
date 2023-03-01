eval $(minikube docker-env)
docker build -t storage -f services/storage/Dockerfile services/storage
docker build -t order -f services/order/Dockerfile services/order
docker build -t buyer -f services/buyer/Dockerfile services/buyer
docker build -t client -f services/client/Dockerfile services/client

