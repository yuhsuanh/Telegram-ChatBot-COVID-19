package pers.telegram.bot.bo;

public class Country {
	
	//Total cases, Total deaths, New cases, New deaths, Total recovered
	private String country;
	private String totalCases;
	private String totalDeaths;
	private String totalRecovered;
	private String newCases;
	private String newDeaths;
	
	public Country() { }

	public Country(String totalCases, String totalDeaths, String totalRecovered, String newCases, String newDeaths) {
		this.totalCases = totalCases;
		this.totalDeaths = totalDeaths;
		this.totalRecovered = totalRecovered;
		this.newCases = newCases;
		this.newDeaths = newDeaths;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTotalCases() {
		return totalCases;
	}

	public void setTotalCases(String totalCases) {
		this.totalCases = totalCases;
	}

	public String getTotalDeaths() {
		return totalDeaths;
	}

	public void setTotalDeaths(String totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public String getTotalRecovered() {
		return totalRecovered;
	}

	public void setTotalRecovered(String totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

	public String getNewCases() {
		return newCases;
	}

	public void setNewCases(String newCases) {
		this.newCases = newCases;
	}

	public String getNewDeaths() {
		return newDeaths;
	}

	public void setNewDeaths(String newDeaths) {
		this.newDeaths = newDeaths;
	}
	
}
