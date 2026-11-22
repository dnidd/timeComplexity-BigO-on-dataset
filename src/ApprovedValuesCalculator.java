import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;

/**
 * Class calculating approved values
 */
public class ApprovedValuesCalculator {

    /**
     * Calculating approved values
     *
     * @param weatherMap holds data
     * @param dateFrom date from
     * @param dateTo date to
     * @return list of approved values
     */
    public List<String> calculateApprovedValues(NavigableMap<LocalDate, List<WeatherData>> weatherMap, LocalDate dateFrom, LocalDate dateTo) {

        List<WeatherData> allWeatherData = new ArrayList<>();
        List<String> result = new ArrayList<>();

        // Extract lists of objects
        // O(log n + k*m)
        for (List<WeatherData> weatherDataList : weatherMap.subMap(dateFrom, true, dateTo, true).values()) {   // O(log n) + O(k)
            allWeatherData.addAll(weatherDataList);   // O(k * m), m=number of lists, k=number of elems in lists
        }

        double approvedValues = 0.0;
        double totalValues = allWeatherData.size();

        for (WeatherData data : allWeatherData) {  // O(n)
            if("G".equals(data.getQuality())) {   // O(1)
                approvedValues ++;   // O(1)
            }
        }

        double approvedPercentage = (approvedValues / totalValues) * 100;

        result.add(String.format("Approved values between %s and %s: %.2f %%", dateFrom, dateTo, approvedPercentage));
        return result;
    }
}


























