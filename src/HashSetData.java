import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Class creating and holding hash set of dates
 */
public class HashSetData {
    private final Set<LocalDate> datasetDates;

    public HashSetData() {
        this.datasetDates = new HashSet<>();
    }

    // Contains: O(1)
    public boolean getDate(LocalDate date) {
        return datasetDates.contains(date);
    }

    public void addToDatasetDates(LocalDate date) {
        datasetDates.add(date);
    }
}