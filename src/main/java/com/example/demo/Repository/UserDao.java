package com.example.demo.Repository;

import com.example.demo.Entity.UserEntity;
import com.example.demo.exception.ApiRequestException;

import org.springframework.stereotype.Repository;
import org.springframework.hateoas.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Repository
public class UserDao {

    private static List<UserEntity> users = new ArrayList<>();
    private static int userCount = 3;

    static {
        users.add(new UserEntity(1, "aa", new Date()));
        users.add(new UserEntity(2, "bb", new Date()));
        users.add(new UserEntity(3, "cc", new Date()));
    }

    public List<UserEntity> findAll() {
        return users;
    }

    public UserEntity findById(int id) {

        for (var user : users) {
            if (user.getId() == id){

                return user;
            }
        }
        
        throw new ApiRequestException("User Not Found");
    }

    public UserEntity saveOne(UserEntity user) {

        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public UserEntity deleteById(int id) {
        // Make the List Iterable, Iterator.hasnext is like foreach
        Iterator<UserEntity> iterator = users.iterator();
        while (iterator.hasNext()) {
            UserEntity user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        throw new ApiRequestException("ID not found");
    }

}
