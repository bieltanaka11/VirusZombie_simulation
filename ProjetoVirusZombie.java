
package ProjetoVirusZombie;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Classe main do tipo projeto virus zumbi.
 * @author Gabriel Carvalho 
 * 
 */
public class ProjetoVirusZombie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mundo m = new Mundo();
        
    UIManager UI=new UIManager();
    
    UI.put("OptionPane.background", Color.white);
    UI.put("Panel.background", Color.white);


        
        ImageIcon iconSaudaveis = new ImageIcon("src\\ProjetoVirusZombie\\saudaveis.png");
        ImageIcon iconMorte = new ImageIcon("src\\ProjetoVirusZombie\\caixao.png");
        ImageIcon iconZumbi = new ImageIcon("src\\ProjetoVirusZombie\\zumbi.jpg");
        
        int result = JOptionPane.showConfirmDialog((Component) null, "BEM VINDO!!\nOK para começar\nCANCEL para cancelar",
        "Simulação Transmissão Vírus Zumbi", JOptionPane.OK_CANCEL_OPTION,0, iconZumbi);
        
        if(result == 0){
        switch (m.desenhaMundo()) {
        
        case 1:
        JOptionPane.showMessageDialog(null,"Não há mais pessoas infectadas","Atenção", 0, iconSaudaveis);
        break;
        case 2:
        JOptionPane.showMessageDialog(null,"Não há mais pessoas saudáveis","Atenção",0,iconMorte);
        break;
        default:
        break;
        
        }
        }
        else if(result == 2){
        System.out.println("A simulção foi cancelada!!!!");
        }
        }

    }


    
            


