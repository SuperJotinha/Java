import java.awt.*;

public class Quadrado extends Figura {
    protected Ponto cantoSuperiorEsquerdo;
    protected int lado;
    protected boolean preenchido;

    // Construtor para um quadrado com informações sobre preenchimento
    public Quadrado(int x, int y, int lado, Color corAtual, boolean preenchido) {
        super(corAtual);
        this.cantoSuperiorEsquerdo = new Ponto(x, y);
        this.lado = lado;
        this.preenchido = preenchido;
    }

    // Métodos getters e setters para preenchido
    public boolean isPreenchido() {
        return preenchido;
    }

    public void setPreenchido(boolean preenchido) {
        this.preenchido = preenchido;
    }

    public void setCantoSuperiorEsquerdo(int x, int y) {
        this.cantoSuperiorEsquerdo = new Ponto(x, y, this.getCor());
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    public Ponto getCantoSuperiorEsquerdo() {
        return this.cantoSuperiorEsquerdo;
    }

    public int getLado() {
        return this.lado;
    }

    public void torneSeVisivel(Graphics g) {
        g.setColor(this.cor);
        if (preenchido) {
            g.fillRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), lado, lado);
        } else {
            g.drawRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), lado, lado);
        }
    }

    public void torneSeVisivelPreenchido(Graphics g) {
        g.setColor(this.cor);
        g.fillRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), lado, lado);
    }

    // Método equivalente a CirculoVazado
    public void torneSeVisivelVazado(Graphics g) {
        g.setColor(this.cor);
        g.drawRect(this.cantoSuperiorEsquerdo.getX(), this.cantoSuperiorEsquerdo.getY(), lado, lado);
    }

    public String toString() {
        return "q:" +
                this.cantoSuperiorEsquerdo.getX() +
                ":" +
                this.cantoSuperiorEsquerdo.getY() +
                ":" +
                this.lado +
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
