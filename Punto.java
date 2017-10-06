package OGeometricas;


public class Punto {
   public double x,y;
   public Punto(double x,double y){
       this.x=x;
       this.y=y;
   }
   public String getDetails(){
       return("("+x+","+y+")");
   }
   public double getX(){
       return x;
   }
   public double getY(){
       return y;
   }
   public void setX(double x){
     this.x=x;  
   }
   public void setY(double y){
     this.y=y;  
   }
   public void translate(double h, double v){
     x+=v;
     y+=h;
   }
   }
