package src;

public class GoEuroJavaTest {
	public static final String defaultcsvname = "cityinfo.csv";
	public static final String url = "http://api.goeuro.com/api/v2/position/suggest/en/";
			
	public static void main(String[] args) {
		try{
			
			CityInfo cityinfo = new CityInfo();
			cityinfo.setCityNameAndCSVNameFromArg(args, defaultcsvname);
			cityinfo.setURL(url);
			cityinfo.getJSON();
			cityinfo.generateCSV();
			
		} catch(Exception e) {
			System.out.println("The process is terminated. No CSV file generated.");
		}
	}
}
