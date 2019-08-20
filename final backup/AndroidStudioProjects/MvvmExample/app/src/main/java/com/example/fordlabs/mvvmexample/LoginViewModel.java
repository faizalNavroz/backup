package com.example.fordlabs.mvvmexample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;
import android.widget.Toast;

public class LoginViewModel extends BaseObservable {

    private User user;



    public LoginViewModel() {

        this.user = new User("","");
    }



    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(com.example.fordlabs.mvvmexample.BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(com.example.fordlabs.mvvmexample.BR.userPassword);
    }

    public void onLoginClicked(){
        Log.d("msg","RUNNING");
    }



}