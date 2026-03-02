import java.util.*;

public class Main {
    static void main() {
        // Criação das variáveis
        String[][] tabuleiro = new String[3][3];
        Scanner entrada = new Scanner(System.in);

        // Colentado jogada do usuário
        FuncoesJogoDaVelha.JogadaUsuario jogadaUsuario;

        while (!FuncoesJogoDaVelha.verificaGanhador((tabuleiro)) && FuncoesJogoDaVelha.verificaTabuleiro(tabuleiro)) { // Trocar para do while
            FuncoesJogoDaVelha.mostrarTabuleiro(tabuleiro);
            // Solicita e verifica o numero do usuario
            do {
                System.out.print("Por favor, faça sua jogada: ");
                jogadaUsuario = FuncoesJogoDaVelha.transcreverJogadaUsuario(entrada.nextLine());
            } while (FuncoesJogoDaVelha.verificarJogada(tabuleiro, jogadaUsuario.linha(), jogadaUsuario.coluna(), true));

            // Marcar a escolha do usuário
            tabuleiro[jogadaUsuario.linha()][jogadaUsuario.coluna()] = "[X]";
            System.out.println("Sua escolha foi marcada com sucesso!");

            // Verifica a possibilidade de continuar o jogo
            if (!FuncoesJogoDaVelha.verificaTabuleiro(tabuleiro) || FuncoesJogoDaVelha.verificaGanhador(tabuleiro)) {break;}

            // Jogada do computador
            Random gerador = new Random();
            int compLinha;
            int compColuna;
            do {
                compLinha = gerador.nextInt(0, 3);
                compColuna = gerador.nextInt(0, 3);
            } while (FuncoesJogoDaVelha.verificarJogada(tabuleiro, compLinha, compColuna, false));
            tabuleiro[compLinha][compColuna] = "[O]";
        }
    }
}