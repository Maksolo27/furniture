eval $(minikube docker-env)
#docker build -t storage -f services/storage/Dockerfile services/storage
docker build -t storage:25 -f services/storage/Dockerfile services/storage
docker build -t storage-migrations:25 -f services/storage/Dockerfile.migration services/storage
docker build -t order:25 -f services/order/Dockerfile services/order/
docker build -t order-migrations:25 -f services/order/Dockerfile.migration services/order
docker build -t buyer:25 -f services/buyer/Dockerfile services/buyer/
docker build -t buyer-migrations:25 -f services/buyer/Dockerfile.migration services/buyer
docker build -t client:25 -f client/Dockerfile client

