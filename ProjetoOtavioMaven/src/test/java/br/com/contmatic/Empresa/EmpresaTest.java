package br.com.contmatic.Empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.DEFAULT)
public class EmpresaTest {

    Empresa emp;
    Empresa emp2;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void Verifica_nome_nao_nulo() {
        emp = new Empresa();
        emp.setNome("Contimatic");
        assertEquals("Verifica se nome é nulo","",emp);
    }

}
