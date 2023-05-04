# Dockerfile

FROM eclipse-temurin:17-alpine
LABEL name=ms-sum

RUN apk add --no-cache bash
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser
RUN mkdir -p /opt/ms-sum && chown javauser:javauser /opt/ms-sum

WORKDIR /opt/ms-sum
USER javauser

COPY target/*.jar /opt/ms-sum/

CMD ["java", "-jar", "app.jar"]
