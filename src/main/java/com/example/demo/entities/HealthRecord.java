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
    private double calorieIntake;
    private Boolean exceededCalorieLimit;
    private double weight;
    private double waterIntake;
    @Enumerated(EnumType.STRING)
    private TimePeriod periodGreatestCalorieIntake;
    @JoinColumn(nullable = false)
    @ManyToOne(optional = false)
    private UserP user;

    /**
     * TODO: add hours_of_sleep, tiredness, activity_level columns to HealthRecord
     */

    public HealthRecord(){}

    public HealthRecord(long id, Date date, int caloriesIntake, Boolean exceededCalorieLimit, int weight, int waterIntake, TimePeriod periodGreatestCalorieIntake, UserP user) {
        this.id = id;
        this.date = date;
        this.calorieIntake = caloriesIntake;
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

    public double getCaloriesIntake() {
        return calorieIntake;
    }

    public void setCaloriesIntake(double caloriesIntake) {
        this.calorieIntake = caloriesIntake;
    }

    public Boolean getExceededCalorieLimit() {
        return exceededCalorieLimit;
    }

    public void setExceededCalorieLimit(Boolean exceededCalorieLimit) {
        this.exceededCalorieLimit = exceededCalorieLimit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWaterIntake() {
        return waterIntake;
    }

    public void setWaterIntake(double waterIntake) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthRecord that = (HealthRecord) o;
        return id == that.id &&
                calorieIntake == that.calorieIntake &&
                weight == that.weight &&
                waterIntake == that.waterIntake &&
                date.equals(that.date) &&
                exceededCalorieLimit.equals(that.exceededCalorieLimit) &&
                periodGreatestCalorieIntake == that.periodGreatestCalorieIntake &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, calorieIntake, exceededCalorieLimit, weight, waterIntake, periodGreatestCalorieIntake, user);
    }

}
