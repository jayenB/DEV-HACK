package com.example.hackathon;

public class SaveData {
    String name,age,sex,diabetes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDiabetes() {
        return diabetes;
    }

    public void setDiabetes(String diabetes) {
        this.diabetes = diabetes;
    }

    public SaveData(String name, String age, String sex, String diabetes) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.diabetes = diabetes;
    }
}
