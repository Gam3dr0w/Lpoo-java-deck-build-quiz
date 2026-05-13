import java.util.*;

public class CardFactory {
    public static List<Card> createDeck() {
        return Arrays.asList(
                new Card("JAVA", "Ataque Java", "causa dano + 12"),
                new Card("LOOP", "Loop Cortante", "causa o dobro do ataque"),
                new Card("CURA", "Cura Binária", "cura baseado na vida máxima e defesa"),
                new Card("ESCUDO", "Escudo de Newton", "aumenta a defesa"),
                new Card("BUFF", "Algoritmo de Força", "aumenta o ataque"),
                new Card("HISTORIA", "Golpe Histórico", "causa dano baseado em ataque + defesa"),
                new Card("VIDA", "Energia Vital", "recupera 10 de vida"),
                new Card("CONTRA", "Contra-Ataque", "ganha defesa e causa dano"),
                new Card("MATH", "Raio Matemático", "causa 20 de dano"),
                new Card("FIREWALL", "Firewall", "ganha defesa e cura um pouco")
        );
    }
}