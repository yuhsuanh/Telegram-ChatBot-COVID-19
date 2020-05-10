/**
 * Author: Yu-Hsuan Huang
 * Date: May 10, 2020
 * Description: Create a Telegram Bot echo your message
 */
package pers.telegram.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotService extends TelegramLongPollingBot{
	
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub
		// Check if users are chat with Bot
		if (update.hasMessage() && update.getMessage().hasText()) {
	        // Get user input message
	        String message_text = update.getMessage().getText();
	        // Get user chat id
	        long chat_id = update.getMessage().getChatId();

	        System.out.println(chat_id + ": " + message_text);
	        
	        // Create a message object object
	        SendMessage message = new SendMessage();
	        message.setChatId(chat_id);
	        message.setText(message_text);
	        
	        try {
	        		// Sending our message object to user
	            execute(message);
	        } catch (TelegramApiException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

	public String getBotUsername() {
		// TODO Auto-generated method stub
		// Username for your bot
		return "*bot";
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		// Bot Token
		return "----------------------------------------------";
	}

}
