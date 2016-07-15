# GoEuroJavaTest

This simple java program is created according to the GoEuro Java Test.
https://github.com/goeuro/dev-test

The program makes use of the API of GoEuro to search the information of a CITY and return a csv file.
http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME

The program is built by using IDE Eclipse.
The jar file is in folder /jar

#Execution
java -jar GoEuroJavaTest.jar CITYNAME [csvfilename]

#Parameter
CITYNAME
  city name for searching.
[csvfilename] Optional
  csv file name
  if no csv file name, "cityinfo.csv" will be the default file name.
  
#External Libraries used
Common io
https://commons.apache.org/proper/commons-io/
org.JSON
http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22org.json%22
