#!/bin/bash

scp build/libs/$WAR_NAME.war deploy@qp2.agileview.co.uk:~
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 stop"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-enabled/$SITE || sudo a2dissite $SITE"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE || sudo rm /etc/apache2/sites-available/$SITE"
ssh deploy@qp2.agileview.co.uk "rm /var/lib/tomcat7/webapps/$WAR_NAME.war"
ssh deploy@qp2.agileview.co.uk "rm -rf /var/lib/tomcat7/webapps/$WAR_NAME"
ssh deploy@qp2.agileview.co.uk "mv ~/$WAR_NAME.war /var/lib/tomcat7/webapps"
ssh deploy@qp2.agileview.co.uk "sudo /etc/init.d/tomcat7 start"
ssh deploy@qp2.agileview.co.uk "test -f /etc/apache2/sites-available/$SITE || sudo a2ensite $SITE"
ssh deploy@qp2.agileview.co.uk "sudo service apache2 restart"
