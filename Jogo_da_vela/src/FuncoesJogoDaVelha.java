public class FuncoesJogoDaVelha {
    // Ultima modificacao: 28/02/2026
    // Mostra o tabuleiro
    public static void mostrarTabuleiro(String[][] tabuleiro) {
        // Espaço para limpar o terminal
        for (int i=0; i!=25; i++) {
            System.out.println(" ");
        }

        // Mostrando tabuleiro
        System.out.println("   A " + "  B " + "  C ");
        for (int i=0; i!= 3; i++) {
            System.out.print((i+1) + " ");
            for (int j=0; j!=3; j++) {
                if (tabuleiro[i][j] != null) {
                    System.out.print(tabuleiro[i][j] + " ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.print("\n");
        }
    }

    // Ultima modificacao: 02/03/2026
    // Traduz a joga do usuario para o sistema de coluna e linha com números
    public record JogadaUsuario(int linha, int coluna) {}
    public static JogadaUsuario transcreverJogadaUsuario(String jogadaUsuario) {
        int linha, coluna;
        char letra;

        // Coletando a linha da jogadaUsuario
        linha = (jogadaUsuario.charAt(1)) - '0';
        linha -= 1;

        // Coletando a coluna da jogadaUsuario
        letra = Character.toLowerCase(jogadaUsuario.charAt(0));
        coluna = (int) letra - 97;

        return new JogadaUsuario(linha, coluna);
    }

    // Ultima modificacao: 01/03/2026
    // Verifica se a jogada e possivel
    public static boolean verificarJogada(String[][] tabuleiro, int linha, int coluna, boolean jogador) {
        boolean verificador = true;
        if (linha < 3 && coluna < 3 && tabuleiro[linha][coluna] == null) {
            verificador = false;
        } else {
            if (jogador) {
                System.out.println("O campo selecionado esta INVALIDO. Por favor digite uma campo VALIDO!");
            }
        }
        return verificador;
    }

    // Ultima modificacao: 02/03/2026
    // Informa se o usuario ou computador ganhou
    public static String verificaGanhador(String simbolo) {
        String retorno = "";
        if (simbolo.equals("[X]")) {
            retorno = "USUARIO";
        } else {
            retorno = "COMPUTADOR";
        }
        return retorno;
    }

    // Ultima modificiacao: 02/03/2026
    // Verifica se o computador ou o usuario ganhou o jogo
    public static boolean verificaGanhador(String[][] tabuleiro) {
        String baseLinha;
        String baseColuna;
        String baseDiagonal;
        String localGanhado = "";
        String ganhador = "";
        boolean resposta = false;

        for(int i=0; i<3; i++){
            // Verifica linha
            baseLinha = tabuleiro[i][0] == null ? "":tabuleiro[i][0];
            if (baseLinha.equals(tabuleiro[i][1]) && baseLinha.equals(tabuleiro[i][2])) {
                resposta = true;
                localGanhado = "linha: " + (i+1);
                ganhador = verificaGanhador(baseLinha);
                break;
            }

            // Verifica coluna
            baseColuna = tabuleiro[0][i] == null? "":tabuleiro[0][i];
            if (baseColuna.equals(tabuleiro[1][i]) && baseColuna.equals(tabuleiro[2][i])) {
                resposta = true;
                localGanhado = "coluna: " + ((char) (i+65)) ;
                ganhador = verificaGanhador(baseColuna);
                break;
            }
        }

        // Verifica diagonais
        baseDiagonal = tabuleiro[1][1] == null ? "":tabuleiro[1][1];
        if (baseDiagonal.equals(tabuleiro[0][0]) && baseDiagonal.equals(tabuleiro[2][2])) {
            resposta = true;
            localGanhado = "DIAGONAL PRINCIPAL";
            ganhador = verificaGanhador(baseDiagonal);
        }
        if (baseDiagonal.equals(tabuleiro[0][2]) && baseDiagonal.equals(tabuleiro[2][0])) {
            resposta = true;
            localGanhado = "DIAGONAL SECUNDARIA";
            ganhador = verificaGanhador(baseDiagonal);
        }

        //Mensagem informando o ganhador
        if (resposta) {
            mostrarTabuleiro(tabuleiro);
            System.out.println("O " + ganhador + " ganhou na " + localGanhado);
        }

        // Retorno
        return resposta;
    }

    // Ultima modificacao: 02/03/2026
    // Verifica se pode continuar o jogo
    public static boolean verificaTabuleiro(String[][] tabuleiro) {
        boolean verificador = false;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (tabuleiro[i][j] == null) {
                    verificador = true;
                    break;
                }
            }
            if(verificador) {break;}
        }
        return verificador;
    }
}

