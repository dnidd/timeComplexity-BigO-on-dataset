import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to structure data in TreeMap
 */
public class TreeMapBuilder {
    private final TreeMapData treeMapData;

    public TreeMapBuilder(TreeMapData treeMapData) {
        this.treeMapData = treeMapData;
    }

    /**
     * Load weather data from List
     * Structure data in TreeMap
     * Sums total temperature per date
     * Sums amount of approved values
     * Sums missing values
     *
     * @param fileData path to file with weather data
     */

    public void structureTreeMap(List<String> fileData) {
        Map<LocalDate, WeatherDataSummary> summedValuesMap = new HashMap<>();

        for (String row : fileData) {
            String[] parts = row.split(";");

            LocalDate date = LocalDate.parse(parts[0]);
            LocalTime time = LocalTime.parse(parts[1]);
            double temperature = Double.parseDouble(parts[2]);
            String quality = parts[3];

            summedValuesMap.putIfAbsent(date, new WeatherDataSummary());
            WeatherDataSummary summary = summedValuesMap.get(date);

            // Sums values
            if (!Double.isNaN(temperature)) {
                summary.totalTemperature += temperature;
                summary.approvedValues += quality.equals("G") ? 1 : 0;
            } else {
                summary.missingValues ++;
            }

            WeatherData weatherData = new WeatherData(date, time, temperature, quality, summary.totalTemperature, summary.missingValues, summary.approvedValues);

            treeMapData.addToTreeMapData(date, weatherData);
        }

    }
}

































