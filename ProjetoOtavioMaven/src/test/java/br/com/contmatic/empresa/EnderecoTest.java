package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EnderecoTest {

    Endereco endereco;
    Estado estado;

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
        endereco = new Endereco();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >> ----------------------------------------------------------- */

    /* -------------------------------------------------- Logradouro >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_logradouro_nulo() {
        endereco.setLogradouro(null);
        assertNull(endereco.getLogradouro());
    }

    @Test
    public void nao_deve_aceitar_logradouro_vazio() {
        endereco.setLogradouro("");
        assertThat("", is(not(endereco.getLogradouro())));
    }

    @Test
    public void nao_deve_aceitar_logradouro_alfanumerico() {
        endereco.setLogradouro("Rua 9");
        assertNull(endereco.getLogradouro());
    }

    @Test
    public void deve_aceitar_logradouro_somente_com_letras() {
        endereco.setLogradouro("Rua Nove");
        assertThat("Rua Nove", is(endereco.getLogradouro()));
    }

    /* -------------------------------------------------- <<< Logradouro ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        endereco.setComplemento(null);
        assertNull(endereco.getComplemento());
    }

    @Test
    public void nao_deve_aceitar_numero_vazio() {
        endereco.setComplemento("");
        assertEquals(null, endereco.getComplemento());
    }

    @Test
    public void deve_aceitar_complemento_alfanumerico() {
        endereco.setComplemento("110a");
        assertNotNull(endereco.getComplemento());
    }

    @Test
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        endereco.setComplemento("110!");
        assertNotEquals("110!", endereco.getComplemento());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Complemento >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_complemento_nulo() {
        endereco.setNumero(null);
        assertThat(null, is(endereco.getNumero()));
    }

    @Test
    public void nao_deve_aceitar_complemento_vazio() {
        endereco.setNumero("");
        assertNull(endereco.getNumero());
    }

    @Test
    public void deve_aceitar_numero_alfanumerico() {
        endereco.setNumero("51b");
        assertEquals("51b", endereco.getNumero());
    }

    @Test
    public void nao_deve_aceitar_numero_com_caracteres_especiais() {
        endereco.setNumero("5!b!");
        assertNull(endereco.getNumero());
    }

    /* -------------------------------------------------- <<< Complemento ----------------------------------------------------------- */

    /* -------------------------------------------------- Estado >>> ----------------------------------------------------------- */

    @Test
    public void deve_aceitar_estado_nao_nulo() {
        endereco.setEstado(estado);
        assertSame(estado, endereco.getEstado());
    }

    @Test
    public void nao_deve_aceitar_estado_nulo() {
        endereco.setEstado(null);
        assertNotSame(endereco, endereco.getEstado());
    }

    /* -------------------------------------------------- <<< Estado ----------------------------------------------------------- */

    /* -------------------------------------------------- CEP >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
        assertNull(endereco.getCep());
    }

    @Test
    public void nao_deve_aceitar_cep_vazio() {
        endereco.setCep("");
        assertEquals(null, endereco.getCep());
    }

    @Test
    public void nao_deve_aceitar_cep_alfanumerico() {
        endereco.setCep("035910op");
        assertThat(null, is(endereco.getCep()));
    }

    @Test
    public void deve_aceitar_cep_numerico() {
        endereco.setCep("03591010");
        assertNotNull(endereco.getCep());
    }

    @Test
    public void nao_deve_aceitar_cep_maior_que_8_digitos() {
        endereco.setCep("035910101");
        assertNull(endereco.getCep());
    }

    @Test
    public void deve_aceitar_cep_com_8_digitos() {
        endereco.setCep("03591010");
        assertThat("03591010", is(endereco.getCep()));
    }

    @Test
    public void nao_deve_aceitar_cep_menor_que_8_digitos() {
        endereco.setCep("0359101");
        assertNotEquals("0359101", endereco.getCep());
    }

    /* -------------------------------------------------- <<< CEP ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Endereco endereco2 = new Endereco();
        assertEquals(endereco.toString(), endereco2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_logradouro_nulo() {
        endereco.setLogradouro(null);
        System.out.println(endereco.hashCode());
        assertEquals(28629151, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1071699469_para_logradouro_nao_nulo() {
        endereco.setLogradouro("Rua Nove");
        System.out.println(endereco.hashCode());
        assertEquals(1071699469, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_numero_nulo() {
        endereco.setNumero(null);
        System.out.println(endereco.hashCode());
        assertEquals(28629151, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28677841_para_numero_nao_nulo() {
        endereco.setNumero("123");
        System.out.println(endereco.hashCode());
        assertEquals(28677841, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_complemento_nulo() {
        endereco.setComplemento(null);
        System.out.println(endereco.hashCode());
        assertEquals(28629151, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1594831394_para_complemento_nao_nulo() {
        endereco.setComplemento("51y");
        System.out.println(endereco.hashCode());
        assertEquals(1594831394, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_estado_nulo() {
        endereco.setEstado(null);
        System.out.println(endereco.hashCode());
        assertEquals(28629151, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1778825312_para_estado_nao_nulo() {
        endereco.setEstado(estado);
        System.out.println(endereco.hashCode());
        assertEquals(-1778825312, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_28629151_para_cep_nulo() {
        endereco.setCep(null);
        System.out.println(endereco.hashCode());
        assertEquals(28629151, endereco.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1661400867_para_cep_nao_nulo() {
        endereco.setCep("12345678");
        System.out.println(endereco.hashCode());
        assertEquals(1661400867, endereco.hashCode());
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(endereco.equals(endereco));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_endereco_nulo() {
        Endereco endereco2 = new Endereco();
        endereco2 = null;
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        assertFalse(endereco.equals(endereco2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_logradouro_nulo_com_logradouro_nao_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua Nove");
        endereco.setLogradouro(null);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_logradouros_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_logradouro_nao_nulo_com_logradouro_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro("Rua Nove");
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_logradouros_nao_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro("Rua Nove");
        endereco.setLogradouro("Rua Nove");
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_numero_nulo_com_numero_nao_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero("123");
        endereco.setNumero(null);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_numeros_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_numero_nao_nulo_com_numero_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero("123");
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_numeros_nao_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero("123");
        endereco.setNumero("123");
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_complemento_nulo_com_complemento_nao_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento("51y");
        endereco.setComplemento(null);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_complementos_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_complemento_nao_nulo_com_complemento_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento("51y");
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_complementos_nao_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento("51y");
        endereco.setComplemento("51y");
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_estado_nulo_com_estado_nao_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(estado);
        endereco.setEstado(null);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_estados_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(null);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_estado_nao_nulo_com_estado_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(estado);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_estados_nao_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(estado);
        endereco.setEstado(estado);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_cep_nulo_com_cep_nao_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(null);
        endereco2.setCep("12345678");
        endereco.setCep(null);
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ceps_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(null);
        endereco2.setCep(null);
        endereco.setCep(null);
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_cep_nao_nulo_com_cep_nulo_de_outro_endereco() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(null);
        endereco2.setCep(null);
        endereco.setCep("12345678");
        assertFalse(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ceps_nao_nulos() {
        Endereco endereco2 = new Endereco();
        endereco2.setLogradouro(null);
        endereco.setLogradouro(null);
        endereco2.setNumero(null);
        endereco.setNumero(null);
        endereco2.setComplemento(null);
        endereco.setComplemento(null);
        endereco2.setEstado(null);
        endereco.setEstado(null);
        endereco2.setCep("12345678");
        endereco.setCep("12345678");
        assertTrue(endereco.equals(endereco2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
