# 

## Model
www.msaez.io/#/storming/27efc3ba6a08c6b86665151d3b20753a

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- taxi-calling-service
- driver-management-service
- mobile-application-service
- payment-service
- location-service


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- taxi-calling-service
```
 http :8088/taxiCalls customerId="customerId" currentLocation="currentLocation" destination="destination" assignedDriverId="assignedDriverId" 
 http :8088/rides rideId="rideId" driverId="driverId" customerId="customerId" startLocation="startLocation" endLocation="endLocation" 
 http :8088/payments rideId="rideId" customerId="customerId" amount="amount" 
 http :8088/reviews rideId="rideId" rating="rating" comment="comment" 
```
- driver-management-service
```
 http :8088/drivers driverId="driverId" name="name" phone="phone" location="location" status="status" statusType="statusType" 
```
- mobile-application-service
```
```
- payment-service
```
```
- location-service
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

