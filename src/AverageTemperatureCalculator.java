import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Class calculating average temperature
 */
public class AverageTemperatureCalculator {

    /**
     * Calculating average temperature
     *
     * @param weatherMap holds data
     * @param dateFrom date from
     * @param dateTo date to
     * @return list of average temperatures
     */
    public List<String> calculateAverageTemperatures(NavigableMap<LocalDate, List<WeatherData>> weatherMap, LocalDate dateFrom, LocalDate dateTo) {

        // Create subMap
        Map<LocalDate, List<WeatherData>> subMap = weatherMap.subMap(dateFrom, true, dateTo, true);   // O(log n) + O(k)

        List<String> results = new ArrayList<>();

        // k = size of subMap
        // https://stackoverflow.com/questions/38868481/time-complexity-of-treemap-operations-get-and-submap
        for (Map.Entry<LocalDate, List<WeatherData>> entry : subMap.entrySet()) {   // O(k) (1 iter per date)
            LocalDate date = entry.getKey();   // O(1)
            List<WeatherData> weatherDataList = entry.getValue();   // O(1)

            // .getLast(), commented code shows example:
            // double totalTemperature = weatherDataList.getLast().getTotalTemperature();   // O(1)
            double totalTemperature = weatherDataList.get(weatherDataList.size() - 1).getTotalTemperature();
            double averageTemperature =  totalTemperature / weatherDataList.size();   // O(1)

            results.add(String.format("%s average temperature: %.2f degrees Celsius", date, averageTemperature));

        }
            return results;

        }
    }
































