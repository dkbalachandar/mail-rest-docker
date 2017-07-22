package com.resource;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Properties;

@Path("/sendMail")
public class MailResource {

    Properties properties = System.getProperties();

    public MailResource() {
        properties.put("mail.smtp.host", System.getenv("SMTP_HOST"));
        properties.put("mail.smtp.port", "25");
    }

    @GET
    @Produces(MediaType.TEXT_HTML) public Response sendSimpleHelloMail() throws WebApplicationException {

        String to = "test123@gmail.com";
        String from = "test123@gmail.com";
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Subject");
            message.setContent("<h1>Hello</h1>", "text/html");
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new WebApplicationException(ex.getMessage());
        }
        return Response.ok().entity("Mail has been sent successfully").build();
    }
}
