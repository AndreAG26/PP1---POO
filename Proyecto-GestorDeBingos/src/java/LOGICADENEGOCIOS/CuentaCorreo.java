package LOGICADENEGOCIOS;

import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.MessagingException;

import javax.mail.Multipart;

import java.io.File;

/**
 * 
 * @author 
 * @version 1.0
 */

public class CuentaCorreo{
  private String usuario;
  private String clave = "meoc uuhg yvdu bflt";
  private String servidor = "smtp.gmail.com";
  private String puerto = "587";
  private Properties propiedades;
  
   /**
   * Constructor que inicializa la cuenta de correo con las propiedades básicas para la conexión SMTP.
   * 
   * @param pCorreo El correo electrónico del usuario que será utilizado para enviar mensajes.
   */
  public CuentaCorreo(String pCorreo){
    propiedades = new Properties();
    propiedades.put("mail.smtp.host",servidor);
    propiedades.put("mail.smtp.port",puerto);
    propiedades.put("mail.smtp.auth","true");
    propiedades.put("mail.smtp.starttls.enable","true");
    usuario = pCorreo;
  }
  
    /**
   * Crea y retorna una sesión SMTP utilizando las propiedades y credenciales configuradas.
   * 
   * @return Session Una sesión SMTP autenticada.
   */
  private Session abrirSesion(){
    Session sesion = Session.getInstance(propiedades,
      new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
          return new PasswordAuthentication(usuario,clave);
        }
    });
    return sesion;
  }
  
   /**
   * Envia un correo electrónico con archivos adjuntos.
   * 
   * @param destinatario El correo electrónico del destinatario.
   * @param archivosAdjuntos Un array de Strings que contiene las rutas de los archivos a adjuntar.
   * @throws java.io.IOException Si ocurre un error al adjuntar los archivos.
   */
  public void enviarCorreo(String destinatario, String[] archivosAdjuntos) throws java.io.IOException {
    Session sesion = abrirSesion();

    try {
        Message message = new MimeMessage(sesion);
        message.setFrom(new InternetAddress(usuario));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Cartones del bingo");

        // Cuerpo del mensaje
        MimeBodyPart mensajeBodyPart = new MimeBodyPart();
        mensajeBodyPart.setText("");

        // Crear una lista de partes del mensaje para los archivos adjuntos
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mensajeBodyPart);

        // Adjuntar archivos al mensaje
        for (String archivoAdjunto : archivosAdjuntos) {
            MimeBodyPart adjuntoBodyPart = new MimeBodyPart();
            adjuntoBodyPart.attachFile(new File(archivoAdjunto));
            multipart.addBodyPart(adjuntoBodyPart);
        }

        // Asignar las partes al mensaje
        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
    } catch (MessagingException e) {
        e.printStackTrace();
    }
    }
  }