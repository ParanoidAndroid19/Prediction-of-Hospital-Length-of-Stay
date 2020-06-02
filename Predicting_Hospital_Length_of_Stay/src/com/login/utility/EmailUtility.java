package com.login.utility;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {
	public static boolean sendEmail(String emailId,String ipAddress,String macAddress)
	{
		final String userName="nagargandhi00@gmail.com";
		final String password="navimumbai";
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
		
		try
		{
			Message message=new MimeMessage(session);
			message.setFrom(new InternetAddress("nagargandhi00@gmail.com"));
		    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId));
		    message.setSubject("This Ip Address trying to download your attachment..........");
		    message.setText("IpAddress"+ipAddress+""+" MacAddress "+macAddress);
			Transport.send(message);
            System.out.println("Done");
		}
		catch(MessagingException e)
		{
			throw new RuntimeException(e);
	}
		
		return true;
	
	}
	
	public static boolean sendEmail(String emailId,String password1)
	{
		final String userName="nagargandhi00@gmail.com";
		final String password="navimumbai";
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(properties,
				new javax.mail.Authenticator(){
			        protected PasswordAuthentication getPasswordAuthentication(){
			        	 return new PasswordAuthentication(userName, password);
			        }
		});
	
		try 
		{
			System.out.println("emailId -"+emailId); 
			System.out.println("password1 -"+password1);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("garjear@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(emailId));
			message.setSubject("Get Your Password");
			message.setText("Your user Id='"+emailId+"' Your Passward is='"+password1+"' http://localhost:8080/LoginVerify/Login.jsp");
 
			Transport.send(message);
			
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	public static void main(String args[])
	{
		
	}

}


	
	
	


