package email;

import java.util.Objects;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import portsout.Enviar;

public class EnEmail implements Enviar {
	private String emisor;
	private String receptor;
	private String usuario;
	private String contra;
	private String host;

	public EnEmail(String emisor, String receptor, String usuario, String contra, String host) {

		this.emisor = Objects.requireNonNull(emisor);
		this.receptor = Objects.requireNonNull(receptor);
		this.usuario = Objects.requireNonNull(usuario);
		this.contra = Objects.requireNonNull(contra);
		this.host = Objects.requireNonNull(host);
	}

	@Override
	public void notificarEmpleado(String titulo, String msj) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		// create the Session object
		Authenticator authenticator = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usuario, contra);
			}
		};
		Session session = Session.getInstance(props, authenticator);

		try {
			// create a MimeMessage object
			Message message = new MimeMessage(session);
			// set From email field
			message.setFrom(new InternetAddress(emisor));
			// set To email field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receptor));
			// set email subject field
			message.setSubject(titulo);
			// set the content of the email message
			message.setText(msj);
			// send the email message
			Transport.send(message);
			System.out.println("Mensaje Enviado!");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public Boolean isEnviado() {
		// TODO Auto-generated method stub
		return null;
	}

}