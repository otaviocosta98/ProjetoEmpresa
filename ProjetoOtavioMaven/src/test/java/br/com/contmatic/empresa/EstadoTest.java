package br.com.contmatic.empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EstadoTest {

    Estado estado;
    Cidade cidade;

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
        cidade = new Cidade();
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
        assertNull(estado.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        estado.setCodigo("269");
        assertNotNull(estado.getCodigo());
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
        assertNull(estado.getNome());
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
        assertNull(estado.getNome());
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
        assertNull(estado.getUf());
    }

    @Test
    public void deve_aceitar_uf_somente_com_letras() {
        estado.setUf("SP");
        assertNotNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_alfa_numerico() {
        estado.setUf("SP2");
        assertNull(estado.getUf());
    }

    @Test
    public void deve_aceitar_uf_somente_com_2_letras() {
        estado.setUf("SP");
        assertNotNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_maior_que_2() {
        estado.setUf("SPO");
        assertNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_menor_que_2() {
        estado.setUf("S");
        assertNull(estado.getUf());
    }

    @Test
    public void nao_deve_aceitar_uf_com_letra_minuscula() {
        estado.setUf("sp");
        assertNull(estado.getUf());
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
        assertNull(estado.getTamanho());
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
        assertNull(estado.getTamanho());
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
        assertNull(estado.getPopulacao());
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
        assertNull(estado.getCidade());
    }

    @Test
    public void deve_aceitar_cidade_nao_nula() {
        estado.setCidade(cidade);
        assertNotNull(estado.getCidade());
    }

    /* -------------------------------------------------- <<< Cidade ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Estado estado2 = new Estado();
        assertEquals(estado.toString(), estado2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void hash_code1() {
        estado.setCodigo(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code2() {
        estado.setCodigo("123");
        System.out.println(estado.hashCode());
        assertEquals(-1390899085, estado.hashCode());
    }

    @Test
    public void hash_code3() {
        estado.setNome(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code4() {
        estado.setNome("Sao Paulo");
        System.out.println(estado.hashCode());
        assertEquals(-504210855, estado.hashCode());
    }

    @Test
    public void hash_code5() {
        estado.setUf(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code6() {
        estado.setUf("SP");
        System.out.println(estado.hashCode());
        assertEquals(887506334, estado.hashCode());
    }

    @Test
    public void hash_code7() {
        estado.setTamanho(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code8() {
        estado.setTamanho("123456798");
        System.out.println(estado.hashCode());
        assertEquals(-1166658226, estado.hashCode());
    }

    @Test
    public void hash_code9() {
        estado.setPopulacao(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code10() {
        estado.setPopulacao("123456789");
        System.out.println(estado.hashCode());
        assertEquals(1632965174, estado.hashCode());
    }
    
    @Test
    public void hash_code11() {
        estado.setCidade(null);
        System.out.println(estado.hashCode());
        assertEquals(887503681, estado.hashCode());
    }

    @Test
    public void hash_code12() {
        estado.setCidade(cidade);
        System.out.println(estado.hashCode());
        assertEquals(-909447678, estado.hashCode());
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_equals() {
        assertTrue(estado.equals(estado));
    }

    @Test
    public void deve_ser_valido_equals1() {
        Estado estado2 = new Estado();
        estado2 = null;
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals2() {
        Estado estado2 = new Estado();
        assertFalse(estado.equals(estado2.getClass()));
    }
    
    @Test
    public void deve_ser_valido_equals3() {
        Estado estado2 = new Estado();
        estado2.setCidade(cidade);
        estado.setCidade(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals4() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals5() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(cidade);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals6() {
        Estado estado2 = new Estado();
        estado2.setCidade(cidade);
        estado.setCidade(cidade);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals7() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo("11");
        estado.setCodigo(null);
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals8() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo(null);
        assertTrue(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals9() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo(null);
        estado.setCodigo("00");
        assertFalse(estado.equals(estado2));
    }

    @Test
    public void deve_ser_valido_equals10() {
        Estado estado2 = new Estado();
        estado2.setCidade(null);
        estado.setCidade(null);
        estado2.setCodigo("00");
        estado.setCodigo("00");
        assertTrue(estado.equals(estado2));
    }
    
    @Test
    public void deve_ser_valido_equals11() {
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
    public void deve_ser_valido_equals12() {
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
    public void deve_ser_valido_equals13() {
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
    public void deve_ser_valido_equals14() {
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
    public void deve_ser_valido_equals15() {
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
    public void deve_ser_valido_equals16() {
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
    public void deve_ser_valido_equals17() {
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
    public void deve_ser_valido_equals18() {
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
    public void deve_ser_valido_equals19() {
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
    public void deve_ser_valido_equals20() {
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
    public void deve_ser_valido_equals21() {
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
    public void deve_ser_valido_equals22() {
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
    public void deve_ser_valido_equals23() {
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
    public void deve_ser_valido_equals24() {
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
    public void deve_ser_valido_equals25() {
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
    public void deve_ser_valido_equals26() {
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
