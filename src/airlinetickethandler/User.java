package airlinetickethandler;

/**
 *
 * @author Stelios Papakosmas, AM: 171085
 */
public class User {
    
    private String ticketId;
    private String issueDate;
    private String clientName;
    private String itinerary;
    private String cost;
    private String luggage;
    private String gate;
    private String seat;
    private String foodType;

    public User(String ticketId, String issueDate, String clientName, String itinerary, String cost, String luggage, String gate, String seat, String foodType) {
        this.ticketId = ticketId;
        this.issueDate = issueDate;
        this.clientName = clientName;
        this.itinerary = itinerary;
        this.cost = cost;
        this.luggage = luggage;
        this.gate = gate;
        this.seat = seat;
        this.foodType = foodType;
    }

    public User() {
    }
    
    

    public String getTicketId() {
        return ticketId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getClientName() {
        return clientName;
    }

    public String getItinerary() {
        return itinerary;
    }

    public String getCost() {
        return cost;
    }

    public String getLuggage() {
        return luggage;
    }

    public String getGate() {
        return gate;
    }

    public String getSeat() {
        return seat;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setLuggage(String luggage) {
        this.luggage = luggage;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString() {
        return ticketId + "\t" + issueDate + "\t" + clientName + "\t" + itinerary + "\t" + cost + "\t" + luggage + "\t" + gate + "\t" + seat + "\t" + foodType;
    }

    
}
