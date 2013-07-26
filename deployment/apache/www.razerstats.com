<VirtualHost *:80>                                                                                                                                                                   
        ServerAdmin webmaster@razerstats.com                                                                                                                                             
        ServerName www.razerstats.com                                                                                                                                                  
                                                                                                                                                                                     
        JKMount /stats/* ajp13_worker                                                                                                                                  
        JKMount /stats ajp13_worker                                                                                                                                    
                                                                                                                                                                                     
                                                                                                                                                                                     
        ProxyRequests Off                                                                                                                                                            
        ProxyPreserveHost On                                                                                                                                                         
                                                                                                                                                                                     
        ProxyPass / ajp://localhost:8009/stats/                                                                                                                        
        ProxyPassReverse / ajp://localhost:8009/stats/                                                                                                                 
                                                                                                                                                                                     
        Header edit Location "^http://www.nzbair.com/stats/(.*)$" "http://www.stats.com/$1"                                                                       
                                                                                                                                                                                     
        ProxyHTMLExtended On                                                                                                                                                         
        SetOutputFilter DEFLATE;proxy-html;INFLATE                                                                                                                                   
        ProxyHtmlURLMap /stats/ /                                                                                                                                      
                                                                                                                                                                                     
        ErrorLog  /var/www/www.razerstats.com/logs/error.log                                                                                                                           
        CustomLog /var/www/www.razerstats.com/logs/access.log combined                                                                                                                 
</VirtualHost>    