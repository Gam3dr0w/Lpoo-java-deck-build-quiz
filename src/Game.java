import java.util.*;

public class Game {
    private Scanner sc = new Scanner(System.in);

    public void start() {
        System.out.println("=== CodeArena: Deck do Conhecimento - Checkpoint 2 ===");
        System.out.print("Nome do jogador: ");
        String nome = sc.nextLine();

        Player player = escolherPersonagem(nome);

        Enemy[] inimigos = {
            new Enemy("Bug Iniciante", 45, 6, 1),
            new Enemy("Erro de Compilacao", 65, 8, 2),
            new Enemy("Boss NullPointer", 90, 11, 3)
        };

        BattleManager bm = new BattleManager(sc);

        for (Enemy e : inimigos) {
            System.out.println("\nNova batalha contra: " + e.getName());
            boolean venceu = bm.startBattle(player, e);

            if (!venceu) {
                System.out.println("\nVoce perdeu a jornada!");
                System.out.println("Pontuacao final: " + player.getScore());
                return;
            }

            player.heal(15);
            System.out.println("Voce venceu e recuperou 15 de vida!");
        }

        System.out.println("\nParabens! Voce venceu todas as batalhas!");
        System.out.println("Pontuacao final: " + player.getScore());
    }

    private Player escolherPersonagem(String nome) {
        System.out.println("\nEscolha seu personagem:");
        System.out.println("1 - Programador: equilibrado");
        System.out.println("2 - Hacker: mais ataque, menos defesa");
        System.out.print("Opcao: ");
        return sc.nextLine().equals("2") ? new Player(nome, new Hacker()) : new Player(nome, new Programmer());
    }
}
