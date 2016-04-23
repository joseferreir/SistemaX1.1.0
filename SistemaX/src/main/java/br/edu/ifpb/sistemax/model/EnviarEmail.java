/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.sistemax.model;


import br.edu.ifpb.sistemax.entidades.Evento;
import br.edu.ifpb.sistemax.entidades.Usuario;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author José
 */
public class EnviarEmail {

    public EnviarEmail() {
    }
    

    /**
     * @param args the command line arguments
     */
    public  void enviarEmail(Usuario responsavelPorEvento, Evento evento,String responsavelPorExcuuir) {
          StringBuilder assunto = new StringBuilder("Caro Sr(a). ");
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            
          assunto.append(responsavelPorEvento.getNome());
          assunto.append("\n");
          
          assunto.append(evento.getSala().getNome());
          assunto.append(" local onde aconteceria ");
          assunto.append(evento.getNome());
          assunto.append(" no dia ");
          assunto.append(sdf.format(evento.getDataInicio()));
          assunto.append("; Foi excruida");
          assunto.append("\n");
          assunto.append(" pelo usuário(a) ");
         assunto.append(responsavelPorExcuuir);
          assunto.append("\n");
          assunto.append(" por favor acesse: www.sistemaX.com.br ");
          assunto.append("\n");
          assunto.append("para reserva outa sala.");
          assunto.append(" pedimas desculpas pelo trastorno ");
          assunto.append("mensagem eletronica pedimos que nao responda");
          
        // TODO code application logic here
          Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("patterngameslocadora@gmail.com", "locadora321");
                    }
                });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("patterngameslocadora@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(responsavelPorEvento.getEmail());

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(evento.getNome()+"  Informaçáo importante");//Assunto
            message.setText(assunto.toString());
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

            System.out.println("Feito!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
}
