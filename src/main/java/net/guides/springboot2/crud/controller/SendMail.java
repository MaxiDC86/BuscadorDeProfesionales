package net.guides.springboot2.crud.controller;



import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import net.guides.springboot2.crud.model.Formulario;

public class SendMail {

	/**
	   Outgoing Mail (SMTP) Server
	   requires TLS or SSL: smtp.yandex.com (use authentication)
	   Use Authentication: Yes
	   Port for SSL: 587
	 */
	public static void send(Formulario contactoFormulario) {
		final String fromEmail = "salud-cerca@outlook.com"; //requires valid gmail id
		final String password = "salud-4278"; // correct password for gmail id
		final String toEmail = "salud-cerca@outlook.com"; // can be any email id 
		
		System.out.println("SSLEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com"); //SMTP Host
		props.put("mail.smtp.socketFactory.port", "587"); //SSL Port
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
		props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
		props.put("mail.smtp.port", "587"); //SMTP Port
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		
		Session session = Session.getDefaultInstance(props, auth);
		System.out.println("Session created");
	        EmailUtil.sendEmail(session, toEmail,"SSLEmail Testing Subject", contactoFormulario.getMessage());


	}

}

