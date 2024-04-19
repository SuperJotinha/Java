import java.awt.Color;
import java.awt.Graphics;
import java.util.StringTokenizer;

public class Circulo extends Figura {
    protected Ponto centro;
    protected int raio;

    public Circulo(int x, int y, int r) {
        this(x, y, r, Color.BLACK);
    }

    public Circulo(int x, int y, int r, Color cor) {
        super(cor);
        this.centro = new Ponto(x, y);
        this.raio = r;
    }

    public Circulo(String s) {
        StringTokenizer quebrador = new StringTokenizer(s, ":");

        quebrador.nextToken();

        int x = Integer.parseInt(quebrador.nextToken());
        int y = Integer.parseInt(quebrador.nextToken());

        int r = Integer.parseInt(quebrador.nextToken());

        Color cor = new Color(Integer.parseInt(quebrador.nextToken()), Integer.parseInt(quebrador.nextToken()),
                Integer.parseInt(quebrador.nextToken()));

        this.centro = new Ponto(x, y, cor);
        this.raio = r;
        this.cor = cor;
    }

    public void setCentro(int x, int y) {
        this.centro = new Ponto(x, y, this.getCor());
    }

    public void setRaio(int r) {
        this.raio = r;
    }

    public Ponto getCentro() {
        return this.centro;
    }

    public int setRaio() {
        return this.raio;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.drawOval(this.centro.getX() - raio, this.centro.getY() - raio, 2 * raio, 2 * raio);
    }

    public String toString() {
        return "c:" + this.centro.getX() + ":" + this.centro.getY() + ":" + this.raio + ":" + this.getCor().getRed()
                + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
    }
}

class CirculoPreenchido extends Circulo {
    public CirculoPreenchido(int x, int y, int raio, Color cor) {
        super(x, y, raio, cor);
    }

    @Override
    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.fillOval(this.centro.getX() - raio, this.centro.getY() - raio, 2 * raio, 2 * raio);
    }

    @Override
    public String toString() {
        return "cp:" + this.centro.getX() + ":" + this.centro.getY() + ":" + this.raio + ":" + this.getCor().getRed()
                + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
    }
}

class CirculoVazado extends Circulo {
    public CirculoVazado(int x, int y, int raio, Color cor) {
        super(x, y, raio, cor);
    }

    @Override
    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.drawOval(this.centro.getX() - raio, this.centro.getY() - raio, 2 * raio, 2 * raio);
    }

    @Override
    public String toString() {
        return "cv:" + this.centro.getX() + ":" + this.centro.getY() + ":" + this.raio + ":" + this.getCor().getRed()
                + ":" + this.getCor().getGreen() + ":" + this.getCor().getBlue();
    }
}
