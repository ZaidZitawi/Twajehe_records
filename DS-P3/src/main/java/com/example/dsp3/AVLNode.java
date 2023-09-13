package com.example.dsp3;

public class AVLNode {
    int seatNumber;
    double avg;
    Student student;
    AVLNode left; // left child
    AVLNode right; //right child
    int height; //Height
    public AVLNode(int seatNumber){
        this(seatNumber, null, null);
    }

    public AVLNode(double avg){
        this(avg, null, null);
    }

    public AVLNode(Student student){this(student, null, null);}

    public AVLNode(int seatNumber, AVLNode left, AVLNode right)
    {
        this.seatNumber=seatNumber;
        this.left=left;
        this.right=right;
        this.height=0;
    }
    public AVLNode(double avg, AVLNode left, AVLNode right)
    {
        this.avg=avg;
        this.left=left;
        this.right=right;
        this.height=0;
    }
    public AVLNode(Student student, AVLNode left, AVLNode right)
    {
        this.student= student;
        this.left=left;
        this.right=right;
        this.height=0;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "seatNumber=" + seatNumber +
                ", avg=" + avg +
                ", height=" + height +
                '}';
    }
    //I will make two methods for every operation in the avl class, 2 insertion operation, 2 deletion and so on
    //because there will be two avl trees with different kinds of data:
    //1)the first one will take Nodes data type as integer which is seat number
    //2)the second one will take Nodes data type as double which is average

}
