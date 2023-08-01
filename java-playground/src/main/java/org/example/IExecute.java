package org.example;
// @FunctionalInterface
public interface IExecute {
    String TEST_CONSTANT = "osman";

    String exec(int count,String processName);

    default String proxyMethod(String processName){
        return exec(10,processName);
    }

    public static String checkExecution(String process){
        return "OK";
    }

}
