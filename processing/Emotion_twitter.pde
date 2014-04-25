//With help from the tutorial here: http://codasign.com/tutorials/processing-and-twitter/
import twitter4j.conf.*;
import twitter4j.auth.*;
import twitter4j.api.*;
import twitter4j.*;
import java.util.*;

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

void setup()
{
    size(800,600);
    tc.getNewTweets();
    particleArray = new Particle[200];
    particleCloud = new ParticleCloud(particleArray);
    
    //fill cloud with particles
    particleCloud.makeParticlesSad();
    particleCloud.makeParticlesHappy();
}

void draw(){
  
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
  void refreshTweets(){
      while (true){
          tc.getNewTweets();
          delay(100000);
      }
  }

//Method to change location when a button is clicked
//TODO: change from hardcode
void mousePressed(){
    
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
