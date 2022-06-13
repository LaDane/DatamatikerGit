package webscraper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Tester {

    private static final String[] URLS = {
            "https://www.fck.dk",
            "https://www.google.com",
            "https://politiken.dk",
            "https://cphbusiness.dk"
    };

    public static List<TagCounter> runSequental() {
        List<TagCounter> urls = new ArrayList();
        urls.add(new TagCounter("https://www.fck.dk"));
        urls.add(new TagCounter("https://www.google.com"));
        urls.add(new TagCounter("https://politiken.dk"));
        urls.add(new TagCounter("https://cphbusiness.dk"));
        for (TagCounter tc : urls) {
            tc.doWork();
        }
        return urls;
    }

    public static void main(String[] args) throws Exception {
        // Sequential
        long timeSequental;
        long start = System.nanoTime();

        List<TagCounter> fetchedData = new Tester().runSequental();
        long end = System.nanoTime();
        timeSequental = end - start;
        System.out.println("Time Sequential: " + ((timeSequental) / 1_000_000) + " ms.");

        // Parallel
        start = System.nanoTime();

        List<TagCounter> tList = runParrallel();

        for (TagCounter tc : tList) {
            System.out.println("Title: " + tc.getTitle());
            System.out.println("Div's: " + tc.getDivCount());
            System.out.println("Body's: " + tc.getBodyCount());
            System.out.println("----------------------------------");
        }

        long timeParallel = System.nanoTime() - start;
        System.out.println("Time Parallel: " + ((timeParallel) / 1_000_000) + " ms.");
        System.out.println("Paralle was " + timeSequental / timeParallel + " times faster");

    }

    public static List<TagCounter> runParrallel() throws Exception {
        List<TagCounter> list = new ArrayList<>();
        List<Future<TagCounter>> tList = new ArrayList<>();

        ExecutorService ex = Executors.newCachedThreadPool();
        for(String url : URLS) {
            Future<TagCounter> fut = ex.submit(new TagCounter(url));
            tList.add(fut);
        }
        for(Future<TagCounter> f : tList) {
            TagCounter result = f.get();
            list.add(result);
        }

        return list;
    }

//    public static List<TagCounter> runParrallel() throws ExecutionControl.NotImplementedException {
//        throw new ExecutionControl.NotImplementedException("Pleeeeease implement me!");
//    }

}
