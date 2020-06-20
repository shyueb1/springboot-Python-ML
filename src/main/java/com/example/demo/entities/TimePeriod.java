package com.example.demo.entities;

public enum TimePeriod {
        MORNING{
            @Override
            public String toString() {
                return "morning";
            }
        },
        AFTERNOON{
            @Override
            public String toString() {
                return "afternoon";
            }
        },
        EVENING{
            @Override
            public String toString() {
                return "evening";
            }
        },
        MIDNIGHT{
            @Override
            public String toString() {
                return "midnight";
            }
        }
}
