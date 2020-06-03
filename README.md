## BUILD JAR
./gradlew build

## BUILD DOCKER IMAGE
docker build --build-arg JAR_FILE=build/libs/*.jar -f docker/Dockerfile  -t alsvinicius/clients-fields-api .

## SWAGGER
http://localhost:10000/swagger-ui.html