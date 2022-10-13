package uz.numeric;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import uz.numeric.crypt.Crypt;
import uz.numeric.crypt.Decoder;
import uz.numeric.crypt.Encoder;

public class Bot extends TelegramLongPollingBot {

    private boolean inArray(Long id, Long[] arr){
        for(Long x : arr){
            if(id == x) return true;
        }

        return false;
    }

    @Override
    public String getBotUsername() {
        return "numeric_alphabet_bot";
    }

    @Override
    public String getBotToken() {
        return "5127806445:AAF-xmKU_Pf-bbjEabEcTmqypj48-69zXVg";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long admins[] = {649244901L, 973253531L };
        String chatId = update.getMessage().getChatId().toString();
        Crypt encoder = new Encoder();
        Crypt decoder = new Decoder();
        if(update.hasMessage() && update.getMessage().hasText()){
            String text = update.getMessage().getText();
            String result = "";
            text = text.toLowerCase();
            if(text.startsWith("h")){
                text = text.substring(2).trim();
                result = encoder.doCrypt(text);
                SendMessage msg = new SendMessage(chatId, result);
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    System.err.println("error with sending message");
                }
            }
            if(text.startsWith("e")){
                text = text.substring(2).trim();
                result = decoder.doCrypt(text);
                SendMessage msg = new SendMessage(chatId, result);
                try {
                    execute(msg);
                } catch (TelegramApiException e) {
                    System.err.println("error");
                }
            }
        }
    }
}
