import java.util.ArrayList;
import java.util.List;

/**
 * Class holding file list
 */
public class FileListData {
    private List<String> weatherList;

    public FileListData() {
        this.weatherList = new ArrayList<>();
    }

    public List<String> getWeatherList() {
        return weatherList;
    }
    public void setWeatherList(List<String> weatherList) {
        this.weatherList = weatherList;
    }

}
