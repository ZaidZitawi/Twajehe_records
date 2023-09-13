package com.example.dsp3;

import javafx.css.Size;
import javafx.geometry.Pos;

public class DLinkedList {
    Student front, back;
    int size;

    public DLinkedList() {
        front = null;
        back = null;
        size = 0;
    }

    public void addFirst(int seatNum, String branch, double avg) {
        Student newStudent = new Student(seatNum, branch, avg);
        if (size == 0) {
            front = back = newStudent;
            newStudent.next = newStudent.prev = null;
        } else {
            front.prev = newStudent;
            newStudent.next = front;
            front = newStudent;
            newStudent.prev = back;
            back.next = front;
        }
        size++;

    }


    public void Delete(int index) {

        if (size == 0) {
            return;
        } else if (size == 1) {
            front = back = null;
        } else if (index == size - 1)
            deleteLast();
        else if (index == 0)
            deleteFirst();
        else {
            Student current = front;
            for (int i = 0; i < index; i++)
                current = current.next;
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
    }

    public void deleteFirst() {
        Student current = front;
        if (size == 0) {
            return;
        } else if (size == 1) {
            front = back = null;
        } else {
            front = current.next;
            front.prev = null;
            current.next = null;
        }
        size--;
    }

    public void deleteLast() {
        Student current = back;
        if (size == 0) {
            return;
        } else if (size == 1) {
            front = back = null;
        } else {
            back = current.prev;
            current.prev = null;
            back.next = null;
        }
        size--;
    }

    public int SearchPOS(int Seatnum) {//Delete Position of the node
        Student current = front;
        int POS = 0;
        while (current != null) {
            if (current.getSeatNum() == Seatnum)
                return POS;
            else
                current = current.next;
            POS += 1;
        }
        size--;
        return -1;
    }

    public String Search(int seatNumber) {
        Student current = front;
        for (int i = 0; i < size; i++) {
            if (current.getSeatNum() == seatNumber)
                return current + "";
            else
                current = current.next;
        }
        return "The Student is not found!";
    }

    public Student Searchh(int seatNumber) {
        Student current = front;
        for (int i = 0; i < size; i++) {
            if (current.getSeatNum() == seatNumber)
                return current;
            else
                current = current.next;
        }
        return null;
    }

    public String toString() {
        Student newStudent = front;
        String buffer = "";
        for (int i = 0; i < size; i++) {
            buffer = buffer.concat(newStudent.toString());
            newStudent = newStudent.next;
        }
        return buffer;
    }

    public void traverse() {
        Student current = front;
        for (int i = 0; i < size; i++) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    public void Update(Student s, int seatnumber, String branch, double avg) {
        Search(seatnumber);
        s.setSeatNum(seatnumber);
        s.setBranch(branch);
        s.setAverage(avg);

    }

    public void sortByAverage () {
        Student current, index;
        if (front == null) {
            return;
        } else {
            current = front;
            index=current.next;
            for (int i =0;i<size-1;i++) {
                for (int j=i+1 ; j<size ; j++) {
                    if (current.getAverage() > index.getAverage()) {
                        swap(current, index);
                    }
                    index = index.next;
                }
                current = current.next;
                index = current.next;
            }
        }
    }

    public static void swap(Student a, Student b) {
        int seatNum = a.getSeatNum();
        String branch = a.getBranch();
        double avg = a.getAverage();
        //a=temp
        a.setAverage(b.getAverage());
        a.setBranch(b.getBranch());
        a.setSeatNum(b.getSeatNum());
        //a=b
        b.setSeatNum(seatNum);
        b.setBranch(branch);
        b.setAverage(avg);
        //b=temp
    }
    public Student NextStudent(Student student){
        Student curr = front;
        for (int i = 0; i<size ; i++){
            curr=curr.next;
            if (curr.getAverage()==student.getAverage()) {
                curr = curr.next;
                break;
            }
        }
        return curr;
    }
    public int NextStudentSeatNumber(Student student){
        Student curr = front;
        for (int i = 0; i<size ; i++){
            curr=curr.next;
            if (curr.getAverage()==student.getAverage()) {
                curr = curr.next;
                break;
            }
        }
        return curr.getSeatNum();
    }
    public Student prevStudent(Student student){
        Student curr = front;
        for (int i = 0; i<size ; i++){
            curr=curr.next;
            if (curr.getAverage()==student.getAverage()) {
                curr = curr.prev;
                break;
            }
        }
        return curr;
    }
    public int prevStudentseatNumber(Student student){
        Student curr = front;
        for (int i = 0; i<size ; i++){
            curr=curr.next;
            if (curr.getAverage()==student.getAverage()) {
                curr = curr.prev;
                break;
            }
        }
        return curr.getSeatNum();
    }
    public String  getStudentsAccordingToAVG(double avg){
        String buffer="";
        Student curr = front;
        for (int i = 0; i<size ; i++){
            while (curr.getAverage()==avg){
                buffer=buffer.concat(curr.toString());
                curr=curr.next;
            }
            curr=curr.next;
        }
        return buffer;
    }

}
