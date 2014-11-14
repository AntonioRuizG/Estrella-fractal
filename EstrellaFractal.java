import java.awt.geom.*;
import java.awt.*;
import java.util.*;


public class EstrellaFractal
{

    private Path2D forma;
    private int fase;
    
    /**
     * Constructor for objects of class EstrellaFractal
     */
    public EstrellaFractal(Punto centro,Punto p1,int prof,int fase)
    {
        forma = new Path2D.Double();
        forma.moveTo(p1.x,p1.y);
        Punto p2 = p1.rotar(centro,120);
        Punto p3 = p2.rotar(centro,120);
        LadoFractal(p1,p2,prof);
        forma.lineTo(p2.x,p2.y);
        LadoFractal(p2,p3,prof);
        forma.lineTo(p3.x,p3.y);
        LadoFractal(p3,p1,prof); 

    }
    
    public Shape getShape()
    {
        return forma;
    }
    
    private void LadoFractal(Punto p1, Punto pf,int prof)
    {
        if (prof==0)
            return;
        
        prof--;
        Punto p2 = p1.unTercio(pf);
        LadoFractal(p1,p2,prof);
        forma.lineTo(p2.x,p2.y);
        Punto p3 = p1.dosTercios(pf).rotar(p2,300);
        LadoFractal(p2,p3,prof);
        forma.lineTo(p3.x,p3.y);
        Punto p4 = p1.dosTercios(pf);
        LadoFractal(p3,p4,prof);
        forma.lineTo(p4.x,p4.y);
        LadoFractal(p4,pf,prof);
    }
    
    public static void main(String [] args)
    {
        boolean vuelta = false;

        Punto centro = new Punto(500,500);
        Punto vertice =new Punto(500,450);
        Ventana v = new Ventana(1000,1000);
        
        EstrellaFractal es = new EstrellaFractal(centro,vertice,4,300);
        
        
        
        v.dibujar(es.getShape());
        v.redraw();
        
    }
    
}
