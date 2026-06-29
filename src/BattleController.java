import java.util.*;

public class BattleController {

    public interface BattleListener {
        void onLog(String mensagem);
        void onEstadoAtualizado();
    }

    private final Random random = new Random();
    private final List<Card> deck = CardFactory.createDeck();
    private final QuestionBank bank = new QuestionBank();

    private final Player player;
    private final Enemy enemy;
    private final List<Card> hand = new ArrayList<>();
    private final BattleListener listener;

    private int turn = 1;
    private Question perguntaAtual;
    private Card cartaSelecionada;
    private int indiceCartaSelecionada = -1;

    public BattleController(Player player, Enemy enemy, BattleListener listener) {
        this.player = player;
        this.enemy = enemy;
        this.listener = listener;
    }

    public void iniciarBatalha() {
        draw(4);
        log("--- Turno " + turn + " ---");
        log(statusTexto());
        processarTurnosVaziosAutomaticamente();
    }

    public boolean batalhaTerminou() {
        return !player.isAlive() || !enemy.isAlive();
    }

    public boolean jogadorVenceu() {
        return player.isAlive();
    }

    public List<Card> getHand() { return hand; }
    public Player getPlayer() { return player; }
    public Enemy getEnemy() { return enemy; }
    public int getTurn() { return turn; }

    public Question getPerguntaAtual() { return perguntaAtual; }

    public Question escolherAtaqueComum() {
        cartaSelecionada = null;
        perguntaAtual = bank.getRandomAnyQuestion();
        log("\nAtaque Comum escolhido.");
        return perguntaAtual;
    }

    public Question escolherCarta(int indiceNaMao) {
        cartaSelecionada = hand.get(indiceNaMao);
        indiceCartaSelecionada = indiceNaMao;
        perguntaAtual = bank.getRandomQuestion(cartaSelecionada.getId());
        log("\nCarta usada: " + cartaSelecionada.getName());
        return perguntaAtual;
    }

    public void responder(String resposta) {
        if (perguntaAtual == null) {
            throw new IllegalStateException("Nenhuma ação foi escolhida antes de responder.");
        }

        boolean correto = perguntaAtual.checkAnswer(resposta);

        if (cartaSelecionada == null) {
            aplicarAtaqueComum(correto);
        } else {
            aplicarCarta(correto);
        }

        perguntaAtual = null;
        cartaSelecionada = null;
        indiceCartaSelecionada = -1;

        if (batalhaTerminou()) {
            listener.onEstadoAtualizado();
            return;
        }

        if (enemy.isAlive()) {
            enemy.attack(player);
        }

        if (batalhaTerminou()) {
            listener.onEstadoAtualizado();
            return;
        }

        if (turn % 2 == 0) {
            draw(1);
            log("Você comprou 1 carta.");
        }

        player.endTurn();
        turn++;

        log("\n--- Turno " + turn + " ---");
        log(statusTexto());

        processarTurnosVaziosAutomaticamente();

        listener.onEstadoAtualizado();
    }

    private void processarTurnosVaziosAutomaticamente() {
        while (!batalhaTerminou() && hand.isEmpty()) {
            log("Sem cartas: você perdeu o turno e comprou 3 cartas.");
            draw(3);
            if (enemy.isAlive()) enemy.attack(player);

            if (batalhaTerminou()) return;

            player.endTurn();
            turn++;
            log("\n--- Turno " + turn + " ---");
            log(statusTexto());
        }
    }

    private void aplicarAtaqueComum(boolean correto) {
        if (correto) {
            int damage = player.getAttack() + perguntaAtual.getDifficulty().getDamageBonus();
            log("Correto! Dificuldade " + perguntaAtual.getDifficulty().getName()
                    + " deu +" + perguntaAtual.getDifficulty().getDamageBonus() + " de dano.");
            enemy.takeDamage(damage);
            player.addScore(perguntaAtual.getDifficulty().getScore());
        } else {
            log("Errado! O ataque falhou.");
        }
    }

    private void aplicarCarta(boolean correto) {
        hand.remove(indiceCartaSelecionada);
        if (correto) {
            log("Correto! A carta ativou com bônus da dificuldade " + perguntaAtual.getDifficulty().getName() + ".");
            cartaSelecionada.use(player, enemy, perguntaAtual);
            player.addScore(perguntaAtual.getDifficulty().getScore() + 5);
        } else {
            log("Errado! A carta foi descartada sem efeito.");
        }
    }

    private void draw(int amount) {
        for (int i = 0; i < amount; i++) hand.add(deck.get(random.nextInt(deck.size())));
    }

    private String statusTexto() {
        return player.getName() + " HP: " + player.getHp() + "/" + player.getMaxHp()
                + " | ATK: " + player.getAttack() + " | DEF: " + player.getDefense() + "\n"
                + enemy.getName() + " HP: " + enemy.getHp() + "/" + enemy.getMaxHp()
                + " | ATK: " + enemy.getAttack() + " | DEF: " + enemy.getDefense();
    }

    private void log(String msg) {
        listener.onLog(msg);
    }
}
