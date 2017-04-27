package br.com.contmatic.empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperadoraTest {

    Operadora operadora;
    /* -------------------------------------------------- SetUps e TearDowns >>> -----------------------------------------------------------*/
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
        operadora = new Operadora();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /* -------------------------------------------------- <<< SetUps e TearDowns -----------------------------------------------------------*/
    
    /* -------------------------------------------------- Testes >>> -----------------------------------------------------------*/
    
    /* -------------------------------------------------- Codigo >>> -----------------------------------------------------------*/
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        operadora.setCodigo(null);
        assertNull(operadora.getCodigo());
    }
    
    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        operadora.setCodigo("");
        assertNull(operadora.getCodigo());
    }
    
    @Test
    public void deve_aceitar_somente_numeros_no_codigo() {
        operadora.setCodigo("021");
        assertNotNull(operadora.getCodigo());
    }
    
    @Test
    public void nao_deve_aceitar_letras_no_codigo() {
        operadora.setCodigo("021b");
        assertNull(operadora.getCodigo());
    }
    
    /* -------------------------------------------------- <<< Codigo -----------------------------------------------------------*/
    
    /* -------------------------------------------------- Nome >>> -----------------------------------------------------------*/
    
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        operadora.setNome(null);
        assertNull(operadora.getNome());
    }
    
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        operadora.setNome("");
        assertNull(operadora.getNome());
    }
    
    @Test
    public void deve_aceitar_nome_valido() {
        operadora.setNome("Contmatic");
        assertNotNull(operadora.getNome());
    }
    
    /* -------------------------------------------------- <<< Nome -----------------------------------------------------------*/
    
    /* -------------------------------------------------- ToString >>> -----------------------------------------------------------*/
    
    @Test
    public void deve_ser_valido_to_string() {
        operadora.setCodigo("035");
        operadora.setNome("Contmatic");
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("035");
        operadora2.setNome("Contmatic");
        assertEquals(operadora.toString(),operadora2.toString());
    }
    
    /* -------------------------------------------------- <<< ToString -----------------------------------------------------------*/
    
/* -------------------------------------------------- hashCode >>> -----------------------------------------------------------*/
    
    @Test
    public void hash_code_com_codigo_e_nome_nulo() {
        operadora.setCodigo(null);
        operadora.setNome(null);
        System.out.println(operadora.hashCode());
        assertEquals(961, operadora.hashCode());
    }
    
    @Test
    public void hash_code_com_codigo_nulo() {
        operadora.setCodigo(null);
        operadora.setNome("contmatic");
        System.out.println(operadora.hashCode());
        assertEquals(-400105911, operadora.hashCode());
    }
    
    @Test
    public void hash_code_com_nome_nulo() {
        operadora.setCodigo("123");
        operadora.setNome(null);
        System.out.println(operadora.hashCode());
        assertEquals(1510351, operadora.hashCode());
    }
    
    @Test
    public void hash_code_com_codigo_e_nome_preenchidos() {
        operadora.setCodigo("123");
        operadora.setNome("contmatic");
        System.out.println(operadora.hashCode());
        assertEquals(-398596521, operadora.hashCode());
    }
    
    /* -------------------------------------------------- <<< hashCode -----------------------------------------------------------*/
    
/* -------------------------------------------------- equals >>> -----------------------------------------------------------*/
    
    @Test
    public void deve_ser_valido_equals() {
        assertTrue(operadora.equals(operadora));
    }
    
    @Test
    public void deve_ser_valido_equals1() {
        Operadora operadora2 = new Operadora();
        assertTrue(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals2() {
        Operadora operadora2 = null;
        assertFalse(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals3() {
        Operadora operadora2 = new Operadora();
        assertFalse(operadora.equals(operadora2.getClass()));
    }
    
    @Test
    public void deve_ser_valido_equals4() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo(null);
        assertFalse(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals5() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("1");
        operadora.setCodigo("0");
        assertFalse(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals6() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo("0");
        operadora2.setNome("contmatic");
        operadora.setNome(null);
        assertFalse(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals7() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo("0");
        operadora2.setNome(null);
        operadora.setNome(null);
        assertTrue(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals8() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo("0");
        operadora2.setNome(null);
        operadora.setNome("contmatic");
        assertFalse(operadora.equals(operadora2));
    }
    
    @Test
    public void deve_ser_valido_equals9() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo("0");
        operadora2.setNome("contmatic");
        operadora.setNome("contmatic");
        assertTrue(operadora.equals(operadora2));
    }
    
    /* -------------------------------------------------- <<< equals -----------------------------------------------------------*/
    
    /* -------------------------------------------------- <<< Testes -----------------------------------------------------------*/

}
