package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.apache.commons.lang3.RandomStringUtils;

/*
This should provide a simple skeleton example for how to use Callable and Future
Observer how Callable, compared to Runnable returns a value
*/
class RandomStringGenerator implements Callable<String>{
  int length;
  RandomStringGenerator(int length){
    this.length = length;
  }
  @Override
  public String call() throws Exception {
    String randomString = RandomStringUtils.random(length, true, true); //true,true -> useLetters, useNumbers
    //Wait a random period (between 0 and 1 second to demonstrate that we still can get strings in the right order
    Thread.sleep((int)(Math.random()*1000)); 
    return randomString;
  }
}

public class SimpleFututureCallable {
  
  public static void main(String[] args) throws Exception {
    ExecutorService executor = Executors.newCachedThreadPool();
    List<Future<String>> futures = new ArrayList<>();
    for(int i = 5; i <= 16; i++){
      Callable<String> stringGenerator = new RandomStringGenerator(i);
      Future future = executor.submit(stringGenerator);
      futures.add(future);
    }
    //Get the results
    for(Future<String> future : futures){
      String randomStr = future.get();
      System.out.println(randomStr);
    }
  }
}
