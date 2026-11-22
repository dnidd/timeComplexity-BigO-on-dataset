import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Creates and holds TreeMap of dates and WeatherData objects
 */
public class TreeMapData {
    // NavigableMap to be able to use subMap
    private final NavigableMap<LocalDate, List<WeatherData>> weatherTreeMap;

    public TreeMapData() {
        this.weatherTreeMap = new TreeMap<>();
    }

    public NavigableMap<LocalDate, List<WeatherData>> getTreeMapData() {
        return weatherTreeMap;
    }

    public void addToTreeMapData(LocalDate date, WeatherData weatherData) {
        weatherTreeMap.computeIfAbsent(date, k -> new ArrayList<>()).add(weatherData);
    }
}