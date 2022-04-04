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
    public void addUser(User user) {
        if (checkFields(user)) {
            repoSpringData.save(user);
        } else {
            throw new IllegalArgumentException("Incorrect input values");
        }
    }

    @Override
    public void addUser(String name, String surname, Integer age) {
        User user = new User(name, surname, age);
        if (checkFields(user)) {
            repoSpringData.save(new User(name, surname, age));
        } else {
            throw new IllegalArgumentException("Incorrect input values");
        }
    }

    @Override
    public void editUser(User user) {
        User extractedUser = repoSpringData.findById(user.getId()).orElseThrow(() -> {
            throw new IllegalArgumentException("This user is not exist");
        });
        if (checkFields(user)) {
            fillingFields(user, extractedUser);
            repoSpringData.save(extractedUser);
        }
    }

    private boolean checkFields(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            return false;
        }
        if (user.getSurname() == null || user.getSurname().isEmpty()) {
            return false;
        }
        if (user.getAge() < 0 && user.getAge() > 120) {
            return false;
        }
        return true;
    }

    private void fillingFields(User source, User dest) {
        dest.setName(source.getName());
        dest.setSurname(source.getSurname());
        dest.setAge(source.getAge());
    }

    @Override
    public void deleteUser(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Incorrect value of Id");
        }
        repoSpringData.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(repoSpringData.findAll());

    }

    @Override
    public User getUser(long id) {
        if (id < 0) {
            throw new IllegalArgumentException("Incorrect value of Id");
        }
        return repoSpringData.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("This user is not exist");
        });
    }
}
