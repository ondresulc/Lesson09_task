package com.company;

import java.util.HashMap;

public class Main {

    public static HashMap<Integer, Object> listOfForks = new HashMap<>();
    public static HashMap<Integer, Philosopher> listOfPhilosophers = new HashMap<>();


    public static void main(String[] args) {
        createForkList();
        for (int i = 0; i < 10; i++) {
            listOfPhilosophers.put(i, new Philosopher("Philosopher" + i, i));
        }
        makePhilosopherEat();
    }

    public static void createForkList() {
        for (int i = 0; i < 10; i++) {
            listOfForks.put(i, new Object());
        }
    }

    public static void makePhilosopherEat() {
        for (int i = 0; i < 10; i++) {
            listOfPhilosophers.get(i).start();
            listOfPhilosophers.get(i).setName(listOfPhilosophers.get(i).philosophersName);
        }
    }

}


