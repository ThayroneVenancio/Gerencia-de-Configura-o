package com.example.av01;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class CadastroPedidoTest {

    @Test
    public void VerificarPreco() {
        DAO dao = new DAO();
        CadastroPedido cp = new CadastroPedido();
        assertTrue(cp.verificarValor(10.00));
        assertFalse(cp.verificarValor(-1.00));
        assertFalse(cp.verificarValor(-2.57));

    }

   @Test
    public void deceriaVerificarPreco() {
        CadastroPedido cp = new CadastroPedido();
        DAO dao = new DAO();

        cp.informarProduto("Tilapia");
        assertTrue(dao.salvarProduto(cp));

       cp.informarProduto("Tucunare");
       assertTrue(dao.salvarProduto(cp));

    }

    @Test
    public void verificarSalvarDescricaoProduto(){
        CadastroPedido cp = new CadastroPedido();
        cp.informarProduto("Tilapia");
        DAO daoFalso = Mockito.mock(DAO.class);
        Mockito.when(daoFalso.salvarProduto(cp)).thenReturn(true);

        cp.informarProduto("Sardinha");
        Mockito.when(daoFalso.salvarProduto(cp)).thenReturn(true);
    }






    @Test
    public void VerificarPrecoSalvo() {
        CadastroPedido cpFalso = Mockito.mock(CadastroPedido.class);
        Mockito.when(cpFalso.verificarValor(10.00)).thenReturn(true);
    }




}