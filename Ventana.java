import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.image.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Write a description of class Ventana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ventana extends JFrame
{
    private final Image imagen;
    private Panel panel;
    private Color colorDeFondo;

    public Ventana(int ancho, int alto)
    {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(ancho,alto);
        panel=new Panel();
        setContentPane(panel);
        this.colorDeFondo=Color.white;
        imagen = createImage(ancho, alto);
        
    }
    
    public void redraw()
    {
        panel.repaint();
    }
    
    public void dibujar(Shape e)
    {
        Graphics2D g = (Graphics2D)imagen.getGraphics();
        g.setColor(Color.red);
        g.fill(e);
    } 
    
    public Graphics2D getGraphics2D()
    {
        return (Graphics2D)imagen.getGraphics();
    }
    
    public void borrar()
    {
        Graphics2D g = (Graphics2D)imagen.getGraphics();
        g.setColor(colorDeFondo);
        
        Dimension d = panel.getSize();
        

        g.fillRect(0,0,d.width,d.height);
    }
 
    private class Panel extends JPanel
    {
        public void paint(Graphics g)
        {
            g.drawImage(imagen, 0, 0, null);
        }
    }
}
