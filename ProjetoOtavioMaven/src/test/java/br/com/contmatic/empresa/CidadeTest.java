package br.com.contmatic.empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CidadeTest {
    
    Cidade cidade;
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
        cidade = new Cidade();
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
        cidade.setCodigo(null);
        assertNull(cidade.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        cidade.setCodigo("");
        assertNull(cidade.getCodigo());
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        cidade.setCodigo("269");
        assertNotNull(cidade.getCodigo());
    }

    @Test
    public void nao_deve_aceitar_codigo_alfa_numerico() {
        cidade.setCodigo("269b");
        assertNull(cidade.getCodigo());
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
        assertNotNull(cidade.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        cidade.setNome("Sao Paulo2");
        assertNull(cidade.getNome());
    }
    
    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */
    
    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */
    
    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        cidade.setTamanho(null);
        assertNull(cidade.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_vazio() {
        cidade.setTamanho("");
        assertNull(cidade.getTamanho());
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
        assertNotNull(cidade.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_alfa_numerico() {
        cidade.setPopulacao("123456E");
        assertNull(cidade.getPopulacao());
    }
    
    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */
    
    /* -------------------------------------------------- Cidade >>> ----------------------------------------------------------- */
    
    @Test
    public void nao_deve_aceitar_cidade_nulo() {
        cidade.setBairro(null);
        assertNull(cidade.getBairro());
    }

    @Test
    public void deve_aceitar_cidade_nao_nulo() {
        cidade.setBairro(bairro);
        assertNotNull(cidade.getBairro());
    }
    
    /* -------------------------------------------------- <<< Cidade ----------------------------------------------------------- */
    
    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */
    
    @Test
    public void deve_ser_valido_to_string() {
        Cidade cidade2 = new Cidade();
        assertEquals(cidade.toString(), cidade2.toString());
    }
    
    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */
    
    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */
    
    @Test
    public void hash_code1() {
        cidade.setCodigo(null);
        System.out.println(cidade.hashCode());
        assertEquals(28629151, cidade.hashCode());
    }

    @Test
    public void hash_code2() {
        cidade.setCodigo("123");
        System.out.println(cidade.hashCode());
        assertEquals(2045193681, cidade.hashCode());
    }

    @Test
    public void hash_code3() {
        cidade.setNome(null);
        System.out.println(cidade.hashCode());
        assertEquals(28629151, cidade.hashCode());
    }

    @Test
    public void hash_code4() {
        cidade.setNome("Sao Paulo");
        System.out.println(cidade.hashCode());
        assertEquals(1369208455, cidade.hashCode());
    }

    @Test
    public void hash_code5() {
        cidade.setBairro(null);
        System.out.println(cidade.hashCode());
        assertEquals(28629151, cidade.hashCode());
    }

    @Test
    public void hash_code6() {
        cidade.setBairro(bairro);
        System.out.println(cidade.hashCode());
        assertEquals(-1778825312, cidade.hashCode());
    }

    @Test
    public void hash_code7() {
        cidade.setTamanho(null);
        System.out.println(cidade.hashCode());
        assertEquals(28629151, cidade.hashCode());
    }

    @Test
    public void hash_code8() {
        cidade.setTamanho("123456798");
        System.out.println(cidade.hashCode());
        assertEquals(-1838749454, cidade.hashCode());
    }

    @Test
    public void hash_code9() {
        cidade.setPopulacao(null);
        System.out.println(cidade.hashCode());
        assertEquals(28629151, cidade.hashCode());
    }

    @Test
    public void hash_code10() {
        cidade.setPopulacao("123456789");
        System.out.println(cidade.hashCode());
        assertEquals(-2025533686, cidade.hashCode());
    }
    
    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */
    
    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */
    
    @Test
    public void deve_ser_valido_equals() {
        assertTrue(cidade.equals(cidade));
    }

    @Test
    public void deve_ser_valido_equals1() {
        Cidade cidade2 = new Cidade();
        cidade2 = null;
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals2() {
        Cidade cidade2 = new Cidade();
        assertFalse(cidade.equals(cidade2.getClass()));
    }

    @Test
    public void deve_ser_valido_equals3() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo("11");
        cidade.setCodigo(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals4() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals5() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo("00");
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals6() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo("00");
        cidade.setCodigo("00");
        assertTrue(cidade.equals(cidade2));
    }
    
    @Test
    public void deve_ser_valido_equals7() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome("São Paulo");
        cidade.setNome(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals8() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals9() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome("São Paulo");
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals10() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome("São Paulo");
        cidade.setNome("São Paulo");
        assertTrue(cidade.equals(cidade2));
    }
    
    @Test
    public void deve_ser_valido_equals11() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(bairro);
        cidade.setBairro(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals12() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals13() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(bairro);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals14() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(bairro);
        cidade.setBairro(bairro);
        assertTrue(cidade.equals(cidade2));
    }
    
    @Test
    public void deve_ser_valido_equals15() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho("123456789");
        cidade.setTamanho(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals16() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals17() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho("123456789");
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals18() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho("123456789");
        cidade.setTamanho("123456789");
        assertTrue(cidade.equals(cidade2));
    }
    
    @Test
    public void deve_ser_valido_equals19() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho(null);
        cidade2.setPopulacao("123456789");
        cidade.setPopulacao(null);
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals20() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho(null);
        cidade2.setPopulacao(null);
        cidade.setPopulacao(null);
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals21() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho(null);
        cidade2.setPopulacao(null);
        cidade.setPopulacao("123456789");
        assertFalse(cidade.equals(cidade2));
    }

    @Test
    public void deve_ser_valido_equals22() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(null);
        cidade.setCodigo(null);
        cidade2.setNome(null);
        cidade.setNome(null);
        cidade2.setBairro(null);
        cidade.setBairro(null);
        cidade2.setTamanho(null);
        cidade.setTamanho(null);
        cidade2.setPopulacao("123456789");
        cidade.setPopulacao("123456789");
        assertTrue(cidade.equals(cidade2));
    }
    
    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */
    
    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
