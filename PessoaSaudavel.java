
package ProjetoVirusZombie;

import java.util.Random;

/**
 * Classe para objetos do tipo Pessoa Saudavel.
 * @author Gabriel Carvalho
 *
 */

public class PessoaSaudavel extends Pessoa implements IMovable{
    public boolean antidoto;
    int tempo;

    public PessoaSaudavel() {
    }
    
    public PessoaSaudavel(boolean antidoto, int x, int y, int cor) {
        super(x, y, cor);
        this.antidoto = antidoto;
        
    }

    public PessoaSaudavel(boolean antidoto, int tempo, int x, int y, int cor) {
        super(x, y, cor);
        this.antidoto = antidoto;
        this.tempo = tempo;
    }

    public PessoaSaudavel(int x, int y, int cor) {
        super(x, y, cor);
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }






    @Override
    public void mover() {
        Random random = new Random();
        int op = random.nextInt(3);
        int posY = super.getY() + 1;
        int posY2 = super.getY()- 1;
        int posX = super.getX() + 1;
        int posX2 = super.getX() - 1;

        switch (op) {
            case 0:
                super.setY(posY);
                break;
            case 1:
                super.setY(posY2);
                break;
            case 2:
                super.setX(posX);
                break;
            case 3:
                super.setX(posX2);
                break;
        }
    }
    
}

