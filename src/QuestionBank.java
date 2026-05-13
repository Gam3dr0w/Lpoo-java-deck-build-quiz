import java.util.*;

public class QuestionBank {
    private Map<String, List<Question>> questions = new HashMap<>();
    private List<Question> allQuestions = new ArrayList<>();
    private Random random = new Random();

    public QuestionBank() {
        add("JAVA",
                mc("Qual modificador impede herança de uma classe?", "3", "static", "private", "final", "abstract"),
                mc("Qual conceito permite métodos com comportamentos diferentes?", "2", "encapsulamento", "polimorfismo", "atributo", "instância"),
                tf("Classe abstrata pode ter métodos concretos e abstratos.", "V"),
                mc("Principal função do encapsulamento?", "1", "proteger dados", "aumentar FPS", "remover construtores", "impedir objetos"),
                mc("Variável local existe onde?", "4", "em todo projeto", "em toda classe", "em outro pacote", "só no método"),
                tf("Interface define comportamentos que classes implementam.", "V"),
                mc("Criação correta de objeto?", "2", "Player p = Player();", "Player p = new Player();", "new Player = p;", "object Player p;"),
                mc("Sobrescrever método da classe mãe é:", "3", "sobrecarga", "compilação", "sobrescrita", "encapsulamento"),
                tf("Construtor tem o mesmo nome da classe.", "V"),
                mc("Palavra que acessa a classe mãe?", "1", "super", "this", "extends", "parent")
        );

        add("LOOP",
                mc("Valor final: int x=0; for(int i=1;i<=4;i++){x+=i;}", "4", "4", "6", "8", "10"),
                mc("O que causa loop infinito?", "1", "condição nunca falsa", "usar int", "usar print", "ter uma linha"),
                tf("Um for pode ser convertido em while.", "V"),
                mc("Quantas vezes executa? for(int i=10;i>4;i-=2)", "3", "2", "4", "3", "5"),
                mc("Comando que encerra um laço?", "2", "continue", "break", "returnLoop", "stopFor"),
                tf("continue pula para a próxima repetição.", "V"),
                mc("Saída: for(int i=0;i<3;i++) print(i)", "1", "012", "123", "0123", "111"),
                mc("Melhor laço quando sabe o número de repetições?", "3", "if", "switch", "for", "try"),
                tf("Laço dentro de laço é laço aninhado.", "V"),
                mc("Loop externo 3 vezes e interno 4 vezes: total?", "4", "4", "7", "10", "12")
        );

        add("CURA",
                mc("Sistema que defende contra microrganismos?", "2", "respiratório", "imunológico", "digestivo", "locomotor"),
                tf("Antibióticos combatem bactérias, não vírus diretamente.", "V"),
                mc("Nutriente ligado ao reparo de tecidos?", "1", "proteína", "CO2", "sódio puro", "celulose"),
                mc("Cicatrização depende de:", "3", "luz solar", "ausência de sangue", "renovação celular", "frio extremo"),
                tf("Febre pode ser resposta contra infecções.", "V"),
                mc("Célula de defesa do sangue?", "4", "hemácia", "neurônio", "plaqueta", "leucócito"),
                mc("Órgão que filtra sangue?", "2", "pulmão", "rim", "estômago", "coração"),
                tf("Vacinas treinam o sistema imunológico.", "V"),
                mc("Vitamina ligada à coagulação?", "3", "C", "D", "K", "B1"),
                mc("Homeostase é:", "1", "equilíbrio interno", "energia solar", "calor infinito", "perda de água")
        );

        add("ESCUDO",
                mc("2ª Lei de Newton:", "3", "m/a", "v.t", "m.a", "E.d"),
                tf("Maior massa geralmente significa maior inércia.", "V"),
                mc("Capacete protege porque:", "2", "aumenta impacto", "distribui impacto", "remove gravidade", "gera velocidade"),
                mc("Unidade de pressão no SI?", "4", "Newton", "Joule", "Watt", "Pascal"),
                tf("Atrito depende de contato entre superfícies.", "V"),
                mc("Objeto parado tende a ficar parado por causa da:", "1", "inércia", "radiação", "evaporação", "densidade"),
                mc("Maior pressão ocorre com:", "3", "mesma força em área maior", "força zero", "mesma força em área menor", "área gigante"),
                tf("Ação gera reação oposta de mesma intensidade.", "V"),
                mc("Energia cinética está ligada a:", "2", "temperatura", "movimento", "repouso", "cor"),
                mc("Defesa no jogo parece com:", "1", "resistência", "mais dano recebido", "cura inimiga", "perda de turno")
        );

        add("BUFF",
                mc("Buff temporário altera:", "4", "nome", "cenário", "história", "atributo por tempo"),
                tf("Aumento de ataque muda o balanceamento.", "V"),
                mc("Ataque 12 com buff de 25% vira:", "2", "13", "15", "16", "18"),
                mc("Estrutura para guardar buffs ativos?", "1", "List", "int", "char", "boolean"),
                tf("Buffs podem ser acumulativos ou não.", "V"),
                mc("Buff de 1 turno deve sair:", "3", "antes de usar", "nunca", "após o turno", "ao fechar jogo"),
                mc("Melhor exemplo de buff:", "4", "perder vida", "travar", "apagar personagem", "aumentar ataque"),
                tf("Buff permanente dura até fim da batalha ou jogo.", "V"),
                mc("20 +10% e depois +5 =", "2", "22", "27", "25", "30"),
                mc("Classe Buff poderia ter:", "1", "nome, duração e valor", "só print", "só main", "só Scanner")
        );

        add("HISTORIA",
                mc("Revolução Francesa começou em:", "3", "1492", "1640", "1789", "1917"),
                tf("Independência do Brasil foi em 1822.", "V"),
                mc("Lei Áurea fez:", "2", "criou república", "aboliu escravidão", "iniciou colonização", "fundou Brasília"),
                mc("Início da Idade Contemporânea:", "1", "Revolução Francesa", "Queda de Constantinopla", "Brasil 1500", "Cruzadas"),
                tf("A 1ª Guerra veio antes da 2ª Guerra.", "V"),
                mc("Colonial brasileiro começou forte com:", "4", "petróleo", "café industrial", "soja", "açúcar"),
                mc("Guerra Fria: rivalidade entre:", "3", "Brasil e Argentina", "França e Alemanha", "EUA e URSS", "Portugal e Espanha"),
                tf("Inconfidência Mineira envolveu impostos portugueses.", "V"),
                mc("República no Brasil foi proclamada em:", "2", "1822", "1889", "1930", "1964"),
                mc("Iluminismo defendia:", "1", "razão e ciência", "feudalismo", "fim da ciência", "absolutismo total")
        );

        add("VIDA",
                mc("Organela que produz energia?", "2", "ribossomo", "mitocôndria", "lisossomo", "vacúolo"),
                tf("DNA contém informações genéticas.", "V"),
                mc("Fotossíntese usa:", "1", "luz, água e CO2", "som e areia", "ferro e calor", "petróleo"),
                mc("Seleção natural está ligada a:", "3", "Newton", "Dalton", "Darwin", "Pascal"),
                tf("Autotróficos produzem próprio alimento.", "V"),
                mc("Fonte rápida de energia celular:", "4", "DNA", "RNA", "queratina", "ATP"),
                mc("Troca gasosa ocorre nos:", "2", "ossos", "alvéolos", "rins", "músculos"),
                tf("Células eucariontes possuem núcleo organizado.", "V"),
                mc("Processo que gera duas células iguais:", "1", "mitose", "meiose", "fecundação", "mutação"),
                mc("Relação seres vivos e ambiente:", "3", "astronomia", "geometria", "ecologia", "mecânica")
        );

        add("CONTRA",
                mc("Negação de 'A e B':", "4", "A e não B", "A ou B", "não A e não B sempre", "não A ou não B"),
                tf("Defender pode ser útil sem dano imediato.", "V"),
                mc("No xadrez, ameaça direta ao rei:", "2", "roque", "xeque", "empate", "promoção"),
                mc("Se inimigo sempre ataca, boa ação:", "1", "aumentar defesa", "curar inimigo", "ignorar vida", "jogar aleatório"),
                tf("Prever ação inimiga faz parte da estratégia.", "V"),
                mc("Resposta proporcional a uma ação:", "3", "evaporação", "inércia térmica", "ação e reação", "condensação"),
                mc("A=true, B=false. A || B =", "1", "verdadeiro", "falso", "nulo", "erro"),
                tf("Contra-atacar é reagir a uma ação adversária.", "V"),
                mc("Melhor decisão estratégica:", "4", "ignorar dados", "repetir sempre", "escolher acaso", "avaliar risco"),
                mc("Operadores lógicos comuns:", "2", "+ e -", "&& e ||", "* e /", "new e class")
        );

        add("MATH",
                mc("3² + 4² =", "3", "12", "18", "25", "49"),
                tf("Número primo tem exatamente dois divisores positivos.", "V"),
                mc("2x + 6 = 18. x =", "2", "5", "6", "7", "8"),
                mc("Média de 6, 8 e 10:", "1", "8", "9", "10", "24"),
                tf("Soma dos ângulos de um triângulo é 180°.", "V"),
                mc("20% de 150:", "4", "15", "20", "25", "30"),
                mc("PA: a1=2, razão=3. quinto termo:", "3", "11", "12", "14", "15"),
                tf("Raiz de 144 é 12.", "V"),
                mc("5! =", "2", "60", "120", "20", "720"),
                mc("R$80 com 25% de desconto:", "1", "R$60", "R$65", "R$70", "R$75")
        );

        add("FIREWALL",
                mc("Função principal de firewall:", "3", "brilho", "formatar PC", "filtrar conexões", "criar senhas"),
                tf("Phishing tenta obter dados enganando usuários.", "V"),
                mc("Melhora segurança da conta:", "1", "2FA", "mesma senha", "senha pública", "links suspeitos"),
                mc("Malware é:", "2", "monitor", "software malicioso", "cabo", "linguagem segura"),
                tf("Atualizações corrigem falhas de segurança.", "V"),
                mc("Senha mais forte:", "4", "123456", "senha", "abcdef", "Tigre#47Lua!92"),
                mc("Criptografia serve para:", "3", "apagar arquivos", "aumentar volume", "proteger dados", "mudar cor"),
                tf("Wi-Fi público desconhecido pode ser arriscado.", "V"),
                mc("Backup é importante porque:", "1", "recupera dados", "impede todo vírus", "substitui senha", "desliga internet"),
                mc("Engenharia social explora:", "2", "placa de vídeo", "falhas humanas", "só matemática", "processador")
        );
    }

    public Question getRandomQuestion(String cardId) {
        List<Question> list = questions.get(cardId);
        return list.get(random.nextInt(list.size()));
    }

    public Question getRandomAnyQuestion() {
        return allQuestions.get(random.nextInt(allQuestions.size()));
    }

    private void add(String id, Question... qs) {
        List<Question> list = Arrays.asList(qs);
        questions.put(id, list);
        allQuestions.addAll(list);
    }

    private Question mc(String text, String answer, String... options) {
        return new MultipleChoiceQuestion(text, answer, "Difícil", options);
    }

    private Question tf(String text, String answer) {
        return new TrueFalseQuestion(text, answer, "Difícil");
    }
}