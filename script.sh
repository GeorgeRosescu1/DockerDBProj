#!/bin/sh

cp -r /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps
sed -i '/<Valve/i\<!--' /usr/local/tomcat/webapps/manager/META-INF/context.xml
sed -i '/<Manager/i\-->' /usr/local/tomcat/webapps/manager/META-INF/context.xml

sed -i '/<Valve/i\<!--' /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
sed -i '/<Manager/i\-->' /usr/local/tomcat/webapps/host-manager/META-INF/context.xml

sh /usr/local/tomcat/bin/catalina.sh run

