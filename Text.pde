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
  
  void display(){
    
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
  
  void updateCount(){
    font = loadFont("AlegreyaSansSC-Regular-48.vlw");
    textFont(font, 32);
    text(tc.tweetCount2(), 620, 500);
    text(tc.tweetCount(), 690, 500);
  }
  
}
