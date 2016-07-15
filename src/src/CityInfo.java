package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

public class CityInfo {
	private String jsonstring;
	private String cityname;
	private String url;
	private String csvname;
	
	public CityInfo(){
		
		jsonstring = "";
		cityname = "";
		url = "";
		csvname = "";
		
	}
	
	public void setCityNameAndCSVNameFromArg(String[] args, String defaultcsvname) throws Exception{
		
		if (args.length == 0) {
			
			System.out.println("Please enter the city name!");
			System.out.println("e.g. GoEuroJavaTest CITY_NAME");
			throw new Exception();
			
		}
		
		if (args.length == 1){
			
			cityname = args[0];
			csvname = defaultcsvname;
			System.out.println("City Name: " + cityname);
			System.out.println("Default CSV File Name is used: " + csvname);
			return;
			
		}
		
		if (args.length > 1){
			
			cityname = args[0];
			csvname = args[1];
			System.out.println("City Name: " + cityname);
			System.out.println("CSV File Name: " + csvname);
			return;
			
		}
		
	}
	
	public void setURL(String urlname){
		
		url = urlname;
		
	}
	
	public String getJSON() throws Exception{
		
		try {
			
			URL goeuroapi = new URL(url.concat(cityname));
			
			BufferedReader in = new BufferedReader(
					new InputStreamReader(goeuroapi.openStream()));
			
			//while loop to read if the json is in multiple line
			String line = "";
			jsonstring = "";
			
	        while ((line = in.readLine()) != null)
	        	jsonstring+=line;
			in.close();
			
			return jsonstring;
			
		} catch(Exception e) {
			
			System.out.println("Error when retreiving JSON from the url: " + url);			
			throw e;
			
		}
		
	}
	public void generateCSV() throws Exception{
		
        try {
        	
            JSONArray docs = new JSONArray(jsonstring);
            File file=new File(csvname);
            String csv = CDL.toString(docs);
            
    		if (csv == null){
    			System.out.println("No information is returned from API.");
    			System.out.println("No CSV file is generated.");
    			return;
    		}
    		
    		if (csv.trim().equals("")){
    			System.out.println("No information is returned from API.");
    			System.out.println("No CSV file is generated.");
    			return;
    		}  		
    		
            FileUtils.writeStringToFile(file, csv, "UTF-8");
            
        } catch (JSONException e) {
        	
        	System.out.println("Error in converting JSON to CSV");            
            throw e;
            
        } catch (IOException e) {
        	
        	System.out.println("Error in writing the csv file: " + csvname);
        	System.out.println("Please check the write permission of the folder.");
            throw e;
            
        }
        
        System.out.println("CSV file: " + csvname + " is generated.");
		
	}
}
