package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EnderecoTest.
 */
public class EnderecoTest {

    /** The endereco. */
    Endereco endereco;

    /* -------------------------------------------------- SetUps e TearDowns >>> ----------------------------------------------------------- */

    /**
     * Set up before class.
     *
     * @throws Exception the exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("-------------Começo Classe Teste------------->");
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.template");
    }

    /**
     * Tear down after class.
     *
     * @throws Exception the exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("<------------Fim Classe teste-----------------");
    }

    /**
     * Set up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("!-Começo Teste-!");
        endereco = Fixture.from(Endereco.class).gimme("valid");
        System.out.println(endereco.toString());
        ;
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /** The thrown. */
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >> ----------------------------------------------------------- */

    /* -------------------------------------------------- Logradouro >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar logradouro nulo.
     */
    @Test
    public void nao_deve_aceitar_logradouro_nulo() {
        endereco.setLogradouro(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Logradouro não deve ser nulo"));
    }

    /**
     * Nao deve aceitar logradouro vazio.
     */
    @Test
    public void nao_deve_aceitar_logradouro_vazio() {
        endereco.setLogradouro("");
        assertFalse(ValidatorAnnotations.isValid(endereco, "Logradouro não deve ser vazio"));
    }

    /**
     * Nao deve aceitar logradouro alfanumerico.
     */
    @Test
    public void nao_deve_aceitar_logradouro_alfanumerico() {
        endereco.setLogradouro("Rua 9");
        assertFalse(ValidatorAnnotations.isValid(endereco, "Logradouro deve conter somente palavras"));
    }

    /**
     * Deve aceitar logradouro somente com letras.
     */
    @Test
    public void deve_aceitar_logradouro_somente_com_letras() {
        assertNotNull(endereco.getLogradouro());
    }

    /* -------------------------------------------------- <<< Logradouro ----------------------------------------------------------- */

    /* -------------------------------------------------- Complemento >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar complemento nulo.
     */
    @Test
    public void nao_deve_aceitar_complemento_nulo() {
        endereco.setComplemento(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Complemento não deve ser nulo"));
    }

    /**
     * Nao deve aceitar complemento vazio.
     */
    @Test
    public void nao_deve_aceitar_complemento_vazio() {
        endereco.setComplemento("");
        assertFalse(ValidatorAnnotations.isValid(endereco, "Complemento não deve ser vazio"));
    }

    /**
     * Nao deve aceitar complemento com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        endereco.setComplemento("110!");
        assertFalse(ValidatorAnnotations.isValid(endereco, "Complemento deve ser somente alfa-numerico"));
    }

    /**
     * Deve aceitar complemento alfanumerico.
     */
    @Test
    public void deve_aceitar_complemento_alfanumerico() {
        assertNotNull(endereco.getComplemento());
    }

    /* -------------------------------------------------- <<< Complemento ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar numero nulo.
     */
    @Test
    public void nao_deve_aceitar_numero_nulo() {
        endereco.setNumero(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Numero não deve ser nulo"));
    }

    /**
     * Nao deve aceitar numero vazio.
     */
    @Test
    public void nao_deve_aceitar_numero_vazio() {
        endereco.setNumero(0);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Numero deve ser maior que 0"));
    }

    /**
     * Deve aceitar numero alfanumerico.
     */
    @Test
    public void deve_aceitar_numero_alfanumerico() {
        assertNotNull(endereco.getNumero());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Estado >>> ----------------------------------------------------------- */

    /**
     * Deve aceitar estado nao nulo.
     */
    @Test
    public void deve_aceitar_estado_nao_nulo() {
        endereco.setEstado(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Estado não deve ser nulo"));
    }

    /**
     * Nao deve aceitar estado nulo.
     */
    @Test
    public void nao_deve_aceitar_estado_nulo() {
        assertNotNull(endereco.getEstado());
    }

    /* -------------------------------------------------- <<< Estado ----------------------------------------------------------- */

    /* -------------------------------------------------- CEP >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar cep nulo.
     */
    @Test
    public void nao_deve_aceitar_cep_nulo() {
        endereco.setCep(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "CEP não deve ser nulo"));
    }

    /**
     * Nao deve aceitar cep menor ou igual a zero.
     */
    @Test
    public void nao_deve_aceitar_cep_menor_ou_igual_a_zero() {
        endereco.setCep("");
        assertFalse(ValidatorAnnotations.isValid(endereco, "CEP não deve ser vazio"));
    }

    /**
     * Nao deve aceitar cep alfa numerico.
     */
    @Test
    public void nao_deve_aceitar_cep_alfa_numerico() {
        endereco.setCep("0359-11o");
        assertFalse(ValidatorAnnotations.isValid(endereco, "CEP deve conter somente 8 digitos"));
    }

    /**
     * Deve aceitar cep com 8 digitos.
     */
    @Test
    public void deve_aceitar_cep_com_8_digitos() {
        assertNotNull(endereco.getCep());
    }

    /* -------------------------------------------------- <<< CEP ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Endereco endereco2 = endereco;
        assertEquals(endereco.toString(), endereco2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Endereco endereco2 = new Endereco();
        assertNotEquals(endereco.toString(), endereco2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido hashcode de valores iguais.
     */
    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Endereco endereco2 = endereco;
        assertEquals(endereco.hashCode(), endereco2.hashCode());
    }

    /**
     * Nao deve ser valido hashcode de objetos diferentes.
     */
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_diferentes() {
        Endereco endereco2 = new Endereco();
        assertThat(endereco.hashCode(), is(not(endereco2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    /**
     * Deve o equals retornar false comparando endereco a outro objeto que não seja da clase endereco.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_endereco_a_outro_objeto_que_não_seja_da_clase_endereco() {
        Cidade cidade = new Cidade();
        assertFalse(endereco.equals(cidade));
    }

    /**
     * Deve o equals retornar true comparando ele mesmo.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(endereco.equals(endereco));
    }

    /**
     * Deve o equals retornar true comparando outro endereco igual.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_outro_endereco_igual() {
        Endereco endereco2 = endereco;
        assertTrue(endereco.equals(endereco2));
    }

    /**
     * Deve o equals retornar false comparando outro endereco diferente.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_outro_endereco_diferente() {
        Endereco endereco2 = new Endereco();
        assertFalse(endereco.equals(endereco2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
