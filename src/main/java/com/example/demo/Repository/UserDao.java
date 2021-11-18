package com.example.demo.Repository;

import com.example.demo.Model.UserModel;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {


    private static List<UserModel> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new UserModel(1, "aa", new Date()));
        users.add(new UserModel(2, "bb", new Date()));
        users.add(new UserModel(3, "cc", new Date()));
    }

    public List<UserModel> findAll() {
        return users;
    }

    public UserModel findOne(int id) {
        for (var user : users) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public UserModel saveOne(UserModel user) {

        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

}
