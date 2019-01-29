void setup(){
   background(255);
   size(600,600);
   rectMode(CENTER);
   ellipseMode(CENTER);
   circleDraw(width/2, height/2, height);
}

void draw(){
  
}

void circleDraw(float xLoc, float yLoc, float diameter){
   if(diameter > 5){
     
     fill((float) Math.random() * 256, (float) Math.random() * 256, (float) Math.random() * 256);
     
     ellipse(xLoc,yLoc, diameter, diameter);
     float y = quadratic(-2.0, -(diameter/2), (float) Math.pow(diameter/2,2));
     float baseLength = 2 * ((float) Math.sqrt(Math.pow(diameter/2, 2 ) - Math.pow(y, 2 )));
     
     fill((float) Math.random() * 256, (float) Math.random() * 256, (float) Math.random() * 256);

     triangle(xLoc, yLoc - diameter/2, xLoc - baseLength/2, yLoc+y, xLoc + baseLength/2, yLoc+y);
     
     circleDraw((float)(xLoc + diameter/3),yLoc, (float) (diameter / 3));
     circleDraw((float)(xLoc - diameter/3),yLoc, (float) (diameter / 3));
     circleDraw(xLoc,(float)(yLoc - diameter/3), (float) (diameter / 3));
     circleDraw(xLoc,(float)(yLoc + diameter/3), (float) (diameter / 3));
     
     circleDraw(xLoc,yLoc, (float) (diameter / 3));
     
     circleDraw((float)(xLoc + diameter/3.65),(float)(yLoc + diameter/3.65), (float) (diameter / 4.45));
     circleDraw((float)(xLoc - diameter/3.65),(float)(yLoc + diameter/3.65), (float) (diameter / 4.45));
     circleDraw((float)(xLoc + diameter/3.65),(float)(yLoc - diameter/3.65), (float) (diameter / 4.45));
     circleDraw((float)(xLoc - diameter/3.65),(float)(yLoc - diameter/3.65), (float) (diameter / 4.45));
   }
   
}

float quadratic(float a, float b, float c){
  return (-b - sqrt( b*b - 4*a*c)) / (2*a);
}
   
   

   
   