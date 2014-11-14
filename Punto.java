
/**
 * Representa un punto en un espacio de 2 dimensiones.
 * 
 * @author Antonio Ruiz Gutierrez
 * @version 1.0.0
 */
public class Punto
{
    public double x;
    public double y;


    /**
     * Constructor de objetos de clase Punto.
     * @param x Coordenada x.
     * @param y Coordenada y.
     */
    public Punto(double x, double y)
    {
        this.x = x;
        this.y = y;

    }
    
    public Punto(Punto p)
    {
        this.x = p.x;
        this.y = p.y;

    }
    
    /**
     * Transforma el punto con un vector.
     * @param v El vector de transformacion.
     * @return El punto transformado.
     */
    public Punto transformar(Vector v)
    {
        return new Punto(x + v.x, y + v.y);
    }
    
    /**
     * Rota el punto alrededor de otro punto los grados dados.
     * @param p el centro de rotacion.
     * @param radianes Los radianes a rotar.
     * @return El punto transformado.
     */
    public Punto rotar(Punto c,int grados)
    {
        double rad=grados*2*Math.PI/360;

        double cos = Math.cos(rad);
        double sin = Math.sin(rad);
        
        double xn = c.x + (x-c.x)*cos - (y-c.y)*sin;
        double yn = c.y + (x-c.x)*sin + (y-c.y)*cos;
        return new Punto(xn,yn);
    }
    

    
    public Punto unTercio(Punto p2)
    {
        return new Punto((p2.x+x*2)/3,(p2.y+y*2)/3);
    }
    
    public Punto dosTercios(Punto p2)
    {
        return new Punto((p2.x*2+x)/3,(p2.y*2+y)/3);
    }
    
    public Punto puntoMedio(Punto p2)
    {
        return new Punto((x+p2.x)/2,(y+p2.y)/2);
    }
    
}
