<VirtualHost *:80>                                                                                                                                                                   
        ServerAdmin webmaster@razerstats.com                                                                                                                                             
        ServerName www.razerstats.com                                                                                                                                                  
                                                                                                                                                                                     
        JKMount /stats-web/* ajp13_worker                                                                                                                                  
        JKMount /stats-web ajp13_worker                                                                                                                                    
                                                                                                                                                                                     
                                                                                                                                                                                     
        ProxyRequests Off                                                                                                                                                            
        ProxyPreserveHost On                                                                                                                                                         
                                                                                                                                                                                     
        ProxyPass / ajp://localhost:8009/stats-web/                                                                                                                        
        ProxyPassReverse / ajp://localhost:8009/stats-web/                                                                                                                 
                                                                                                                                                                                     
        Header edit Location "^http://www.razerstats.com/stats-web/(.*)$" "http://www.stats.com/$1"                                                                       
                                                                                                                                                                                     
        ProxyHTMLExtended On                                                                                                                                                         
        SetOutputFilter DEFLATE;proxy-html;INFLATE                                                                                                                                   
        ProxyHtmlURLMap /stats-web/ /                                                                                                                                      
                                                                                                                                                                                     
        ErrorLog  /var/log/apache2/www.razerstats.com/error.log                                                                                                                           
        CustomLog /var/log/apache2/www.razerstats.com/access.log combined                                                                                                                 
</VirtualHost>    
