package com.alearner.mdc.advance;

/**
 * Created by mzg on 2018/8/17.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import chapters.mdc.NumberCruncher;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class NumberCruncherClient {
    public NumberCruncherClient() {
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                String url = "rmi://" + args[0] + "/Factor";
                chapters.mdc.NumberCruncher nc = (chapters.mdc.NumberCruncher) Naming.lookup(url);
                loop(nc);
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        } else {
            usage("Wrong number of arguments.");
        }

    }

    static void usage(String msg) {
        System.err.println(msg);
        System.err.println("Usage: java chapters.mdc.NumberCruncherClient HOST\n   where HOST is the machine where the NumberCruncherServer is running.");
        System.exit(1);
    }

    static void loop(NumberCruncher nc) {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;

        while(true) {
            System.out.print("Enter a number to factor, '-1' to quit: ");

            try {
                i = Integer.parseInt(in.readLine());
            } catch (Exception var5) {
                var5.printStackTrace();
            }

            if (i == -1) {
                System.out.print("Exiting loop.");
                return;
            }

            try {
                System.out.println("Will attempt to factor " + i);
                int[] factors = nc.factor(i);
                System.out.print("The factors of " + i + " are");

                for(int k = 0; k < factors.length; ++k) {
                    System.out.print(" " + factors[k]);
                }

                System.out.println(".");
            } catch (RemoteException var6) {
                System.err.println("Could not factor " + i);
                var6.printStackTrace();
            }
        }
    }
}
