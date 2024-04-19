import java.awt.*;

public class Retangulo extends Figura {
    protected Ponto cantoSuperiorEsquerdo;
    protected int largura;
    protected int altura;
    protected boolean preenchido;

    public Retangulo(int x, int y, int largura, int altura, Color corAtual, boolean preenchido) {
        super(corAtual);
        this.cantoSuperiorEsquerdo = new Ponto(x, y);
        this.largura = largura;
        this.altura = altura;
        this.preenchido = preenchido;
    }

    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }

    public void setCantoSuperiorEsquerdo(int x, int y) {
        this.cantoSuperiorEsquerdo = new Ponto(x, y, this.getCor());
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Ponto getCantoSuperiorEsquerdo() {
        return this.cantoSuperiorEsquerdo;
    }

    public int getLargura() {
        return this.largura;
    }

    public int getAltura() {
        return this.altura;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        if (preenchido) {
            g.fillRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), largura, altura);
        } else {
            g.drawRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), largura, altura);
        }
    }

    public void torneSeVisivelPreenchido(Graphics g) {
        g.setColor(this.cor);
        g.fillRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), largura, altura);
    }

    public void torneSeVisivelVazado(Graphics g) {
        g.setColor(this.cor);
        g.drawRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), largura, altura);
    }

    public String toString() {
        return "r:" +
                this.cantoSuperiorEsquerdo.getX() +
                ":" +
                this.cantoSuperiorEsquerdo.getY() +
                ":" +
                this.largura +
                ":" +
                this.altura +
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
