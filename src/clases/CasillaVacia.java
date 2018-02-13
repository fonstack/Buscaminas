package clases;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;

public class CasillaVacia extends Casilla {
    private int minasAlrededor;
    static private int destapadas;

    public CasillaVacia(int coorX, int coorY, FrameJuego ventana) {
        super(coorX, coorY, ventana);
        this.minasAlrededor = calcularMinasAlrededor();
        this.setFocusPainted(false);
    }
    
    

    public int calcularMinasAlrededor(){
        int minas = 0;
        int i = this.coorX;
        int j = this.coorY;

        
        // Si está en la primera fila
        if(i == 0){
            // Si esta en la primera columna
            if(j == 0){
                if(FrameJuego.casillasMinadas[i][j+1]== true){                  minas++;}
                if(FrameJuego.casillasMinadas[i+1][j+1]== true){                  minas++;}
                if(FrameJuego.casillasMinadas[i+1][j]== true){                  minas++;}
                return minas;
            }
            //Si esta en la última columna
            if(j == (FrameDificultad.columnas-1) ){
                if(FrameJuego.casillasMinadas[i][j-1]== true){         minas++;}
                if(FrameJuego.casillasMinadas[i+1][j-1]== true){         minas++;}
                if(FrameJuego.casillasMinadas[i+1][j]== true){           minas++;}
                return minas;
            }
            // Si está entre la primera y la última columna  
            else{
                if(FrameJuego.casillasMinadas[i][j-1]== true){                minas++;}
                if(FrameJuego.casillasMinadas[i][j+1]== true){                minas++;}
                if(FrameJuego.casillasMinadas[i+1][j-1]== true){              minas++;}
                if(FrameJuego.casillasMinadas[i+1][j]== true){                minas++;}
                if(FrameJuego.casillasMinadas[i+1][j+1]== true){              minas++;}
                return minas;
            }  
        }

        



        // Si está en la última fila
        else if( i == (FrameDificultad.filas-1) ){
                // Si esta en la primera columna
                if(j == 0){
                    if(FrameJuego.casillasMinadas[i-1][j]== true){             minas++;}
                    if(FrameJuego.casillasMinadas[i-1][j+1]== true){           minas++;}
                    if(FrameJuego.casillasMinadas[i][j+1]== true){             minas++;}
                    return minas;
                }
                //Si esta en la última columna
                if(j == (FrameDificultad.columnas-1) ){
                    if(FrameJuego.casillasMinadas[i-1][j]== true){             minas++;}
                    if(FrameJuego.casillasMinadas[i-1][j-1]== true){           minas++;}
                    if(FrameJuego.casillasMinadas[i][j-1]== true){             minas++;}
                    return minas; 
                }
                // Si está entre la primera y la última columna
                else{
                    if(FrameJuego.casillasMinadas[i][j-1]== true){             minas++;}
                    if(FrameJuego.casillasMinadas[i][j+1]== true){             minas++;}
                    if(FrameJuego.casillasMinadas[i-1][j-1]== true){           minas++;}
                    if(FrameJuego.casillasMinadas[i-1][j]== true){             minas++;}
                    if(FrameJuego.casillasMinadas[i-1][j+1]== true){           minas++;}
                    return minas;    
                }
            }

        
        // Si está en la primera columna excepto en las posiciones esquinísticas
        else if(j == 0   &&  i!=0    &&  i!=(FrameDificultad.filas-1)){
            if(FrameJuego.casillasMinadas[i+1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i-1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i+1][j+1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i-1][j+1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i][j+1]== true){                     minas++;}
            return minas;  
        }


        // Si está en la última columna excepto en las posiciones esquinísticas
        else if(j == (FrameDificultad.columnas-1) &&  i!=0    &&  i!=(FrameDificultad.filas-1)){
            if(FrameJuego.casillasMinadas[i+1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i-1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i+1][j-1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i-1][j-1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i][j-1]== true){                     minas++;}
            return minas;  
        }


        // Si está en cualquier posición del centro
        else{
            if(FrameJuego.casillasMinadas[i-1][j-1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i-1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i-1][j+1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i][j-1]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i][j+1]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i+1][j-1]== true){                   minas++;}
            if(FrameJuego.casillasMinadas[i+1][j]== true){                     minas++;}
            if(FrameJuego.casillasMinadas[i+1][j+1]== true){                   minas++;}
            return minas;  
        }
    }

    @Override
    public void destapar() {
        
        if(this.estado != 0){
            return;
        }
        
     
        this.setBackground(new Color(240, 240, 240));
        this.estado = 1;
        
        // Escribir el número de minas alrededor
        switch (this.minasAlrededor) {
            case 1:
                this.setText("1");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.darkGray);
                break;
            case 2:
                this.setText("2");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.blue);
                break;
            case 3:
                this.setText("3");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.MAGENTA);
                break;
            case 4:
                this.setText("4");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.GRAY);
                break;
            case 5:
                this.setText("5");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.orange);
                break;
            case 6:
                this.setText("6");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.RED);
                break;
            case 7:
                this.setText("7");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.PINK);
                break;
            case 8:
                this.setText("8");
                this.setFont(new Font("Calibri Light", 1, 14));
                this.setForeground(Color.BLACK);
                break;
                
            case 0:
                
                int i = this.coorX;
                int j = this.coorY;
                
                // Si está en la primera fila
                if(i == 0){
                    // Si esta en la primera columna
                    if(j == 0){
                        FrameJuego.casillas[i][j+1].destapar();
                        FrameJuego.casillas[i+1][j+1].destapar(); 
                        FrameJuego.casillas[i+1][j].destapar();
                    }
                    //Si esta en la última columna
                    else if(j == (FrameDificultad.columnas-1) ){
                        FrameJuego.casillas[i][j-1].destapar();         
                        FrameJuego.casillas[i+1][j-1].destapar();         
                        FrameJuego.casillas[i+1][j].destapar();           
                    }
                    // Si está entre la primera y la última columna  
                    else{
                        FrameJuego.casillas[i][j-1].destapar();                
                        FrameJuego.casillas[i][j+1].destapar();                
                        FrameJuego.casillas[i+1][j-1].destapar();              
                        FrameJuego.casillas[i+1][j].destapar();                
                        FrameJuego.casillas[i+1][j+1].destapar();              
                    }  
                }

                // Si está en la última fila
                else if( i == (FrameDificultad.filas-1) ){
                        // Si esta en la primera columna
                        if(j == 0){
                            FrameJuego.casillas[i-1][j].destapar();             
                            FrameJuego.casillas[i-1][j+1].destapar();           
                            FrameJuego.casillas[i][j+1].destapar();             
                        }
                        //Si esta en la última columna
                        else if(j == (FrameDificultad.columnas-1) ){
                            FrameJuego.casillas[i-1][j].destapar();             
                            FrameJuego.casillas[i-1][j-1].destapar();           
                            FrameJuego.casillas[i][j-1].destapar();             
                        }
                        // Si está entre la primera y la última columna
                        else{
                            FrameJuego.casillas[i][j-1].destapar();             
                            FrameJuego.casillas[i][j+1].destapar();             
                            FrameJuego.casillas[i-1][j-1].destapar();           
                            FrameJuego.casillas[i-1][j].destapar();             
                            FrameJuego.casillas[i-1][j+1].destapar();           
                        }
                    }


                // Si está en la primera columna excepto en las posiciones esquinísticas
                else if(j == 0   &&  i!=0    &&  i!=(FrameDificultad.filas-1)){
                    FrameJuego.casillas[i+1][j].destapar();                     
                    FrameJuego.casillas[i-1][j].destapar();                     
                    FrameJuego.casillas[i+1][j+1].destapar();                   
                    FrameJuego.casillas[i-1][j+1].destapar();                   
                    FrameJuego.casillas[i][j+1].destapar();                     
                }


                // Si está en la última columna excepto en las posiciones esquinísticas
                else if(j == (FrameDificultad.columnas-1) &&  i!=0    &&  i!=(FrameDificultad.filas-1)){
                    FrameJuego.casillas[i+1][j].destapar();                     
                    FrameJuego.casillas[i-1][j].destapar();                     
                    FrameJuego.casillas[i+1][j-1].destapar();                  
                    FrameJuego.casillas[i-1][j-1].destapar();                   
                    FrameJuego.casillas[i][j-1].destapar();                     
                }


                // Si está en cualquier posición del centro
                else{
                    FrameJuego.casillas[i-1][j-1].destapar();                   
                    FrameJuego.casillas[i-1][j].destapar();                     
                    FrameJuego.casillas[i-1][j+1].destapar();                   
                    FrameJuego.casillas[i][j-1].destapar();                     
                    FrameJuego.casillas[i][j+1].destapar();                     
                    FrameJuego.casillas[i+1][j-1].destapar();                   
                    FrameJuego.casillas[i+1][j].destapar();                     
                    FrameJuego.casillas[i+1][j+1].destapar();                   
                }
                break;
                
            default:
                break;
        }
        
        destapadas++;
            
        if(destapadas == ( ((FrameDificultad.filas) * (FrameDificultad.columnas)) - (FrameDificultad.minas) ) ){
            
            this.ventana.flagearMinadas();
            
            destapadas = 0;
            this.ganar();
            
        }
        
    }
    
    private void ganar(){
        int respuesta = JOptionPane.showConfirmDialog(null, "           ¡¡HAS GANADO!!\nDesea jugar una nueva partida?", "¿Qué desea hacer?", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE );
        
        if(respuesta == JOptionPane.NO_OPTION){
            System.exit(0);
        }else{
            this.ventana.perder();
            FrameDificultad f = new FrameDificultad();
            f.setVisible(true);
    }
    }
    
    public static void reiniciarDestapadas(){
        destapadas = 0;
    }
    
}