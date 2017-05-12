package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EstadoTest {

    Estado estado;
    Cidade[] cidade;

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
        estado = new Estado();
        cidade = new Cidade[2];
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
        estado.setCodigo(null);
        assertNull(estado.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        estado.setCodigo("");
        assertNotEquals("", estado.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        estado.setCodigo("269");
        assertThat("269", is(estado.getCodigo()));
    }

    @Test
    public void nao_deve_aceitar_codigo_alfa_numerico() {
        estado.setCodigo("269b");
        assertNull(estado.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        estado.setNome(null);
        assertEquals(null, estado.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        estado.setNome("");
        assertNull(estado.getNome());
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        estado.setNome("Sao Paulo");
        assertNotNull(estado.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        estado.setNome("Sao Paulo2");
        assertNotEquals("Sao Paulo2", estado.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- UF >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_uf_nulo() {
        estado.setUf(null);
        assertNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_vazio() {
        estado.setUf("");
        assertEquals(null, estado.getUf());
    }

    @Test
    public void deve_aceitar_uf_somente_com_letras() {
        estado.setUf("SP");
        assertThat("SP", is(estado.getUf()));
    }

    @Test
    public void nao_deve_aceitar_uf_alfa_numerico() {
        estado.setUf("SP2");
        assertNull(estado.getUf());
    }

    @Test
    public void deve_aceitar_uf_somente_com_2_letras() {
        estado.setUf("SP");
        assertEquals("SP", estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_maior_que_2() {
        estado.setUf("SPO");
        assertThat("SPO", is(not(estado.getUf())));
    }

    @Test
    public void nao_deve_aceitar_uf_menor_que_2() {
        estado.setUf("S");
        assertNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_com_letra_minuscula() {
        estado.setUf("sp");
        assertNotEquals("sp", estado.getUf());
    }

    @Test
    public void deve_aceitar_uf_com_letra_maiuscula() {
        estado.setUf("SP");
        assertNotNull(estado.getUf());
    }

    /* -------------------------------------------------- <<< UF ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        estado.setTamanho(null);
        assertEquals(null, estado.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_vazio() {
        estado.setTamanho("");
        assertNull(estado.getTamanho());
    }

    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        estado.setTamanho("123456789");
        assertNotNull(estado.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_alfa_numerico() {
        estado.setTamanho("123456E");
        assertNotEquals("123456E", estado.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- Populacao >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        estado.setPopulacao(null);
        assertNull(estado.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        estado.setPopulacao("");
        assertThat("", is(not(estado.getPopulacao())));
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        estado.setPopulacao("123456789");
        assertNotNull(estado.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_alfa_numerico() {
        estado.setPopulacao("123456E");
        assertNull(estado.getPopulacao());
    }

    /* -------------------------------------------------- <<< Populacao ----------------------------------------------------------- */

    /* -------------------------------------------------- Cidade >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cidade_nulo() {
        estado.setCidade(null);
        assertNotSame(cidade, estado.getCidade());
    }

    @Test
    public void deve_aceitar_cidade_nao_nula() {
        estado.setCidade(cidade);
        assertSame(cidade, estado.getCidade());
    }

    /* -------------------------------------------------- <<< Cidade ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Estado estado2 = new Estado();
        assertThat(estado.toString(), is(estado2.toString()));
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Estado estado2 = new Estado();
        estado.setCodigo("123");
        estado2.setCodigo("123");
        assertEquals(estado.hashCode(), estado2.hashCode());
    }
    
    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo(){
        Estado estado2 = new Estado();
        estado.setCodigo(null);
        estado2.setCodigo("123");
        assertNotEquals(estado.hashCode(), estado2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Estado estado2 = new Estado();
        estado.setCodigo("456");
        estado2.setCodigo("123");
        assertThat(estado.hashCode(), is(not(estado2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(estado.equals(estado));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_estado_nulo() {
        Estado estado2 = new Estado();
        estado2 = null;
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outro_estado() {
        Estado estado2 = new Estado();
        assertFalse(estado.equals(estado2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCodigo("11");
        estado.setCodigo(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Estado estado2 = new Estado();
        estado2.setCodigo(null);
        estado.setCodigo(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCodigo(null);
        estado.setCodigo("00");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Estado estado2 = new Estado();
        estado2.setCodigo("00");
        estado.setCodigo("00");
        assertTrue(estado.equals(estado2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
