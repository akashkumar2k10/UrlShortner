KeyGenrator Build Process

1. mvn clean install 
2. docker buildx build --load --platform=linux/amd64 -t <docker_hub_id>/<image_name>:<version> .
3. docker image ls
4. docker push <docker_hub_id>/<image_name>:<version>
5. kubectl apply -f keygenrator-deployment.yaml
