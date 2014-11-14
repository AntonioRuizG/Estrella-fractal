
/**
 * Write a description of class Vector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vector
{
    public double x;
    public double y;
    public double z;
    public double modulo;

    /**
     * Constructor de objetos de clase Vector
     * @param x Coordenada x.
     * @param y Coordenada y.
     * @param z Coordenada z.
     */    
    public Vector(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        modulo = Math.sqrt(x*x + y*y + z*z);
    }
    
    /**
     * Constructor de objetos de clase Vector
     * @param p1 El punto inicial.
     * @param p2 El punto final.
     */    
    public Vector(Punto p1, Punto p2)
    {
        this.x = p1.x-p2.x;
        this.y = p1.y-p2.y;

        
        modulo = Math.sqrt(x*x + y*y);
    }
    
    /**
     * Multiplica el vector por un escalar.
     * @param f El escalar.
     */
    public void multiplicar(double f)
    {
         x*=f;
         y*=f;
         z*=f;
    }
    
    /**
     * Suma al vector otro vector dado.
     * @param v El vector a sumar
     */
    public void sumar(Vector v)
    {
         x+=v.x;
         y+=v.y;
         z+=v.z;
    }
    
    /**
     * Rota el vector.
     * @param radianes Los radianes a rotar.
     */
    public void rotar(double radianes)
    {
        double cos = Math.cos(radianes);
        double sin = Math.sin(radianes);
        
        double xn = x*cos - y*sin;
        double yn = x*sin + y*cos;
        x=xn;
        y=yn;
    }
    
    public double angulo(Vector v)
    {
        double m1= Math.sqrt(x*x + y*y);
        double m2= Math.sqrt(v.x*v.x + v.y*v.y);
        return Math.acos((x*v.x+y*v.y)/(m1*m2));
    }

    
}
