import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;

@ManagedBean
@RequestScoped
public class ProducerBean {
    @Resource(mappedName = "java:/myJmsTest/MyQueue")
    Queue queue;
    @Inject
    JMSContext jmsContext;

    private String mail;
    private String message;

    public void sendMessage() {
        String text = mail + ":" + message;
        System.out.println(text);
        jmsContext.createProducer().send(queue,text);

    }

    // GETTERS && SETTERS


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
