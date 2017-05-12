package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CidadeTest {

    Cidade cidade;
    Bairro[] bairro;

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
        cidade = new Cidade();
        bairro = new Bairro[2];
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
        cidade.setCodigo(null);
        assertNull(cidade.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        cidade.setCodigo("");
        assertEquals(null, cidade.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        cidade.setCodigo("269");
        assertNotNull(cidade.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_alfa_numerico() {
        cidade.setCodigo("269b");
        assertThat("269b", is(not(cidade.getCodigo())));
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        cidade.setNome(null);
        assertNull(cidade.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        cidade.setNome("");
        assertNull(cidade.getNome());
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        cidade.setNome("Sao Paulo");
        assertEquals("Sao Paulo", cidade.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        cidade.setNome("Sao Paulo2");
        assertNotEquals("Sao Paulo2", cidade.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        cidade.setTamanho(null);
        assertEquals(null, cidade.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_vazio() {
        cidade.setTamanho("");
        assertNotEquals("", cidade.getTamanho());
    }

    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        cidade.setTamanho("123456789");
        assertNotNull(cidade.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_alfa_numerico() {
        cidade.setTamanho("123456E");
        assertNull(cidade.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        cidade.setPopulacao(null);
        assertNull(cidade.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        cidade.setPopulacao("");
        assertNull(cidade.getPopulacao());
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        cidade.setPopulacao("123456789");
        assertEquals("123456789", cidade.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_alfa_numerico() {
        cidade.setPopulacao("123456E");
        assertNotEquals("123456E", cidade.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Cidade >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cidade_nulo() {
        cidade.setBairro(null);
        assertNotSame(cidade, cidade.getBairro());
    }

    @Test
    public void deve_aceitar_cidade_nao_nulo() {
        cidade.setBairro(bairro);
        assertSame(bairro, cidade.getBairro());
    }

    /* -------------------------------------------------- <<< Cidade ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Cidade cidade2 = new Cidade();
        assertThat(cidade.toString(), is(cidade2.toString()));
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Cidade cidade2 = new Cidade();
        cidade.setCodigo("123");
        cidade2.setCodigo("123");
        assertEquals(cidade.hashCode(), cidade2.hashCode());
    }
    
    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo(){
        Cidade cidade2 = new Cidade();
        cidade.setCodigo(null);
        cidade2.setCodigo("123");
        assertNotEquals(cidade.hashCode(), cidade2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Cidade cidade2 = new Cidade();
        cidade.setCodigo("456");
        cidade2.setCodigo("123");
        assertThat(cidade.hashCode(), is(not(cidade2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(cidade.equals(cidade));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outra_cidade_nula() {
        Cidade cidade2 = new Cidade();
        cidade2 = null;
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outra_cidade() {
        Cidade cidade2 = new Cidade();
        assertFalse(cidade.equals(cidade2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outra_cidade() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo("11");
        cidade.setCodigo(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outra_cidade() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo("00");
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo("00");
        cidade.setCodigo("00");
        assertTrue(cidade.equals(cidade2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
