package com.atln.springcloud.myhandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class obj {
    int i = 0;

    public void addTo20() {
        this.i = 20;
    }
}

public class test {

    public static void main(String[] args) {
        obj obj = new obj();
        System.out.println(Thread.currentThread().getName() + "come in");
        // new Thread();
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.addTo20();
            System.out.println(Thread.currentThread().getName() + "新线程创建了！" + obj.i);

        }
                , "AAAA").start();

        //    System.out.println(Thread.currentThread().getName()+"-------" + obj.i);
        // while (obj.i == 0) {
        //System.out.println("--------");
        // }
        System.out.println(Thread.currentThread().getName() + "==============" + obj.i);

        Callable<Integer> myCallable = new MyCallable();    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象

        int a = 2;
        System.out.println("a 非的结果是：" + (~a));

        HashMap map = new HashMap(10);
        map.put("00", 00);

        String s1 = "abc";
        String s2 = "abc";
        System.out.println("++++++++++" + s1 == s2);


        //Executors.newFixedThreadPool(10);

    }

    private Lock lock = new ReentrantLock();

    public void testMethod() {
        //Executors.
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        Condition condition = lock.newCondition();
        lock.unlock();

        HashMap map = new HashMap(10);
        map.put("00", 00);
    }
}


class MyCallable implements Callable<Integer> {
    private int i = 0;

    // 与run()方法不同的是，call()方法具有返回值
    @Override
    public Integer call() {
        int sum = 0;
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            sum += i;
        }
        return sum;
    }

}


 class ThreadTest1 {
    private int j;

    public static void main(String args[]) {
        ThreadTest1 tt = new ThreadTest1();
        Inc inc = tt.new Inc();
        Dec dec = tt.new Dec();
        for (int
             i = 0; i < 2; i++) {
            Thread t = new Thread(inc);
            t.start();
            t = new Thread(dec);
            t.start();
        }

        Set set=new HashSet<>();
        set.add("Aa");
        set.add("Aa");
    }

    private synchronized void inc() {
        j++;
        System.out.println(Thread.currentThread().getName() + "-inc:" + j);
    }

    private synchronized void dec() {
        j--;
        System.out.println(Thread.currentThread().getName() + "-dec:" + j);
    }

    class Inc implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                inc();
            }
        }
    }

    class Dec implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                dec();
            }
        }
    }
}
