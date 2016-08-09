package com.lee.greendao.db.dao;

import android.content.Context;

import com.lee.greendao.db.model.User;

import java.util.List;

/**
 * ClassName: DBManager
 * Description TODO 数据库管理类
 * Auther lijun lee mingyangnc@163.com
 * Date 2016/8/8 10:59
 */
public class DBManager {

    private static DBManager instance;

    private DaoMaster daoMaster;

    private DaoSession daoSession;

    public static DBManager getInstance(Context context) {
        if (instance == null) {
            synchronized (DBManager.class) {
                if (instance == null) {
                    instance = new DBManager(context);
                }
            }
        }
        return instance;
    }

    private DBManager() {

    }

    private DBManager(Context context) {
        if (daoSession == null) {
            if (daoMaster == null) {
//                DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, context.getPackageName(), null);
                // 数据库升级helper
                UpgradeOpenHelper helper = new UpgradeOpenHelper(context, context.getPackageName(), null);
                daoMaster = new DaoMaster(helper.getWritableDatabase());
            }
            daoSession = daoMaster.newSession();
        }
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
