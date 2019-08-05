# weather
Website which returns a weather report for either london or hong kong

Build instructions
Git clone
git clone https://github.com/kinsie84/weather.git
Once cloned, the application jar file can be built locally using the command mvn clean install:

The jar file can be run with the following commmand:
java -jar target/weather-0.0.1-SNAPSHOT.jar

The application will deploy on an embedded tomcat server on port 8081 with context path '/weather';
ie: http://localhost:8081/weather
