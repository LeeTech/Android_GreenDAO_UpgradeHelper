package com.lee.greendao.db.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.lee.greendao.db.model.User;

import org.greenrobot.greendao.database.Database;

/**
 * ClassName: UpgradeOpenHelper
 * Description TODO UpgradeOpenHelper
 * Auther lijun lee mingyangnc@163.com
 * Date 2016/8/8 17:00
 */
public class UpgradeOpenHelper extends DaoMaster.OpenHelper {

    public UpgradeOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //操作数据库的更新
        MigrationHelper.migrate(db, UserDao.class);
    }
}
