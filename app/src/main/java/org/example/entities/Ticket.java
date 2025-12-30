package org.example.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticket {
    @JsonProperty("ticket_id")
    private String ticketId;
    private String source;
    private String destination;
    @JsonProperty("user_id")
    private String userId;
    private Train train;
    @JsonProperty("date_of_travel")
    private Date dateOfTravel;
    
    public Ticket(String ticketId, String source, String destination, String userId, Train train, Date dateOfTravel) {
        this.ticketId = ticketId;
        this.source = source;
        this.destination = destination;
        this.userId = userId;
        this.train = train;
        this.dateOfTravel = dateOfTravel;
    }

    public Ticket(){}

   public String getTicketInfo(){
        return String.format("Ticket ID: %s belongs to the user %s from %s to %s on %s",ticketId,userId,source,destination,dateOfTravel);
    }
    
    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Date getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(Date dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    
    
}
