package org.example.entities;

import java.util.List;
import java.util.Map;

public class Train {
    private String trainId;
    private String trainNo;
    private List<List<Integer>> availableSeats;
    private Map<String,String> stationTime;
    private List<String> stations;

    //Constructors
    public Train(String trainId, String trainNo, List<List<Integer>> availableSeats, Map<String, String> stationTime,
            List<String> stations) {
        this.trainId = trainId;
        this.trainNo = trainNo;
        this.availableSeats = availableSeats;
        this.stationTime = stationTime;
        this.stations = stations;
    }

    public Train(){}

    //Getters and setters

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public void setTrainNo(String trainNo) {
        this.trainNo = trainNo;
    }

    public List<List<Integer>> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<List<Integer>> availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Map<String, String> getStationTime() {
        return stationTime;
    }

    public void setStationTime(Map<String, String> stationTime) {
        this.stationTime = stationTime;
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }

    

    
}
