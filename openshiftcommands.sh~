cd app-root/repo/
ant -buildfile custom_rules.xml -Dconfig.username=$OPENSHIFT_POSTGRESQL_DB_USERNAME -Dconfig.password=$OPENSHIFT_POSTGRESQL_DB_PASSWORD -Dconfig.url=$OPENSHIFT_POSTGRESQL_DB_HOST -Dconfig.port=$OPENSHIFT_POSTGRESQL_DB_PORT 
cd ../../../jbossews/webapps/
cp ../../app-root/repo/webapps/Mobility_Collector_Servlet.war .
exit
