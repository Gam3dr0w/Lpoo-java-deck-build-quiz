import java.util.*;

public class Game {
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("=== CodeArena: Deck do Conhecimento ===");
        System.out.print("Nome do jogador: ");
        String nome = sc.nextLine();

        Player player = escolherPersonagem(nome);

        Enemy[] inimigos = {
                new Enemy("Bug Iniciante", 50, 6, 1),
                new Enemy("Erro de Compilação", 80, 8, 2),
                new Enemy("Boss NullPointer", 100, 10, 3)
        };

        BattleManager bm = new BattleManager(sc);

        for (Enemy e : inimigos) {
            System.out.println("\nNova batalha contra: " + e.getName());
            boolean venceu = bm.startBattle(player, e);

            if (!venceu) {
                System.out.println("\nVocê perdeu a jornada!");
                return;
            }

            player.heal(15);
            System.out.println("Você venceu a batalha e recuperou 15 de vida!");
        }

        System.out.println("\nParabéns! Você venceu todas as batalhas!");
        System.out.println("Pontuação final: " + player.getScore());
    }

    private Player escolherPersonagem(String nome) {
        System.out.println("\nEscolha seu personagem:");
        System.out.println("1 - Programador: equilibrado");
        System.out.println("2 - Hacker: mais ataque, menos defesa");
        System.out.print("Opção: ");

        String op = sc.nextLine();

        if (op.equals("2")) {
            return new Player(nome, new Hacker());
        }

        return new Player(nome, new Programmer());
    }
}