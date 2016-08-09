package com.lee.greendao.db.dao;

import android.content.Context;

import com.lee.greendao.db.model.User;

import java.util.List;

/**
 * ClassName: DBService
 * Description TODO DBService
 * Auther lijun lee mingyangnc@163.com
 * Date 2016/8/8 11:39
 */
public class DBService {

    private static DBService instance;

    public Context mContext;

    public UserDao mUserDao;

    public static DBService getInstance(Context context) {
        if (instance == null) {
            synchronized (DBService.class) {
                if (instance == null) {
                    instance = new DBService(context);
                }
            }
        }
        return instance;
    }

    private DBService(Context context) {
        mContext = context;
        instance = this;
        mUserDao = DBManager.getInstance(mContext).getDaoSession().getUserDao();
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> loadAllUsers() {
        return mUserDao.loadAll();
    }

    /**
     * 删除用户表
     */
    public void deleteUserInfos() {
        mUserDao.deleteAll();
    }

    /**
     * 通过 userId 查找用户
     *
     * @return
     */
    public User findUserById(String userId) {
        return mUserDao.queryBuilder().where(UserDao.Properties.UserId.eq(userId)).unique();
    }

    /**
     * 插入数据,并返回id
     *
     * @param user
     * @return
     */
    public long insertOrReplaceUser(User user) {
        return mUserDao.insert(user);
    }

    /**
     * 用过 userId 删除用户
     *
     * @param userId
     */
    public void delete(String userId) {
        User user = mUserDao.queryBuilder().where(UserDao.Properties.UserId.eq(userId)).unique();
        if (user != null) {
            mUserDao.delete(user);
        }
    }
}
