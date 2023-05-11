package ProjetoVirusZombie;

/**
 * Classe para objetos do tipo Pessoa.
 * @author Gabriel Carvalho 
 * 
 */
public abstract class Pessoa {


    private int x;
    private int y;
    private int cor;

    /**
     * Método construtor
     */
    public Pessoa() {
    }

    /**
     * Método construtor
     *
     * @param x 
     * @param y 
     * @param cor 
     * mundo
     */
    public Pessoa(int x, int y, int cor) {
        this.x = x;
        this.y = y;
        this.cor = cor;
    }


    public int getX() {
        return x;
    }


    public void setX(int x) {
        if(x>59)
        this.x = 0;

        else if(x<0)
        this.x = 59;

        else
        this.x = x;
    }


    public int getY() {
        return y;
    }


    public void setY(int y) {
        if(y>29)
        this.y = 0;

        else if(y<0)
        this.y = 29;

        else
        this.y = y;

    }


    public int getCor() {
        return cor;
    }


    public void setCor(int cor) {
        this.cor = cor;
    }



}

