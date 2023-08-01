package org.example;

public class MyExecutor implements IExecute {

    @Override
    public String exec(int count, String processName) {
        return "Executed " + processName + " count : " + count;
    }

    public void doSome(){
        System.out.println("test me");
    }

}
