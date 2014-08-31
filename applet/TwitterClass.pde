class TwitterClass{
  
Twitter twitter;  
Location location = new Location();

//query search terms
String searchStringSad = ":(";
String searchStringHappy = ":)";

//tweet storage
List<Status> tweets;
List<Status> tweets2;
int currentTweet;
  
  TwitterClass(){
    
    //access tokens
    ConfigurationBuilder cb = new ConfigurationBuilder();
    cb.setOAuthConsumerKey("2c92gBCdOmCGYYTYCscuJw");
    cb.setOAuthConsumerSecret("u7ZfLWoSBp0QOfxaT56Qmiko7VQkaQLYVt229iLKaQw");
    cb.setOAuthAccessToken("2321471576-TA6IPuStgqMSuyYB0VA0Pc74BEvgqyS4WkoBYwq");
    cb.setOAuthAccessTokenSecret("G5JzWAkcS86SLgn5j3MVT7YU9V0NemGUfRvhthnM5TLUE");
    
    TwitterFactory tf = new TwitterFactory(cb.build());
    
    twitter = tf.getInstance();
    
    getNewTweets();
    currentTweet = 0;
    thread("refreshTweets");
    
  }
  
  void getNewTweets(){
    try {
        // try to get tweets here
        println("in here");
        Query querySad = new Query(searchStringSad);
        QueryResult resultSad = twitter.search(querySad.geoCode(new GeoLocation(location.getLat(),location.getLon()), location.getSearchRadius(), location.getRadiusUnit()).count(100));
                println("in here");

        Query queryHappy = new Query(searchStringHappy);
        QueryResult resultHappy = twitter.search(queryHappy.geoCode(new GeoLocation(location.getLat(),location.getLon()), location.getSearchRadius(), location.getRadiusUnit()).count(100));
                println("in here");

        tweets = resultSad.getTweets();
        tweets2 = resultHappy.getTweets();    
    } 
    
    catch (TwitterException te) {
    // deal with the case where we can't get them here
    System.out.println("Failed to search tweets: " + te.getMessage());
    System.exit(-1);
    }
}

  //method that updates the tweets every 10 sec
  void refreshTweets(){
      while (true){
          getNewTweets();
          delay(100000);
      }
  }
  
  List<Status> getTweets(){
    return tweets;
  }
  
  List<Status> getTweets2(){
    return tweets2;
  }
  
  int tweetCount(){
    return tweets.size();
  }
  
  int tweetCount2(){
    return tweets2.size();
  }
  
 void setLocation(){
    
  if (mouseX >= 650 && mouseX <= 650+60 && 
      mouseY >= 100-15 && mouseY <= 100){
    location = new Location(1);
  }
  else if(mouseX >= 650 && mouseX <= 650+60 && 
      mouseY >= 120-15 && mouseY <= 120){
    location = new Location(2);
  }
  else if(mouseX >= 650 && mouseX <= 650+75 && 
      mouseY >= 140-15 && mouseY <= 140){
    location = new Location(3);
  }
  else if(mouseX >= 650 && mouseX <= 650+75 && 
      mouseY >= 160-15 && mouseY <= 160){
    location = new Location(4);
  }
  else if(mouseX >= 650 && mouseX <= 650+100 && 
      mouseY >= 180-15 && mouseY <= 180){
    location = new Location(5);
  }
  else{
    //do nothing
  } 
}
  
}
