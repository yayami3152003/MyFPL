package com.example.fpoly.metmoi.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.core.content.ContextCompat;

public class PersonObject {
    private String date;
    private String time;
    private String message;
    private String server;
    private String studentName;
    private String teacherName;
    private int phoneImage; // Resource ID for phone image
    private int smsImage; // Resource ID for SMS image
    private String personCon;
    private Context context;
    private int profileImage; // Resource ID for profile image

    // Additional fields for teacher
    private int teacherProfileImage; // Resource ID for teacher's profile image
    private boolean isTeacher; // Indicates whether the person is a teacher or not

    // Constructors
    public PersonObject(String date, String time, String message, String server, String studentName, String teacherName, int phoneImage, int smsImage, String personCon, Context context, int profileImage, int teacherProfileImage, boolean isTeacher) {
        this.date = date;
        this.time = time;
        this.message = message;
        this.server = server;
        this.studentName = studentName;
        this.teacherName = teacherName;
        this.phoneImage = phoneImage;
        this.smsImage = smsImage;
        this.personCon = personCon;
        this.context = context;
        this.profileImage = profileImage;
        this.teacherProfileImage = teacherProfileImage;
        this.isTeacher = isTeacher;
    }


    // Getters and Setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getPhoneImage() {
        return phoneImage;
    }

    public void setPhoneImage(int phoneImage) {
        this.phoneImage = phoneImage;
    }

    public int getSmsImage() {
        return smsImage;
    }

    public void setSmsImage(int smsImage) {
        this.smsImage = smsImage;
    }
    public int getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public String getPresonCon() {
        return personCon;
    }

    public void setPresonCon(String presonCon) {
        this.personCon = presonCon;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public int getTeacherProfileImage() {
        return teacherProfileImage;
    }

    public void setTeacherProfileImage(int teacherProfileImage) {
        this.teacherProfileImage = teacherProfileImage;
    }

    public boolean isTeacher() {
        return isTeacher;
    }

    public void setTeacher(boolean teacher) {
        isTeacher = teacher;
    }
    // Updated methods to fetch drawables with context
    public Drawable getProfileImageDrawable() {
        if (context == null) {
            Log.e("PersonObject", "Context is null!");
            return null;
        }
        return ContextCompat.getDrawable(context, profileImage);
    }

    public Drawable getPhoneIconDrawable() {
        if (context == null) {
            Log.e("PersonObject", "Context is null!");
            return null;
        }
        return ContextCompat.getDrawable(context, phoneImage);
    }

    public Drawable getSmsIconDrawable() {
        if (context == null) {
            Log.e("PersonObject", "Context is null!");
            return null;
        }
        return ContextCompat.getDrawable(context, smsImage);
    }

}