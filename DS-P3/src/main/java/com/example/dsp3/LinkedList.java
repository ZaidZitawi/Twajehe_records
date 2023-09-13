package com.example.dsp3;

public class LinkedList {
    double avg;
    Student front, back;
    int size;

    public LinkedList() {
        front=back= null;
        size = 0;

    }
    public  LinkedList(double avg){
        this.avg=avg;
        front=back=null;
        size=0;
    }
    public void addFirst(Student s) {
        Student newStudent = new Student(s.getSeatNum(), s.getBranch(), s.getAverage());
        newStudent.next=front;
        front = newStudent;
        Student curr = front;
        while (curr.next != null) {
            curr = curr.next;
        }
        back = curr;
        size++;
    }
}
