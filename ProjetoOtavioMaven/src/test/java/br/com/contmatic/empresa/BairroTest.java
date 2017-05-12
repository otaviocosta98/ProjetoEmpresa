package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BairroTest {

    Bairro bairro;

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
        bairro = new Bairro();
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
        bairro.setCodigo(null);
        assertEquals(null, bairro.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        bairro.setCodigo("");
        assertNull(bairro.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        bairro.setCodigo("269");
        assertThat("269", is(bairro.getCodigo()));
    }

    @Test
    public void nao_deve_aceitar_codigo_alfa_numerico() {
        bairro.setCodigo("269b");
        assertNull(bairro.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        bairro.setNome(null);
        assertEquals(null, bairro.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        bairro.setNome("");
        assertNull(bairro.getNome());
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        bairro.setNome("Cohab");
        assertNotNull(bairro.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        bairro.setNome("Cohab1");
        assertNotEquals("Cohab1", bairro.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        bairro.setTamanho(null);
        assertNull(bairro.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_vazio() {
        bairro.setTamanho("");
        assertNotEquals("", bairro.getTamanho());
    }

    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        bairro.setTamanho("123456789");
        assertNotNull(bairro.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_alfa_numerico() {
        bairro.setTamanho("123456E");
        assertThat("123456E", is(not(bairro.getTamanho())));
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        bairro.setPopulacao(null);
        assertEquals(null, bairro.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        bairro.setPopulacao("");
        assertNull(bairro.getPopulacao());
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        bairro.setPopulacao("123456789");
        assertThat("123456789", is(bairro.getPopulacao()));
    }

    @Test
    public void nao_deve_aceitar_populacao_alfa_numerico() {
        bairro.setPopulacao("123456E");
        assertNull(bairro.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        bairro.setTipo(null);
        assertNull(bairro.getTipo());
    }

    @Test
    public void nao_deve_aceitar_tipo_vazio() {
        bairro.setTipo("");
        assertNull(bairro.getTipo());
    }

    @Test
    public void deve_aceitar_tipo_somente_com_letras() {
        bairro.setTipo("Comercial");
        assertEquals("Comercial", bairro.getTipo());
    }

    @Test
    public void nao_deve_aceitar_tipo_alfa_numerico() {
        bairro.setTipo("Comercial1");
        assertNotEquals("Comercial1", bairro.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Bairro bairro2 = new Bairro();
        assertEquals(bairro.toString(), bairro2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo("123");
        bairro2.setCodigo("123");
        assertEquals(bairro.hashCode(), bairro2.hashCode());
    }
    
    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo(null);
        bairro2.setCodigo("123");
        assertNotEquals(bairro.hashCode(), bairro2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo("456");
        bairro2.setCodigo("123");
        assertThat(bairro.hashCode(), is(not(bairro2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(bairro.equals(bairro));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_bairro_nulo() {
        Bairro bairro2 = new Bairro();
        bairro2 = null;
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        assertFalse(bairro.equals(bairro2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("11");
        bairro.setCodigo(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo("00");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("00");
        bairro.setCodigo("00");
        assertTrue(bairro.equals(bairro2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
