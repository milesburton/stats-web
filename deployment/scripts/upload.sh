#!/bin/bash

scp build/libs/$WAR_NAME.war deploy@qp2.agileview.co.uk:~
ssh deploy@qp2.agileview.co.uk "chown tomcat7:tomcat7 /home/deploy/$WAR_NAME.war"
ssh deploy@qp2.agileview.co.uk "rm -rf /var/lib/tomcat7/webapps/$WAR_NAME*"
ssh deploy@qp2.agileview.co.uk "mv ~/$WAR_NAME.war /var/lib/tomcat7/webapps"
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 restart"

