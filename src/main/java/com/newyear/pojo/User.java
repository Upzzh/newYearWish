package com.newyear.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Date2020/1/22 14:16
 **/
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private Integer id;
    @Column(name = "username",nullable = false)
    private String userName;
    @Column(name = "email",nullable = false)
    private String Email;
}
