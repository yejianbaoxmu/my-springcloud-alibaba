FROM openjdk:11
ADD ./target/my-order-1.0.2.jar order.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","-Xms512m","-Xmx1024m","order.jar"]
MAINTAINER yejianbao "yejianbao@anicert.cn"