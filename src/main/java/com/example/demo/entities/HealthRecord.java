package com.example.demo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class HealthRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private Date date;
    private int caloriesIntake;
    private Boolean exceededCalorieLimit;
    private int weight;
    private int waterIntake;
    private TimePeriod periodGreatestCalorieIntake;
    @ManyToOne
    private UserP user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthRecord that = (HealthRecord) o;
        return id == that.id &&
                caloriesIntake == that.caloriesIntake &&
                weight == that.weight &&
                waterIntake == that.waterIntake &&
                date.equals(that.date) &&
                exceededCalorieLimit.equals(that.exceededCalorieLimit) &&
                periodGreatestCalorieIntake == that.periodGreatestCalorieIntake &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, caloriesIntake, exceededCalorieLimit, weight, waterIntake, periodGreatestCalorieIntake, user);
    }

    public HealthRecord(long id, Date date, int caloriesIntake, Boolean exceededCalorieLimit, int weight, int waterIntake, TimePeriod periodGreatestCalorieIntake, UserP user) {
        this.id = id;
        this.date = date;
        this.caloriesIntake = caloriesIntake;
        this.exceededCalorieLimit = exceededCalorieLimit;
        this.weight = weight;
        this.waterIntake = waterIntake;
        this.periodGreatestCalorieIntake = periodGreatestCalorieIntake;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCaloriesIntake() {
        return caloriesIntake;
    }

    public void setCaloriesIntake(int caloriesIntake) {
        this.caloriesIntake = caloriesIntake;
    }

    public Boolean getExceededCalorieLimit() {
        return exceededCalorieLimit;
    }

    public void setExceededCalorieLimit(Boolean exceededCalorieLimit) {
        this.exceededCalorieLimit = exceededCalorieLimit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(int waterIntake) {
        this.waterIntake = waterIntake;
    }

    public TimePeriod getPeriodGreatestCalorieIntake() {
        return periodGreatestCalorieIntake;
    }

    public void setPeriodGreatestCalorieIntake(TimePeriod periodGreatestCalorieIntake) {
        this.periodGreatestCalorieIntake = periodGreatestCalorieIntake;
    }

    public UserP getUser() {
        return user;
    }

    public void setUser(UserP user) {
        this.user = user;
    }

}
