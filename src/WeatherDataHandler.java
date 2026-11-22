import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 * Retrieves temperature data from a weather station file.
 */
public class WeatherDataHandler {
	private final FileListData fileData;
	private final FileReader reader;
	private final TreeMapData treeMapData;
	private final TreeMapBuilder treeMapBuilder;
	private final HashSetData hashSetData;
	private final HashSetBuilder hashSetBuilder;
	private final DateValidator validator;
	private final AverageTemperatureCalculator average;
	private final MissingValuesCalculator missing;
	private final ApprovedValuesCalculator approved;



	WeatherDataHandler() {
		this.fileData = new FileListData();
		this.reader = new FileReader(fileData);
		this.treeMapData = new TreeMapData();
		this.treeMapBuilder = new TreeMapBuilder(treeMapData);
		this.hashSetData = new HashSetData();
		this.hashSetBuilder = new HashSetBuilder(hashSetData);
		this.validator = new DateValidator(hashSetData);
		this.average = new AverageTemperatureCalculator();
		this.missing = new MissingValuesCalculator();
		this.approved = new ApprovedValuesCalculator();
	}

	/**
	 * Load weather data from file.
	 * Structure data
	 * 
	 * @param filePath path to file with weather data
	 * @throws IOException if there is a problem while reading the file
	 */
	public void loadData(String filePath) throws IOException {
		// read file, create & structure List
		// FileReader takes fileData-object: FileReader(fileData) and reads file
		reader.readFile(filePath);

		// Create & structure TreeMap
		treeMapBuilder.structureTreeMap(fileData.getWeatherList());

		// Create & structure HashSet for date control
		hashSetBuilder.structureHashSet(fileData.getWeatherList());
	}

	/**
	 * Invokes date validator
	 *
	 * @param dateFrom start date (YYYY-MM-DD) inclusive
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return boolean of validation
	 */
	public boolean validateDates(LocalDate dateFrom, LocalDate dateTo) {
		if (validator.validateDates(dateFrom,dateTo) ) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Search for average temperature for all dates between the two dates (inclusive).
	 * Result is sorted by date (ascending). When searching from 2000-01-01 to 2000-01-03
	 * the result should be:
	 * 2000-01-01 average temperature: 0.42 degrees Celsius
	 * 2000-01-02 average temperature: 2.26 degrees Celsius
	 * 2000-01-03 average temperature: 2.78 degrees Celsius
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return average temperature for each date, sorted by date  
	 */
	public List<String> averageTemperatures(LocalDate dateFrom, LocalDate dateTo) {

		return average.calculateAverageTemperatures(treeMapData.getTreeMapData(), dateFrom, dateTo);
	}
	/**
	 * Search for missing values between the two dates (inclusive) assuming there 
	 * should be 24 measurement values for each day (once every hour). Result is
	 * sorted by number of missing values (descending). When searching from
	 * 2000-01-01 to 2000-01-03 the result should be:
	 * 2000-01-02 missing 1 values
	 * 2000-01-03 missing 1 values
	 * 2000-01-01 missing 0 values
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return dates with missing values together with number of missing values for each date, sorted by number of missing values (descending)
	 */
	public List<String> missingValues(LocalDate dateFrom, LocalDate dateTo) {

		return missing.calculateMissingValues(treeMapData.getTreeMapData(), dateFrom, dateTo);
	}
	/**
	 * Search for percentage of approved values between the two dates (inclusive).
	 * When searching from 2000-01-01 to 2000-01-03 the result should be:
	 * Approved values between 2000-01-01 and 2000-01-03: 32.86 %
	 * 
	 * @param dateFrom start date (YYYY-MM-DD) inclusive  
	 * @param dateTo end date (YYYY-MM-DD) inclusive
	 * @return period and percentage of approved values for the period  
	 */
	public List<String> approvedValues(LocalDate dateFrom, LocalDate dateTo) {

		return approved.calculateApprovedValues(treeMapData.getTreeMapData(), dateFrom, dateTo);
	}
}