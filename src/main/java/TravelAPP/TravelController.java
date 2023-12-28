package TravelAPP;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TravelController {

    private ConsoleView consoleView;

    private String path = "trips/";
    private int id = 1;

    public TravelController() {
        consoleView = new ConsoleView();
    }

    public int getFileId() {

        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith("json")) {
                id++;
            }
        }
        return id;
    }

    public void startApplication() {
        String userInput = consoleView.printMainMenu();
        if (userInput.equals("1")) {
            // TODO 여행기록, 여행정보 입력을 받고 여정정보를 입력받는다.
            saveTripRecord();
        } else if (userInput.equals("2")) {
            // TODO 여행조회
            // read -> string -> object(DTO)
            searchTripList();
            // show list -> input id -> show trip
        } else if (userInput.equals("3")) {
            // TODO 여정기록
            inputItinerary();
            // show list -> input id ->
        } else if (userInput.equals("4")) {
            // TODO 종료
        } else {
            System.out.println("잘못된 입력 값 입니다.");
        }
    }

    public void saveTripRecord() {
        // object(DTO) -> string -> save
        TripDTO tripDTO = consoleView.getTripRecord();

        tripDTO.setTrip_id(getFileId());
        saveFile(tripDTO);
        selectItineraryMenu(tripDTO);
    }

    public void selectItineraryMenu(TripDTO tripDTO) {
        // y/n
        String userInput = consoleView.printSelectItineraryMenu();
        switch (userInput) {
            case "y":
            case "Y":
                saveItineraryRecord(tripDTO);
                break;
            case "n":
            case "N":
                startApplication();
                break;
            default:
                System.out.println("잘못된 입력 값 입니다.");
                selectItineraryMenu(tripDTO);
                break;
        }
    }

    public void saveItineraryRecord(TripDTO tripDTO) {
        ItineraryDTO itineraryDTO = consoleView.getItineraryRecord();
//        List<ItineraryDTO> itineraryDTOList = new ArrayList<>();
        //List<ItineraryDTO> itineraryDTOList = tripDTO.getItineraryDTOList();
        List<ItineraryDTO> itineraryDTOList = new ArrayList<ItineraryDTO>(tripDTO.getItineraryDTOList());
        itineraryDTOList.add(itineraryDTO);

        for (int i = 0; i < itineraryDTOList.size(); i++) {
            itineraryDTOList.get(i).setItinerary_id(i + 1);
        }

        tripDTO.setItineraryDTOList(itineraryDTOList);
        saveFile(tripDTO);
        selectItineraryMenu(tripDTO);
    }

    public void searchTripList() {
        String userInput = consoleView.printTripList(readAllTrip());
        searchOnlyTrip(userInput);
    }

    public void inputItinerary() {
        String userInput = consoleView.printTripList(readAllTrip());

        File[] files = new File(path).listFiles();
        String endWith = "_" + userInput + ".json";
        String filename = "";
        boolean isExist = false;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(endWith)) {
                isExist = true;
                filename = file.getName();
                if (isExist) {
                    break;
                }
            }
        }

        if (isExist) {
            // tripDto ->
            Gson gson = new Gson();
            TripDTO tripDTO = new TripDTO();
            try {
                File file = new File(path, filename);
                FileReader fileReader = new FileReader(file);
                tripDTO = gson.fromJson(fileReader, TripDTO.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            saveItineraryRecord(tripDTO);

        } else {
            System.out.println("wrong id");
            startApplication();
        }
    }

    public void searchOnlyTrip(String id) {
        File[] files = new File(path).listFiles();
        String endWith = "_" + id + ".json";
        String filename = "";
        boolean isExist = false;
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(endWith)) {
                isExist = true;
                filename = file.getName();
                if (isExist) {
                    break;
                }
            }
        }

        if (isExist) {
            // tripDto ->
            Gson gson = new Gson();
            TripDTO tripDTO = new TripDTO();
            try {
                File file = new File(path, filename);
                FileReader fileReader = new FileReader(file);
                tripDTO = gson.fromJson(fileReader, TripDTO.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            consoleView.printTripInfo(tripDTO);
            startApplication();
        } else {
            // wrong value
            System.out.println("wrong id");
            startApplication();
        }
    }

    public void saveFile(TripDTO tripDTO) {
        String filename = "trip_" + tripDTO.getTrip_id() + ".json";
        // filename = "trip_1.json"
        File file = new File(path, filename);
        try {
            FileWriter fileWriter = new FileWriter(file);
            Gson gson = new Gson();
            String saveData = gson.toJson(tripDTO);
            fileWriter.write(saveData);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TripDTO> readAllTrip() {

        Gson gson = new Gson();
        List<TripDTO> tripDTOList = new ArrayList<>();

        File[] files = new File(path).listFiles();  // files.length = 2

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith("json")) {
                String filename = file.getName();
                File f = new File(path, filename);
                try {
                    FileReader fileReader = new FileReader(f);
                    TripDTO tripDTO = gson.fromJson(fileReader, TripDTO.class);
                    tripDTOList.add(tripDTO);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return tripDTOList;
    }

}
