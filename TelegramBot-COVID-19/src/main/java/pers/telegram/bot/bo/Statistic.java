package pers.telegram.bot.bo;

import java.util.Map;

public class Statistic {
	
	private String date;
	
	private String totalCases;
	private String totalDeaths;
	private String totalRecovered;
	
	public Map<String, Country> countries;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public Map<String, Country> getCountries() {
		return countries;
	}
	public void setCountries(Map<String, Country> countries) {
		this.countries = countries;
	}
	
	
}
