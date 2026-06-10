import java.util.*;

public class CardFactory {
    public static List<Card> createDeck() {
        return Arrays.asList(
            new Card("JAVA", "Ataque Java", "dano baseado no ataque"),
            new Card("LOOP", "Loop Cortante", "dano dobrado"),
            new Card("CURA", "Cura Binaria", "recupera vida"),
            new Card("ESCUDO", "Escudo de Newton", "defesa temporaria"),
            new Card("BUFF", "Algoritmo de Forca", "aumenta ataque"),
            new Card("HISTORIA", "Golpe Historico", "ataque + defesa"),
            new Card("VIDA", "Energia Vital", "cura direta"),
            new Card("CONTRA", "Contra-Ataque", "defesa + dano"),
            new Card("MATH", "Raio Matematico", "dano forte"),
            new Card("FIREWALL", "Firewall", "escudo + cura")
        );
    }
}
