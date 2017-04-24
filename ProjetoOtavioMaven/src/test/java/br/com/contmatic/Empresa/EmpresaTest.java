package br.com.contmatic.Empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
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
    public void Valida_Nome_Empresatest3() {
        emp = new Empresa();
        emp.setNome("Contimatic");
        assertEquals("Verifica nome", "Contimatic", emp.getNome());
    }

    @Test
    public void Valida_IEtest2() {
        emp = new Empresa();
        emp.setIE("123456789000");
        assertTrue("Verifica IE", emp.getIE().length() == 12);
    }

    @Test
    public void Valida_CNPJtest1() {
        emp = new Empresa();
        emp.setCNPJ("75315964820490");
        assertThat("75315964820490", equalTo(emp.getCNPJ()));
    }

    @Test(expected = NullPointerException.class)
    public void Valida_Razao_Social() {
        emp = new Empresa();
        emp.setRazaoSocial(null);
    }

    @Test
    @Ignore
    public void Ignore_Teste() {
        System.out.println("Ignore");
    }

    @Test(timeout = 1000)
    public void Timeout_Teste() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Timeout");
    }

}
