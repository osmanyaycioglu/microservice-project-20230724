package org.example;

public class Car {
    private int horsePower;
    private int avgSpeed;

    public int forward(int km){
        return km / avgSpeed;
    }

    public int backward(){
        return 2;
    }

    public int cookTea(){
        return 12;
    }

}
