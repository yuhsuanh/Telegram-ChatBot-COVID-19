/**
 * Author: Yu-Hsuan Huang
 * Date: May 10, 2020
 * Description: Create a Telegram Bot to get different input types
 */
package pers.telegram.bot;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendContact;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendVideo;
import org.telegram.telegrambots.meta.api.methods.send.SendVoice;
import org.telegram.telegrambots.meta.api.objects.Audio;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Video;
import org.telegram.telegrambots.meta.api.objects.Voice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotService extends TelegramLongPollingBot{

	public void onUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()) {
			//TODO user input text
			System.out.println("User input \'TEXT\'");
			long chatId = update.getMessage().getChatId();
			String messageText = update.getMessage().getText();
			
			if(messageText.equals("/menu")) {
				SendMessage message = new SendMessage() // Create a message object object
                        .setChatId(chatId)
                        .setText("Here is your keyboard");
				
				// Create ReplyKeyboardMarkup object
			    ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
			    
			    // Create the keyboard (list of keyboard rows)
			    List<KeyboardRow> keyboard = new ArrayList<>();
			    
			    // Create a keyboard row
			    KeyboardRow row = new KeyboardRow();
			    row.add("Row 1 Button 1");
			    row.add("Row 1 Button 2");
			    row.add("Row 1 Button 3");
			    
			    // Add the first row to the keyboard
			    keyboard.add(row);
			    
			    // Set the keyboard to the markup
			    keyboardMarkup.setKeyboard(keyboard);
			    // Add it to the message
			    message.setReplyMarkup(keyboardMarkup);
			    try {
			        execute(message); // Sending our message object to user
			    } catch (TelegramApiException e) {
			        e.printStackTrace();
			    }
			}  else if (messageText.equals("/hide")) {
				SendMessage msg = new SendMessage()
			                        .setChatId(chatId)
			                        .setText("Keyboard hidden");
			    ReplyKeyboardRemove keyboardMarkup = new ReplyKeyboardRemove();
			    msg.setReplyMarkup(keyboardMarkup);
			    try {
			        execute(msg); // Call method to send the photo
			    } catch (TelegramApiException e) {
			        e.printStackTrace();
			    }
			}
			
			
		} else if (update.hasMessage() && update.getMessage().hasPhoto()) {
			//TODO user input photo
			System.out.println("User input \'PHOTO\'");
		    long chatId = update.getMessage().getChatId();

		    // Array with photo objects with different sizes
		    // We will get the biggest photo from that array
		    List<PhotoSize> photos = update.getMessage().getPhoto();
		    // Know file_id
		    String fileId = photos.stream()
		                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
		                    .findFirst()
		                    .orElse(null).getFileId();
		    
		    // Know photo width
		    int fileWidth = photos.stream()
		                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
		                    .findFirst()
		                    .orElse(null).getWidth();
		    
		    // Know photo height
		    int fileHeight = photos.stream()
		                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
		                    .findFirst()
		                    .orElse(null).getHeight();
		    
		    // Know photo size
		    int fileSize = photos.stream()
		                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
		                    .findFirst()
		                    .orElse(null).getFileSize();
		    
		    // Know photo height
		    String filePath = photos.stream()
		                    .sorted(Comparator.comparing(PhotoSize::getFileSize).reversed())
		                    .findFirst()
		                    .orElse(null).getFilePath();
		    
		    // Set photo caption
		    String caption = "File ID: " + fileId + "\nWidth: " + Integer.toString(fileWidth) + "\nHeight: " + Integer.toString(fileHeight) + "\nSize: " + Integer.toString(fileSize) + "\nPath: " + filePath;
		    SendPhoto msg = new SendPhoto()
		                    .setChatId(chatId)
		                    .setPhoto(fileId)
		                    .setCaption(caption);
		    try {
		        execute(msg);
		    } catch (TelegramApiException e) {
		        e.printStackTrace();
		    }
		} else if (update.hasMessage() && update.getMessage().hasVoice()) {
			//TODO user input voice
			System.out.println("User input \'VOICE\'");
			long chatId = update.getMessage().getChatId();
			
			Voice voice = update.getMessage().getVoice();
			
			String fileId = voice.getFileId();
			int fileDuration = voice.getDuration();
			int fileSize = voice.getFileSize();
			
			String caption = "File ID: " + fileId + "\nFile duration: " + fileDuration + "\nFile size: " + fileSize; 
			SendVoice msg = new SendVoice()
							.setChatId(chatId)
							.setVoice(fileId)
							.setCaption(caption);
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasAudio()) {
			//TODO user input audio
			System.out.println("User input \'AUDIO\'");
			long chatId = update.getMessage().getChatId();
			
			Audio audio = update.getMessage().getAudio();
			String fileId = audio.getFileId();
			String fileTitle = audio.getTitle();
			int fileDuration = audio.getDuration();
			int fileSize = audio.getFileSize();
			
			String caption = "File ID: " + fileId + "\nFile title:" + fileTitle + "\nFile duration: " + fileDuration + "\nFile size: " + fileSize; 
			SendAudio msg = new SendAudio()
							.setChatId(chatId)
							.setAudio(fileId)
							.setCaption(caption);
			
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasVideo()) {
			//TODO user input video
			System.out.println("User input \'VIDEO\'");
			long chatId = update.getMessage().getChatId();
			
			Video video = update.getMessage().getVideo();
			String fileId = video.getFileId();
			int fileDuration = video.getDuration();
			int fileSize = video.getFileSize();
			int fileHeight = video.getHeight();
			int fileWidth = video.getWidth();
			
			String caption = "File ID: " + fileId + "\nFile duration: " + fileDuration + "\nFile size: " + fileSize + "\nFile height: " + fileHeight + "\nFile width: " + fileWidth; 
			SendVideo msg = new SendVideo()
							.setChatId(chatId)
							.setVideo(fileId)
							.setCaption(caption);
			
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasContact()) {
			//TODO user input contact
			System.out.println("User input \'CONTACT\'");
			long chatId = update.getMessage().getChatId();
			
			Contact contact  = update.getMessage().getContact();
			int userId = contact.getUserID();
			String card = contact.getVCard();
			String fName = contact.getFirstName();
			String lName = contact.getLastName();
			String phone = contact.getPhoneNumber();
			
			String caption = "User ID: " + userId + "\nCard: " + card + "\nFirst name: " + fName + "\nLast name: " + lName +"\nPhone: " +phone;
			System.out.println(caption);
			
			SendContact msg = new SendContact();
			msg.setChatId(chatId);
			msg.setPhoneNumber(phone);
			msg.setFirstName(fName);
			msg.setLastName(lName);
			
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasLocation()) {
			//TODO user input location
			System.out.println("User input \'LOCATION\'");
			long chatId = update.getMessage().getChatId();
			
			Location location = update.getMessage().getLocation();
			float longitude = location.getLongitude();
			float latitude = location.getLatitude();
			
			SendMessage msgT = new SendMessage();
			msgT.setChatId(chatId);
			msgT.setText("Longitude: " + longitude + "\nLatitude: " + latitude);
			
			SendLocation msgL = new SendLocation(latitude, longitude);
			msgL.setChatId(chatId);
				
			try {
				execute(msgL);
				execute(msgT);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasDocument()) {
			//TODO user input document
			System.out.println("User input \'DOCUMENT\'");
			long chatId = update.getMessage().getChatId();
			
			Document document = update.getMessage().getDocument();
			String fileId = document.getFileId();
			String fileName = document.getFileName();
			int fileSize = document.getFileSize();
			
			String caption = "File ID: "+ fileId + "\nFile Name: " + fileName + "\nFile Size: " + fileSize;
			SendDocument msg = new SendDocument();
			msg.setChatId(chatId);
			msg.setDocument(fileId);
			msg.setCaption(caption);
			
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		} else if (update.hasMessage() && update.getMessage().hasAnimation()) {
			//TODO user input animation
			System.out.println("User input \'ANIMATION\'");
		} else if (update.hasMessage() && update.getMessage().hasSticker()) {
			//TODO user input sticker
			System.out.println("User input \'STIKER\'");
		} else {
			//TODO user input others
			System.out.println("User input \'OTHERS\'");
			long chatId = update.getMessage().getChatId();
			
			SendMessage msg = new SendMessage();
			msg.setChatId(chatId);
			msg.setText("Others Type");
			
			try {
				execute(msg);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	public String getBotUsername() {
		return "*bot";
	}

	@Override
	public String getBotToken() {
		return "----------------------------------------------";
	}

}
