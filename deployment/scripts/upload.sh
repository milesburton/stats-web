#!/bin/bash

scp build/libs/$WAR_NAME.war deploy@qp2.agileview.co.uk:~
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 stop"
# If the application is already installed, Remove Apache and Tomcat legacy
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-enabled/$SITE_NAME || sudo a2dissite $SITE_NAME"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE_NAME ||  rm /etc/apache2/sites-available/$SITE_NAME"
ssh deploy@qp2.agileview.co.uk "test -f /var/lib/tomcat7/webapps/$WAR_NAME.war ||  rm /var/lib/tomcat7/webapps/$WAR_NAME.war"
ssh deploy@qp2.agileview.co.uk "test -d /var/lib/tomcat7/webapps/$WAR_NAME ||  rm -rf /var/lib/tomcat7/webapps/$WAR_NAME"

# Install new application and install apache config
scp build/libs/$WAR_NAME.war deploy@qp2.agileview.co.uk:/var/lib/tomcat7/webapps  
scp deployment/apache/$SITE_NAME deploy@qp2.agileview.co.uk:/etc/apache2/sites-available

ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 start"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE_NAME || sudo a2ensite $SITE_NAME"
ssh deploy@qp2.agileview.co.uk "sudo service apache2 restart"
