FROM bellsoft/liberica-openjdk-alpine:23-cds
RUN apk add curl jq

WORKDIR /home/selenium-docker

ADD target/docker-resources ./
ADD runner.sh	runner.sh

# Fix for windows
RUN dos2unix runner.sh

ENTRYPOINT sh runner.sh