UI_PROJECT_HOME=../UI

cp -rf  web-app/images/* $UI_PROJECT_HOME/web-app/engage/images/
cp -rf  web-app/less/* $UI_PROJECT_HOME/web-app/engage/less/
cp -rf  web-app/js/* $UI_PROJECT_HOME/web-app/engage/js/
cp -rf  web-app/font/* $UI_PROJECT_HOME/web-app/engage/font/

cp -rf  web-app/tmpl/* $UI_PROJECT_HOME/web-app/tmpl/

cp grails-app/views/socialEngage/cases.gsp $UI_PROJECT_HOME/grails-app/views/socialEngage/cases.gsp
cp grails-app/views/socialEngage/posts.gsp $UI_PROJECT_HOME/grails-app/views/socialEngage/posts.gsp
cp grails-app/views/socialEngage/overview.gsp $UI_PROJECT_HOME/grails-app/views/socialEngage/overview.gsp
