package com.newyear.dao;

import com.newyear.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Date2020/1/24 8:34
 **/
@Repository
public interface UserDao  extends JpaRepository<User,Integer> {
    public List<User> findAll();
}
