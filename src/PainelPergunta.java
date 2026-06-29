import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class PainelPergunta extends JPanel {

    private final JTextField campoResposta = new JTextField();
    private final JPanel areaResposta = new JPanel();
    private final JLabel rotuloDificuldade = new JLabel();
    private final JLabel rotuloPergunta = new JLabel();
    private final JButton botaoConfirmar = new JButton("Confirmar resposta");

    private Consumer<String> aoConfirmar;
    private String escolhaAtual;

    public PainelPergunta() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(new Color(250, 250, 252));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(210, 210, 220)),
                BorderFactory.createEmptyBorder(14, 16, 14, 16)));

        rotuloDificuldade.setFont(new Font("SansSerif", Font.BOLD, 11));
        rotuloDificuldade.setAlignmentX(Component.LEFT_ALIGNMENT);

        rotuloPergunta.setFont(new Font("SansSerif", Font.PLAIN, 15));
        rotuloPergunta.setAlignmentX(Component.LEFT_ALIGNMENT);
        rotuloPergunta.setBorder(BorderFactory.createEmptyBorder(6, 0, 12, 0));

        areaResposta.setLayout(new BoxLayout(areaResposta, BoxLayout.Y_AXIS));
        areaResposta.setOpaque(false);
        areaResposta.setAlignmentX(Component.LEFT_ALIGNMENT);

        botaoConfirmar.setAlignmentX(Component.LEFT_ALIGNMENT);
        TelaInicial.estilizarBotaoPrimario(botaoConfirmar);
        botaoConfirmar.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        botaoConfirmar.setBackground(new Color(60, 140, 80));
        botaoConfirmar.setMaximumSize(new Dimension(220, 38));
        botaoConfirmar.addActionListener(e -> confirmar());

        add(rotuloDificuldade);
        add(rotuloPergunta);
        add(areaResposta);
        add(Box.createVerticalStrut(12));
        add(botaoConfirmar);
    }

    public void exibirPergunta(Question pergunta, Consumer<String> aoConfirmar) {
        this.aoConfirmar = aoConfirmar;
        this.escolhaAtual = null;
        botaoConfirmar.setEnabled(true);

        rotuloDificuldade.setText("[" + pergunta.getDifficulty().getName().toUpperCase() + "]  " + pergunta.getKind());
        rotuloDificuldade.setForeground(corDificuldade(pergunta.getDifficulty()));

        String textoPergunta = pergunta.getKind().equals("Complete a Lacuna")
                ? "Complete: " + pergunta.getText()
                : pergunta.getText();
        rotuloPergunta.setText("<html><body style='width: 360px'>" + escapeHtml(textoPergunta) + "</body></html>");

        areaResposta.removeAll();

        String[] opcoes = pergunta.getOptions();
        if (opcoes.length > 0) {
            montarMultiplaEscolha(opcoes);
        } else if (pergunta.getKind().equals("Verdadeiro ou Falso")) {
            montarVerdadeiroFalso();
        } else {
            montarCampoTexto();
        }

        revalidate();
        repaint();
    }

    private void montarMultiplaEscolha(String[] opcoes) {
        ButtonGroup grupo = new ButtonGroup();
        for (int i = 0; i < opcoes.length; i++) {
            String valor = String.valueOf(i + 1);
            JRadioButton radio = new JRadioButton((i + 1) + ") " + opcoes[i]);
            radio.setFont(new Font("SansSerif", Font.PLAIN, 13));
            radio.setOpaque(false);
            radio.setAlignmentX(Component.LEFT_ALIGNMENT);
            radio.setFocusPainted(false);
            radio.addActionListener(e -> escolhaAtual = valor);
            grupo.add(radio);
            areaResposta.add(radio);
            areaResposta.add(Box.createVerticalStrut(2));
        }
    }

    private void montarVerdadeiroFalso() {
        ButtonGroup grupo = new ButtonGroup();
        JRadioButton verdadeiro = new JRadioButton("Verdadeiro (V)");
        JRadioButton falso = new JRadioButton("Falso (F)");
        for (JRadioButton r : new JRadioButton[]{verdadeiro, falso}) {
            r.setFont(new Font("SansSerif", Font.PLAIN, 13));
            r.setOpaque(false);
            r.setAlignmentX(Component.LEFT_ALIGNMENT);
            r.setFocusPainted(false);
            grupo.add(r);
            areaResposta.add(r);
            areaResposta.add(Box.createVerticalStrut(2));
        }
        verdadeiro.addActionListener(e -> escolhaAtual = "V");
        falso.addActionListener(e -> escolhaAtual = "F");
    }

    private void montarCampoTexto() {
        campoResposta.setText("");
        campoResposta.setFont(new Font("SansSerif", Font.PLAIN, 14));
        campoResposta.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoResposta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 32));
        campoResposta.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(4, 8, 4, 8)));
        campoResposta.addActionListener(e -> confirmar());
        areaResposta.add(campoResposta);
        SwingUtilities.invokeLater(campoResposta::requestFocus);
    }

    private void confirmar() {
        String resposta;
        if (pergComCampoTexto()) {
            resposta = campoResposta.getText();
        } else {
            if (escolhaAtual == null) {
                JOptionPane.showMessageDialog(this,
                        "Selecione uma opção antes de confirmar.",
                        "Resposta obrigatória", JOptionPane.WARNING_MESSAGE);
                return;
            }
            resposta = escolhaAtual;
        }

        if (aoConfirmar != null) {
            botaoConfirmar.setEnabled(false);
            Consumer<String> callback = aoConfirmar;
            aoConfirmar = null;
            callback.accept(resposta);
        }
    }

    private boolean pergComCampoTexto() {
        return areaResposta.getComponentCount() > 0
                && areaResposta.getComponent(areaResposta.getComponentCount() - 1) instanceof JTextField;
    }

    private Color corDificuldade(Difficulty d) {
        switch (d) {
            case EASY: return new Color(60, 140, 80);
            case MEDIUM: return new Color(200, 140, 30);
            case HARD: return new Color(190, 60, 60);
            default: return Color.DARK_GRAY;
        }
    }

    private String escapeHtml(String texto) {
        return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
