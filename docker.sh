eval $(minikube docker-env)
#docker build -t storage -f services/storage/Dockerfile services/storage
docker build -t storage:2.0 -f services/storage/Dockerfile services/storage
docker build -t storage-migrations:2.0 -f services/storage/Dockerfile.migration services/storage
docker build -t order -f services/order/Dockerfile services/order
docker build -t buyer:2.0 -f services/buyer/Dockerfile services/buyer/
docker build -t buyer-migrations:2.0 -f services/buyer/Dockerfile.migration services/buyer
docker build -t client -f client/Dockerfile client

