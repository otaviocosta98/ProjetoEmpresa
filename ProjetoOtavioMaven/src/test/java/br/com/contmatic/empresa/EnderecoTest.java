package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

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

    /* -------------------------------------------------- Região >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar regiao nula.
     */
    @Test
    public void nao_deve_aceitar_regiao_nula() {
        endereco.setRegiao(null);
        assertFalse(ValidatorAnnotations.isValid(endereco, "Região não deve ser nulo"));
    }

    /**
     * Deve aceitar regiao valida.
     */
    @Test
    public void deve_aceitar_regiao_valida() {
        assertNotNull(endereco.getRegiao());
    }

    /* -------------------------------------------------- <<< Região ----------------------------------------------------------- */

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

    /* -------------------------------------------------- Equals & HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido equals e hashcode para campo codigo.
     */
    @Test
    public void deve_ser_valido_equals_e_hashcode_para_campo_codigo() {
        EqualsVerifier.forClass(Endereco.class).withOnlyTheseFields("logradouro", "numero", "cep").suppress(Warning.NONFINAL_FIELDS).verify();
    }

    /* -------------------------------------------------- <<< Equals & HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
