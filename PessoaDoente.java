package ProjetoVirusZombie;

import java.util.Random;

/**
 * Classe para objetos do tipo Pessoa Doente.
 * @author Gabriel Carvalho 
 * 
 */


public class PessoaDoente extends Pessoa implements IMovable{

    public Virus virus;
    int tempo;
    

    public PessoaDoente() {
    }

    public PessoaDoente(Virus virus, int x, int y, int cor) {
        super(x, y, cor);
        this.virus = virus;
    }



    @Override
    public void mover() {
        Random random = new Random();
        int op = random.nextInt(3);
        int posY = super.getY() + 1;
        int posY2 = super.getY()-1;
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
        


    public Virus getVirus() {
        return virus;
    }


    public void setVirus(Virus virus) {
        this.virus = virus;
    }

}

