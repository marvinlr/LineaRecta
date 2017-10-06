package OGeometricas;
import OGeometricas.*;
public class LineaRecta {
  public Punto p1; 
  public Punto p2;
  public LineaRecta linea2;
  public LineaRecta paralela;
  public  double m;
  public double distancia;
  public boolean existe;
public LineaRecta(Punto p1, Punto p2){
  this.p1=p1;
  this.p2=p2;
  this.linea2=linea2;
  this.existe=calExiste();
  this.m=calM();
}
public LineaRecta(LineaRecta linea2,double m){
 this.linea2=linea2;
 this.m=m;
 this.paralela=calParalela();
 //this.distancia=calDistancia();
}
public Punto getP1(){
    return p1;
}
public Punto getP2(){
    return p2;
}
public void setLina2(LineaRecta linea2){
   this.linea2=linea2; 
}
public boolean calExiste(){
    if(((p2.getX())-(p1.getX())) != 0){
    existe = true;    
    }
    else{
     existe = false;   
    }
   return existe;
}
public double calM(){
 return(p2.getY()-p1.getY())/(p2.getX()-p1.getX());   
}
public double calInterseccionY(){
 return  (-m*p1.getX()+p1.y); 
}
public double calInterseccionX(){
 return -calInterseccionY()/calM();   
}
public Punto calIntercecionLineas(LineaRecta linea2){
    double x,y;
    Punto p = null;
   if(((p2.getX())-(p1.getX())) != 0 && ((linea2.getP2().getX()))-(linea2.getP1().getX())!=0){
    x=((calInterseccionY()-linea2.calInterseccionY())/(linea2.calM()-calM()));
    y=calM()*(x)+(calInterseccionY());
   p= new Punto(x,y);
   }
   else if((p2.getX())-(p1.getX()) == 0){
    y=(linea2.calM()*p1.getX())+linea2.calInterseccionY();   
    p= new Punto(p1.getX(),y);   
   }
   else if(((linea2.getP2().getX()))-(linea2.getP1().getX())==0){
   y=(calM()*linea2.p1.getX())+calInterseccionY();   
    p= new Punto(linea2.getP1().getX(),y);   
   }
    return p; 
}
public LineaRecta calParalela(){
    Punto p=new Punto(-linea2.p2.getX(),linea2.p2.getY());
    double y2=(-linea2.calM()*p.getX())+p.getY();
    Punto pl=new Punto(linea2.p1.getX(),y2);
    LineaRecta l=new LineaRecta(pl,p);
    return l;
}
public double calDistancia(){
    double x=0;
    double y1=((linea2.calM()*x)+linea2.calInterseccionY());
    double y2=((calM()*x)+calInterseccionY());
    return Math.sqrt(Math.pow(x-x, 2)+Math.pow(y2-y1,2));
    //return Math.abs(((calM()*x)+y+calInterseccionY())/ Math.sqrt(Math.pow((calM())+y, 2)));
   }
public String toString(){
    if(existe){
     return("Resultado:\ncoordenada #1= "+p1.getDetails()+"\ncoordenada #2= "+p2.getDetails()+
             "\npenduente m= "+calM()+"\ninterseccion en el eje Y= "+calInterseccionY()+
             "\ninterseccion en el eje X= "+calInterseccionX());   
    }
    else{
     return("Resultado:\ncoordenada #1= "+p1.getDetails()+"\ncoordenada #2= "+p2.getDetails()+
             "\npenduente m= no cuenta con pendiente exacta"+"\ninterseccion en el eje Y= "+calInterseccionY()+
             "\ninterseccion en el eje X= "+getP1().getX());   
    }
}
public String toStringInt(){
   if(m-linea2.calM()!=0){
    return ("\nel punto de intercecion es entre las 2 rectas es: "+calIntercecionLineas(linea2).getDetails());   
  }
    else{
    return ("\nlas rectas son paralelas y tienen una distancia de: "+calDistancia());  
   }
}
}