FROM jboss/wildfly:10.1.0.Final
ADD EJBRemote/build/libs/EJBRemote.jar /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]