#!/bin/bash

scp build/libs/stats-web.war deploy@cvps2.agileview.co.uk:~/stats-web.war
ssh deploy@cvps2.agileview.co.uk "sudo chown tomcat7:tomcat7 /home/deploy/stats-web.war"
ssh deploy@cvps2.agileview.co.uk "sudo rm -rf /var/www/tomcat7/webapps/stats-web*"
ssh deploy@cvps2.agileview.co.uk "sudo mv /home/deploy/stats.war /var/www/tomcat7/webapps"

