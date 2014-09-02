/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionpaie;

import javafx.scene.control.TitledPane;

/**
 *
 * @author Ahmed
 */
public class FonctionnairePane  extends TitledPane{
    
    private Fonctionnaire fonctionnaire ;
    
    public FonctionnairePane(Fonctionnaire f , String libeleBanque , String libeleFonction){
       
        super( f.getPrenomFonctionnaire()+ "  "+f.getNomFonctionnaire(),new FonctionnaireInfoGrid(f,libeleBanque,libeleFonction)) ;
         this.fonctionnaire=f ;
    }
    
    public Fonctionnaire getFonctionnaire(){
        return fonctionnaire ;
    }
    
}
