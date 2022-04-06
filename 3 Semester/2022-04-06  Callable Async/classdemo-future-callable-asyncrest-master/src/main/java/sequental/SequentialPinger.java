package sequental;

/*
 * Code taken from 
 * http://crunchify.com/how-to-get-ping-status-of-any-http-end-point-in-java/
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class SequentialPinger {

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";
  public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
  public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

  private static String[] hostList = {
    "https://crunchify.com",
    "https://yahoo.com",
    "https://www.ebay.com",
    "https://google.com",
    "https://www.example.com",
    "https://paypal.com",
    "https://bing.com/",
    "http://techcrunch.com/",
    "https://mashable.com/",
    "https://thenextweb.com/",
    "https://wordpress.com/",
    "https://cphbusiness.dk/",
    //"http://sjsu.edu/",
    "http://ebay.co.uk/", "http://google.co.uk/",
    "https://www.wikipedia.org/",
    "https://dr.dk", "https://pol.dk", "https://www.google.dk",
    "https://phoronix.com", "http://www.i-dont-exist-sorry.com/",
    "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
    "http://docs.oracle.com",
    "http://imgur.com/", "http://www.imagemagick.org"
  };
  
  //Public so URL's can be reused in the parallel part
  public static String[] getHostList(){
    return hostList;
  }
  
  //Public so it can be reused in the  parallel part
  public static String getStatus(String url) throws IOException {

    String result = ANSI_RED_BACKGROUND + "Error"+ ANSI_RESET ;
    try {
      URL siteURL = new URL(url);
      HttpURLConnection connection = (HttpURLConnection) siteURL
              .openConnection();
      connection.setRequestMethod("GET");
      connection.connect();

      int code = connection.getResponseCode();
      if (code == 200) {
        result = ANSI_GREEN_BACKGROUND + "GREEN"+ ANSI_RESET ;
      }
      if (code == 301) {
        result = ANSI_YELLOW_BACKGROUND + "REDIRECT"+ ANSI_RESET ;
      }
    } catch (Exception e) {
      result = ANSI_RED_BACKGROUND + "RED"+ ANSI_RESET ;
    }
    return result;
  }

  public static void main(String args[]) throws Exception {

    long timeStart = System.nanoTime();
    for (String url : hostList) {
      String status = getStatus(url);
      System.out.println(url + "\t\tStatus:" + status);
    }
    long timeEnd = System.nanoTime();
    long total = (timeEnd - timeStart) / 1_000_000;
    System.out.println("Time to check URLS: " + total + "ms.");

  }

  
}
