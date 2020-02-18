FROM tomcat:jdk8-corretto
ADD target/Project.war /usr/local/tomcat/webapps/
COPY src/main/resources/tomcat-users.xml /usr/local/tomcat/conf/
COPY script.sh /usr/local/tomcat
EXPOSE 8080
CMD ["/usr/local/tomcat/script.sh", "run"]