package main;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    UserMockDB userMockDB = UserMockDB.getInstance();

    @GetMapping("/users")
    public List<User> index(){
        return userMockDB.fetchUsers();
    }

    @GetMapping("/user/{id}")
    public User show(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userMockDB.getUserById(userId);
    }

    @PostMapping("/user/search")
    public List<User> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return userMockDB.searchUsers(searchTerm);
    }

    @PostMapping("/user")
    public User create(@RequestBody Map<String, String> body){
        int id = Integer.parseInt(body.get("id"));
        String userName = body.get("userName");
        String age = body.get("age");
        String gender = body.get("gender");
        return userMockDB.createUser(id, userName, age, gender);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable String id, @RequestBody Map<String, String> body){
        int userId = Integer.parseInt(body.get("id"));
        String userName = body.get("userName");
        String age = body.get("age");
        String gender = body.get("gender");
        return userMockDB.updateUser(userId, userName, age, gender);
    }

    @DeleteMapping("user/{id}")
    public boolean delete(@PathVariable String id){
        int userId = Integer.parseInt(id);
        return userMockDB.delete(userId);
    }

}
