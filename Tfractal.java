import java.awt.*;
import javax.swing.*;
/**
 * Write a description of class Tfractal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tfractal
{
    
    /**
     * Constructor for objects of class Tfractal
     */
    public Tfractal(Punto p1,Punto p2, int n, Graphics2D g,double grados)
    {
        
        if (n==1) return;
        n--;
        
        g.drawLine((int)p1.x,(int)p1.y,(int)p2.x,(int)p2.y);
        Punto p3=p1.unTercio(p2).rotar(p2,(int)grados);
        
        Tfractal t1 = new Tfractal(p2,p3,n,g,grados);
        
        Punto p4=p1.unTercio(p2).rotar(p2,(int)grados/2);
        Tfractal t2 = new Tfractal(p2,p4,n,g,grados);
        
        
        
        
    }
    
    public static void main()
    {
        Ventana v = new Ventana(1000,1000);
        Graphics2D g=v.getGraphics2D();
        g.setStroke(new BasicStroke(2));
        
        Punto p1=new Punto(500,600);
        Punto p2=new Punto(500,450);
        Punto p3=new Punto(500,600);
        Punto p4=new Punto(650,600);
        Punto p5=new Punto(500,600);
        Punto p6=new Punto(350,600);
        Punto p7=new Punto(500,600);
        Punto p8=new Punto(500,750);
        
        
        Tfractal t;
        Tfractal t2;
        Tfractal t3;
        Tfractal t4;
        
        for (int i=0;i<=10800;i++){
            t=new Tfractal(p1,p2,12,g,i);
            t2=new Tfractal(p3,p4,12,g,i);
            t3=new Tfractal(p5,p6,12,g,i);
            t4=new Tfractal(p7,p8,12,g,i);
            
            v.redraw();
            try{Thread.sleep(20);}
            catch(Exception e){}
            v.borrar();
        }
        
        
    }
    
    
}
