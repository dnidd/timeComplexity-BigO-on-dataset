import java.time.LocalDate;

/**
 * Class for validating dates
 *
 */
public class DateValidator {
    private final HashSetData hashSetData;

    public DateValidator(HashSetData hashSetData) {
        this.hashSetData = hashSetData;
    }

    // Checks if both dates in data set
    public boolean datesExistInDataset(LocalDate dateFrom, LocalDate dateTo) {
        return hashSetData.getDate(dateFrom) && hashSetData.getDate(dateTo);
    }

    // Checks if dateFrom before dateTo
    public boolean isDateFromBeforeDateTo(LocalDate dateFrom, LocalDate dateTo) {
        return dateFrom.isBefore(dateTo);
    }

    // Checks if dateFrom equals dateTo
    public boolean isDateFromEqualToDateTo(LocalDate dateFrom, LocalDate dateTo) {
        return dateFrom.equals(dateTo);
    }

    /**
     * Combined checks for all conditions
     *
     * @param dateFrom date from
     * @param dateTo date to
     *
     * @return boolean of validation
     */
    public boolean validateDates(LocalDate dateFrom, LocalDate dateTo) {
        if (!datesExistInDataset(dateFrom, dateTo)) {
            return false;
        }

        if (!isDateFromBeforeDateTo(dateFrom, dateTo)) {
            return false;
        }

        if (isDateFromEqualToDateTo(dateFrom, dateTo)) {
            return false;
        }

        return true;
    }
}