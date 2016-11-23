FROM jboss/wildfly
RUN mkdir -p /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main
ADD module.xml postgresql-9.4.1208.jar /opt/jboss/wildfly/modules/system/layers/base/org/postgresql/main/
ADD standalone.xml /opt/jboss/wildfly/standalone/configuration/
CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]
ADD web-unibave-ws.war /opt/jboss/wildfly/standalone/deployments/
