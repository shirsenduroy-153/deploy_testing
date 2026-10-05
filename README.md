# Deploy Testing Application

A lightweight Spring Boot application designed for deployment validation, testing CI/CD pipelines, Docker containerization, and server deployments.

---

## 🚀 Features

- **Spring Boot 3.3.4 & Java 17**
- **Multi-stage Dockerfile** (Zero host dependency needed; builds and packages in Docker)
- **Docker Compose** ready for one-command deployment
- **REST Endpoints** for health and sanity checks
- **Spring Boot Actuator** enabled (`/actuator/health`, `/actuator/info`)

---

## 📡 API Endpoints

| Method | Endpoint | Description | Sample Output |
| :--- | :--- | :--- | :--- |
| `GET` | `/` | Root deployment sanity check | `{"status":"SUCCESS","message":"...","hostname":"..."}` |
| `GET` | `/api/hello?name=John` | Greeting endpoint with hostname | `{"status":"SUCCESS","message":"Hello John!..."}` |
| `GET` | `/api/health` | Custom health endpoint | `{"status":"UP","timestamp":"..."}` |
| `GET` | `/actuator/health` | Spring Boot Actuator health check | `{"status":"UP"}` |

---

## 🐳 Docker Deployment

### 1. Run with Docker Compose (Recommended)
```bash
docker compose up -d --build
```
Check running container:
```bash
docker compose ps
docker compose logs -f
```
Stop container:
```bash
docker compose down
```

### 2. Run with Docker CLI
```bash
# Build the image
docker build -t deploy-testing-app:latest .

# Run the container
docker run -d -p 8080:8080 --name deploy-testing-app deploy-testing-app:latest
```

---

## 💻 Local Development (Without Docker)

Requires Java 17+ & Maven:
```bash
mvn clean spring-boot:run
```
Or build jar and run:
```bash
mvn clean package -DskipTests
java -jar target/deploy-testing-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Quick Test (cURL)
```bash
curl http://localhost:8080/
curl http://localhost:8080/api/hello
curl http://localhost:8080/api/health
curl http://localhost:8080/actuator/health
```
