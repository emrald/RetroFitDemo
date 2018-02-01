package com.trivediinfoway.retrofitdemo.dataclass;

import com.trivediinfoway.retrofitdemo.dataclass.UserData;

/**
 * Created by TI A1 on 12-10-2017.
 */
public class LoginClass {

    boolean error;

    public UserData getData() {
        return user_data;
    }

    UserData user_data = null;

    public boolean isError() {
        return error;
    }

    public LoginClass(boolean error, String message) {
        this.error = error;
        this.message = message;
       // this.user_data = user_data;
    }

    public String getMessage() {
        return message;
    }

   /* public String getUser_data() {
        return user_data;
    }*/

    String message;
   // String user_data;
}
