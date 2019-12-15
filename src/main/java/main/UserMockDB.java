package main;

import java.util.ArrayList;
import java.util.List;

public class UserMockDB {
    //list of users
    private List<User> users;

    private static UserMockDB instance = null;
    public static UserMockDB getInstance(){
        if(instance == null){
            instance = new UserMockDB();
        }
        return instance;
    }

    public UserMockDB() {
        users = new ArrayList<User>();
    }

    // return all users
    public List<User> fetchUsers() {
        return users;
    }

    // return user by id
    public User getUserById(int id) {
        for(User u: users) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    // search user by text
    public List<User> searchUsers(String searchTerm) {
        List<User> searchedUsers = new ArrayList<User>();
        for(User u: users) {
            if(u.getUserName().toLowerCase().contains(searchTerm.toLowerCase())) {
                searchedUsers.add(u);
            }
        }

        return searchedUsers;
    }

    // create user
    public User createUser(int id, String userName, String age, String gender) {
        User newUser = new User(id, userName, age, gender);
        users.add(newUser);
        return newUser;
    }

    // update user detail
    public User updateUser(int id, String userName, String age, String gender) {
        for(User u: users) {
            if(u.getId() == id) {
                int userIndex = users.indexOf(u);
                u.setUserName(userName);
                u.setAge(age);
                u.setGender(gender);
                users.set(userIndex, u);
                return u;
            }

        }

        return null;
    }

    // delete user by id
    public boolean delete(int id){
        int userIndex = -1;
        for(User u: users) {
            if(u.getId() == id) {
                userIndex = users.indexOf(u);
                continue;
            }
        }
        if(userIndex > -1){
            users.remove(userIndex);
        }
        return true;
    }
}
