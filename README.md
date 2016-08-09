# Android_GreenDAO_UpgradeHelper
#Dead work
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
