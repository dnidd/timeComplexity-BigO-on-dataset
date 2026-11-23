/**
 * Application for retrieving and presenting temperature
 * data from a weather station file.
 */
public class WeatherDataMain {
	/**
	 * Program entry point.
	 *
	 * @param args optional argument for path to weather data file
	 */
	public static void main(String[] args) {
		WeatherDataHandler weatherData = new WeatherDataHandler();
		String fileName = Config.FILE_PATH;
		if(args.length > 0) {
			fileName = args[0];
		}		
		try {				
			weatherData.loadData(fileName);
			new WeatherDataUI(weatherData).startUI();
		} catch (Exception e) {
			System.out.println("Closing program ...");
			e.printStackTrace();
			System.out.println("Current working directory: " + System.getProperty("user.dir"));
		}		
	}
}