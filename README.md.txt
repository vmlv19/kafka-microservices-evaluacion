
## Requisitos
- Docker Desktop instalado
- Java 17
- Maven

## Cómo ejecutar

### 1. Compilar los microservicios
cd producer
./mvnw clean package -DskipTests

cd ../consumer
./mvnw clean package -DskipTests

### 2. Levantar todo con Docker
docker-compose up --build -d

### 3. Probar con Postman
POST http://localhost:8080/publish
Content-Type: application/json

{
  "message": "Hola desde Kafka"
}

### 4. Ver logs del Consumer
docker logs consumer -f