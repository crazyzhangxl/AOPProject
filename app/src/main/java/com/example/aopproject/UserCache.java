package com.example.aopproject;

/**
 * @author crazyZhangxl on 2019/1/28.
 * Describe:
 */
public class UserCache {
    private boolean isLogin;

    private UserCache(){

    }

    private static class UserCacheHolder{
        private static final UserCache M_INSTANCE = new UserCache();
    }

    public static UserCache getInstance(){
        return UserCacheHolder.M_INSTANCE;
    }

    public void setLogin(boolean login){
        this.isLogin = login;
    }

    public boolean isLogin(){
        return isLogin;
    }
}
