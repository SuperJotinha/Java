import java.awt.*;
import java.util.*;

public class Linha extends Figura
{
    protected Ponto p1, p2;
    
    public Linha (int x1, int y1, int x2, int y2)
    {
        this (x1, y1, x2, y2, Color.BLACK);
    }
	
    public Linha (int x1, int y1, int x2, int y2, Color cor)
    {
        super(cor);

        this.p1 = new Ponto (x1,y1,cor);
        this.p2 = new Ponto (x2,y2,cor);
    }

    public Linha (String s)
    {
        StringTokenizer quebrador = new StringTokenizer(s,":");

        quebrador.nextToken();

        int   x1  = Integer.parseInt(quebrador.nextToken());
        int   y1  = Integer.parseInt(quebrador.nextToken());

        int   x2  = Integer.parseInt(quebrador.nextToken());
        int   y2  = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color (Integer.parseInt(quebrador.nextToken()),  // R
                               Integer.parseInt(quebrador.nextToken()),  // G
                               Integer.parseInt(quebrador.nextToken())); // B

        this.p1  = new Ponto (x1,y1,cor);
        this.p2  = new Ponto (x2,y2,cor);
        this.cor = cor;
    }

    public void setP1 (int x, int y)
    {
        this.p1 = new Ponto (x,y,this.getCor());
    }

    public void setP2 (int x, int y)
    {
        this.p2 = new Ponto (x,y,this.getCor());
    }

    public void setP2Continuo(int x, int y) {
        this.p2 = new Ponto(x, y, this.getCor());
    }

    public Ponto getP1 ()
    {
        return this.p1;
    }

    public Ponto getP2 ()
    {
        return this.p2;
    }

    public void torneSeVisivel (Graphics g)
    {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(this.cor);

    // Configurar a largura da linha para 3 pixels (por exemplo)
    float espessuraLinha = 5.0f;
    g2d.setStroke(new BasicStroke(espessuraLinha));

    g2d.drawLine(
        this.p1.getX(), this.p1.getY(),
        this.p2.getX(), this.p2.getY()
    );
    }

    public String toString()
    {
        return "r:" +
               this.p1.getX() +
               ":" +
               this.p1.getY() +
               ":" +
               this.p2.getX() +
               ":" +
               this.p2.getY() +
               ":" +
               this.getCor().getRed() +
               ":" +
               this.getCor().getGreen() +
               ":" +
               this.getCor().getBlue();
    }

    public void atualizarPonto2(int x, int y) 
    {
        this.p2 = new Ponto(x, y, this.getCor());
    }
}