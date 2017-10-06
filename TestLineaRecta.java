package OGeometricas;
import OGeometricas.*;
public class TestLineaRecta {
   public static void main(String[]args){
  Punto p1=new Punto(-1.0,5.0);
  Punto p2=new Punto(-3.0,3.0); 
  Punto p3=new Punto(0.0,0.0);
  Punto p4=new Punto(2.0,2.0);
  LineaRecta linea1=new  LineaRecta(p1,p2);
  LineaRecta linea2=new  LineaRecta(p3,p4);
  linea1.setLina2(linea2);
  System.out.println("LINEA #1\n"+linea1.toString());
  System.out.println("LINEA #2\n"+linea2.toString());
 System.out.println(""+linea1.toStringInt());

}
}
