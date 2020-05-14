package pers.telegram.bot.services;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pers.telegram.bot.bo.Country;
import pers.telegram.bot.bo.Statistic;

public class HttpService {

	private static final Logger logger = LogManager.getLogger(HttpService.class); 
	private static final String URL = "https://www.worldometers.info/coronavirus/";
	
	private static long catchTimeMillis;
	private static Statistic statisticData;
	
	public static void recatchData() {
		Statistic data = new Statistic();
		
		try {
			logger.info("Get HTML from " + URL);
			Document doc = Jsoup.connect(URL).get();
			Elements content = doc.getElementsByClass("content-inner");
			
			// Update Date Time
			Elements date = content.first().getElementsByAttributeValue("style", "font-size:13px; color:#999; margin-top:5px; text-align:center");
			data.setDate(date.first().text().substring(14));
			logger.info("Data update time:" + date.first().text().substring(14));
			
			
			// Total Cases, Total Deaths, Total Recovered
			Elements total = content.first().getElementsByClass("maincounter-number");
			for (int i=0; i<total.size(); i++) {
				switch(i) {
				case 0:
					data.setTotalCases(total.get(i).text());
					break;
				case 1:
					data.setTotalDeaths(total.get(i).text());
					break;
				case 2:
					data.setTotalRecovered(total.get(i).text());
					break;
				}
			}
			logger.info("Get total cases, total deaths and total recovered");
			
			// Each country data
			Element table = doc.getElementById("main_table_countries_today");
			Elements tbodies = table.getElementsByTag("tbody");
			Elements trs = tbodies.first().getElementsByTag("tr");
			Map<String, Country> countries = new HashMap<String, Country>();
			for (int i=0; i< trs.size(); i++) {
				Elements tds = trs.get(i).getElementsByTag("td");
				if(!tds.first().text().trim().isEmpty()) {
					Country country = new Country();
					country.setCountry(tds.get(0).text().trim());
					country.setTotalCases(tds.get(1).text().trim());
					country.setNewCases(tds.get(2).text().trim());
					country.setTotalDeaths(tds.get(3).text().trim());
					country.setNewDeaths(tds.get(4).text().trim());
					country.setTotalRecovered(tds.get(5).text().trim());
					countries.put(tds.get(0).text().trim(), country);
				}
			}
			logger.info("Get all countries data");
			data.setCountries(countries);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		logger.info("Update catchTimeNillis and statisticData values");
		catchTimeMillis = System.currentTimeMillis();
		statisticData = data;
	}

	
	
	
	
	public static long getCatchTimeMillis() {
		return catchTimeMillis;
	}

	public static void setCatchTimeMillis(long catchTimeMillis) {
		HttpService.catchTimeMillis = catchTimeMillis;
	}

	public static Statistic getStatisticData() {
		return statisticData;
	}

	public static void setStatisticData(Statistic statisticData) {
		HttpService.statisticData = statisticData;
	}
	
}
