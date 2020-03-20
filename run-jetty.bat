set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n -Xmx1024m -XX:MaxPermSize=512m
call mvn jetty:run %1 -P jetty