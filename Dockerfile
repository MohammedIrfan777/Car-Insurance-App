FROM openjdk:8
ADD target/spring-boot-car-insurance.jar spring-boot-car-insurance.jar
EXPOSE 8070
ENTRYPOINT ["java", "-jar", "spring-boot-car-insurance.jar"]
