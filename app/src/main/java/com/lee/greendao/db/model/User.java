package com.lee.greendao.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;


/**
 * ClassName: User
 * Description TODO User
 * Auther lijun lee mingyangnc@163.com
 * Date 2016/8/7 22:59
 */

@Entity(
        // 定义表名
        nameInDb = "user_db",

        // 添加索引,并且标明唯一
        indexes = {@Index(value = "age, date DESC", unique = true)}
)
public class User {

    @Property(nameInDb = "user_id") // 自定义字段
    @Index(unique = true) // 建立索引
    @NotNull
    private String userId;

    @Property(nameInDb = "user_name") // 自定义字段名
    private String name;

    @Unique // 唯一
    @NotNull
    private String identity;

    @NotNull // 不为空
    private String age;

    @NotNull // 不为空
    private String date;

    private String location;

    private String sex;

    @Transient // 不持久化此字段
    private String tempUsageCount;


    @Generated(hash = 1862789169)
    public User(@NotNull String userId, String name, @NotNull String identity,
            @NotNull String age, @NotNull String date, String location, String sex) {
        this.userId = userId;
        this.name = name;
        this.identity = identity;
        this.age = age;
        this.date = date;
        this.location = location;
        this.sex = sex;
    }

    @Generated(hash = 586692638)
    public User() {
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTempUsageCount() {
        return tempUsageCount;
    }

    public void setTempUsageCount(String tempUsageCount) {
        this.tempUsageCount = tempUsageCount;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
