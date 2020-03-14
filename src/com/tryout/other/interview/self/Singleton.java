package com.tryout.other.interview.self;

import java.util.Date;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-28 6:42 PM
 */
public class Singleton {

    private static Singleton instance;
    private String abc;

    private Singleton(){
        System.out.println(Thread.currentThread().getName()+" In constructor");
        abc = Thread.currentThread().getName();
    }

    public static Singleton getInstance(){
        if(instance ==null) {
            synchronized (Singleton.class) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(instance ==null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

    public void print() throws InterruptedException{
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " " + this.abc);
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc)  throws InterruptedException{
        this.abc = abc;
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + " " + this.abc);
    }
}
