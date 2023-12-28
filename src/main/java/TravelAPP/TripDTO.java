package TravelAPP;

import java.util.List;

public class TripDTO {
    private int trip_id;
    private String trip_name;
    private String start_date;
    private String end_date;
    private List<ItineraryDTO> itineraryDTOList;

    public TripDTO() {
    }

    public TripDTO(String trip_name, String start_date, String end_date, List<ItineraryDTO> itineraryDTOList) {
        this.trip_name = trip_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.itineraryDTOList = itineraryDTOList;
    }

    public TripDTO(int trip_id, String trip_name, String start_date, String end_date, List<ItineraryDTO> itineraryDTOList) {
        this.trip_id = trip_id;
        this.trip_name = trip_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.itineraryDTOList = itineraryDTOList;
    }

    public int getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(int trip_id) {
        this.trip_id = trip_id;
    }

    public String getTrip_name() {
        return trip_name;
    }

    public void setTrip_name(String trip_name) {
        this.trip_name = trip_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public List<ItineraryDTO> getItineraryDTOList() {
        return itineraryDTOList;
    }

    public void setItineraryDTOList(List<ItineraryDTO> itineraryDTOList) {
        this.itineraryDTOList = itineraryDTOList;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "trip_id=" + trip_id +
                ", trip_name='" + trip_name + '\'' +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", itineraryDTOList=" + itineraryDTOList +
                '}';
    }
}
