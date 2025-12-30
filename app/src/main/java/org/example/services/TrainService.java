package org.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.example.entities.Train;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TrainService {
    private Train train;
    private List<Train> trainList;
    private static final String TRAINS_PATH =  "D:/projects/IRCTC/app/src/main/java/org/example/entities/LocalDb";
    private ObjectMapper objectMapper = new ObjectMapper();

    public TrainService(Train train)throws IOException{
        this.train=train;
        loadTrains();
    }

    public TrainService()throws IOException{
        loadTrains();
    }

    private List<Train> loadTrains()throws IOException{
        File trains = new File(TRAINS_PATH);
        return objectMapper.readValue(trains, new TypeReference<List<Train>>(){});
    }


    public List<Train> searchTrains(String source, String destination){
        return trainList.stream().filter(train -> validTrain(train, source, destination)).collect(Collectors.toList());
    }

    private Boolean validTrain(Train train , String source , String destination){
        List<String> stationOrder = train.getStations();

        int sourceIndex = stationOrder.indexOf(source.toLowerCase());
        int destinationIndex = stationOrder.indexOf(destination.toLowerCase());

        return sourceIndex != -1 && destinationIndex != -1 && sourceIndex < destinationIndex;
    }

    public Boolean addTrain(Train train){
        try {
            trainList.add(train);
            saveTrainListToFile();
            return Boolean.TRUE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    private void saveTrainListToFile()throws IOException{
        File trainsFile = new File(TRAINS_PATH);
        objectMapper.writeValue(trainsFile, trainList);
    }
}
