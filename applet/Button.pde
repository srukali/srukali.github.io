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
  
void display(){
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
