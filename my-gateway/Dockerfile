FROM openjdk:11
ADD ./target/my-gateway-1.0.0.jar gateway.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","-Xms512m","-Xmx1024m","gateway.jar"]
MAINTAINER yejianbao "yejianbao@anicert.cn"