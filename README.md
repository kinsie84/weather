# Weather
Website which returns a weather report for either london or hong kong

# Prerequisites

JDK 1.8.X

Maven 3.3.x

# Build

Download/Clone the project on to your local machine:

--> git clone https://github.com/kinsie84/weather.git

Once cloned/downloaded, the application jar file can be built locally using the command: 

--> mvn clean install

# Run
The jar file can be run with the following commmand:

--> java -jar target/weather-0.0.1-SNAPSHOT.jar

The application will deploy on an embedded tomcat server on port 8081 with context path '/weather';
ie: http://localhost:8081/weather
