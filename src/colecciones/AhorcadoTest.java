package colecciones;


import org.junit.Assert;
import org.junit.Test;

public class AhorcadoTest {

    @Test
    public void crearAhorcadoCon10ChancesYNoUsarNinguna() {
        
        Ahorcado ahorcado = new Ahorcado("casa", 10);
        Assert.assertEquals(10, ahorcado.obtenerChancesRestantes());
    }

    @Test
    public void arriesgarLetraYPerderUnaChance() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('g');
        Assert.assertEquals(9, ahorcado.obtenerChancesRestantes());
    }

    @Test
    public void arriesgarLetraQueExistaYNoPerderChances() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('f');
        Assert.assertEquals(10, ahorcado.obtenerChancesRestantes());
    }
    
    @Test
    public void arriesgar2LetrasQueExistanY3queNoYPerder3Chances() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('f');
        ahorcado.arriesgarLetra('e');
        ahorcado.arriesgarLetra('b');
        ahorcado.arriesgarLetra('z');
        ahorcado.arriesgarLetra('x');
        Assert.assertEquals(7, ahorcado.obtenerChancesRestantes());
        Assert.assertFalse(ahorcado.gano());
        Assert.assertFalse(ahorcado.perdio());
    }

    @Test
    public void arriesgar10LetrasQueNoExistanYPerder() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('g');
        ahorcado.arriesgarLetra('t');
        ahorcado.arriesgarLetra('b');
        ahorcado.arriesgarLetra('z');
        ahorcado.arriesgarLetra('x');
        ahorcado.arriesgarLetra('h');
        ahorcado.arriesgarLetra('y');
        ahorcado.arriesgarLetra('i');
        ahorcado.arriesgarLetra('n');
        ahorcado.arriesgarLetra('m');
        Assert.assertEquals(0,ahorcado.obtenerChancesRestantes());
        Assert.assertTrue(ahorcado.perdio());
    }
    
    @Test
    public void ganoElJuegoYNoPerdioNingunaChance() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('e');
        ahorcado.arriesgarLetra('s');
        ahorcado.arriesgarLetra('f');
        ahorcado.arriesgarLetra('r');
        ahorcado.arriesgarLetra('a');
        Assert.assertEquals("esfera", ahorcado.obtenerEstado());
    }
    
    @Test
    public void arriesgoDescubriendoDosLetras() {
        
        Ahorcado ahorcado = new Ahorcado("esfera", 10);
        ahorcado.arriesgarLetra('e');
        ahorcado.arriesgarLetra('a');
        Assert.assertEquals("e__e_a", ahorcado.obtenerEstado());
    }
    
    @Test
    public void elEstadoSonSoloGuionesSiNuncaSeArriesgo() {
        
        Ahorcado ahorcado = new Ahorcado("algoritmo", 4);
        
        Assert.assertEquals("_________", ahorcado.obtenerEstado());
    }
    
}

