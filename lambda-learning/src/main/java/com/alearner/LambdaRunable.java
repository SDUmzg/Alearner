package com.alearner;

/**
 * Created by mzg on 2018/7/6.
 */
public class LambdaRunable {

    public static void main(String [] args){
        beforeLambda();
        useLambda();
    }

    public static   void beforeLambda(){
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Anonymous inner classes");
            }
        }).start();
    }

    public static void useLambda(){
        new Thread(()-> System.out.println("Using lambda")).start();
    }
}
