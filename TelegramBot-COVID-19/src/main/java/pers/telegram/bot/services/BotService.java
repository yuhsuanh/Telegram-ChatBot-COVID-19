package pers.telegram.bot.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import pers.telegram.bot.bo.Country;
import pers.telegram.bot.bo.Statistic;
import pers.telegram.bot.constants.TextConstant;

public class BotService extends TelegramLongPollingBot{
	
	private static final Logger logger = LogManager.getLogger(BotService.class);

	public void onUpdateReceived(Update update) {
		
		if(update.hasMessage() && update.getMessage().hasText()) {
			long chatId = update.getMessage().getChatId();
			String text = update.getMessage().getText();
			logger.info("Chat ID: " + chatId + " Message: " + text);
			
			Statistic data = getStatisticData();

			SendMessage msg = new SendMessage();
			msg.setChatId(chatId);
			
			//Commands
			if(text.indexOf("/") == 0) {
				if(text.equals("/help") || text.equals("/start")) {
					msg.setText(TextConstant.HELP_MSG);
				} else if(text.equals("/regions")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.REGIONS));
					keyboardMarkup.setOneTimeKeyboard(true);
					
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/northamerica")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.NORTH_AMERICA));
					keyboardMarkup.setOneTimeKeyboard(true);
					
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/southamerica")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.SOUTH_AMERICA));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/asia")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.ASIA));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/europe")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.EUROPE));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/oceania")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.OCEANIA));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/africa")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.AFRICA));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else if(text.equals("/allcountries")) {
					ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
					keyboardMarkup.setKeyboard(createButtons(TextConstant.ALL_COUNTRIES));
					keyboardMarkup.setOneTimeKeyboard(true);
	
					msg.setText(TextConstant.BUTTON_MSG);
					msg.setReplyMarkup(keyboardMarkup);
				} else {
					msg.setText(TextConstant.TYPE_AGAIN_MSG);
				}
			}
			//Keywords
			else {
				if(text.equals("Total cases")) {
					msg.setText("Total cases: " + data.getTotalCases());
				} else if(text.equals("Total deaths")) {
					msg.setText("\nTotal deaths: " + data.getTotalDeaths());
				} else if(text.equals("Total recovered") ) {
					msg.setText("\nTotal recovered: " + data.getTotalRecovered());
				} else if(data.getCountries().get(text) != null) {
					Country country = data.getCountries().get(text);
					msg.setText(text + "\nTotal cases: " + country.getTotalCases() + "\nTotal deaths:" + country.getTotalDeaths()
							+ "\nTotal recovered: " + country.getTotalRecovered() + "\nNew cases: " + country.getNewCases() + "\nNew deaths: " + country.getNewDeaths());
				} else {
					msg.setText(TextConstant.TYPE_AGAIN_MSG);
				}
			}
			
			this.executeMessage(msg);
		} else if (update.hasMessage()) {
			 long chatId = update.getMessage().getChatId();
			 
			 SendMessage msg = new SendMessage();
			 msg.setChatId(chatId);
			 msg.setText("Please use /help command to know how to use this BOT.");
			 
			 this.executeMessage(msg);
		}
	}
	
	private void executeMessage(SendMessage msg) {
		try {
			execute(msg);
		} catch (TelegramApiException e) {
			logger.error(e.getMessage());
		}
	}
	
	private List<KeyboardRow> createButtons(String[] array) {
		List<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
		logger.info("Create keyboard buttons");
		
		int i;
		for(i=0; i+2<array.length; i+=3) {
			KeyboardRow row = new KeyboardRow();
			row.add(array[i]);
			row.add(array[i+1]);
			row.add(array[i+2]);
			keyboard.add(row);
		}
		
		KeyboardRow row = new KeyboardRow();
		if(i < array.length) {
			row.add(array[i]);
			if (i+1 < array.length)
				row.add(array[i+1]);
			keyboard.add(row);
		}
		
		return keyboard;
	}
	
	private Statistic getStatisticData() {
		long nowTimeMillis = System.currentTimeMillis();
		if(nowTimeMillis > HttpService.getCatchTimeMillis() + TextConstant.MINUTE_30) {
			logger.info("Re-catch statistic data from website");
			HttpService.recatchData();
		}
		return HttpService.getStatisticData();
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		return "*bot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return "----------------------------------------------";
	}

}
