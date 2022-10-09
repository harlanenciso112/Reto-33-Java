package Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessages;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "cabinId")
    @JsonIgnoreProperties({"messages"})
    private Cabin cabin;

    @ManyToOne
    @JoinColumn(name = "clientId")
    @JsonIgnoreProperties({"messages"})
    private Client client;


    public Integer getIdMessages() {
        return idMessages;
    }

    public void setIdMessages(Integer idMessages) {
        this.idMessages = idMessages;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
