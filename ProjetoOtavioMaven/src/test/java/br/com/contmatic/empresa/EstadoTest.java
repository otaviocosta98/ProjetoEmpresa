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
    public void deve_o_hash_code_ser_igual_a_887503681_para_codigo_nulo() {
        estado.setCodigo(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1390899085_para_codigo_nao_nulo() {
        estado.setCodigo("123");
        System.out.println(estado.hashCode());
        assertEquals(-1390899085, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_nome_nulo() {
        estado.setNome(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_504210855_para_nome_nao_nulo() {
        estado.setNome("Sao Paulo");
        System.out.println(estado.hashCode());
        assertEquals(-504210855, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_uf_nulo() {
        estado.setUf(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887506334_para_uf_nao_nulo() {
        estado.setUf("SP");
        System.out.println(estado.hashCode());
        assertEquals(887506334, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_tamanho_nulo() {
        estado.setTamanho(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1166658226_para_tamanho_nao_nulo() {
        estado.setTamanho("123456798");
        System.out.println(estado.hashCode());
        assertEquals(-1166658226, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_populacao_nula() {
        estado.setPopulacao(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1632965174_para_populacao_nao_nula() {
        estado.setPopulacao("123456789");
        System.out.println(estado.hashCode());
        assertEquals(1632965174, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_cidade_nula() {
        estado.setCidade(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1664653280_para_cidade_nao_nula() {
        estado.setCidade(cidade);
        System.out.println(estado.hashCode());
        assertEquals(-1664653280, estado.hashCode());
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
    public void deve_o_equals_retornar_false_comparando_cidade_nula_com_cidade_nao_nula_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(cidade);
        estado.setCidade(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_cidades_nulas() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_cidade_nao_nula_com_cidade_nula_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(cidade);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_cidades_nao_nulas() {
        Estado estado2 = new Estado();
        estado2.setCidade(cidade);
        estado.setCidade(cidade);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo("11");
        estado.setCodigo(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo("00");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo("00");
        estado.setCodigo("00");
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nulo_com_nome_nao_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome("São Paulo");
        estado.setNome(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nao_nulo_com_nome_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome("São Paulo");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nao_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome("São Paulo");
        estado.setNome("São Paulo");
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_uf_nulo_com_uf_nao_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf("SP");
        estado.setUf(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ufs_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_uf_nao_nulo_com_uf_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf("SP");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ufs_nao_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf("SP");
        estado.setUf("SP");
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tamanho_nulo_com_tamanho_nao_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho("123456789");
        estado.setTamanho(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tamanhos_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tamanho_nao_nulo_com_tamanho_nulo_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho("123456789");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tamanhos_nao_nulos() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho("123456789");
        estado.setTamanho("123456789");
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_populacao_nula_com_populacao_nao_nula_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho(null);
        estado2.setPopulacao("123456789");
        estado.setPopulacao(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_populacoes_nulas() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho(null);
        estado2.setPopulacao(null);
        estado.setPopulacao(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_populacao_nao_nula_com_populacao_nula_de_outro_estado() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho(null);
        estado2.setPopulacao(null);
        estado.setPopulacao("123456789");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_populaoes_nao_nulas() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        estado2.setNome(null);
        estado.setNome(null);
        estado2.setUf(null);
        estado.setUf(null);
        estado2.setTamanho(null);
        estado.setTamanho(null);
        estado2.setPopulacao("123456789");
        estado.setPopulacao("123456789");
        assertTrue(estado.equals(estado2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
