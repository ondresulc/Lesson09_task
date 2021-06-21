package com.company;

public class Philosopher extends Thread {

    int leftForkIndex;
    int rightForkIndex;
    private Integer portionsLeft = 1000;

    String philosophersName = "";
    int philosophersIndex;

    public Philosopher(String philosophersName, int philosophersIndex) {
        this.philosophersName = philosophersName;
        this.philosophersIndex = philosophersIndex;

        int numberOfForks = Main.listOfForks.size();

        if (philosophersIndex == 0) {
           leftForkIndex = numberOfForks - 1;
        } else {
            leftForkIndex = this.philosophersIndex - 1;
        }
        rightForkIndex = this.philosophersIndex;
    }

    private void startAction(String action) {
        System.out.println(Thread.currentThread().getName() + " " + action);
        try {
            Thread.sleep(0,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        Object firstFork = Main.listOfForks.get(leftForkIndex);

        Object secondFork = Main.listOfForks.get(rightForkIndex);

        int lastEatingPhilosophersIndex = Main.listOfPhilosophers.size()-1;
        if (philosophersIndex == lastEatingPhilosophersIndex) {
            secondFork = Main.listOfForks.get(leftForkIndex);

            firstFork = Main.listOfForks.get(rightForkIndex);
        }

        //System.out.println(leftForkIndex +" AND " + rightForkIndex);

        while (portionsLeft > 0) {
            synchronized (firstFork) {
                startAction("just getting first FORK!");

                synchronized (secondFork) {
                    startAction("just getting second FORK and starts eating!");

                    portionsLeft--;
                    startAction("put the second FORK down!");
                }
                startAction("put the first FORK down! Portions left: " +portionsLeft +"\n********************************************************");
            }

            if (portionsLeft == 0) {
                System.out.println(philosophersName + " finished all the food!"+"\n********************************************************");
            }
        }
    }
}
