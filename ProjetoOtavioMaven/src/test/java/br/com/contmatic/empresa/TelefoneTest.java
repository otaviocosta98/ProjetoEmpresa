package br.com.contmatic.empresa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TelefoneTest {

    Telefone telefone;
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
        telefone = new Telefone();
        operadora = new Operadora();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- DDD >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ddd_nulo() {
        telefone.setDdd(null);
        assertNull(telefone.getDdd());
    }

    @Test
    public void nao_deve_aceitar_ddd_vazio() {
        telefone.setDdd("");
        assertNotSame("", telefone.getDdd());
    }

    @Test
    public void deve_aceitar_somente_ddd_numerico() {
        telefone.setDdd("11");
        assertEquals("11", telefone.getDdd());
    }

    @Test
    public void nao_deve_aceitar_letras_no_ddd() {
        telefone.setDdd("11a");
        assertNotEquals("11a", telefone.getDdd());
    }

    @Test
    public void nao_deve_aceitar_ddd_maiores_que_2_digitos() {
        telefone.setDdd("111");
        assertNotEquals("111", telefone.getDdd());
    }

    @Test
    public void nao_deve_aceitar_ddd_menores_que_2_digitos() {
        telefone.setDdd("1");
        assertNotEquals("1", telefone.getDdd());
    }

    /* -------------------------------------------------- <<< DDD ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        telefone.setNumero(null);
        assertNull(telefone.getNumero());
    }

    @Test
    public void nao_deve_aceitar_numero_vazio() {
        telefone.setNumero("");
        assertNull(telefone.getNumero());
    }

    @Test
    public void deve_aceitar_somente_numero_numerico() {
        telefone.setNumero("123456798");
        assertNotNull(telefone.getNumero());
    }

    @Test
    public void nao_deve_aceitar_numero_maior_que_9_caracteres() {
        telefone.setNumero("12345679890");
        assertNotSame("1235467890", telefone.getNumero());
    }

    @Test
    public void nao_deve_aceitar_numero_menor_que_8_caracteres() {
        telefone.setNumero("123");
        assertNotEquals("123", telefone.getNumero());
    }

    @Test
    public void deve_aceitar_numero_entre_8_e_9_caracteres() {
        telefone.setNumero("12345678");
        assertEquals("12345678", telefone.getNumero());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Ramal >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ramal_nulo() {
        telefone.setRamal(null);
        assertSame(null, telefone.getRamal());
    }

    @Test
    public void pode_aceitar_ramal_vazio() {
        telefone.setRamal("");
        assertNotNull(telefone.getRamal());
    }

    @Test
    public void nao_deve_aceitar_ramal_com_letras() {
        telefone.setRamal("123c");
        assertNotEquals("123c", telefone.getRamal());
    }

    @Test
    public void deve_aceitar_somente_ramal_numerico() {
        telefone.setRamal("123");
        assertEquals("123", telefone.getRamal());
    }

    /* -------------------------------------------------- <<< Ramal ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        telefone.setTipo(null);
        assertNull(telefone.getTipo());
    }

    @Test
    public void nao_deve_aceitar_tipo_vazio() {
        telefone.setTipo("");
        assertNull(telefone.getTipo());
    }

    @Test
    public void deve_aceitar_somente_tipo_com_letras() {
        telefone.setTipo("residencial");
        assertEquals("residencial", telefone.getTipo());
    }

    @Test
    public void nao_deve_aceitar_tipo_com_numero() {
        telefone.setTipo("residencial1");
        assertNotEquals("residencial1", telefone.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- Responsavel >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_responsavel_nulo() {
        telefone.setResponsavel(null);
        assertNull(telefone.getResponsavel());
    }

    @Test
    public void nao_deve_aceitar_responsavel_vazio() {
        telefone.setResponsavel("");
        assertNull(telefone.getResponsavel());
    }

    @Test
    public void deve_aceitar_somente_responsavel_com_letras() {
        telefone.setResponsavel("contmatic");
        assertEquals("contmatic", telefone.getResponsavel());
    }

    @Test
    public void nao_deve_aceitar_responsavel_com_numero() {
        telefone.setResponsavel("contmatic1");
        assertNotEquals("contmatic1", telefone.getResponsavel());
    }

    /* -------------------------------------------------- <<< Responsavel ----------------------------------------------------------- */

    /* -------------------------------------------------- Telefone >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_operadora_nula() {
        telefone.setOperadora(null);
        assertNull(telefone.getOperadora());
    }

    @Test
    public void deve_aceitar_operadora_nao_nula() {
        telefone.setOperadora(operadora);
        assertNotNull(telefone.getOperadora());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Telefone telefone2 = new Telefone();
        assertEquals(telefone.toString(), telefone2.toString());
    }

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< hashCode ----------------------------------------------------------- */

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_ddd_nulo() {
        telefone.setDdd(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1466627807_para_ddd_nao_nulo() {
        telefone.setDdd("11");
        System.out.println(telefone.hashCode());
        assertEquals(-1466627807, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_numero_nulo() {
        telefone.setNumero(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1774691899_para_numero_nao_nulo() {
        telefone.setNumero("12345678");
        System.out.println(telefone.hashCode());
        assertEquals(-1774691899, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_ramal_nulo() {
        telefone.setRamal(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887552692_para_ramal_nao_nulo() {
        telefone.setRamal("3");
        System.out.println(telefone.hashCode());
        assertEquals(887552692, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_tipo_nulo() {
        telefone.setTipo(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1985349622_para_tipo_nao_nulo() {
        telefone.setTipo("residencial");
        System.out.println(telefone.hashCode());
        assertEquals(1985349622, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_responsavel_nulo() {
        telefone.setResponsavel(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1369092537_para_responsavel_nao_nulo() {
        telefone.setResponsavel("contmatic");
        System.out.println(telefone.hashCode());
        assertEquals(1369092537, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_887503681_para_operadora_nula() {
        telefone.setOperadora(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_916132832_para_operadora_nao_nula() {
        telefone.setOperadora(operadora);
        System.out.println(telefone.hashCode());
        assertEquals(916132832, telefone.hashCode());
    }

    /* -------------------------------------------------- hashCode >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< equals ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(telefone.equals(telefone));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_telefone_nulo() {
        Telefone telefone2 = new Telefone();
        telefone2 = null;
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        assertFalse(telefone.equals(telefone2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ddd_nulo_com_ddd_nao_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd("11");
        telefone.setDdd(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ddds_nulos() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd(null);
        telefone.setDdd(null);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ddd_nao_nulo_com_ddd_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd(null);
        telefone.setDdd("00");
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ddds_nao_nulos() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd("00");
        telefone.setDdd("00");
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_numero_nulo_com_numero_nao_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero("12345678");
        telefone.setNumero(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_numeros_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_numero_nao_nulo_com_numero_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero("12345678");
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_numeros_nao_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero("12345678");
        telefone.setNumero("12345678");
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_operadora_nula_com_operadora_nao_nula_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(operadora);
        telefone.setOperadora(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_operadoras_nulas() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_operadora_nao_nula_com_operadora_nula_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(operadora);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_operadoras_nao_nulas() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(operadora);
        telefone.setOperadora(operadora);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ramal_nulo_com_ramal_nao_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal("123");
        telefone.setRamal(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ramais_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        ;
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ramal_nao_nulo_com_ramal_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal("123");
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ramais_nao_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal("123");
        telefone.setRamal("123");
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_responsavel_nulo_com_responsavel_nao_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel("Contmatic");
        telefone.setResponsavel(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_responsaveis_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel(null);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_responsavel_nao_nulo_com_responsavel_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel("Contmatic");
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_responsaveis_nao_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel("Contmatic");
        telefone.setResponsavel("Contmatic");
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tipo_nulo_com_tipo_nao_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel(null);
        telefone2.setTipo("Residencial");
        telefone.setTipo(null);
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tipos_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel(null);
        telefone2.setTipo(null);
        telefone.setTipo(null);
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_tipo_nao_nulo_com_tipo_nulo_de_outro_telefone() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel(null);
        telefone2.setTipo(null);
        telefone.setTipo("Residencial");
        assertFalse(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_tipos_nao_nulos() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);
        telefone2.setResponsavel(null);
        telefone.setResponsavel(null);
        telefone2.setTipo("Residencial");
        telefone.setTipo("Residencial");
        assertTrue(telefone.equals(telefone2));
    }

    /* -------------------------------------------------- equals >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
