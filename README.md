# EJBRemoteService

Run an EJB service on Wildfly server in a Docker container. 

Invoke the EJB service remotely. 

Before running, make sure to add an application user to the Wildfly server, using the add-user.sh script in wildfly/bin

Resources:
1) https://docs.jboss.org/author/display/WFLY10/EJB%20invocations%20from%20a%20remote%20client%20using%20JNDI.html
2) https://www.baeldung.com/wildfly-ejb-jndi
3) https://docs.oracle.com/javase/jndi/tutorial/getStarted/concepts/naming.html
4) https://docs.oracle.com/javase/jndi/tutorial/getStarted/overview/index.html
