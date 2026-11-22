import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Class holding weather data
 */
public class WeatherData {
    private final LocalDate date;
    private final LocalTime time;
    private final Double temperature;
    private final String quality;
    private final double totalTemperature;
    private final int missingValues;
    private final int approvedValues;

    /**
     * Constructs WeatherData
     *
     * @param date date
     * @param time time
     * @param temperature temperature
     * @param quality quality
     * @param totalTemperature total temperature
     * @param missingValues missing values
     * @param approvedValues approved values
     */
    public WeatherData(LocalDate date, LocalTime time, double temperature, String quality, double totalTemperature, int missingValues, int approvedValues) {
        this.date = date;
        this.time = time;
        this.temperature = temperature;
        this.quality = quality;
        this.totalTemperature = totalTemperature;
        this.missingValues = missingValues;
        this.approvedValues = approvedValues;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getQuality() {
        return quality;
    }

    public double getTotalTemperature() {
        return totalTemperature;
    }


    @Override
    public String toString() {
        return time + " " + temperature + " " + quality + " " + totalTemperature + " " + missingValues + " " + approvedValues;
    }


}