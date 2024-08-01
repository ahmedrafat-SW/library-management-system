package com.dev.librarymanagementsystem.service;

import com.dev.librarymanagementsystem.dao.UserDao;
import com.dev.librarymanagementsystem.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByName(username);
    }

    public List<User> getAll(){
        return userDao.getAll();
    }

    public User saveUser(User user){
        return userDao.save(user);
    }

    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    public User updateUser(Long id, User user) throws Exception{
        User savedUser = userDao.getById(id);
        if (savedUser != null){
            return userDao.save(user);
        } else{
            throw new UsernameNotFoundException("user not exist");
        }
    }
}
