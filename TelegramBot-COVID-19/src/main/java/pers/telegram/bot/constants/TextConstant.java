package pers.telegram.bot.constants;

public class TextConstant {
	
	public static final long MINUTE_30 = 1800000;
	public static final long MINUTE_60 = 3600000;
	
	public static final String HELP_MSG = "There are commands you can use: " + 
			"/help - to know how to use this bot\n" +
			"---------------------------------------\n" +
			"/allcountries - get all countries buttons\n" +
			"/regions - get all regions\n" +
			"---------------------------------------\n" + 
			"/asia - get Asia countries buttons\n" + 
			"/oceania - get Oceania countries buttons\n" + 
			"/africa - get Africa countries buttons\n" + 
			"/europe - get Europe countries buttons\n" + 
			"/northamerica - get North America countries buttons\n" + 
			"/southamerica - get South America countries buttons\n" +
			"=======================================\n\n" + 
			"Enter your country name to get COVID-19 statistic data:\n" + 
			"Total cases / Total deaths / Total Recovered / New cases / New deaths\n" +
			"---------------------------------------\n" + 
			"For example (Enter): Taiwan\n";
			
	
	public static final String BUTTON_MSG = "Choose below buttons";
	public static final String TYPE_AGAIN_MSG = "Please enter correct ketword";
	
	public static final String DATE_FILE_NAME = "Date.txt";
	public static final String DATA_FILE_NAME = "Data.properties";
	
	public static final String[] REGIONS = {"North America", "South America", "Asia", "Oceania", "Africa", "Europe"};
	public static final String[] ALL_COUNTRIES = {"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Anguilla", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "British Virgin Islands", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "CAR", "Caribbean Netherlands", "Cayman Islands", "Chad", "Channel Islands", "Chile", "China", "Colombia", "Comoros", "Congo", "Costa Rica", "Croatia", "Cuba", "Curaçao", "Cyprus", "Czechia", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "DRC", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Faeroe Islands", "Falkland Islands", "Fiji", "Finland", "France", "French Guiana", "French Polynesia", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Isle of Man", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macao", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nepal", "Netherlands", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Macedonia", "Norway", "Oman", "Pakistan", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Réunion", "Romania", "Russia", "Rwanda", "S. Korea", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin", "Saint Pierre Miquelon", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Sint Maarten", "Slovakia", "Slovenia", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "St. Barth", "St. Vincent Grenadines", "Sudan", "Suriname", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Trinidad and Tobago", "Tunisia", "Turkey", "Turks and Caicos", "UAE", "Uganda", "UK", "Ukraine", "Uruguay", "USA", "Uzbekistan", "Vatican City", "Venezuela", "Vietnam", "Western Sahara", "Yemen", "Zambia", "Zimbabwe"};
	public static final String[] AFRICA = {"Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cabo Verde", "Cameroon", "CAR", "Chad", "Comoros", "Congo", "Djibouti", "DRC", "Egypt", "Equatorial Guinea", "Eritrea", "Eswatini", "Ethiopia", "Gabon", "Gambia", "Ghana", "Guinea", "Guinea-Bissau", "Ivory Coast", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi", "Mali", "Mauritania", "Mauritius", "Mayotte", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Réunion", "Rwanda", "Sao Tome and Principe", "Senegal", "Seychelles", "Sierra Leone", "Somalia", "South Africa", "South Sudan", "Sudan", "Tanzania", "Togo", "Tunisia", "Uganda", "Western Sahara", "Zambia", "Zimbabwe"};
	public static final String[] ASIA = {"Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan", "Brunei", "Cambodia", "China", "Cyprus", "Georgia", "Hong Kong", "India", "Indonesia", "Iran", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Kuwait", "Kyrgyzstan", "Laos", "Lebanon", "Macao", "Malaysia", "Maldives", "Mongolia", "Myanmar", "Nepal", "Oman", "Pakistan", "Palestine", "Philippines", "Qatar", "S. Korea", "Saudi Arabia", "Singapore", "Sri Lanka", "Syria", "Taiwan", "Tajikistan", "Thailand", "Timor-Leste", "Turkey", "UAE", "Uzbekistan", "Vietnam", "Yemen"};
	public static final String[] EUROPE = {"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia and Herzegovina", "Bulgaria", "Channel Islands", "Croatia", "Czechia", "Denmark", "Estonia", "Faeroe Islands", "Finland", "France", "Germany", "Gibraltar", "Greece", "Hungary", "Iceland", "Ireland", "Isle of Man", "Italy", "Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Malta", "Moldova", "Monaco", "Montenegro", "Netherlands", "North Macedonia", "Norway", "Poland", "Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain", "Sweden", "Switzerland", "UK", "Ukraine", "Vatican City"};
	public static final String[] OCEANIA = {"Australia", "Fiji", "French Polynesia", "New Caledonia", "New Zealand", "Papua New Guinea"};
	public static final String[] NORTH_AMERICA = {"Anguilla", "Antigua and Barbuda", "Aruba", "Bahamas", "Barbados", "Belize", "Bermuda", "British Virgin Islands", "Canada", "Caribbean Netherlands", "Cayman Islands", "Costa Rica", "Cuba", "Curaçao", "Dominica", "Dominican Republic", "El Salvador", "Greenland", "Grenada", "Guadeloupe", "Guatemala", "Haiti", "Honduras", "Jamaica", "Martinique", "Mexico", "Montserrat", "Nicaragua", "North America", "Panama", "Saint Kitts and Nevis", "Saint Lucia", "Saint Martin", "Saint Pierre Miquelon", "Sint Maarten", "St. Barth", "St. Vincent Grenadines", "Trinidad and Tobago", "Turks and Caicos", "USA"};
	public static final String[] SOUTH_AMERICA = {"Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador", "Falkland Islands", "French Guiana", "Guyana", "Paraguay", "Peru", "Suriname", "Uruguay", "Venezuela"};
	
}
