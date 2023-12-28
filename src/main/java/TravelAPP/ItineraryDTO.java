package TravelAPP;

public class ItineraryDTO {
    private int itinerary_id;
    private String departure_place;
    private String destination;
    private String departure_time;
    private String arrival_time;
    private String check_in;
    private String check_out;

    public ItineraryDTO() {
    }

    public ItineraryDTO(int itinerary_id, String departure_place, String destination, String departure_time, String arrival_time, String check_in, String check_out) {
        this.itinerary_id = itinerary_id;
        this.departure_place = departure_place;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public ItineraryDTO(String departure_place, String destination, String departure_time, String arrival_time, String check_in, String check_out) {
        this.departure_place = departure_place;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.check_in = check_in;
        this.check_out = check_out;
    }

    public int getItinerary_id() {
        return itinerary_id;
    }

    public void setItinerary_id(int itinerary_id) {
        this.itinerary_id = itinerary_id;
    }

    public String getDeparture_place() {
        return departure_place;
    }

    public void setDeparture_place(String departure_place) {
        this.departure_place = departure_place;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(String departure_time) {
        this.departure_time = departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(String arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    @Override
    public String toString() {
        return "ItineraryDTO{" +
                "itinerary_id=" + itinerary_id +
                ", departure_place='" + departure_place + '\'' +
                ", destination='" + destination + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", arrival_time='" + arrival_time + '\'' +
                ", check_in='" + check_in + '\'' +
                ", check_out='" + check_out + '\'' +
                '}';
    }
}
