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
    public void deve_o_hash_code_ser_igual_a_28629151_para_codigo_nulo() {
        bairro.setCodigo(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_2045193681_para_codigo_nao_nulo() {
        bairro.setCodigo("123");
        System.out.println(bairro.hashCode());
        assertEquals(2045193681, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_nome_nulo() {
        bairro.setNome(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_663569150_para_nome_nao_nulo() {
        bairro.setNome("Cohab");
        System.out.println(bairro.hashCode());
        assertEquals(-663569150, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_tipo_nulo() {
        bairro.setTipo(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_320215678_para_tipo_nao_nulo() {
        bairro.setTipo("Comercial");
        System.out.println(bairro.hashCode());
        assertEquals(320215678, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_tamanho_nulo() {
        bairro.setTamanho(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_2025532756_para_tamanho_nao_nulo() {
        bairro.setTamanho("123456798");
        System.out.println(bairro.hashCode());
        assertEquals(-2025532756, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_populacao_nula() {
        bairro.setPopulacao(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_774090644_para_populacao_nao_nula() {
        bairro.setPopulacao("123456789");
        System.out.println(bairro.hashCode());
        assertEquals(774090644, bairro.hashCode());
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

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nulo_com_nome_nao_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome("Cohab");
        bairro.setNome(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nao_nulo_com_nome_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome("Cohab");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nao_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome("Cohab");
        bairro.setNome("Cohab");
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_populacao_nula_com_populacao_nao_nula_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao("12345798");
        bairro.setPopulacao(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_populacoes_nulas() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_populacao_nao_nula_com_populacao_nula_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao("123456789");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_populacoes_nao_nulas() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao("123456789");
        bairro.setPopulacao("123456789");
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tamanho_nulo_com_tamanho_nao_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho("123456789");
        bairro.setTamanho(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tamanhos_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tamanho_nao_nulo_com_tamanho_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho("123456789");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tamanhos_nao_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho("123456789");
        bairro.setTamanho("123456789");
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tipo_nulo_com_tipo_nao_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho(null);
        bairro2.setTipo("Comercial");
        bairro.setTipo(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tipos_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho(null);
        bairro2.setTipo(null);
        bairro.setTipo(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tipo_nao_nulo_com_tipo_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho(null);
        bairro2.setTipo(null);
        bairro.setTipo("Comercial");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tipos_nao_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        bairro2.setPopulacao(null);
        bairro.setPopulacao(null);
        bairro2.setTamanho(null);
        bairro.setTamanho(null);
        bairro2.setTipo("Comercial");
        bairro.setTipo("Comercial");
        assertTrue(bairro.equals(bairro2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
