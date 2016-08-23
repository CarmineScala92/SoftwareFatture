/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageemail;

/**
 *
 * @author Carmine
 */


// File Name SendFileEmail.java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendEmail {
	public String invioEmail(String mittente,String destinatario,String corpoMessaggio, String subject, String smtp,final String username,final String password, String path1,String path2,String path3,String path4,String path5){
		Properties props = new Properties();
		
                if(smtp.equals("gmail")){
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.socketFactory.port", "465");
                    props.put("mail.smtp.socketFactory.class",
                                    "javax.net.ssl.SSLSocketFactory");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.port", "465");

                }
                else if (smtp.equals("libero")){
                      props.put("mail.smtp.host", "smtp.libero.it");
                      props.put("mail.smtp.socketFactory.port", "465");
                      props.put("mail.smtp.socketFactory.class",
                                      "javax.net.ssl.SSLSocketFactory");
                      props.put("mail.smtp.auth", "true");
                      props.put("mail.smtp.port", "465");
                }
                else{
                    return "Il sistema gestisce solo e-mail di gmail e libero";
                }
                System.err.println(username+"     "+ password);
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username,password);
				}
			});

		try {
               
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mittente));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(destinatario));
			message.setSubject(subject);
			message.setText(corpoMessaggio);

			BodyPart messageBodyPart0 = new MimeBodyPart();

                        messageBodyPart0.setText(corpoMessaggio);
                        Multipart multipart0 = new MimeMultipart();
                        multipart0.addBodyPart(messageBodyPart0);
                        
                        
                         
                        if(!path1.equals("")){
                            addAttachment( multipart0, path1,new MimeBodyPart());
                           
                        }
                        
                        
                          if(!path2.equals("")){
                             addAttachment( multipart0, path2,new MimeBodyPart());
                        }
                        
                        
                        if(!path3.equals("")){
                            addAttachment( multipart0, path3,new MimeBodyPart()); 
                        }
                        
                        if(!path4.equals("")){
                            addAttachment( multipart0, path4,new MimeBodyPart());
                        }
                        
                        if(!path5.equals("")){
                            addAttachment( multipart0, path5,new MimeBodyPart());
                        }
                        message.setContent(multipart0);
                        Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
                   
                        return ""+e;
			//throw new RuntimeException(e);
		}
                return "L'email è stata inviata correttamente";
        }
        
        private static void addAttachment(Multipart multipart, String filename,MimeBodyPart messageBodyPart) throws MessagingException
    {
        DataSource source = new FileDataSource(filename);       
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(filename);
        multipart.addBodyPart(messageBodyPart);
    }
        
        	public static void addToZipFile(String fileName, ZipOutputStream zos) throws FileNotFoundException, IOException {

		System.out.println("Writing '" + fileName + "' to zip file");

		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ZipEntry zipEntry = new ZipEntry(fileName);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}
                
                
                /*
                FileOutputStream fos = new FileOutputStream("atest.zip");
			ZipOutputStream zos = new ZipOutputStream(fos);

			String file1Name = "file1.txt";
			String file2Name = "file2.txt";
			String file3Name = "folder/file3.txt";
			String file4Name = "folder/file4.txt";
			String file5Name = "f1/f2/f3/file5.txt";

			addToZipFile(file1Name, zos);
			addToZipFile(file2Name, zos);
			addToZipFile(file3Name, zos);
			addToZipFile(file4Name, zos);
			addToZipFile(file5Name, zos);

			zos.close();
			fos.close();
                */
        
}