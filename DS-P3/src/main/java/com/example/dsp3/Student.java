package com.example.dsp3;


public class Student {
    private int SeatNum;
    private String Branch;
    private double Average;
     Student next;
     Student prev;

    public Student(int seatNum, String branch, double average) {
        SeatNum = seatNum;
        Branch = branch;
        Average = average;
    }

    public Student(int seatNum) {
        SeatNum = seatNum;
    }
    public Student(double avg) {
        avg=avg;
    }


    public int getSeatNum() {
        return SeatNum;
    }

    public void setSeatNum(int seatNum) {
        SeatNum = seatNum;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String branch) {
        this.Branch = branch;
    }

    public double getAverage() {
        return Average;
    }

    public void setAverage(double average) {
        Average = average;
    }



    @Override
    public String toString() {
        return "Seat number: " +getSeatNum() +", Branch: " +getBranch() + ", Average: " +getAverage() + ". " + "\n";
    }
}
