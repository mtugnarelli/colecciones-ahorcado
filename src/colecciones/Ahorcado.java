package colecciones;

import java.util.LinkedList;
import java.util.List;

public class Ahorcado {

    private List<Character> caracteresDeLaPalabra;
    private List<Character> caracteresAdivinados;
    private int chancesRestantes;

    /**
     * post: inicializar el juego a partir de la palabraAAdivinar y la cantidad de 
     *       chances disponibles inicialmente para arriesgar letras.
     */
    public Ahorcado(String palabraAAdivinar, int cantidadDeChances) {

        this.chancesRestantes = cantidadDeChances;
        this.caracteresDeLaPalabra = new LinkedList<>();
        this.caracteresAdivinados = new LinkedList<>();

        this.inicializarCaracteres(palabraAAdivinar);
    }

    private void inicializarCaracteres(String palabraAAdivinar) {

        for (int i = 0; i < palabraAAdivinar.length(); i++) {
            
            this.caracteresDeLaPalabra.add(palabraAAdivinar.charAt(i));
            this.caracteresAdivinados.add('_');
        }
    }

    /**
     * post: devuelve la cantidad de chances restantes para arriesgar una 
     *       letra que no exista en la palabra.
     */
    public int obtenerChancesRestantes() {

        return this.chancesRestantes;
    }

    private void restarUnaChance() {
     
        this.chancesRestantes--;
    }

    /**
     * post: devuelve la palabra, enmascarada por _ (guión bajo) 
     *       en aquellas letras desconocidas.
     */
    public String obtenerEstado() {

        StringBuilder palabraAdivinada = new StringBuilder();
        
        for (Character letra : this.caracteresAdivinados) {
            
            palabraAdivinada.append(letra);
        }
    
        return palabraAdivinada.toString();
    }

    /**
     * post: arriesgar una letra, consumiendo una chance si esta
     *       no forma parte de la palabra a adivinar.
     */
    public void arriesgarLetra(char letra) {
        
        if (! this.perdio()) {

            int coincidencias = 0;
            
            for (int i = 0; i < this.caracteresDeLaPalabra.size(); i++) {
                if (this.caracteresDeLaPalabra.get(i) == letra) {
                    this.caracteresAdivinados.set(i, letra);
                    coincidencias++;
                }
            }
            
            if (coincidencias == 0) {
                this.restarUnaChance();
            }
        } 
    }

    /**
     * post: devuelve la cantidad de letras que tiene la palabra a adivinar.
     */
    public int obtenerLongitudDeLaPalabra() {
        
        return this.caracteresDeLaPalabra.size();
    }
    
    /**
     * post: indica si se usaron todas las chances.
     */
    public boolean perdio() {
        
        return (this.obtenerChancesRestantes() == 0);
    }

    /**
     * post: indica si se ganó el juego por haber completado
     *       la palabra a adivinar.
     */
    public boolean gano() {

        return !this.perdio() && 
               caracteresAdivinados.equals(caracteresDeLaPalabra);
    }

    
    
}
