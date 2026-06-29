import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;
import java.util.List;

public class TelaBatalha extends JFrame implements BattleController.BattleListener {

    private static final Enemy[] INIMIGOS = {
            new Enemy("Bug Iniciante", 45, 6, 1),
            new Enemy("Erro de Compilação", 65, 8, 2),
            new Enemy("Boss NullPointer", 90, 11, 3)
    };

    private final Player player;
    private int indiceInimigo = 0;

    private BattleController controller;

    private final PainelStatus painelJogador = new PainelStatus(new Color(40, 130, 90));
    private final PainelStatus painelInimigo = new PainelStatus(new Color(170, 60, 60));
    private final JTextArea log = new JTextArea();

    private final JPanel painelAcoes = new JPanel();
    private final PainelPergunta painelPergunta = new PainelPergunta();
    private final JPanel containerInferior = new JPanel(new CardLayout());
    private static final String CARTAO_ACOES = "ACOES";
    private static final String CARTAO_PERGUNTA = "PERGUNTA";

    public TelaBatalha(Player player) {
        super("CodeArena: Deck do Conhecimento - Batalha");
        this.player = player;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 640);
        setMinimumSize(new Dimension(600, 560));
        setLocationRelativeTo(null);

        montarLayout();
        redirecionarSaidaPadraoParaLog();
        iniciarProximaBatalha();
    }

    private void montarLayout() {
        JPanel raiz = new JPanel(new BorderLayout(12, 12));
        raiz.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
        raiz.setBackground(Color.WHITE);

        JPanel topo = new JPanel(new GridLayout(1, 2, 12, 0));
        topo.setOpaque(false);
        topo.add(painelJogador);
        topo.add(painelInimigo);
        raiz.add(topo, BorderLayout.NORTH);

        log.setEditable(false);
        log.setLineWrap(true);
        log.setWrapStyleWord(true);
        log.setFont(new Font("Monospaced", Font.PLAIN, 12));
        log.setBackground(new Color(248, 248, 248));
        log.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        JScrollPane scrollLog = new JScrollPane(log);
        scrollLog.setBorder(BorderFactory.createLineBorder(new Color(225, 225, 225)));
        raiz.add(scrollLog, BorderLayout.CENTER);

        painelAcoes.setLayout(new BoxLayout(painelAcoes, BoxLayout.Y_AXIS));
        painelAcoes.setOpaque(false);
        painelAcoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        containerInferior.add(envolverComTitulo(painelAcoes, "Escolha sua ação"), CARTAO_ACOES);
        containerInferior.add(envolverComTitulo(painelPergunta, "Responda para concluir a ação"), CARTAO_PERGUNTA);
        raiz.add(containerInferior, BorderLayout.SOUTH);

        setContentPane(raiz);
    }

    private JPanel envolverComTitulo(JComponent conteudo, String titulo) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.setOpaque(false);
        JLabel rotulo = new JLabel(titulo);
        rotulo.setFont(new Font("SansSerif", Font.BOLD, 12));
        rotulo.setForeground(new Color(110, 110, 110));
        rotulo.setBorder(BorderFactory.createEmptyBorder(0, 2, 6, 0));
        painel.add(rotulo, BorderLayout.NORTH);
        painel.add(conteudo, BorderLayout.CENTER);
        return painel;
    }

    private void redirecionarSaidaPadraoParaLog() {
        PrintStream original = System.out;
        PrintStream paraLog = new PrintStream(original) {
            @Override
            public void println(String x) {
                original.println(x);
                SwingUtilities.invokeLater(() -> apendarLog(x));
            }
        };
        System.setOut(paraLog);
    }

    private void iniciarProximaBatalha() {
        Enemy inimigoOriginal = INIMIGOS[indiceInimigo];
        Enemy inimigo = new Enemy(inimigoOriginal.getName(), inimigoOriginal.getMaxHp(),
                inimigoOriginal.getAttack(), inimigoOriginal.getDefense());

        apendarLog("\n=== Nova batalha contra: " + inimigo.getName() + " ===");

        controller = new BattleController(player, inimigo, this);
        controller.iniciarBatalha();
        atualizarStatus();
        mostrarPainelAcoes();
    }

    private void atualizarStatus() {
        painelJogador.atualizar(player.getName(), player.getHp(), player.getMaxHp(),
                player.getAttack(), player.getDefense());
        Enemy inimigo = controller.getEnemy();
        painelInimigo.atualizar(inimigo.getName(), inimigo.getHp(), inimigo.getMaxHp(),
                inimigo.getAttack(), inimigo.getDefense());
    }

    private void mostrarPainelAcoes() {
        painelAcoes.removeAll();

        JButton ataqueComum = new JButton("Ataque Comum  (dano base + bonus da dificuldade)");
        ataqueComum.setAlignmentX(Component.LEFT_ALIGNMENT);
        ataqueComum.setFont(new Font("SansSerif", Font.BOLD, 13));
        ataqueComum.setFocusPainted(false);
        ataqueComum.setBackground(new Color(230, 230, 235));
        ataqueComum.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        ataqueComum.addActionListener(e -> escolherAtaqueComum());
        painelAcoes.add(ataqueComum);
        painelAcoes.add(Box.createVerticalStrut(10));

        List<Card> mao = controller.getHand();
        if (mao.isEmpty()) {
            JLabel semCartas = new JLabel("Sua mão está vazia. Use o Ataque Comum ou aguarde a próxima compra.");
            semCartas.setFont(new Font("SansSerif", Font.ITALIC, 12));
            semCartas.setForeground(new Color(130, 130, 130));
            painelAcoes.add(semCartas);
        } else {
            JLabel rotuloMao = new JLabel("Cartas na mão:");
            rotuloMao.setFont(new Font("SansSerif", Font.BOLD, 12));
            rotuloMao.setAlignmentX(Component.LEFT_ALIGNMENT);
            painelAcoes.add(rotuloMao);
            painelAcoes.add(Box.createVerticalStrut(4));

            for (int i = 0; i < mao.size(); i++) {
                Card carta = mao.get(i);
                JButton botaoCarta = new JButton((i + 1) + ". " + carta.getName() + " - " + carta.getDesc());
                botaoCarta.setAlignmentX(Component.LEFT_ALIGNMENT);
                botaoCarta.setFont(new Font("SansSerif", Font.PLAIN, 13));
                botaoCarta.setFocusPainted(false);
                botaoCarta.setHorizontalAlignment(SwingConstants.LEFT);
                botaoCarta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 34));
                final int indice = i;
                botaoCarta.addActionListener(e -> escolherCarta(indice));
                painelAcoes.add(botaoCarta);
                painelAcoes.add(Box.createVerticalStrut(4));
            }
        }

        painelAcoes.revalidate();
        painelAcoes.repaint();
        mostrarCartao(CARTAO_ACOES);
    }

    private void escolherAtaqueComum() {
        Question pergunta = controller.escolherAtaqueComum();
        painelPergunta.exibirPergunta(pergunta, this::responder);
        mostrarCartao(CARTAO_PERGUNTA);
    }

    private void escolherCarta(int indice) {
        Question pergunta = controller.escolherCarta(indice);
        painelPergunta.exibirPergunta(pergunta, this::responder);
        mostrarCartao(CARTAO_PERGUNTA);
    }

    private void responder(String resposta) {
        controller.responder(resposta);
    }

    private void mostrarCartao(String nome) {
        ((CardLayout) containerInferior.getLayout()).show(containerInferior, nome);
    }

    private void apendarLog(String mensagem) {
        log.append(mensagem + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    @Override
    public void onLog(String mensagem) {
        SwingUtilities.invokeLater(() -> apendarLog(mensagem));
    }

    @Override
    public void onEstadoAtualizado() {
        SwingUtilities.invokeLater(() -> {
            atualizarStatus();

            if (controller.batalhaTerminou()) {
                tratarFimDeBatalha();
            } else {
                mostrarPainelAcoes();
            }
        });
    }

    private void tratarFimDeBatalha() {
        if (!controller.jogadorVenceu()) {
            new TelaFim(false, player.getScore(), null).setVisible(true);
            dispose();
            return;
        }

        player.heal(15);
        apendarLog("Você venceu e recuperou 15 de vida!");
        atualizarStatus();

        indiceInimigo++;
        if (indiceInimigo >= INIMIGOS.length) {
            new TelaFim(true, player.getScore(), null).setVisible(true);
            dispose();
        } else {
            iniciarProximaBatalha();
        }
    }
}
