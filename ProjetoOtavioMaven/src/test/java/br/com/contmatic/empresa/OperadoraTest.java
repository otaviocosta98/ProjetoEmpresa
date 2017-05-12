package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OperadoraTest {

    Operadora operadora;

    /* -------------------------------------------------- SetUps e TearDowns >>> ----------------------------------------------------------- */
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

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */
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
        assertEquals("021", operadora.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_letras_no_codigo() {
        operadora.setCodigo("021b");
        assertNotEquals("021b", operadora.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        operadora.setNome(null);
        assertNull(operadora.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        operadora.setNome("");
        assertThat("", is(not(operadora.getNome())));
    }
    
    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        operadora.setNome("Oi");
        assertNotNull(operadora.getNome());
    }

    @Test
    public void deve_aceitar_nome_alfa_numerico() {
        operadora.setNome("Oi98");
        assertNotEquals("Cohab1", operadora.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Operadora operadora2 = new Operadora();
        assertEquals(operadora.toString(), operadora2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- hashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Operadora operadora2 = new Operadora();
        operadora.setCodigo("123");
        operadora2.setCodigo("123");
        assertEquals(operadora.hashCode(), operadora2.hashCode());
    }
    
    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo(){
        Operadora operadora2 = new Operadora();
        operadora.setCodigo(null);
        operadora2.setCodigo("123");
        assertNotEquals(operadora.hashCode(), operadora2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Operadora operadora2 = new Operadora();
        operadora.setCodigo("456");
        operadora2.setCodigo("123");
        assertThat(operadora.hashCode(), is(not(operadora2.hashCode())));
    }

    /* -------------------------------------------------- <<< hashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(operadora.equals(operadora));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outra_operadora_nula() {
        Operadora operadora2 = null;
        assertFalse(operadora.equals(operadora2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outra_operadora() {
        Operadora operadora2 = new Operadora();
        assertFalse(operadora.equals(operadora2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outra_operadora() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo(null);
        assertFalse(operadora.equals(operadora2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo(null);
        operadora.setCodigo(null);
        assertTrue(operadora.equals(operadora2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outra_operadora() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo(null);
        operadora.setCodigo("0");
        assertFalse(operadora.equals(operadora2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Operadora operadora2 = new Operadora();
        operadora2.setCodigo("0");
        operadora.setCodigo("0");
        assertTrue(operadora.equals(operadora2));
    }

    /* -------------------------------------------------- <<< equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
