package springBootMVCShopping.service;

import org.springframework.stereotype.Service;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;

@Service
public class SMSMassageService {
	
	
	final DefaultMessageService messageService;
	public SMSMassageService() {
		this.messageService = NurigoApp.INSTANCE.initialize(
				"NCSS1WJQZAXJTOU3",
				"WN5E66CV7FMOEVUA52T0H0UQUZU0VQOY",
				"https://api.coolsms.co.kr");
	} 
	public void smsSend(String _to, String _from, String _content) {
		Message message = new Message();
		message.setFrom(_from);
		message.setTo(_to);
		message.setText(_content);
		SingleMessageSentResponse response = this.messageService.sendOne(
				new SingleMessageSendingRequest(message));
		System.out.println(response);
	}
}
