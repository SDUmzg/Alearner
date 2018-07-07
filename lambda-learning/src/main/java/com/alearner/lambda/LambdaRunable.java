package com.alearner.lambda;


/**
 * Created by mzg on 2018/7/6.
 * 用lambda表达式实现Runnable
 */
public class LambdaRunable {


    public  void beforeLambda(){
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous inner classes");
            }
        }).start();
    }

    public  void useLambda(){
        new Thread(()-> System.out.println("Using lambda")).start();
    }

    /**
     *  TODO：
     *
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     * (int even, int odd) -> even + odd   带参数怎么实现
     */
}
