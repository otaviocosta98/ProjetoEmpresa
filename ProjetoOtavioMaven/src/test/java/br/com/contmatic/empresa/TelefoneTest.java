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
    public void hash_code1() {
        telefone.setDdd(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code2() {
        telefone.setDdd("11");
        System.out.println(telefone.hashCode());
        assertEquals(-1466627807, telefone.hashCode());
    }
    
    @Test
    public void hash_code3() {
        telefone.setNumero(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code4() {
        telefone.setNumero("12345678");
        System.out.println(telefone.hashCode());
        assertEquals(-1774691899, telefone.hashCode());
    }
    
    @Test
    public void hash_code5() {
        telefone.setRamal(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code6() {
        telefone.setRamal("3");
        System.out.println(telefone.hashCode());
        assertEquals(887552692, telefone.hashCode());
    }
    
    @Test
    public void hash_code7() {
        telefone.setTipo(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code8() {
        telefone.setTipo("residencial");
        System.out.println(telefone.hashCode());
        assertEquals(1985349622, telefone.hashCode());
    }
    
    @Test
    public void hash_code9() {
        telefone.setResponsavel(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code10() {
        telefone.setResponsavel("contmatic");
        System.out.println(telefone.hashCode());
        assertEquals(1369092537, telefone.hashCode());
    }
    
    @Test
    public void hash_code11() {
        telefone.setOperadora(null);
        System.out.println(telefone.hashCode());
        assertEquals(887503681, telefone.hashCode());
    }
    
    @Test
    public void hash_code12() {
        telefone.setOperadora(operadora);
        System.out.println(telefone.hashCode());
        assertEquals(916132832, telefone.hashCode());
    }
    
    /* -------------------------------------------------- hashCode >>> ----------------------------------------------------------- */
    
    /* -------------------------------------------------- <<< equals ----------------------------------------------------------- */
    
    @Test
    public void deve_ser_valido_equals() {
        assertTrue(telefone.equals(telefone));
    }
    
    @Test
    public void deve_ser_valido_equals1() {
        Telefone telefone2 = new Telefone();
        telefone2 = null;
        assertFalse(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals2() {
        Telefone telefone2 = new Telefone();
        assertFalse(telefone.equals(telefone2.getClass()));
    }
    
    @Test
    public void deve_ser_valido_equals3() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd("11");
        telefone.setDdd(null);
        assertFalse(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals4() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd(null);
        telefone.setDdd(null);
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals5() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd(null);
        telefone.setDdd("00");
        assertFalse(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals6() {
        Telefone telefone2 = new Telefone();
        telefone2.setDdd("00");
        telefone.setDdd("00");
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals7() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero("12345678");
        telefone.setNumero(null);
        assertFalse(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals8() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals9() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero("12345678");
        assertFalse(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals10() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero("12345678");
        telefone.setNumero("12345678");
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals11() {
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
    public void deve_ser_valido_equals12() {
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
    public void deve_ser_valido_equals13() {
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
    public void deve_ser_valido_equals14() {
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
    public void deve_ser_valido_equals15() {
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
    public void deve_ser_valido_equals16() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);;
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals17() {
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
    public void deve_ser_valido_equals18() {
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
    public void deve_ser_valido_equals19() {
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
    public void deve_ser_valido_equals20() {
        Telefone telefone2 = new Telefone();
        telefone.setDdd(null);
        telefone2.setDdd(null);
        telefone2.setNumero(null);
        telefone.setNumero(null);
        telefone2.setOperadora(null);
        telefone.setOperadora(null);
        telefone2.setRamal(null);
        telefone.setRamal(null);;
        assertTrue(telefone.equals(telefone2));
    }
    
    @Test
    public void deve_ser_valido_equals21() {
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
    public void deve_ser_valido_equals22() {
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
    public void deve_ser_valido_equals23() {
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
    public void deve_ser_valido_equals24() {
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
    public void deve_ser_valido_equals25() {
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
    public void deve_ser_valido_equals26() {
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
    public void deve_ser_valido_equals27() {
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
    public void deve_ser_valido_equals28() {
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
    public void deve_ser_valido_equals29() {
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
    public void deve_ser_valido_equals30() {
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
