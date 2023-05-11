
package ProjetoVirusZombie;

/**
 * A classe mundo contém a matriz que terá os hospitais e pessoas doentes, 
 * saudaveis e curadas.
 */

import java.util.ArrayList;
import java.util.Random;


/**

 * @author Gabriel Carvalho 
 
 * @see Hospital
 * @see PessoaDoente
 * @see PessoaSaudavel
 * @see Pessoa
 * @see Virus
 */
public class Mundo {

    public static String corVermelha = "\033[41m \033[0m";
    public static String corAzul = "\033[44m \033[0m";
    public static String corAmarela = "\033[43m \033[0m";
    public static String corBranca = "\033[47m \033[0m";
    public static String corMagenta = "\033[45m \033[0m";
    public static String corPreta = "\033[40m \033[0m";
    public static String corCiano = "\033[46m \033[0m";
    
    ArrayList<Hospital> H;
    ArrayList<PessoaDoente> D;
    ArrayList<PessoaSaudavel> S;

    Random R = new Random();
    
    public double contadorTempo = 0;

    public int mapaInicial[][] = 
                         {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}, 
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                          {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
    /**
     * Construtor mundo que contém os arraylist.
     */

    public Mundo() {
        H = new ArrayList<>();
        D = new ArrayList<>();
        S = new ArrayList<>();
    }

    /**
     * coresMapa receber valores inteiros que correspondem a hospitais, pessoas saudáveis,
     * pessoas doentes.

     *
     * @param cor
     */
    public void coresMapa(int cor) {
        switch (cor) {
            case 1:
                System.out.print(corCiano);
                break;
            case 3:
                System.out.print(corVermelha);
                break;
            case 5:
                System.out.print(corAzul);
                break;
            case 6:
                System.out.print(corAmarela);
                break;
            case 7:
                System.out.print(corAzul);
                break;
            case 8:
                System.out.print(corMagenta);
                break;                
            default:
                System.out.print(" ");
                break;
        }
    }

    /**
     * Método para construir o hospital dentro da matriz mapaInicial, o hospital é 5x5, onde i é a posição do hospital em y e
     * j é a posição do hospital em x.
     * @param mapaHospital
     */
    public void construcaoHospital(int mapaHospital[][]) {
        for (int i = 0; i < mapaHospital.length; i++) {
            for (int j = 0; j < mapaHospital[i].length; j++) {
                if ((i == 5 && j == 2) || (i == 5 && j == 50) || (i == 23 && j == 30)) {

                    for (int row = 0; row < 5; row++) {
                        for (int col = 0; col < 5; col++) {

                            if ((col == 2 && (row >= 1 && row <= 3)) || (row == 2 && (col >= 1 && col <= 3))) {
                                mapaHospital[i + row][j + col] = H.get(0).getCor() - 2;
                            } else {
                                mapaHospital[i + row][j + col] = H.get(0).getCor();
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Método para colorir os hospitais, esse método é chamado logo após a construção dele.
     * Nesse método se recebe o ArrayList de hospital e a quantidade de hospitais é definida como 3.

     *
     * @param h.
     */
    public void criarHospital(ArrayList<Hospital> h) {
        for (int i = 0; i < 3; i++) {
            h.add(new Hospital(3));
        }
    }
    /**
     * Método para criar no ArrayList de PessoasSaudaveis "pessoas". Recebe-se o
     * ArrayList. O número de pessoas para ser criado são 100, a cor de pessoas saudáveis é definida
     * como 5(azul) e a posição é gerada de forma randômica.

     *
     * @param vigoroso 
     * 
     */
    public void criarPessoaSaudavel(ArrayList<PessoaSaudavel> vigoroso) {
        for (int i = 0; i < 100; i++) {
            while (true) {
                int x = R.nextInt(60);
                int y = R.nextInt(30);
                if (mapaInicial[y][x] == 2 || mapaInicial[y][x] == 1 || mapaInicial[y][x] == 0) {
                    vigoroso.add(new PessoaSaudavel(x, y, 5));
                    break;
                }
            }
        }
    }


    /**
     * Método para criar no ArrayList de PessoasDoentes "pessoas". Recebe-se o array de pessoas doentes
     * e o número de pessoas que deseja criar são 2, a cor de pessoas doentes é definida como 6(amarela)e a
     * posição é gerada de forma randômica.
     * A pessoa doente só é criada depois de verificar através de um while se não há uma pessoa saudável nessa mesma posição.

     *
     * @param mórbido
     * 
     */
    public void criarPessoaDoente(ArrayList<PessoaDoente> mórbido) {
        for (int i = 0; i < 2; i++) {
            Virus V = new Virus((int) contadorTempo);
            boolean run = true;

            while (run) {
                int x = R.nextInt(90);
                int y = R.nextInt(30);
                if (mapaInicial[y][x] == 2 || mapaInicial[y][x] == 1 || mapaInicial[y][x] == 0) {
                    for (int j = 0; j < S.size(); j++) {
                        if ((x == S.get(j).getX() && y == S.get(j).getY())
                                || (x + 1 == S.get(j).getX() && y == S.get(j).getY())
                                || (x - 1 == S.get(j).getX() && y == S.get(j).getY()
                                || (x == S.get(j).getX() && y + 1 == S.get(j).getY())
                                || (x == S.get(j).getX() && y - 1 == S.get(j).getY()))) {
                            break;
                        }
                        
                        else if (j == S.size() - 1) {
                            mórbido.add(new PessoaDoente(V, x, y, 6));
                            run = false;
                        }
                    }
                }
            }
        }
    }
    


    /**
     * Método usado para verificar se houve colisão entre uma pessoa doente com uma pessoa saudável.
     * Como parâmetro recebe um valor para pessoa saudável e um índice, esses parâmetros vem do método verificaPessoaSaudavel.
     * Se a colisão de fato acontecer é adicionado uma nova pessoa doente ao ArrayList de pessoaDoente é removido uma pessoa 
     * saudável e retornasse estado = true.
     *
     * @param aux
     * @param vigoroso
     * @return boolean estado
     */
    public boolean colisaoPessoa(int aux, PessoaSaudavel vigoroso) {
        boolean condicao = false;
        if(vigoroso.getCor() == 7 || vigoroso.getCor() == 8){
            vigoroso.mover();
        }
        else{
            for (int i = 0; i < D.size(); i++) {
            if ((vigoroso.getCor() == 5 && vigoroso.getX() == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() + 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() - 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() + 1 == D.get(i).getY())
                    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() - 1 == D.get(i).getY())) {

                Virus v = new Virus((int) contadorTempo);
                D.add(new PessoaDoente(v, S.get(aux).getX(), S.get(aux).getY(), 6));
               
                D.get(D.size() - 1).mover();
                mapaInicial[D.get(D.size() - 1).getY()][D.get(D.size() - 1).getX()] = D.get(D.size() - 1).getCor();

                S.remove(aux);
                condicao = true;
                break;
            }
        }
            if (condicao == false) {
                vigoroso.mover();
                condicao = false;
            }
        }

        return condicao;
    }
    
    /**
     * Método para verificar se houve colisão.
     * Após, a posição de pessoaSaudavel é salva no copiaMapa.
     * Depois é verificado se houve a colisão pelo método colisaoPessoa.
     *
     * @param copiaMapa 
     */
    
    public void verificaPessoaSaudavel(int[][] copiaMapa) {
        for (int i = 0; i < S.size(); i++) {
            mapaInicial[S.get(i).getY()][S.get(i).getX()] = copiaMapa[S.get(i).getY()][S.get(i).getX()];

            boolean contaminado = colisaoPessoa(i, S.get(i));

            if (S.isEmpty() == false && contaminado == false) {
                mapaInicial[S.get(i).getY()][S.get(i).getX()] = S.get(i).getCor();
            }
        }
    }
    
    /**
     * Método usado para verificar se houve colisão entre uma pessoa doente com uma pessoa saudável curada.
     * Como parâmetro recebe um valor para pessoa saudável e um índice, esses parâmetros vem do método verificaPessoaCuradaInfectada.
     * Se a colisão de fato acontecer é apenas alterada a cor( de 7 para 8) e retornasse estado = true.

     *
     * @param aux
     * @param vigoroso
     * @return boolean estado
     */
    public boolean colisaoPessoaCurada(int aux, PessoaSaudavel vigoroso) {
        boolean condicao =  false;
        if(vigoroso.getCor() == 5 || vigoroso.getCor() == 8){
            vigoroso.mover();
        }
        else{
            for (int i = 0; i < D.size(); i++) {
            if ((vigoroso.getCor() == 7 && vigoroso.getX() == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() + 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() - 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
                    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() + 1 == D.get(i).getY())
                    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() - 1 == D.get(i).getY())) {

                
               S.add(new PessoaSaudavel(true,(int) contadorTempo, S.get(aux).getX(), S.get(aux).getY(), 8));
                
               S.get(S.size() - 1).mover();
               mapaInicial[S.get(S.size() - 1).getY()][S.get(S.size() - 1).getX()] = S.get(S.size() - 1).getCor();
               S.remove(aux);
               condicao = true;
               break;
            }
        }
        if ( condicao == false) {
            vigoroso.mover();
            condicao = false;
        }
        }

        return condicao;
    }

    
    
     /**
     * Método usado para verificar se houve colisão entre uma pessoa saudável curada com vírus com uma pessoa saudável(5) 
     * ou uma pessoa saudável curada(7).
     * Como parâmetro recebe um valor para pessoa saudável e um indice, esses parâmetros vem do método verificaPessoaCuradadaInfectada.
     * Se a colisão de fato acontecer com a pessoa curada é apenas alterada a cor( de 7 para 8) e retornasse estado = true.
     * E se a colisão acontecer com uma pessoa saudável é adicionado uma nova pessoa doente ao ArrayList de pessoaDoente é removido uma pessoa 
     * saudável e retornasse estado = true.
     *
     * @param aux
     * @param vigoroso
     * @return boolean estado
     */   
    
    public boolean colisaoPessoaCuradaVirus(int aux, PessoaSaudavel vigoroso) {
    boolean condicao = false;
    if (vigoroso.getCor() == 8){
    for (int i = 0; i < D.size(); i++) {
    if ((vigoroso.getCor() == 5  &&  vigoroso.getX() == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() + 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() - 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() + 1 == D.get(i).getY())
    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() - 1 == D.get(i).getY())) {
    
    Virus v = new Virus((int) contadorTempo);
    D.add(new PessoaDoente(v, S.get(aux).getX(), S.get(aux).getY(), 6));
    
    D.get(D.size() - 1).mover();
    mapaInicial[D.get(D.size() - 1).getY()][D.get(D.size() - 1).getX()] = D.get(D.size() - 1).getCor();
    
    S.remove(aux);
    condicao = true;
    break;
    }else if ((vigoroso.getCor() == 7 && vigoroso.getX() == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() + 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() - 1 == D.get(i).getX() && vigoroso.getY() == D.get(i).getY())
    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() + 1 == D.get(i).getY())
    || (vigoroso.getX() == D.get(i).getX() && vigoroso.getY() - 1 == D.get(i).getY())) {
    
    
    S.add(new PessoaSaudavel(true,(int) contadorTempo, S.get(aux).getX(), S.get(aux).getY(), 8));
    
    S.get(S.size() - 1).mover();
    mapaInicial[S.get(S.size() - 1).getY()][S.get(S.size() - 1).getX()] = S.get(S.size() - 1).getCor();
    S.remove(aux);
    condicao = true;
    break;
    }
    }
    if ( condicao == false) {
    vigoroso.mover();
    condicao = false;
    }
    }
    
    return condicao;
    }
    /**
     * Método para checar se uma pessoa doente entrou no hospital.
     * Por parâmetro recebe um índice que vem do método verificaPessoaInfectada e também um parametro de PessoaDoente que verifica
     * Se houve a colisão entre uma pessoa doente(6) com o hospital, após isso é apagado a pessoa doente(6) e
     * é adicionado uma nova pessoa saudável(5) e estudado = true.
     *
     * @param indice
     * @param mórbido 
     * @param copiaMapa 
     * @return boolean cura
     */
    public boolean entradaHospital(int indice, PessoaDoente mórbido, int[][] copiaMapa) {
        boolean recuperacao = false;
        int aux = copiaMapa[mórbido.getY()][mórbido.getX()];
        
        if(mórbido.getCor() == 8){
            mórbido.mover();
            recuperacao = true;
        }
        
        else if (mórbido.getCor() == 6 && aux == H.get(0).getCor() || aux == H.get(0).getCor() + 1) {

            S.add(new PessoaSaudavel(mórbido.getX(), mórbido.getY(), 5));
            S.get(S.size() - 1).mover();

            mapaInicial[S.get(S.size() - 1).getY()][S.get(S.size() - 1).getX()] = S.get(S.size() - 1).getCor();
            D.remove(indice);
            recuperacao = true;
        } 
        
        else {
            mórbido.mover();
            recuperacao = false;
        }
        return recuperacao;
    }

    
    /**
     * Método para checar se uma pessoa saudável entrou no hospital.
     * Por parâmetro recebe um índice que vem do método verificaPessoaCurada e também um parametro de PessoaSaudavel que verifica
     * Se houve a colisão entre uma pessoa saudável(5) com o hospital, após isso
     * é adicionado uma nova pessoa saudável(7) e estado = true.
     *
     * @param indice
     * @param vigoroso 
     * @param copiaMapa
     * @return boolean cura
     */
    public boolean entradaHospitalSaudavel(int indice, PessoaSaudavel vigoroso, int[][] copiaMapa) {
        boolean imunização = false;
        int aux = copiaMapa[vigoroso.getY()][vigoroso.getX()];
        if(vigoroso.getCor() == 8){
            vigoroso.mover();
            imunização = true;
        }
        else if (vigoroso.getCor() == 5 && aux == H.get(0).getCor() || aux == H.get(0).getCor() + 1) {

            S.add(new PessoaSaudavel(true,vigoroso.getX(), vigoroso.getY(), 7));
            S.get(S.size()-  1).mover();
            
            mapaInicial[S.get(S.size() - 1).getY()][S.get(S.size() - 1).getX()] = S.get(S.size() - 1).getCor();
            
            
            S.remove(indice);
            imunização = true;
        } 
         
        
        else {
           vigoroso.mover();
           imunização = false;
        }
        return imunização;
   
    }
    
    /**
     * Método para verificar se a pessoa curada entrou no hospital, chamando o método entradaHospitalSaudavel.
     * A posição de pessoaSaudavel é salva no copiaMapa.
     *
     * @param copiaMapa 
     */
    public void verificaPessoaCurada(int[][] copiaMapa) {
            for (int j = 0; j < S.size(); j++) {
            mapaInicial[S.get(j).getY()][S.get(j).getX()] = copiaMapa[S.get(j).getY()][S.get(j).getX()];
            

            if (S.isEmpty() == false) {
                boolean curado = entradaHospitalSaudavel(j, S.get(j), copiaMapa);

                if (curado == false) {
                    mapaInicial[S.get(j).getY()][S.get(j).getX()] = S.get(j).getCor();
                }
            }
        }
    }


    /**
     * Método para verificar se uma PessoaDoente está com o vírus há mais que 30
     * segundos. 
     * Se a PessoaDoente está por mais de 30 segundos ela morre e é removida do ArrayList PessoaDoente e estado = true.
     * É recebido por parâmetro índice, array PessoaDoente e o tempo que é recebido pelo método verificaPessoaInfectada.
     * @param indice
     * @param mórbido
     * @param prazo
     * @return boolean estado
     */
    public boolean tempoContaminado(int indice, PessoaDoente mórbido, int prazo) {
        boolean condicao = false;
        if (prazo - mórbido.virus.getTempoContaminado() >= 30) {
            D.remove(indice);
            condicao = true;
            
        } else {
            condicao = false;
        }
        return condicao;
    }
    /**
     * Método para verificar se o tempo de pessoa com o vírus passou de 30 segundos pelo método tempoContaminado.
     * A posição de pessoaSaudavel é salva no copiaMapa.
     *
     * @param copiaMapa 
     */
    public void verificaPessoaInfectada(int[][]  copiaMapa ) {
        for (int i = 0; i < D.size(); i++) {
            mapaInicial[D.get(i).getY()][D.get(i).getX()] = copiaMapa[D.get(i).getY()][D.get(i).getX()];

            boolean tempoEsgotado = tempoContaminado(i, D.get(i), (int) contadorTempo);

            if (D.isEmpty() == false && tempoEsgotado == false) {
                boolean contaminado = entradaHospital(i, D.get(i), copiaMapa);

                if (contaminado == false) {
                    mapaInicial[D.get(i).getY()][D.get(i).getX()] = D.get(i).getCor();
                }
            }
        }
    }
     /**
     * Método para verificar se uma PessoaSaudavel curada está com o vírus há mais que 30
     * segundos. 
     * Se a PessoaSaudavel curada está por mais de 30 segundos sua cor passa a ser 7 e estado = true.
     * É recebido por parâmetro índice, array PessoaDoente e o tempo que é recebido pelo método verificaPessoaInfectada.
     * @param indice
     * @param vigoroso
     * @param prazo
     * @return boolean estado
     */
    
    public boolean tempoContaminadoCurado(int indice, PessoaSaudavel vigoroso, int prazo) {
        boolean condicao = false;
        
        if (vigoroso.getCor() == 8 && prazo - vigoroso.getTempo() >= 30) {

            S.add(new PessoaSaudavel(true,S.get(indice).getX(), S.get(indice).getY(), 7));
            S.remove(indice);
            condicao = true;
            
        } else {
            condicao = false;
        }
        return condicao;
    }
    /**
     * Método para verificar se o tempo de pessoa saudável, curada e com o vírus passou de 30 segundos pelo método tempoContaminadoVacinado.
     * A posição de pessoaSaudavel é salva no copiaMapa.
     *
     * @param copiaMapa 
     */
    public void verificaPessoaCuradaInfectada(int[][] copiaMapa ) {
        for (int i = 0; i < S.size(); i++) {
            mapaInicial[S.get(i).getY()][S.get(i).getX()] = copiaMapa [S.get(i).getY()][S.get(i).getX()];
            
            boolean tempoEsgotado = tempoContaminadoCurado(i, S.get(i), (int) contadorTempo);
            
            
            
            if (S.isEmpty() == false && tempoEsgotado == false) {
                boolean contaminado = colisaoPessoaCurada(i, S.get(i));

                if (contaminado == false) {
                    mapaInicial[S.get(i).getY()][S.get(i).getX()] = S.get(i).getCor();
                }
            }
        }
    }

    /**
     * Método para verificar se houve colisão com pessoa vacinada com virus(8).
     * Após, a posição de pessoaSaudavel é salva no copiaMapa.
     * Depois é verificado se houve a colisão pelo método colisaoPessoaVacinadaVirus.
     *
     * @param copiaMapa 
     */
     public void verificaColisaoPessoaVacinadaVirus(int[][] copiaMapa) {
    for (int i = 0; i < S.size(); i++) {
    
    mapaInicial[S.get(i).getY()][S.get(i).getX()] = copiaMapa[S.get(i).getY()][S.get(i).getX()];
    
    boolean contaminado = colisaoPessoaCuradaVirus(i, S.get(i));
    
    if (S.isEmpty() == false && contaminado == false) {
    mapaInicial[S.get(i).getY()][S.get(i).getX()] = S.get(i).getCor();
    }
    }
    }
    



    /**
     *
     * @return int copiaMapa[][] 
     */
    public int[][] mapaEstatico() {
        int[][] copiaMapa = new int[mapaInicial.length][];
        for (int i = 0; i < mapaInicial.length; i++) {
            copiaMapa[i] = mapaInicial[i].clone();
        }
        return copiaMapa;
    }

    /**
     * Método para desenhar o mapa principal com as informações necessárias.
     */
    public int desenhaMundo() {
        criarHospital(H);
        construcaoHospital(mapaInicial);
        criarPessoaSaudavel(S);
        criarPessoaDoente(D);

        int[][] myStaticMap = mapaEstatico();

        while(true){
                
                if (D.isEmpty()) {
                    return 1;
                    
                } else if (S.isEmpty()) { 
                    return 2;
                   
                } else if (D.size() + S.size() == 0) {    
                   return 3;
                   
                }
                else {
                    verificaColisaoPessoaVacinadaVirus( myStaticMap);
                    verificaPessoaInfectada(myStaticMap);
                    verificaPessoaCurada(myStaticMap);
                    verificaPessoaSaudavel(myStaticMap);
                    verificaPessoaCuradaInfectada(myStaticMap);
                    
                    System.out.println("************************************************************************************");
                    System.out.println("************************************************************************************");
                    System.out.println("************************************************************************************");
                    System.out.println("************************************************************************************");
                    System.out.println("****** SIMULAÇÃO APOCALIPSE ZUMBI ****************** SIMULAÇÃO APOCALIPSE ZUMBI*****");
                    System.out.printf("                            Tempo de simulação (em segundos): %d \n\n", (int) contadorTempo);
                    contadorTempo += 1;
                    System.out.println("    "+ corAzul + " Número de pessoas saudáveis: " + S.size() + "  "+ corAmarela  + " Número de pessoas infectadas: " + D.size() );
                    System.out.println("                           Total de pessoas: " + (S.size() + D.size()) + "\n");

                    for (int[] mapa1 : mapaInicial) {
                        System.out.print("        ");
                        for (int j = 0; j < mapaInicial[0].length; j++) {
                            coresMapa(mapa1[j]);
                        }
                        System.out.println();
                    }
                } 
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

            }
 
        };
        
