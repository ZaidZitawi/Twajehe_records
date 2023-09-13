package com.example.dsp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DLinkedList dl1= new DLinkedList();
        dl1.addFirst(1203101, "zzzz", 50.8);
        dl1.addFirst(1303101, "oooo", 15.2);
        dl1.addFirst(1403101, "pppp", 99.4);
        dl1.addFirst(1503101, "llll", 49.2);
        dl1.addFirst(1603101, "kkkk", 73.0);
        dl1.addFirst(1703101, "ffff", 88.6);
        dl1.addFirst(1803101, "ssss", 67.5);
        dl1.sortByAverage();
        dl1.traverse();



    }
}
