import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class SierpinskiTriangle extends PApplet {

public void setup()
{
	size(600,600);
}
public void draw()
{
	background((int)(Math.random()*255));
	sierpinski(300,300,600,4);
	sierpinski(100,500,200,4);
	sierpinski(500,500,200,4);
	sierpinski(300,500,200,4);
	sierpinski(200,300,200,4);
	sierpinski(400,300,200,4);
	sierpinski(300,100,200,4);
}
public void sierpinski(int x, int y, int len, int inheritCycle)
{
	fill(255);
	if(inheritCycle<=0)
	{
		//stroke(0);
		noStroke();
		//fill(55+(inheritCycle*50));
		fill((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		fill((int)(Math.random()*255));
		triangle(x-(int)(len/2), y+(int)(len/2), x-(int)(len/4), y, x, y+(int)(len/2));
		fill((int)(Math.random()*255));
		triangle(x-(int)(len/4), y, x, y-(int)(len/2), x+(int)(len/4), y);
		fill((int)(Math.random()*255));
		triangle(x, y+(int)(len/2), x+(int)(len/4), y, x+(int)(len/2), y+(int)(len/2));
	}
	if(inheritCycle>=0)
	{
		sierpinski(x-(int)(len/4),y+(int)(len/4),(int)(len/2),inheritCycle-1);
		sierpinski(x+(int)(len/4),y+(int)(len/4),(int)(len/2),inheritCycle-1);
		sierpinski(x,y-(int)(len/4),(int)(len/2),inheritCycle-1);
	}
	//triangle(x-(int)(len/2), y+(int)(len-2), x, y-(int)(len/2), x+(int)(len/2), y+(int)(len/2));  //Is the triangle base
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "SierpinskiTriangle" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
