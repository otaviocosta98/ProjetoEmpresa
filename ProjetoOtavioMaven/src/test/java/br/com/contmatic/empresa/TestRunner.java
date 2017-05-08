package br.com.contmatic.empresa;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ BairroTest.class, CidadeTest.class, EmpresaTest.class, EstadoTest.class, TelefoneTest.class, OperadoraTest.class })

public class TestRunner {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Rodando Todos os Testes!");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Finalizado!");
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
