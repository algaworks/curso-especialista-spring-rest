package com.algaworks.algafood.infrastructure.service.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.algaworks.algafood.core.email.EmailProperties;

public class SandboxEnvioEmailService extends SmtpEnvioEmailService {

	@Autowired
	private EmailProperties emailProperties;
	
	// Separei a criação de MimeMessage em um método na classe pai (criarMimeMessage),
	// para possibilitar a sobrescrita desse método aqui
	@Override
	protected MimeMessage criarMimeMessage(Mensagem mensagem) throws MessagingException {
		MimeMessage mimeMessage = super.criarMimeMessage(mensagem);
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
		helper.setTo(emailProperties.getSandbox().getDestinatario());
		
		return mimeMessage;
	}

}
