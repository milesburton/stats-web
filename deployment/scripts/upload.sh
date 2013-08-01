#!/bin/bash

ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 stop"
ssh deploy@qp2.agileview.co.uk "rm /var/lib/tomcat7/webapps/$WAR_NAME.war"
ssh deploy@qp2.agileview.co.uk "mv ~/$WAR_NAME.war /var/lib/tomcat7/webapps"
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 start"
