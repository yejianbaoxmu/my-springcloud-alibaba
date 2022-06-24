FROM openjdk:11
ADD ./target/my-storage-1.0.3.jar storage.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","-Xms512m","-Xmx1024m","storage.jar"]
MAINTAINER yejianbao "yejianbao@anicert.cn"