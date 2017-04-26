package br.com.contmatic.empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperadoraTest {

    Operadora op;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("-------------Começo Classe Teste------------->");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("<------------Fim Classe teste-----------------");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("!-Começo Teste-!");
        op = new Operadora();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        op.setCodigo(null);
        assertNull(op.getCodigo());
    }
    
    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        op.setCodigo("");
        assertNull(op.getCodigo());
    }

}
