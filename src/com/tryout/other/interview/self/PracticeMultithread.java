package com.tryout.other.interview.self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author: Mohit Garg (mohit.garg2905@gmail.com)
 * @createdAt: 2019-Jul-25 9:34 PM
 */
public class PracticeMultithread {

    static ExecutorService executorService = Executors.newFixedThreadPool(6);

    public static void main(String[] args){
        printAns(153);

        Runnable ta = () -> {
            Singleton s = Singleton.getInstance();
            try {
                s.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        for(int i=0; i<16; i++){
            executorService.submit(ta);
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

        String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int batchSize = 3;
        List<String> inputs = new ArrayList<>(batchSize);
        int count = 0;
        List<Future<Boolean>> futures = new ArrayList();
        for(int i=0; i<a.length; i++){
            inputs.add(a[i]);
            count++;
            if(count==batchSize){
                Callable t = new T(inputs);
                futures.add(executorService.submit(t));
                count=0;
                inputs = new ArrayList<>();
            }
        }
        if(inputs.size()>0){
            Callable t = new T(inputs);
            futures.add(executorService.submit(t));
        }

        int countN = 0;
        for(Future<Boolean> future: futures){
            System.out.println("Getting future "+ ++countN);
            try {
                Boolean f = future.get();
                if(f)
                    System.out.println("Future "+countN+" processed Successfully");
                else
                    System.out.println("Future "+countN+" processed Failed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("Got future "+countN);
        }

        executorService.shutdown();

        Boolean terminate = false;

        Thread b = new Thread(() -> {
            while(true){
                if(terminate)
                    return;
                System.out.println("Hello");

            }});
        b.start();

        try {
            Thread.currentThread().wait(1000);
            System.out.println("Stopping");
            terminate = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        Callable<Boolean> callable(String s) = () -> {
//            return true;
//        };

//        Callable<Boolean> callable(String s) {
//             () -> {
//                try {
//                    String threadName = Thread.currentThread().getName();
//                    System.out.println("Hello " + threadName+s);
//                    TimeUnit.SECONDS.sleep(1);
//                    return false;
//                }
//                catch (InterruptedException e) {
//                    throw new IllegalStateException("task interrupted", e);
//                }
//            };
//
//        }

//        Future<Boolean> processed = executorService.submit(callable);
    }

    public static void printAns(int a){
        int sum = 0;
        int j=a;
        while(j!=0){
            int digit = j%10;
            int k = digit^3;
            sum += digit^3;
            j = j/10;
        }
        if(sum==a){
            System.out.println("It is an ARMSTRONG number");
        }else{
            System.out.println("It is NOT an ARMSTRONG number");
        }
    }


}

class T implements Callable<Boolean>{
    private final List<String> inputs;
    public T(List<String> inputs){
        this.inputs = inputs;
    }


    @Override
    public Boolean call() throws Exception {
        try{
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello "+threadName);
            this.inputs.forEach(System.out::print);
            System.out.println("Bye "+threadName);
//            Thread.currentThread().wait(5000);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
