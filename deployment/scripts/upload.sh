#!/bin/bash

scp build/libs/$WAR_NAME.war deploy@qp2.agileview.co.uk:~
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 stop"
# If the application is already installed, Remove Apache and Tomcat legacy
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-enabled/$SITE || sudo a2dissite $SITE"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE ||  rm /etc/apache2/sites-available/$SITE"
ssh deploy@qp2.agileview.co.uk "test -f /var/lib/tomcat7/webapps/$WAR_NAME.war ||  rm /var/lib/tomcat7/webapps/$WAR_NAME.war"
ssh deploy@qp2.agileview.co.uk "test -d /var/lib/tomcat7/webapps/$WAR_NAME ||  rm -rf /var/lib/tomcat7/webapps/$WAR_NAME"

# Install new application and install apache config
ssh deploy@qp2.agileview.co.uk "mv ~/$WAR_NAME.war /var/lib/tomcat7/webapps"
ssh deploy@qp2.agileview.co.uk "mv deployment/apache/$SITE /etc/apache2/sites-available"


ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 start"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE || sudo a2ensite $SITE"
ssh deploy@qp2.agileview.co.uk "sudo service apache2 restart"
