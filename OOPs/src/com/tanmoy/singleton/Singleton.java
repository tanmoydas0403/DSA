package com.tanmoy.singleton;

public class Singleton {
    private Singleton(){}

    private static volatile Singleton instance;

    static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
