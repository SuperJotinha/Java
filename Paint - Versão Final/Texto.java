import java.awt.*;

public class Texto extends Figura {
    private String texto;
    private int x;
    private int y;
    private Font font;

    public Texto(int x, int y, String texto, Font font, Color cor) {
        this.cor = cor;
        this.x = x;
        this.y = y;
        this.texto = texto;
        this.font = font;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return font;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        g.setFont(font);
        g.drawString(texto, x, y);
    }

    @Override
    public String toString() {
        return "Texto: " + texto + " Posição: (" + x + ", " + y + ")";
    }
}
