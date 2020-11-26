cd customer-service
mvn package
docker build . -t customer-service
cd ..
cd account-service
mvn package
docker build . -t account-service
cd ..
docker-compose  up