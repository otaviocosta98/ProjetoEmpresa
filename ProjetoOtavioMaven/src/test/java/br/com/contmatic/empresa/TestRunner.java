package br.com.contmatic.empresa;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Class TestRunner.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ BairroTest.class, CidadeTest.class, EmpresaTest.class, EnderecoTest.class, EstadoTest.class, OperadoraTest.class, TelefoneTest.class })

public class TestRunner {

    /**
     * Set up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Rodando Todos os Testes!");
    }

    /**
     * Tear down after class.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Finalizado!");
    }

}
