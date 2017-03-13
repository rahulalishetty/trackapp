package com.example.user.trackapp2;

/**
 * Created by USER on 19-02-2017.
 */

public class DetailsAlarm {
    //String fullname;
    String alarm_activity_name;
    String time;

    DetailsAlarm(){

    }
    DetailsAlarm(String alarm_activity_name,String time){
        //this.fullname=fullname;
        this.alarm_activity_name=alarm_activity_name;
        this.time=time;
    }

    //String getFullname(){
      //  return this.fullname;
    //}
    String getAlarm_activity_name(){
        return this.alarm_activity_name;

    }
    String getTime(){
        return this.time;
    }

}
