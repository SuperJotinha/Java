import java.awt.*;
import java.util.*;

public class Elipse extends Figura {
    protected Ponto centro;
    protected int raio1, raio2;
    protected boolean preenchido;

    // Construtor para uma elipse com informações sobre preenchimento
    public Elipse(int x, int y, int raio1, int raio2, Color corAtual, boolean preenchido) {
        super(corAtual);
        this.centro = new Ponto(x, y);
        this.raio1 = raio1;
        this.raio2 = raio2;
        this.preenchido = preenchido;
    }

    // Métodos getters e setters para preenchido
    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }


    public void setCentro(int x, int y) {
        this.centro = new Ponto(x, y, this.getCor());
    }

    public void setRaio1(int r1) {
        this.raio1 = r1;
    }

    public void setRaio2(int r2) {
        this.raio2 = r2;
    }

    public Ponto getCentro() {
        return this.centro;
    }

    public int getRaio1() {
        return this.raio1;
    }

    public int getRaio2() {
        return this.raio2;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        if (preenchido) {
            g.fillOval(this.centro.getX() - raio1, this.centro.getY() - raio2, 2 * raio1, 2 * raio2);
        } else {
            g.drawOval(this.centro.getX() - raio1, this.centro.getY() - raio2, 2 * raio1, 2 * raio2);
        }
    }

    public String toString() {
        return "e:" +
                this.centro.getX() +
                ":" +
                this.centro.getY() +
                ":" +
                this.raio1 +
                ":" +
                this.raio2 +
                ":" +
                this.getCor().getRed() +
                ":" +
                this.getCor().getGreen() +
                ":" +
                this.getCor().getBlue() +
                ":" +
                this.preenchido;
    }
}