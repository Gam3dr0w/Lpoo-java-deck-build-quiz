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
                System.out.println("Você ficou sem cartas. Perdeu o turno e comprou 3 cartas.");
                draw(hand, 3);
                enemy.attack(player);
                turn++;
                continue;
            }

            showActions(hand);
            int choice = readChoice(hand.size());

            if (choice == 0) {
                usarAtaqueComum(player, enemy);
            } else {
                usarCarta(player, enemy, hand, choice);
            }

            if (enemy.isAlive()) {
                enemy.attack(player);
            }

            if (turn % 2 == 0) {
                draw(hand, 1);
                System.out.println("Você comprou 1 carta.");
            }

            turn++;
        }

        return player.isAlive();
    }

    private void usarAtaqueComum(Player player, Enemy enemy) {
        System.out.println("\nVocê escolheu Ataque Comum.");
        Question q = bank.getRandomAnyQuestion();

        if (q.ask(sc)) {
            System.out.println("Resposta correta! Ataque comum realizado.");
            enemy.takeDamage(player.getAttack());
            player.addScore(5);
        } else {
            System.out.println("Resposta errada! O ataque comum falhou.");
        }
    }

    private void usarCarta(Player player, Enemy enemy, List<Card> hand, int choice) {
        Card card = hand.remove(choice - 1);

        System.out.println("\nCarta usada: " + card.getName());
        Question q = bank.getRandomQuestion(card.getId());

        if (q.ask(sc)) {
            System.out.println("Resposta correta! A carta funcionou.");
            card.use(player, enemy);
            player.addScore(10);
        } else {
            System.out.println("Resposta errada! A carta falhou.");
        }
    }

    private void draw(List<Card> hand, int amount) {
        for (int i = 0; i < amount; i++) {
            hand.add(deck.get(random.nextInt(deck.size())));
        }
    }

    private void showStatus(Player p, Enemy e) {
        System.out.println(p.getName() + " HP: " + p.getHp() + "/" + p.getMaxHp()
                + " | ATK: " + p.getAttack() + " | DEF: " + p.getDefense());
        System.out.println(e.getName() + " HP: " + e.getHp() + "/" + e.getMaxHp()
                + " | ATK: " + e.getAttack() + " | DEF: " + e.getDefense());
    }

    private void showActions(List<Card> hand) {
        System.out.println("\nAções:");
        System.out.println("0 - Ataque Comum - causa dano base e usa pergunta aleatória");

        System.out.println("\nCartas:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println((i + 1) + " - " + hand.get(i));
        }
    }

    private int readChoice(int maxCards) {
        while (true) {
            System.out.print("Escolha uma ação: ");
            try {
                int n = Integer.parseInt(sc.nextLine());
                if (n >= 0 && n <= maxCards) return n;
            } catch (Exception e) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}