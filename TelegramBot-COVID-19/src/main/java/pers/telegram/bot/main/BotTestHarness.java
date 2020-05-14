package pers.telegram.bot.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import pers.telegram.bot.services.BotService;

public class BotTestHarness {
	
	private static final Logger logger = LogManager.getLogger(BotTestHarness.class);
	
	public static void main(String[] args) {
		
		ApiContextInitializer.init();
		TelegramBotsApi botApi = new TelegramBotsApi();
		
		try {
			botApi.registerBot(new BotService());
		} catch (TelegramApiException e) {
			logger.error(e.getMessage());
		}
		
	}

}
