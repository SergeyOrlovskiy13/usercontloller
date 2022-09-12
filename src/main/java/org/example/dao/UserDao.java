package org.example.dao;

import org.example.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserDao {

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM user", new BeanPropertyRowMapper<>(User.class));
    }

    public User show(int id){
        return (User) jdbcTemplate.query("SELECT * FROM user WHERE iduser =?", new Object[]{id},new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);
    }
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO user VALUES(1, ?, ?,?, ?,?,?)",
                user.getUsername(), user.getSurname(),user.getBirthday(), user.getEmail(), user.getAddress(), user.getPhone());
    }

    public void update(int id, User updatedUser) {
        jdbcTemplate.update("UPDATE user SET username=?, surname=?, email=?, address=?, phone=? WHERE iduser=?",
                updatedUser.getUsername(), updatedUser.getSurname(), updatedUser.getBirthday(), updatedUser.getEmail(),
                updatedUser.getAddress(), updatedUser.getPhone(),id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM user WHERE iduser=?", id);
    }




}

