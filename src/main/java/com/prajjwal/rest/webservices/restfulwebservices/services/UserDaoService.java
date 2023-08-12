package com.prajjwal.rest.webservices.restfulwebservices.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.prajjwal.rest.webservices.restfulwebservices.models.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDaoService {
//    @Autowired : does not work on static fields
    static List<User> regeisteredUsers = new ArrayList<>();
    static int count;
    static {
        regeisteredUsers.add(new User(++count,"Prajjwal", LocalDate.now().minusYears(23)));
        regeisteredUsers.add(new User(++count,"Hamlet", LocalDate.now().minusYears(130)));
        regeisteredUsers.add(new User(++count,"Othello", LocalDate.now().minusYears(110)));
    }

    public List<User> getAllUser(){
        return regeisteredUsers;
    }

    public User getThisUser(int id) throws Throwable {
        return regeisteredUsers.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addThisUser(User user){
        regeisteredUsers.add(user);
    }
}
