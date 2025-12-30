package org.example.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.example.entities.Ticket;
import org.example.entities.Train;
import org.example.entities.User;
import org.example.util.UserServiceUtil;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserBookingService {
    private User user;
    private List<User> userList;
    private static final String USERS_PATH = "D:/projects/IRCTC/app/src/main/java/org/example/entities/LocalDb";
    private ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService(User user) throws IOException
    {
        this.user = user;
        loadUsers();
    }

    public UserBookingService()throws IOException{
        loadUsers();
    }

    private List<User> loadUsers() throws IOException{
        File users = new File(USERS_PATH); 
        return objectMapper.readValue(users, new TypeReference<List<User>>(){});
    }

    public Boolean loginUser(){
        Optional<User> foundUser = userList.stream().filter(user1 -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1.getHashpassword());
        }).findFirst();

        return foundUser.isPresent();
    }

    public Boolean signUp(User user){

        try {
            userList.add(user);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch (IOException e) {
            return Boolean.FALSE;
        }

    }

    private void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBooking(){
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId){
        try {
            Boolean success =  user.getTicketsBooked().removeIf(Ticket -> Ticket.getTicketId()==ticketId);
            saveUserListToFile();
            return success;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public List<Train> getTrains(String source , String destination){
        TrainService trainService = new TrainService();
        return trainService.searchTrains(source,destination);
    }
    
}
