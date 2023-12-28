package TravelAPP;

import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    //스캐너 생성
    Scanner scanner = new Scanner(System.in);
    //기본생성자 생성

    public ConsoleView() {
    }

    public String printMainMenu() {
        System.out.println("================ 메뉴 리스트 ================");
        System.out.println("1. 여행기록\t2. 여행조회\t3. 여정기록\t4. 종료");
        System.out.println("===========================================");
        System.out.print("시작할 메뉴번호를 입력하세요 : ");
        return scanner.nextLine();
    }

    //여행정보를 입력받을 메서드 생성하기
    public TripDTO getTripRecord(){
        System.out.println("여행 이름을 입력하세요 : ");
        String tripName = scanner.nextLine();
        System.out.println("시작 날짜를 입력하세요 : ");
        String startDate = scanner.nextLine();
        System.out.println("종료 날짜를 입력하세요 : ");
        String endDate = scanner.nextLine();
        // Book book = new Book("Java", 3000, 500);
        TripDTO tripDTO = new TripDTO(tripName,startDate, endDate, List.of());
        return tripDTO;
    }

    public String printSelectItineraryMenu() {
        System.out.println("select itinerary menu (y/n) : ");
        return scanner.nextLine();
    }

    public ItineraryDTO getItineraryRecord(){
        System.out.print("출발지를 입력하세요 : ");
        String departure_place = scanner.nextLine();
        System.out.print("도착지를 입력하세요 : ");
        String destination = scanner.nextLine();
        System.out.print("출발시간를 입력하세요 : ");
        String departure_time = scanner.nextLine();
        System.out.print("도착시간를 입력하세요 : ");
        String arrival_time = scanner.nextLine();
        System.out.print("체크인를 입력하세요 : ");
        String check_in = scanner.nextLine();
        System.out.print("체크아웃를 입력하세요 : ");
        String check_out = scanner.nextLine();
        ItineraryDTO itineraryDTO = new ItineraryDTO(
                departure_place,
                destination,
                departure_time,
                arrival_time,
                check_in,
                check_out
        );
        return itineraryDTO;
    }

    public String printTripList(List<TripDTO> tripDTOList) {

        for (TripDTO tripDTO : tripDTOList) {
            System.out.println("id: " + tripDTO.getTrip_id() + ", name: " + tripDTO.getTrip_name());
        }
        System.out.print("choose id : ");

        return scanner.nextLine();
    }

    public void printTripInfo(TripDTO tripDTO) {
        System.out.println("id: " + tripDTO.getTrip_id());
        System.out.println("name: " + tripDTO.getTrip_name());
        System.out.println("startDate: " + tripDTO.getStart_date());
        System.out.println("endDate: " + tripDTO.getEnd_date());
        for (ItineraryDTO itineraryDTO : tripDTO.getItineraryDTOList()) {
            System.out.println("itinerary id: " + itineraryDTO.getItinerary_id());
        }
    }

}
