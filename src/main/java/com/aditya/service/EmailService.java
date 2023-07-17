package com.aditya.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.aditya.model.Mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Async
	public void sendEmail(String toEmail, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(toEmail);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailMessage.setFrom("patroaditya9@gmail.com");
		javaMailSender.send(mailMessage);
	}

	public void sendPlainTextEmail(Mail mail) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(mail.getFrom());
		message.setTo(mail.getTo());
		message.setSubject(mail.getSubject());
		message.setText(mail.getBody());

		javaMailSender.send(message);

	}

	public void sendHTMLEmail(Mail mail) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());

		boolean html = true;
		helper.setText("<b>Hi,</b><br><br><i>" + mail.getSubject() + ".</i>"+"<br><br><b>Best Regards</b><br>Java Mail", html);

		javaMailSender.send(message);

	}

	public void sendHTMLEmailWithAttachment(Mail mail) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());

		helper.setText("<b>Hi,</b><br><br>" + mail.getBody() + "<br><br><b>Best Regards</b><br>Java Mail", true);

		FileSystemResource file = new FileSystemResource(new File("D:\\resources\\"+mail.getAttachment()+".pdf"));
		helper.addAttachment(mail.getAttachment()+".pdf", file);

		javaMailSender.send(message);

	}

	public void sendHTMLEmailWithInlineImage(Mail mail) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setSubject(mail.getSubject());
		helper.setFrom(mail.getFrom());
		helper.setTo(mail.getTo());

		String content = "<b>Hi,</b><br><br>" + mail.getBody() + "<br>"
				+ "<br><img src='cid:image'/><br><br><b>Best Regards</b><br>Java Mail";
		helper.setText(content, true);

		FileSystemResource resource = new FileSystemResource(new File("D:\\resources\\" + mail.getImage() + ".jpg"));
		helper.addInline("image", resource);

		javaMailSender.send(message);

	}
}
