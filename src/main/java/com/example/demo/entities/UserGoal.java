package com.example.demo.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserGoal {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @ManyToOne
    private UserP user;
    private int calorieGoal;
    private int weightGoal;
    private int waterGoal;

    public UserGoal(long id, UserP user, int calorieGoal, int weightGoal, int waterGoal) {
        this.id = id;
        this.user = user;
        this.calorieGoal = calorieGoal;
        this.weightGoal = weightGoal;
        this.waterGoal = waterGoal;
    }

    public UserGoal(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserP getUser() {
        return user;
    }

    public void setUser(UserP user) {
        this.user = user;
    }

    public int getCalorieGoal() {
        return calorieGoal;
    }

    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }

    public int getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(int weightGoal) {
        this.weightGoal = weightGoal;
    }

    public int getWaterGoal() {
        return waterGoal;
    }

    public void setWaterGoal(int waterGoal) {
        this.waterGoal = waterGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGoal userGoal = (UserGoal) o;
        return id == userGoal.id &&
                calorieGoal == userGoal.calorieGoal &&
                weightGoal == userGoal.weightGoal &&
                waterGoal == userGoal.waterGoal &&
                user.equals(userGoal.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, calorieGoal, weightGoal, waterGoal);
    }

    @Override
    public String toString() {
        return "UserGoal{" +
                "id=" + id +
                ", user=" + user +
                ", calorieGoal=" + calorieGoal +
                ", weightGoal=" + weightGoal +
                ", waterGoal=" + waterGoal +
                '}';
    }
}
