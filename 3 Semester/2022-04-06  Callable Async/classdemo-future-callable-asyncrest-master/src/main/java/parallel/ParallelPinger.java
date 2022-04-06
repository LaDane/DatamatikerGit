package parallel;

import sequental.SequentialPinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//Perhaps this you go into a separate file
class PingURL implements Callable<String> {
  String url;
  
  PingURL(String url) {
    this.url = url;
  }

  @Override
  public String call() throws Exception {
    return url +"\t\tStatus:\t"+ SequentialPinger.getStatus(url);
  }
}

public class ParallelPinger {
    /*
    Create an executor service
    Get the list of URLs to contact from the static method in SequentalPinger
    Make a List of <Future<String>>
    Create your Callables, and start them via a method on the executor and add the returned future to the list
    Call a "relevant" method on all your futures to get the response, and to the List you eventually will return
    */
  public static List<String> getStatusFromAllServers() throws Exception{
    List<String> list = new ArrayList<>();
    List<Future<String>> fList = new ArrayList<>();

    ExecutorService ex = Executors.newCachedThreadPool();
    for(String url : SequentialPinger.getHostList()) {
      Future<String> fut = ex.submit(new PingURL(url));
      fList.add(fut);
    }
    for(Future<String> f : fList) {
      String result = f.get();
      list.add(result);
    }
    return list;
  }

  public static void main(String[] args) throws Exception {
    long timeStart = System.nanoTime();
    List<String> results = getStatusFromAllServers();
    for(String r: results){
      System.out.println(r);
    }
    long timeEnd = System.nanoTime();
    long total = (timeEnd - timeStart) / 1_000_000;
    System.out.println("Time to check URLS: " + total + "ms.");
  }
}
