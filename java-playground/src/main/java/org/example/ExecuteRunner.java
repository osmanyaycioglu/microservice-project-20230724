package org.example;

public class ExecuteRunner {
    public static void main(String[] args) {
        String prefix = "baslangic";
        MyExecutor myExecutor = new MyExecutor();
        myExecutor.doSome();

        IExecute execute1 = new MyExecutor();
        execute1.exec(2,"test");

        IExecute execute2 = (a,b) -> "Executed " + b + " count : " + a;
        execute2.exec(10,"test");

        IExecute execute3 = (a,b) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(prefix);
            for (int i = 0; i < a; i++) {
                stringBuilder.append("iterasyon calisti ").append(i);
            }
            return stringBuilder.toString();
        };
        execute3.exec(8,"ssahjdkjh");

    }
}
