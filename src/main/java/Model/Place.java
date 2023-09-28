package Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//types issue
@JsonIgnoreProperties(value= {"types"})
public class Place {
	
	private Location location;
	private String name;
	private String address;
	private String language; 
	private String[] types;
	private String accuracy;
	private String phone_number;
	private String website;
	
	public Place()
	{
		
	}
	
	public Place(Location location, String name, String address, String language, String[] types, String accuracy,
			String phone_number, String website) {
		this.location = location;
		this.name = name;
		this.address = address;
		this.language = language;
		this.types = types;
		this.accuracy = accuracy;
		this.phone_number = phone_number;
		this.website = website;
	}
	
	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
    
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String[] getTypes() {
		return types;
	}
	public void setTypes(String[] types) {
		this.types = types;
	}

}
