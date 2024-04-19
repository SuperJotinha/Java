import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class Janela extends JFrame 
{
    protected static final long serialVersionUID = 1L;

    protected JButton btnPonto   = new JButton ("Ponto"),
                      btnLinha   = new JButton ("Linha"),
                      btnCirculo = new JButton ("Circulo"),
                      btnElipse  = new JButton ("Elipse"),
                      btnQuadrado = new JButton ("Quadrado"),
                      btnRetangulo = new JButton ("Retangulo"),
                      btnTexto   = new JButton ("Texto"),
                      btnCores   = new JButton ("Cores"),
                      btnAbrir   = new JButton ("Abrir"),
                      btnSalvar  = new JButton ("Salvar"),
                      btnApagar  = new JButton ("Apagar"),
                      btnSair    = new JButton ("Sair");

    protected MeuJPanel pnlDesenho = new MeuJPanel ();
    protected JLabel statusBar1 = new JLabel ("Mensagem:"),
                     statusBar2 = new JLabel ("Coordenada:");
    protected boolean esperaPonto, esperaInicioReta, esperaFimReta;
    protected Color corAtual = Color.BLACK;
    protected Ponto p1;
    protected Vector<Figura> figuras = new Vector<Figura>();
    protected boolean esperaCirculoPreenchido = false;
    protected boolean esperaCirculoVazado = false;
    protected boolean esperaElipsePreenchido = false;
    protected boolean esperaElipseVazado = false;
    protected boolean esperaQuadradoPreenchido = false;
    protected boolean esperaQuadradoVazado = false;
    protected boolean esperaRetanguloPreenchido = false;
    protected boolean esperaRetanguloVazado = false;
    protected boolean esperaTexto = false;

    

    protected void salvarDesenho() {
        JFileChooser fileChooser = new JFileChooser();
        int escolha = fileChooser.showSaveDialog(null);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                out.writeObject(figuras);
                JOptionPane.showMessageDialog(null, "Desenho salvo com sucesso!");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao salvar o desenho", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    protected void abrirDesenho() {
        JFileChooser fileChooser = new JFileChooser();
        int escolha = fileChooser.showOpenDialog(null);

        if (escolha == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(arquivo))) {
                Vector<Figura> figurasLidas = (Vector<Figura>) in.readObject();
                figuras.addAll(figurasLidas);
                pnlDesenho.repaint();
                JOptionPane.showMessageDialog(null, "Desenho carregado com sucesso!");
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao abrir o desenho", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Janela ()
    {
        super("Editor Gr�fico");

        try
        {
            Image btnPontoImg = ImageIO.read(getClass().getResource("ponto.jpg"));
            btnPonto.setIcon(new ImageIcon(btnPontoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo ponto.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnLinhaImg = ImageIO.read(getClass().getResource("linha.jpg"));
            btnLinha.setIcon(new ImageIcon(btnLinhaImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo linha.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCirculoImg = ImageIO.read(getClass().getResource("circulo.jpg"));
            btnCirculo.setIcon(new ImageIcon(btnCirculoImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo circulo.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnElipseImg = ImageIO.read(getClass().getResource("elipse.jpg"));
            btnElipse.setIcon(new ImageIcon(btnElipseImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo elipse.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnCoresImg = ImageIO.read(getClass().getResource("cores.jpg"));
            btnCores.setIcon(new ImageIcon(btnCoresImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo cores.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnAbrirImg = ImageIO.read(getClass().getResource("abrir.jpg"));
            btnAbrir.setIcon(new ImageIcon(btnAbrirImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo abrir.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSalvarImg = ImageIO.read(getClass().getResource("salvar.jpg"));
            btnSalvar.setIcon(new ImageIcon(btnSalvarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo salvar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnApagarImg = ImageIO.read(getClass().getResource("apagar.jpg"));
            btnApagar.setIcon(new ImageIcon(btnApagarImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo apagar.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }

        try
        {
            Image btnSairImg = ImageIO.read(getClass().getResource("sair.jpg"));
            btnSair.setIcon(new ImageIcon(btnSairImg));
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog (null,
                                           "Arquivo sair.jpg n�o foi encontrado",
                                           "Arquivo de imagem ausente",
                                           JOptionPane.WARNING_MESSAGE);
        }


        btnCores.addActionListener((ActionEvent e) -> {
            Color currentColor = corAtual;
            Color newColor = JColorChooser.showDialog(null, "Escolha uma cor", currentColor);
            if (newColor != null) {
                corAtual = newColor;
            }
            statusBar1.setText("Cor selecionada: " + corAtual);
        });
        
        this.setSize(700, 500);
        this.setVisible(true);

        btnSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDesenho();
            }
        });

        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                abrirDesenho();
            }
        });

        btnPonto.addActionListener(new DesenhoDePonto());
        btnLinha.addActionListener(new DesenhoDeReta());
        btnCirculo.addActionListener(new DesenhoDeCirculo());
        btnElipse.addActionListener(new DesenhoDeElipse());
        btnQuadrado.addActionListener(new DesenhoDeQuadrado());
        btnRetangulo.addActionListener(new DesenhoDeRetangulo());
        btnTexto.addActionListener(new DesenhoDeTexto());



        JPanel     pnlBotoes = new JPanel();
        FlowLayout flwBotoes = new FlowLayout(); 
        pnlBotoes.setLayout (flwBotoes);

        pnlBotoes.add (btnAbrir);
        pnlBotoes.add (btnSalvar);
        pnlBotoes.add (btnPonto);
        pnlBotoes.add (btnLinha);
        pnlBotoes.add (btnCirculo);
        pnlBotoes.add (btnElipse);
        pnlBotoes.add (btnQuadrado);
        pnlBotoes.add (btnRetangulo);
        pnlBotoes.add (btnTexto);
        pnlBotoes.add (btnCores);
        pnlBotoes.add (btnApagar);
        pnlBotoes.add (btnSair);

        JPanel     pnlStatus = new JPanel();
        GridLayout grdStatus = new GridLayout(1,2);
        pnlStatus.setLayout(grdStatus);

        pnlStatus.add(statusBar1);
        pnlStatus.add(statusBar2);

        Container cntForm = this.getContentPane();
        cntForm.setLayout (new BorderLayout());
        cntForm.add (pnlBotoes,  BorderLayout.NORTH);
        cntForm.add (pnlDesenho, BorderLayout.CENTER);
        cntForm.add (pnlStatus,  BorderLayout.SOUTH);
        
        this.addWindowListener (new FechamentoDeJanela());

        this.setSize (700,500);
        this.setVisible (true);
    }

    protected class FechamentoDeJanela extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            salvarDesenho();
            System.exit(0);
        }
    }

    protected class MeuJPanel extends JPanel implements MouseListener, MouseMotionListener {
        private Linha linhaEmDesenho;
        private Ponto pontoInicial;
        private Ponto pontoFinal;
        private ArrayList<Linha> linhas;
        private ArrayList<Ponto> pontos;
        private Circulo circuloEmDesenho;
        private ArrayList<Circulo> circulos;
        private Elipse elipseEmDesenho;
        

        public MeuJPanel() {
            super();
            this.addMouseListener(this);
            this.addMouseMotionListener(this);
            pontoInicial = null;
            pontoFinal = null;
            linhas = new ArrayList<>();
            pontos = new ArrayList<>();
            circuloEmDesenho = null;
            circulos = new ArrayList<>();
        }
    
        public void mouseClicked(MouseEvent e) {
            if (esperaPonto) {
                figuras.add(new Ponto(e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaPonto = false;
            } else if (esperaInicioReta) {
                p1 = new Ponto(e.getX(), e.getY(), corAtual);
                esperaInicioReta = false;
                esperaFimReta = true;
                statusBar1.setText("Mensagem: clique o ponto final da reta");
            } else if (esperaCirculoPreenchido) {
                int raio = 50; // Altere o raio conforme necessário
                figuras.add(new CirculoPreenchido(e.getX(), e.getY(), raio, corAtual)); // Adicione uma nova classe CirculoPreenchido
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaCirculoPreenchido = false;
                statusBar1.setText("Mensagem: círculo preenchido desenhado");
            } else if (esperaCirculoVazado) {
                int raio = 50; // Altere o raio conforme necessário
                figuras.add(new CirculoVazado(e.getX(), e.getY(), raio, corAtual)); // Adicione uma nova classe CirculoVazado
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                esperaCirculoVazado = false;
                statusBar1.setText("Mensagem: círculo vazado desenhado");
            } else if (esperaFimReta) {
                esperaInicioReta = false;
                esperaFimReta = false;
                figuras.add(new Linha(p1.getX(), p1.getY(), e.getX(), e.getY(), corAtual));
                figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                statusBar1.setText("Mensagem:");
            } else if (esperaElipsePreenchido || esperaElipseVazado) {
                int raio1 = 200; // Defina o raio 1 conforme necessário
                int raio2 = 200; // Defina o raio 2 conforme necessário
        
                if (e.getButton() == MouseEvent.BUTTON1) { // Verifica se o clique foi com o botão esquerdo do mouse
                    if (esperaElipsePreenchido) {
                        figuras.add(new Elipse(e.getX(), e.getY(), raio1, raio2, corAtual, true));
                        statusBar1.setText("Mensagem: elipse preenchida desenhada");
                    } else if (esperaElipseVazado) {
                        figuras.add(new Elipse(e.getX(), e.getY(), raio1, raio2, corAtual, false));
                        statusBar1.setText("Mensagem: elipse vazada desenhada");
                    }
                    figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                    esperaElipsePreenchido = false;
                    esperaElipseVazado = false;
                }
            } else if (esperaQuadradoPreenchido || esperaQuadradoVazado) {
                int lado = 100; // Altere o lado conforme necessário
        
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (esperaQuadradoPreenchido) {
                        figuras.add(new Quadrado(e.getX(), e.getY(), lado, corAtual, true));
                        statusBar1.setText("Mensagem: quadrado preenchido desenhado");
                    } else if (esperaQuadradoVazado) {
                        figuras.add(new Quadrado(e.getX(), e.getY(), lado, corAtual, false));
                        statusBar1.setText("Mensagem: quadrado vazado desenhado");
                    }
                    figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                    esperaQuadradoPreenchido = false;
                    esperaQuadradoVazado = false;
                }
            } else if (esperaRetanguloPreenchido || esperaRetanguloVazado) {
                int largura = 80; // Defina a largura conforme necessário
                int altura = 50; // Defina a altura conforme necessário
        
                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (esperaRetanguloPreenchido) {
                        figuras.add(new Retangulo(e.getX(), e.getY(), largura, altura, corAtual, true));
                        statusBar1.setText("Mensagem: retângulo preenchido desenhado");
                    } else if (esperaRetanguloVazado) {
                        figuras.add(new Retangulo(e.getX(), e.getY(), largura, altura, corAtual, false));
                        statusBar1.setText("Mensagem: retângulo vazado desenhado");
                    }
                    figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                    esperaRetanguloPreenchido = false;
                    esperaRetanguloVazado = false;
                }
            }  if (esperaTexto) {
                String texto = JOptionPane.showInputDialog("Digite o texto:");
                if (texto != null) {
                    Font fonte = new Font("Arial", Font.PLAIN, 12); // Exemplo de fonte, ajuste conforme necessário
                    figuras.add(new Texto(e.getX(), e.getY(), texto, fonte, corAtual));
                    figuras.get(figuras.size() - 1).torneSeVisivel(pnlDesenho.getGraphics());
                    esperaTexto = false;
                    statusBar1.setText("Mensagem:");
                }
            }
        }
        
        public void mousePressed(MouseEvent e) {
            if (esperaInicioReta) {
                pontoInicial = new Ponto(e.getX(), e.getY(), corAtual);
                pontoFinal = new Ponto(e.getX(), e.getY(), corAtual);
                esperaInicioReta = false;
                esperaFimReta = true;
                statusBar1.setText("Mensagem: arraste para definir o segundo ponto da reta");
            }
        }

        public void mouseEntered (MouseEvent e) {}

        public void mouseExited (MouseEvent e) {}

        public void mouseDragged(MouseEvent e) {
            if (esperaFimReta) {
                pontoFinal.setX(e.getX());
                pontoFinal.setY(e.getY());
                repaint();
                if (circuloEmDesenho != null) {
                    int raio = (int) Math.sqrt(Math.pow(e.getX() - circuloEmDesenho.getCentro().getX(), 2)
                            + Math.pow(e.getY() - circuloEmDesenho.getCentro().getY(), 2));
                    circuloEmDesenho.setRaio(raio);
                    repaint();
                }
            }
        }
        
        public void mouseMoved(MouseEvent e) {
            statusBar2.setText("Coordenada: " + e.getX() + "," + e.getY());

            if (linhaEmDesenho != null && esperaFimReta) {
                linhaEmDesenho.atualizarPonto2(e.getX(), e.getY());
                pnlDesenho.repaint();
            }
        }

        public void mouseReleased(MouseEvent e) {
            if (esperaFimReta) {
                esperaFimReta = false;
                Linha linha = new Linha(pontoInicial.getX(), pontoInicial.getY(), pontoFinal.getX(), pontoFinal.getY(), corAtual);
                linhas.add(linha);
                statusBar1.setText("Mensagem:");
                pontoInicial = null;
                pontoFinal = null;
                repaint();
                if (circuloEmDesenho != null) {
                    int raio = (int) Math.sqrt(Math.pow(e.getX() - circuloEmDesenho.getCentro().getX(), 2)
                            + Math.pow(e.getY() - circuloEmDesenho.getCentro().getY(), 2));
                    circuloEmDesenho.setRaio(raio); // Definindo o raio final do círculo
                    circuloEmDesenho = null; // Finalizando o desenho do círculo
                    repaint();
                }                
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(5)); // Definindo a espessura da linha para 5
            g2d.setColor(corAtual);
            for (Linha linha : linhas) {
                linha.torneSeVisivel(g2d);
            }
            if (pontoInicial != null && pontoFinal != null) {
                g2d.drawLine(pontoInicial.getX(), pontoInicial.getY(), pontoFinal.getX(), pontoFinal.getY());
            } for (Circulo circulo : circulos) {
                circulo.torneSeVisivel(g2d);
            }

            if (circuloEmDesenho != null) {
                circuloEmDesenho.torneSeVisivel(g2d);
            }
        }
    }

      
    protected class DesenhoDePonto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaPonto = true;
            esperaInicioReta = false;
            esperaFimReta = false;
            statusBar1.setText("Mensagem: clique o local do ponto desejado");
        }
    }

    protected class DesenhoDeReta implements ActionListener
    {
        public void actionPerformed (ActionEvent e)    
        {
            esperaPonto      = false;
            esperaInicioReta = true;
            esperaFimReta    = false;

            statusBar1.setText("Mensagem: clique o ponto inicial da reta");
        }
    }

    protected class DesenhoDeCirculo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Preenchido", "Vazado"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de círculo:",
                    "Tipo de Círculo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
    
            if (escolha == 0) { // Se a opção escolhida for "Preenchido"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoPreenchido = true; // Marcamos que estamos esperando por um círculo preenchido
                statusBar1.setText("Mensagem: clique o local do círculo preenchido desejado");
            } else if (escolha == 1) { // Se a opção escolhida for "Vazado"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoVazado = true; // Marcamos que estamos esperando por um círculo vazado
                statusBar1.setText("Mensagem: clique o local do círculo vazado desejado");
            }
        }
    }  
    protected class DesenhoDeElipse implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Preenchida", "Vazia"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de elipse:",
                    "Tipo de Elipse", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
    
            if (escolha == 0) { // Se a opção escolhida for "Preenchida"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaElipsePreenchido = true; // Marcamos que estamos esperando por uma elipse preenchida
                esperaElipseVazado = false; // Garantimos que não estamos esperando por uma elipse vazada
    
                statusBar1.setText("Mensagem: clique o local da elipse preenchida desejada");
            } else if (escolha == 1) { // Se a opção escolhida for "Vazia"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaElipsePreenchido = false; // Garantimos que não estamos esperando por uma elipse preenchida
                esperaElipseVazado = true; // Marcamos que estamos esperando por uma elipse vazada
    
                statusBar1.setText("Mensagem: clique o local da elipse vazada desejada");
            }
        }
    }
    protected class DesenhoDeQuadrado implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Preenchido", "Vazado"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de quadrado:",
                    "Tipo de Quadrado", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
    
            if (escolha == 0) { // Se a opção escolhida for "Preenchido"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoPreenchido = false;
                esperaCirculoVazado = false;
                esperaElipsePreenchido = false;
                esperaElipseVazado = false;
                esperaQuadradoPreenchido = true; // Marcamos que estamos esperando por um quadrado preenchido
                statusBar1.setText("Mensagem: clique o local do quadrado preenchido desejado");
            } else if (escolha == 1) { // Se a opção escolhida for "Vazado"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoPreenchido = false;
                esperaCirculoVazado = false;
                esperaElipsePreenchido = false;
                esperaElipseVazado = false;
                esperaQuadradoVazado = true; // Marcamos que estamos esperando por um quadrado vazado
                statusBar1.setText("Mensagem: clique o local do quadrado vazado desejado");
            }
        }
    }

    protected class DesenhoDeRetangulo implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] options = {"Preenchido", "Vazado"};
            int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de retângulo:",
                    "Tipo de Retângulo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
    
            if (escolha == 0) { // Se a opção escolhida for "Preenchido"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoPreenchido = false;
                esperaCirculoVazado = false;
                esperaElipsePreenchido = false;
                esperaElipseVazado = false;
                esperaQuadradoPreenchido = false;
                esperaQuadradoVazado = false;
                esperaRetanguloPreenchido = true; // Marcamos que estamos esperando por um retângulo preenchido
                statusBar1.setText("Mensagem: clique o local do retângulo preenchido desejado");
            } else if (escolha == 1) { // Se a opção escolhida for "Vazado"
                esperaPonto = false;
                esperaInicioReta = false;
                esperaFimReta = false;
                esperaCirculoPreenchido = false;
                esperaCirculoVazado = false;
                esperaElipsePreenchido = false;
                esperaElipseVazado = false;
                esperaQuadradoPreenchido = false;
                esperaQuadradoVazado = false;
                esperaRetanguloVazado = true; // Marcamos que estamos esperando por um retângulo vazado
                statusBar1.setText("Mensagem: clique o local do retângulo vazado desejado");
            }
        }
    }

    protected class DesenhoDeTexto implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            esperaTexto = true;
            statusBar1.setText("Mensagem: clique para inserir texto");
        }
    }
}
