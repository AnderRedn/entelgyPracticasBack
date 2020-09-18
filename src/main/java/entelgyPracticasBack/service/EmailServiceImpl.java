package entelgyPracticasBack.service;

import java.io.File;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender mailSender;

	private static final Logger logger = LogManager.getLogger(EmailServiceImpl.class);

	private final String TO = "";
	private final String FROM = "";
	private final String SUBJECT = "Bilbao Weather";
	private final String BODY = "Here's the summary of the weather in Bilbao.";

	/**
	 * Method to configure email and send it. Necessary to change
	 * application.properties with username and password. + Enabling less secure apps to access Gmail
	 * 
	 * @param fileToAttach Route of the .xlsx generatedpreviusly, by default generated at the same level as pom.xml.
	 */
	public void sendMailWithAttachment(String fileToAttach) {

		{
			MimeMessagePreparator preparator = new MimeMessagePreparator() {
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
					FileSystemResource file = new FileSystemResource(new File(fileToAttach));

					helper.setTo(new InternetAddress(TO));
					helper.setFrom(new InternetAddress(FROM));
					helper.setSubject(SUBJECT);
					helper.setText(BODY);
					helper.addAttachment("weather_bilbao.xlsx", file);

				}
			};

			try {
				mailSender.send(preparator);
			} catch (MailException ex) {
				logger.info("MessagingException when sending the mail.");
			}
		}
	}
}
