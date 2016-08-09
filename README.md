# Android_GreenDAO_UpgradeHelper
#Dead work

1.Add the dependency
```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'org.greenrobot:greendao-gradle-plugin:3.0.0'
    }
}
 
// In current version 3.0.0, this must precede the android plugin!
apply plugin: 'org.greenrobot.greendao'
 
dependencies {
    compile 'org.greenrobot:greendao:3.0.1'
}
```

2.Add a new class that extends DaoMaster.OpenHelper
```
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
```

3.Use your UpgradeOpenHelper
```
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
```
#Thanks
 [greenDAO](http://greenrobot.org/greendao/documentation/updating-to-greendao-3-and-annotations/#Basic_propertyannotationsId_Property_etc)
 
#License
```
Copyright 2016 LeeTech

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
