/**
 * Author: Yu-Hsuan Huang
 * Date: May 10, 2020
 * Description: Create main function to initialize api and register bot
 * 
 * Steps:
 * 	1. Import telegram package to gradle
 * 	2. Refresh gradle project
 *  3. Create BotService which extends TelegramLongPollingBot
 *  4. Implement 3 method (onUpdateReceived, getBotUsername, getBotToken)
 *  5. Create main function to register your bot
 * 	
 */
package pers.telegram.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotTestHarness {
	
	public static void main(String[] args) {
		// Initialize Api Context
		ApiContextInitializer.init();
		
		// Instantiate Telegram Bots API
		TelegramBotsApi botApi = new TelegramBotsApi();
		
		//Register bot
		try {
			//Register Telegram Bot 
			botApi.registerBot(new BotService());
		} catch (TelegramApiException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
