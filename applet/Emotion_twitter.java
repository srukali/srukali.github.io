import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import twitter4j.conf.*; 
import twitter4j.auth.*; 
import twitter4j.api.*; 
import twitter4j.*; 
import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Emotion_twitter extends PApplet {

//With help from the tutorial here: http://codasign.com/tutorials/processing-and-twitter/






//Twitter variable
TwitterClass tc = new TwitterClass();

//background
int alphaBG = 100; 

//particle variables
Particle[] particleArray;
ParticleCloud particleCloud;

//location variable
Location location = new Location();

//Button variable
Text text = new Text();

public void setup()
{
    size(800,600);
    tc.getNewTweets();
    particleArray = new Particle[200];
    particleCloud = new ParticleCloud(particleArray);
    
    //fill cloud with particles
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
}

public void draw(){
  
    //display background
    fill(0, alphaBG);
    rect(0, 0, width, height);
    
    //display text
    fill(50);
    text.updateCount();
    text.display();

    particleCloud.display();
}

  //method that updates the tweets every 10 sec
  public void refreshTweets(){
      while (true){
          tc.getNewTweets();
          delay(100000);
      }
  }

//Method to change location when a button is clicked
//TODO: change from hardcode
public void mousePressed(){
    
  if (mouseX >= 650 && mouseX <= 650+60 && 
      mouseY >= 100-15 && mouseY <= 100){
    tc.setLocation();
    tc.getNewTweets();
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
  }
  else if(mouseX >= 650 && mouseX <= 650+60 && 
      mouseY >= 120-15 && mouseY <= 120){
    tc.setLocation();
    tc.getNewTweets();
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
  }
  else if(mouseX >= 650 && mouseX <= 650+75 && 
      mouseY >= 140-15 && mouseY <= 140){
    tc.setLocation();
    tc.getNewTweets();
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
  }
  else if(mouseX >= 650 && mouseX <= 650+75 && 
      mouseY >= 160-15 && mouseY <= 160){
    tc.setLocation();
    tc.getNewTweets();
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();    
  }
  else if(mouseX >= 650 && mouseX <= 650+100 && 
      mouseY >= 180-15 && mouseY <= 180){
    tc.setLocation();
    tc.getNewTweets();
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
  }
  else{
    //do nothing
  } 
}
class Button{
int _x, _y, _width, _height;
String city;
Location location;
  
  Button(int x, int y, int width, int height, String string){
    _x = x;
    _y = y;
    _width = width;
    _height = height;
    city = string;
    
    display();
  }
  
public void display(){
    if (mouseX >= _x && mouseX <= _x+_width && 
      mouseY >= _y-_height && mouseY <= _y){
      fill(155);
      text(city, _x, _y);
    } 
    else {
      fill(50);
      text(city, _x, _y);
    }
}
  
}
class Location{
double lat, lon, searchRadius;
String radiusUnit;
  
  Location(){
    //default Atlanta
    lat = 33.74f;
    lon = -84.83f;
    searchRadius = 10;
    radiusUnit = "mi";
  }
  
  Location(int num){
    searchRadius = 10;
    radiusUnit = "mi";
    
    if(num == 1){
      //Atlanta
      lat = 33.74f;
      lon = -84.83f;
    }
    else if(num == 2){
      //Chicago
      lat = 41.87f;
      lon = -87.63f;
    }
    else if(num == 3){
      //Las Vegas
      lat = 36.12f;
      lon = -115.17f;
    }
    else if(num == 4){
      //New York
      lat = 40.73f;
      lon = -73.99f;
    }
    else if(num == 5){
      //San Francisco
      lat = 37.77f;
      lon = -122.42f;
    }
    else{
      //do nothing
    }
  }
  
  public double getLat(){
    println("lat: " + lat);
    return lat;
  }
  
  public double getLon(){
    return lon;
  }
  
  public double getSearchRadius(){
    return searchRadius;
  }
  
  public String getRadiusUnit(){
    return radiusUnit;
  }
  
}
class Particle {
  float x, y, a, xTime, yTime, radius;
  int r, g, b;

  Particle(int red, int green, int blue) {
    x = random(width);
    y = random(height);
    r = red;
    g = green;
    b = blue;
    radius = 650;
    a = 70;
    xTime = random(100);
    yTime = random(100);
  }
  
  Particle(){
    x = random(width);
    y = random(height);
    radius = 650;
    a = 70;
    xTime = random(100);
    yTime = random(100);
  }

  public void display() {
    move();
    noStroke();
    fill(r, g, b, a);
    ellipse(x, y, 10, 10);
    fill(r, b, g, 40);
    ellipse(x, y, 2, 2);
  }
  
  public void move() {
    x = map(noise(xTime),0,1,0,radius);
    y = map(noise(yTime),0,1,0,radius);
    xTime += 0.001f;
    yTime += 0.001f;
  }
}

class ParticleCloud {
  
  Particle[] particles = new Particle[200];
  List<Status> tweets = tc.getTweets();
  List<Status> tweets2 = tc.getTweets2();

  ParticleCloud(Particle[] _particles) {
    particles = _particles;
  }

  ParticleCloud() {
    //particles = new Particle[200];
    for (int i = 0; i < particles.length; i++) {
      particles[i] = new Particle(0,255,0);
    }
  }

  //method that generates "sad" particles into an array
  public void makeParticlesSad(){
    for(int i = 0; i < tweets.size(); i++){
      particleArray[i] = new Particle(0,0,255);
    }
  }
  
  //method that generates "happy" particles into an array
  public void makeParticlesHappy(){
    for(int i = tweets.size(); i < (tweets.size() + tweets2.size()); i++){
      particleArray[i] = new Particle(0,255,0);
    }
  }

  public void display() {
    for (int i = 0; i < particles.length-1; i++) {
      if(particles[i] != null){
          particles[i].display();
      }
      else
        break;
    }
    
  }
}

class Text{
PFont font, font1, font2;
Button atlButton;
Button lvButton;
Button chiButton;
Button sfButton;
Button nyButton;
TwitterClass t = new TwitterClass();

  Text(){

  }
  
  public void display(){
    
    font1 = loadFont("AlegreyaSansSC-Light-48.vlw");
    textFont(font1, 40);
    text("E-motion", 30,50);
    
    font2 = loadFont("AlegreyaSansSC-Regular-48.vlw");
    textFont(font2, 16);
    text("Happy:", 620, 480);
    text("Sad:", 690, 480);
    text("A glance into the mood of Twitter", 30, 80);
    text("Chicago",650, 120);
    text("Las Vegas", 650, 140);
    text("New York", 650, 160);
    text("San Francisco", 650, 180);
    
    
    //create working buttons
    atlButton = new Button(650, 100, 60, 15, "Atlanta");
    chiButton = new Button(650, 120, 60, 15, "Chicago");
    lvButton = new Button(650, 140, 75, 15, "Las Vegas");
    nyButton = new Button(650, 160, 75, 15, "New York");
    sfButton = new Button(650, 180, 100, 15, "San Francisco");
  }
  
  public void updateCount(){
    font = loadFont("AlegreyaSansSC-Regular-48.vlw");
    textFont(font, 32);
    text(tc.tweetCount2(), 620, 500);
    text(tc.tweetCount(), 690, 500);
  }
  
}
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
  
  public void getNewTweets(){
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
  public void refreshTweets(){
      while (true){
          getNewTweets();
          delay(100000);
      }
  }
  
  public List<Status> getTweets(){
    return tweets;
  }
  
  public List<Status> getTweets2(){
    return tweets2;
  }
  
  public int tweetCount(){
    return tweets.size();
  }
  
  public int tweetCount2(){
    return tweets2.size();
  }
  
 public void setLocation(){
    
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
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Emotion_twitter" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
