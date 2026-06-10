import java.util.*;

public class BattleManager {
    private Scanner sc;
    private Random random = new Random();
    private List<Card> deck = CardFactory.createDeck();
    private QuestionBank bank = new QuestionBank();

    public BattleManager(Scanner sc) {
        this.sc = sc;
    }

    public boolean startBattle(Player player, Enemy enemy) {
        List<Card> hand = new ArrayList<>();
        draw(hand, 4);
        int turn = 1;

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n--- Turno " + turn + " ---");
            showStatus(player, enemy);

            if (hand.isEmpty()) {
                System.out.println("Sem cartas: voce perdeu o turno e comprou 3 cartas.");
                draw(hand, 3);
                enemy.attack(player);
                player.endTurn();
                turn++;
                continue;
            }

            showActions(hand);
            int choice = readChoice(hand.size());

            if (choice == 0) usarAtaqueComum(player, enemy);
            else usarCarta(player, enemy, hand, choice);

            if (enemy.isAlive()) enemy.attack(player);

            if (turn % 2 == 0) {
                draw(hand, 1);
                System.out.println("Voce comprou 1 carta.");
            }

            player.endTurn();
            turn++;
        }

        return player.isAlive();
    }

    private void usarAtaqueComum(Player player, Enemy enemy) {
        System.out.println("\nAtaque Comum escolhido.");
        Question q = bank.getRandomAnyQuestion();

        if (q.ask(sc)) {
            int damage = player.getAttack() + q.getDifficulty().getDamageBonus();
            System.out.println("Correto! Dificuldade " + q.getDifficulty().getName()
                    + " deu +" + q.getDifficulty().getDamageBonus() + " de dano.");
            enemy.takeDamage(damage);
            player.addScore(q.getDifficulty().getScore());
        } else {
            System.out.println("Errado! O ataque falhou.");
        }
    }

    private void usarCarta(Player player, Enemy enemy, List<Card> hand, int choice) {
        Card card = hand.remove(choice - 1);
        Question q = bank.getRandomQuestion(card.getId());
        System.out.println("\nCarta usada: " + card.getName());

        if (q.ask(sc)) {
            System.out.println("Correto! A carta ativou com bonus da dificuldade " + q.getDifficulty().getName() + ".");
            card.use(player, enemy, q);
            player.addScore(q.getDifficulty().getScore() + 5);
        } else {
            System.out.println("Errado! A carta foi descartada sem efeito.");
        }
    }

    private void draw(List<Card> hand, int amount) {
        for (int i = 0; i < amount; i++) hand.add(deck.get(random.nextInt(deck.size())));
    }

    private void showStatus(Player p, Enemy e) {
        System.out.println(p.getName() + " HP: " + p.getHp() + "/" + p.getMaxHp()
                + " | ATK: " + p.getAttack() + " | DEF: " + p.getDefense());
        System.out.println(e.getName() + " HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | ATK: " + e.getAttack() + " | DEF: " + e.getDefense());
    }

    private void showActions(List<Card> hand) {
        System.out.println("\n0 - Ataque Comum - dano base + bonus da dificuldade");
        for (int i = 0; i < hand.size(); i++) System.out.println((i + 1) + " - " + hand.get(i));
    }

    private int readChoice(int maxCards) {
        while (true) {
            System.out.print("Escolha uma acao: ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 0 && n <= maxCards) return n;
            } catch (Exception ignored) {}
            System.out.println("Digite um numero valido.");
        }
    }
}
