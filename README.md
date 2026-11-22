### Time complexity study
A weather data searching and sorting application.
A short study of algorithms and data structures to strive for an<br>
optimization of a worst case scenario calculating time complexity (Big O).

#### Execution
Command line UI application. Instructions and examples in class WeatherDataHandler.

#### Data
A .csv data set of open weather station data from SMHI<br>
(Sveriges meteorologiska och hydrologiska institut) is used<br>
with observations spanning from 1946-01-01;07:00:00 to 2020-12-31;23:00:00.
The data is structured as below extract example:
date;time;temperature;approved/not approved quality.
````
2009-07-06;05:00:00;11.7;Y
2009-07-06;06:00:00;12.1;G
2009-07-06;07:00:00;11.9;Y
2009-07-06;08:00:00;11.8;Y
2009-07-06;09:00:00;12.3;G
2009-07-06;10:00:00;12.9;Y
2009-07-06;11:00:00;12.3;Y
2009-07-06;12:00:00;12.5;G
2009-07-06;13:00:00;12.4;Y
2009-07-06;14:00:00;12.2;Y
2009-07-06;15:00:00;12.7;G
````

### Time complexity
Worst case time complexity scenarios are noted mainly in classes:
- ApprovedValuesCalculator
- AverageTemperatureCalculator
- MissingValuesCalculator