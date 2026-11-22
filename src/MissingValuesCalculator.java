import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

/**
 * Class calculating missing values
 */
public class MissingValuesCalculator {

    /**
     * Calculating missing values
     *
     * @param weatherMap holds data
     * @param dateFrom date from
     * @param dateTo date to
     *
     * @return list of missing values
     */
    public List<String> calculateMissingValues(NavigableMap<LocalDate, List<WeatherData>> weatherMap, LocalDate dateFrom, LocalDate dateTo) {

        // subMap
        Map<LocalDate, List<WeatherData>> subMap = weatherMap.subMap(dateFrom, true, dateTo, true);   // O(log n + k)

        List<String> resultValues = new ArrayList<>();

        // k = size of subMap
        // https://stackoverflow.com/questions/38868481/time-complexity-of-treemap-operations-get-and-submap
        for (Map.Entry<LocalDate, List<WeatherData>> entry : subMap.entrySet()) {   // O(k) (1 iter per date)
            LocalDate date = entry.getKey();   // O(1)
            List<WeatherData> dataList = entry.getValue();   // O(1)

            int totalValues = dataList.size();   // O(1)
            int missingValues = 24 - totalValues;   // O(1)

            resultValues.add(String.format("%s missing %d values", date, missingValues));
        }

       // Sort resultValues, Merge sort O(n log n)
        resultValues.sort((String s1, String s2) -> {
            // Split/separate strings to get temperature ([2]), "%s missing %d values"
            String[] parts1 = s1.split(" ");   // O(1)
            String[] parts2 = s2.split(" ");   // O(1)

            // Get temperatures ([2]), "%s missing %d values"
            int temp1 = Integer.parseInt(parts1[2]);   // O(1)
            int temp2 = Integer.parseInt(parts2[2]);   // O(1)

            // Compare temperatures in descending order
            return Integer.compare(temp2, temp1);
        });


        return resultValues;
    }
}































