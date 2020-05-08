package com.example.av01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CadastroPedidoTest {

    @Test
    public void VerificarPreco(){
        CadastroPedido cp = new CadastroPedido();
        assertTrue(cp.verificarValor(10.00));

        assertFalse(cp.verificarValor(-1.00));

    }
}
