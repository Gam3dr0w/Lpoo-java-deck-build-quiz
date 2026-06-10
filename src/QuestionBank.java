import java.util.*;

public class QuestionBank {
    private Map<String, List<Question>> questions = new HashMap<>();
    private List<Question> allQuestions = new ArrayList<>();
    private Random random = new Random();

    public QuestionBank() {
        add("JAVA",
            mc("Qual modificador impede heranca de uma classe?", "3", Difficulty.MEDIUM, "static", "private", "final", "abstract"),
            mc("Qual conceito permite metodos com comportamentos diferentes?", "2", Difficulty.MEDIUM, "encapsulamento", "polimorfismo", "atributo", "instancia"),
            tf("Classe abstrata pode ter metodos concretos e abstratos.", "V", Difficulty.EASY),
            mc("Principal funcao do encapsulamento?", "1", Difficulty.MEDIUM, "proteger dados", "aumentar FPS", "remover construtores", "impedir objetos"),
            fb("Palavra que cria objeto em Java: ____", "new", Difficulty.EASY),
            tf("Interface define comportamentos que classes implementam.", "V", Difficulty.EASY),
            mc("Criacao correta de objeto?", "2", Difficulty.MEDIUM, "Player p = Player();", "Player p = new Player();", "new Player = p;", "object Player p;"),
            mc("Sobrescrever metodo da classe mae e:", "3", Difficulty.MEDIUM, "sobrecarga", "compilacao", "sobrescrita", "encapsulamento"),
            tf("Construtor tem o mesmo nome da classe.", "V", Difficulty.EASY),
            fb("Palavra que acessa membros da classe mae: ____", "super", Difficulty.HARD)
        );

        add("LOOP",
            mc("Valor final: int x=0; for(int i=1;i<=4;i++){x+=i;}", "4", Difficulty.MEDIUM, "4", "6", "8", "10"),
            mc("O que causa loop infinito?", "1", Difficulty.EASY, "condicao nunca falsa", "usar int", "usar print", "ter uma linha"),
            tf("Um for pode ser convertido em while.", "V", Difficulty.EASY),
            mc("Quantas vezes executa? for(int i=10;i>4;i-=2)", "3", Difficulty.MEDIUM, "2", "4", "3", "5"),
            fb("Comando que encerra um laco: ____", "break", Difficulty.EASY),
            tf("continue pula para a proxima repeticao.", "V", Difficulty.EASY),
            mc("Saida: for(int i=0;i<3;i++) print(i)", "1", Difficulty.MEDIUM, "012", "123", "0123", "111"),
            mc("Melhor laco quando sabe o numero de repeticoes?", "3", Difficulty.EASY, "if", "switch", "for", "try"),
            tf("Laco dentro de laco e laco aninhado.", "V", Difficulty.EASY),
            mc("Loop externo 3 vezes e interno 4 vezes: total?", "4", Difficulty.HARD, "4", "7", "10", "12")
        );

        add("CURA",
            mc("Sistema que defende contra microrganismos?", "2", Difficulty.EASY, "respiratorio", "imunologico", "digestivo", "locomotor"),
            tf("Antibioticos combatem bacterias, nao virus diretamente.", "V", Difficulty.MEDIUM),
            mc("Nutriente ligado ao reparo de tecidos?", "1", Difficulty.EASY, "proteina", "CO2", "sodio puro", "celulose"),
            mc("Cicatrizacao depende de:", "3", Difficulty.MEDIUM, "luz solar", "ausencia de sangue", "renovacao celular", "frio extremo"),
            tf("Febre pode ser resposta contra infeccoes.", "V", Difficulty.EASY),
            fb("Celula de defesa do sangue: ____", "leucocito", Difficulty.HARD),
            mc("Orgao que filtra sangue?", "2", Difficulty.EASY, "pulmao", "rim", "estomago", "coracao"),
            tf("Vacinas treinam o sistema imunologico.", "V", Difficulty.EASY),
            mc("Vitamina ligada a coagulacao?", "3", Difficulty.HARD, "C", "D", "K", "B1"),
            mc("Homeostase e:", "1", Difficulty.HARD, "equilibrio interno", "energia solar", "calor infinito", "perda de agua")
        );

        add("ESCUDO",
            mc("2 Lei de Newton:", "3", Difficulty.MEDIUM, "m/a", "v.t", "m.a", "E.d"),
            tf("Maior massa geralmente significa maior inercia.", "V", Difficulty.EASY),
            mc("Capacete protege porque:", "2", Difficulty.MEDIUM, "aumenta impacto", "distribui impacto", "remove gravidade", "gera velocidade"),
            fb("Unidade de pressao no SI: ____", "pascal", Difficulty.HARD),
            tf("Atrito depende de contato entre superficies.", "V", Difficulty.EASY),
            mc("Objeto parado tende a ficar parado por causa da:", "1", Difficulty.MEDIUM, "inercia", "radiacao", "evaporacao", "densidade"),
            mc("Maior pressao ocorre com:", "3", Difficulty.HARD, "mesma forca em area maior", "forca zero", "mesma forca em area menor", "area gigante"),
            tf("Acao gera reacao oposta de mesma intensidade.", "V", Difficulty.MEDIUM),
            mc("Energia cinetica esta ligada a:", "2", Difficulty.EASY, "temperatura", "movimento", "repouso", "cor"),
            mc("Defesa no jogo parece com:", "1", Difficulty.EASY, "resistencia", "mais dano recebido", "cura inimiga", "perda de turno")
        );

        add("BUFF",
            mc("Buff temporario altera:", "4", Difficulty.EASY, "nome", "cenario", "historia", "atributo por tempo"),
            tf("Aumento de ataque muda o balanceamento.", "V", Difficulty.MEDIUM),
            mc("Ataque 12 com buff de 25% vira:", "2", Difficulty.MEDIUM, "13", "15", "16", "18"),
            mc("Estrutura para guardar buffs ativos?", "1", Difficulty.MEDIUM, "List", "int", "char", "boolean"),
            tf("Buffs podem ser acumulativos ou nao.", "V", Difficulty.EASY),
            mc("Buff de 1 turno deve sair:", "3", Difficulty.MEDIUM, "antes de usar", "nunca", "apos o turno", "ao fechar jogo"),
            mc("Melhor exemplo de buff:", "4", Difficulty.EASY, "perder vida", "travar", "apagar personagem", "aumentar ataque"),
            tf("Buff permanente dura ate fim da batalha ou jogo.", "V", Difficulty.EASY),
            mc("20 +10% e depois +5 =", "2", Difficulty.HARD, "22", "27", "25", "30"),
            fb("Classe Buff poderia ter nome, duracao e ____", "valor", Difficulty.HARD)
        );

        add("HISTORIA",
            mc("Revolucao Francesa comecou em:", "3", Difficulty.MEDIUM, "1492", "1640", "1789", "1917"),
            tf("Independencia do Brasil foi em 1822.", "V", Difficulty.EASY),
            mc("Lei Aurea fez:", "2", Difficulty.EASY, "criou republica", "aboliu escravidao", "iniciou colonizacao", "fundou Brasilia"),
            mc("Inicio da Idade Contemporanea:", "1", Difficulty.HARD, "Revolucao Francesa", "Queda de Constantinopla", "Brasil 1500", "Cruzadas"),
            tf("A 1 Guerra veio antes da 2 Guerra.", "V", Difficulty.EASY),
            mc("Colonial brasileiro comecou forte com:", "4", Difficulty.MEDIUM, "petroleo", "cafe industrial", "soja", "acucar"),
            mc("Guerra Fria: rivalidade entre:", "3", Difficulty.EASY, "Brasil e Argentina", "Franca e Alemanha", "EUA e URSS", "Portugal e Espanha"),
            tf("Inconfidencia Mineira envolveu impostos portugueses.", "V", Difficulty.MEDIUM),
            mc("Republica no Brasil foi proclamada em:", "2", Difficulty.MEDIUM, "1822", "1889", "1930", "1964"),
            fb("Movimento que defendia razao e ciencia: ____", "iluminismo", Difficulty.HARD)
        );

        add("VIDA",
            mc("Organela que produz energia?", "2", Difficulty.MEDIUM, "ribossomo", "mitocondria", "lisossomo", "vacuolo"),
            tf("DNA contem informacoes geneticas.", "V", Difficulty.EASY),
            mc("Fotossintese usa:", "1", Difficulty.MEDIUM, "luz, agua e CO2", "som e areia", "ferro e calor", "petroleo"),
            mc("Selecao natural esta ligada a:", "3", Difficulty.EASY, "Newton", "Dalton", "Darwin", "Pascal"),
            tf("Autotroficos produzem proprio alimento.", "V", Difficulty.MEDIUM),
            fb("Fonte rapida de energia celular: ____", "ATP", Difficulty.HARD),
            mc("Troca gasosa ocorre nos:", "2", Difficulty.MEDIUM, "ossos", "alveolos", "rins", "musculos"),
            tf("Celulas eucariontes possuem nucleo organizado.", "V", Difficulty.EASY),
            mc("Processo que gera duas celulas iguais:", "1", Difficulty.HARD, "mitose", "meiose", "fecundacao", "mutacao"),
            mc("Relacao seres vivos e ambiente:", "3", Difficulty.EASY, "astronomia", "geometria", "ecologia", "mecanica")
        );

        add("CONTRA",
            mc("Negacao de 'A e B':", "4", Difficulty.HARD, "A e nao B", "A ou B", "nao A e nao B sempre", "nao A ou nao B"),
            tf("Defender pode ser util sem dano imediato.", "V", Difficulty.EASY),
            mc("No xadrez, ameaca direta ao rei:", "2", Difficulty.EASY, "roque", "xeque", "empate", "promocao"),
            mc("Se inimigo sempre ataca, boa acao:", "1", Difficulty.MEDIUM, "aumentar defesa", "curar inimigo", "ignorar vida", "jogar aleatorio"),
            tf("Prever acao inimiga faz parte da estrategia.", "V", Difficulty.EASY),
            mc("Resposta proporcional a uma acao:", "3", Difficulty.MEDIUM, "evaporacao", "inercia termica", "acao e reacao", "condensacao"),
            mc("A=true, B=false. A || B =", "1", Difficulty.MEDIUM, "verdadeiro", "falso", "nulo", "erro"),
            tf("Contra-atacar e reagir a uma acao adversaria.", "V", Difficulty.EASY),
            mc("Melhor decisao estrategica:", "4", Difficulty.HARD, "ignorar dados", "repetir sempre", "escolher acaso", "avaliar risco"),
            fb("Operador logico E em Java: ____", "&&", Difficulty.HARD)
        );

        add("MATH",
            mc("3^2 + 4^2 =", "3", Difficulty.MEDIUM, "12", "18", "25", "49"),
            tf("Numero primo tem exatamente dois divisores positivos.", "V", Difficulty.MEDIUM),
            mc("2x + 6 = 18. x =", "2", Difficulty.EASY, "5", "6", "7", "8"),
            mc("Media de 6, 8 e 10:", "1", Difficulty.EASY, "8", "9", "10", "24"),
            tf("Soma dos angulos de um triangulo e 180 graus.", "V", Difficulty.EASY),
            mc("20% de 150:", "4", Difficulty.MEDIUM, "15", "20", "25", "30"),
            mc("PA: a1=2, razao=3. quinto termo:", "3", Difficulty.HARD, "11", "12", "14", "15"),
            tf("Raiz de 144 e 12.", "V", Difficulty.EASY),
            fb("5! = ____", "120", Difficulty.HARD),
            mc("R$80 com 25% de desconto:", "1", Difficulty.MEDIUM, "R$60", "R$65", "R$70", "R$75")
        );

        add("FIREWALL",
            mc("Funcao principal de firewall:", "3", Difficulty.EASY, "brilho", "formatar PC", "filtrar conexoes", "criar senhas"),
            tf("Phishing tenta obter dados enganando usuarios.", "V", Difficulty.EASY),
            mc("Melhora seguranca da conta:", "1", Difficulty.EASY, "2FA", "mesma senha", "senha publica", "links suspeitos"),
            mc("Malware e:", "2", Difficulty.EASY, "monitor", "software malicioso", "cabo", "linguagem segura"),
            tf("Atualizacoes corrigem falhas de seguranca.", "V", Difficulty.EASY),
            mc("Senha mais forte:", "4", Difficulty.MEDIUM, "123456", "senha", "abcdef", "Tigre#47Lua!92"),
            mc("Criptografia serve para:", "3", Difficulty.MEDIUM, "apagar arquivos", "aumentar volume", "proteger dados", "mudar cor"),
            tf("Wi-Fi publico desconhecido pode ser arriscado.", "V", Difficulty.EASY),
            mc("Backup e importante porque:", "1", Difficulty.EASY, "recupera dados", "impede todo virus", "substitui senha", "desliga internet"),
            fb("Engenharia social explora falhas ____", "humanas", Difficulty.HARD)
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

    private Question mc(String text, String answer, Difficulty d, String... options) {
        return new MultipleChoiceQuestion(text, answer, d, options);
    }

    private Question tf(String text, String answer, Difficulty d) {
        return new TrueFalseQuestion(text, answer, d);
    }

    private Question fb(String text, String answer, Difficulty d) {
        return new FillBlankQuestion(text, answer, d);
    }
}
