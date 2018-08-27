package com.alearner.mdc.advance;

/**
 * Created by mzg on 2018/8/17.
 */

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * NumberCruncher factors positive integers.
 */
public interface NumberCruncher extends Remote {
    /**
     * Factor a positive integer number and return its
     * distinct factor's as an integer array.
     * */
    int[] factor(int number) throws RemoteException;
}