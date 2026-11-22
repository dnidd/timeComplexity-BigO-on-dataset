import java.time.LocalDate;
import java.util.List;

/**
 * Class to structure HashSet for date control
 */
public class HashSetBuilder {
    private final HashSetData hashSetData;

    public HashSetBuilder(HashSetData hashSetData) {
        this.hashSetData = hashSetData;
    }

    public void structureHashSet(List<String> fileData) {
        for (String row : fileData) {
            String[] parts = row.split(";");

            // Date
            LocalDate date = LocalDate.parse(parts[0]);

            hashSetData.addToDatasetDates(date);
        }
    }

}
