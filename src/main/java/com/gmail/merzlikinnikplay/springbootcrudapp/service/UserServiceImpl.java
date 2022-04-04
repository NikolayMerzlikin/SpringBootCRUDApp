package com.gmail.merzlikinnikplay.springbootcrudapp.service;

import com.gmail.merzlikinnikplay.springbootcrudapp.model.User;
import com.gmail.merzlikinnikplay.springbootcrudapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repoSpringData;

    @Autowired
    public void setRepoSpringData(UserRepository repoSpringData) {
        this.repoSpringData = repoSpringData;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        repoSpringData.save(user);
    }

    @Override
    @Transactional
    public void addUser(String name, String surname, Integer age) {
        repoSpringData.save(new User(name, surname, age));
    }

    @Override
    @Transactional
    public void editUser(User user) {
        repoSpringData.findById(user.getId()).orElseThrow(()-> {
            throw new RuntimeException("This user is not exist");
        });
        repoSpringData.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        repoSpringData.deleteById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return new ArrayList<>(repoSpringData.findAll());

    }

    @Override
    public User getUser(long id) {
        return repoSpringData.findById(id).orElseThrow(()-> {
            throw new RuntimeException("This user is not exist");
        });
    }
}
