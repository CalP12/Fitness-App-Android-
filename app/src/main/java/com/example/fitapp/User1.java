package com.example.fitapp;

public class User1 {
    public String name,dob,email,we,he,plan;
    public Integer workouts;
    public Double kcalLoss,bmi,totalkcal;
    public User1(){

    }
    public User1(String name, String dob, String email,String plan,String we,String he,Integer workouts, Double kcalLoss,Double totalkcal,Double bmi)
    {
        this.name=name;
        this.dob=dob;
        this.email=email;
        this.plan=plan;
        this.we=we;
        this.he=he;
        this.workouts=workouts;
        this.kcalLoss=kcalLoss;
        this.totalkcal=totalkcal;
        this.bmi=bmi;
    }
}
