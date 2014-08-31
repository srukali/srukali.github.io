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

  void display() {
    move();
    noStroke();
    fill(r, g, b, a);
    ellipse(x, y, 10, 10);
    fill(r, b, g, 40);
    ellipse(x, y, 2, 2);
  }
  
  void move() {
    x = map(noise(xTime),0,1,0,radius);
    y = map(noise(yTime),0,1,0,radius);
    xTime += 0.001;
    yTime += 0.001;
  }
}

