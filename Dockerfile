FROM tomcat:9-jre11-slim
ADD  target/test-2.7.2.war /usr/local/tomcat/webapps/api.war
EXPOSE 8080
CMD ["catalina.sh","run"]