package br.com.contmatic.empresa;

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
        assertNull(bairro.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        bairro.setCodigo("");
        assertNull(bairro.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        bairro.setCodigo("269");
        assertNotNull(bairro.getCodigo());
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
        assertNull(bairro.getNome());
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
        assertNull(bairro.getNome());
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
        assertNull(bairro.getTamanho());
    }

    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        bairro.setTamanho("123456789");
        assertNotNull(bairro.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_alfa_numerico() {
        bairro.setTamanho("123456E");
        assertNull(bairro.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        bairro.setPopulacao(null);
        assertNull(bairro.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        bairro.setPopulacao("");
        assertNull(bairro.getPopulacao());
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        bairro.setPopulacao("123456789");
        assertNotNull(bairro.getPopulacao());
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
        assertNotNull(bairro.getTipo());
    }

    @Test
    public void nao_deve_aceitar_tipo_alfa_numerico() {
        bairro.setTipo("Comercial1");
        assertNull(bairro.getTipo());
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
    public void hash_code1() {
        bairro.setCodigo(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void hash_code2() {
        bairro.setCodigo("123");
        System.out.println(bairro.hashCode());
        assertEquals(2045193681, bairro.hashCode());
    }

    @Test
    public void hash_code3() {
        bairro.setNome(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void hash_code4() {
        bairro.setNome("Cohab");
        System.out.println(bairro.hashCode());
        assertEquals(-663569150, bairro.hashCode());
    }

    @Test
    public void hash_code5() {
        bairro.setTipo(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void hash_code6() {
        bairro.setTipo("Comercial");
        System.out.println(bairro.hashCode());
        assertEquals(320215678, bairro.hashCode());
    }

    @Test
    public void hash_code7() {
        bairro.setTamanho(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void hash_code8() {
        bairro.setTamanho("123456798");
        System.out.println(bairro.hashCode());
        assertEquals(-2025532756, bairro.hashCode());
    }

    @Test
    public void hash_code9() {
        bairro.setPopulacao(null);
        System.out.println(bairro.hashCode());
        assertEquals(28629151, bairro.hashCode());
    }

    @Test
    public void hash_code10() {
        bairro.setPopulacao("123456789");
        System.out.println(bairro.hashCode());
        assertEquals(774090644, bairro.hashCode());
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_equals() {
        assertTrue(bairro.equals(bairro));
    }

    @Test
    public void deve_ser_valido_equals1() {
        Bairro bairro2 = new Bairro();
        bairro2 = null;
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals2() {
        Bairro bairro2 = new Bairro();
        assertFalse(bairro.equals(bairro2.getClass()));
    }

    @Test
    public void deve_ser_valido_equals3() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("11");
        bairro.setCodigo(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals4() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals5() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo("00");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals6() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("00");
        bairro.setCodigo("00");
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals7() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome("Cohab");
        bairro.setNome(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals8() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals9() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome(null);
        bairro.setNome("Cohab");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals10() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        bairro2.setNome("Cohab");
        bairro.setNome("Cohab");
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_ser_valido_equals11() {
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
    public void deve_ser_valido_equals12() {
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
    public void deve_ser_valido_equals13() {
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
    public void deve_ser_valido_equals14() {
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
    public void deve_ser_valido_equals15() {
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
    public void deve_ser_valido_equals16() {
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
    public void deve_ser_valido_equals17() {
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
    public void deve_ser_valido_equals18() {
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
    public void deve_ser_valido_equals19() {
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
    public void deve_ser_valido_equals20() {
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
    public void deve_ser_valido_equals21() {
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
    public void deve_ser_valido_equals22() {
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
