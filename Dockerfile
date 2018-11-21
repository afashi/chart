FROM openjdk:8u181-jre

ENV USERNAME deploy
RUN useradd -ms /bin/bash ${USERNAME}
USER ${USERNAME}

ENV PROJECT_NAME chart-app
ENV DEPLOY_DIR /home/${USERNAME}/webroot
ENV VM_OPTION "-XX:MaxPermSize=128m -Xms128m -Xmx512m"

RUN mkdir -p ${DEPLOY_DIR}
COPY ./target/${PROJECT_NAME}.jar ${DEPLOY_DIR}/${PROJECT_NAME}.jar
COPY ./target/classes/phantomjs /home/${USERNAME}/driver/phantomjs
ENTRYPOINT java -jar ${VM_OPTION}  -XX:OnOutOfMemoryError="kill -9 %p" ${DEPLOY_DIR}/${PROJECT_NAME}.jar