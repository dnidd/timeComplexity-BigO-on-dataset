import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Read weather data from file.
 */
public class FileReader {
    private final FileListData fileData;

    public FileReader(FileListData fileData) {
        this.fileData = fileData;
    }

    /**
     * Read weather data from file.
     *
     * @param filePath path to file with weather data
     * @throws IOException if there is a problem while reading the file
     */
    public void readFile(String filePath) throws IOException {
        fileData.setWeatherList(Files.readAllLines(Paths.get(filePath)));
    }
}
