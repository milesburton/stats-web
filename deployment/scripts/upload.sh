#!/bin/bash

scp build/libs/stats-web.war deploy@qp2.agileview.co.uk:~/stats-web.war
ssh deploy@qp2.agileview.co.uk "sudo chown tomcat7:tomcat7 /home/deploy/stats-web.war"
ssh deploy@qp2.agileview.co.uk "sudo rm -rf /var/lib/tomcat7/webapps/stats-web*"
ssh deploy@qp2.agileview.co.uk "sudo mv /home/deploy/stats-web.war /var/lib/tomcat7/webapps"

