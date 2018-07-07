package com.alearner.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mzg on 2018/7/6.
 * 使用Java 8 lambda表达式进行事件处理
 */
public class EventProcess {

    public void EventListnerAnonymous(){
        JButton show = new JButton("show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
    }

    public void EventListnerLambda(){
        JButton show =  new JButton("show");
        show.addActionListener((e)->{
            System.out.println("Event handling without lambda expression is boring");
        });

    }

}
