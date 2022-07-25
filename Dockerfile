FROM tomcat 
WORKDIR webapps 
COPY target/ExamTemplate-1.0.jar .
RUN rm -rf ROOT && mv ExamTemplate-1.0.jar ROOT.jar
ENTRYPOINT ["sh", "/usr/local/tomcat/bin/startup.sh"]