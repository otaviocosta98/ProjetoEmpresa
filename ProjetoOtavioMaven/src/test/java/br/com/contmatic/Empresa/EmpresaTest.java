package br.com.contmatic.Empresa;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Começo Classe Teste");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Fim Classe teste");
    }

    @Before
    public void setUp() throws Exception {
        emp = new Empresa();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Fim Teste");
    }

    @Test
    public void nome_empresa_nao_deve_ser_nulo() {
        emp.setNome(null);
        assertNull(emp.getNome());
    }

    @Test
    public void nome_empresa_nao_deve_ser_vazio() {
        emp.setNome("");
        assertNull(emp.getNome());
    }
    
    @Test
    public void Valida_IEtest2() {
        emp.setIE("123456789000");
        assertTrue("Verifica IE", emp.getIE().length() == 12);
    }

    @Test
    public void Valida_CNPJtest1() {
        emp.setCNPJ("75315964820490");
        assertThat("75315964820490", equalTo(emp.getCNPJ()));
    }

    @Test(expected = NullPointerException.class)
    public void Valida_Razao_Social() {
        emp = null;
        String rs = emp.getRazaoSocial();
    }

    @Test
    @Ignore
    public void Ignore_Teste() {
        System.out.println("Ignore");
    }

    @Test(timeout = 2000)
    public void Timeout_Teste() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Timeout");
    }

}
