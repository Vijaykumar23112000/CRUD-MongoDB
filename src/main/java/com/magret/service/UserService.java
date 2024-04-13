package com.magret.service;


import com.magret.model.User;
import com.magret.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public User createUser(User user){
        return repo.save(user);
    }

    public User getUserByName(String name) {
        List<User> users = repo.findByName(name);
        return users.isEmpty() ? null : users.getFirst();
    }

    public Optional<User> getUserByUserId(Long userId){
        return repo.findByUserId(userId);
    }

    public void  deleteUser(Long userId){
        repo.deleteByUserId(userId);
    }

    public User updateUserOrCreateUser(Long userId , User request){
        User user = repo.findByUserId(userId).orElse(null);
        if(user==null){
            repo.save(request);
        }
        else{
            user.setUserId(request.getUserId());
            user.setName(request.getName());
            user.setAge(request.getAge());
            user.setLocation(request.getLocation());
            user.setProfile(request.getProfile());
            repo.save(user);
        }
       return null;
    }

}
