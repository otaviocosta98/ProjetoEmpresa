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
 * The Class CidadeTest.
 */
public class CidadeTest {

    /** The cidade. */
    Cidade cidade;

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
        cidade = Fixture.from(Cidade.class).gimme("valid");
        System.out.println(cidade.toString());
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

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar codigo nulo.
     */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        cidade.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Codigo não deve ser nulo"));
    }

    /**
     * Nao deve aceitar codigo menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        cidade.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Codigo deve ser maior que 0"));
    }

    /**
     * Deve aceitar codigo numerico maior que 0.
     */
    @Test
    public void deve_aceitar_codigo_numerico_maior_que_0() {
        assertNotNull(cidade.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar nome nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        cidade.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome não deve ser nulo"));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        cidade.setNome("");
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome não deve ser vazio"));
    }

    /**
     * Deve aceitar nome somente com letras.
     */
    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        assertNotNull(cidade.getNome());
    }

    /**
     * Nao deve aceitar nome alfa numerico.
     */
    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        cidade.setNome("São Paulo2");
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome deve conter somente palavras"));
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar tamanho nulo.
     */
    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        cidade.setTamanho(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Tamanho não deve ser nulo"));
    }

    /**
     * Nao deve aceitar tamanho menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_tamanho_menor_ou_igual_a_0() {
        cidade.setTamanho(0.0);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Tamanho deve ser maior que 0"));
    }

    /**
     * Deve aceitar tamanho somente decimal.
     */
    @Test
    public void deve_aceitar_tamanho_somente_decimal() {
        assertNotNull(cidade.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar populacao nulo.
     */
    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        cidade.setPopulacao(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "População não deve ser nulo"));
    }

    /**
     * Nao deve aceitar populacao vazio.
     */
    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        cidade.setPopulacao(0L);
        assertFalse(ValidatorAnnotations.isValid(cidade, "População deve ser maior que 0"));
    }

    /**
     * Deve aceitar populacao somente numerico.
     */
    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        assertNotNull(cidade.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Bairro >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar bairro nulo.
     */
    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        cidade.setBairro(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Bairro não deve ser nulo"));
    }

    /**
     * Deve aceitar bairro nao nulo.
     */
    @Test
    public void deve_aceitar_bairro_nao_nulo() {
        assertNotNull(cidade.getBairro());
    }

    /* -------------------------------------------------- <<< Bairro ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Cidade cidade2 = cidade;
        assertEquals(cidade.toString(), cidade2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Cidade cidade2 = new Cidade();
        assertNotEquals(cidade.toString(), cidade2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals & HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido equals e hashcode para campo codigo.
     */
    @Test
    public void deve_ser_valido_equals_e_hashcode_para_campo_codigo() {
        EqualsVerifier.forClass(Cidade.class).withOnlyTheseFields("codigo").suppress(Warning.NONFINAL_FIELDS).verify();
    }

    /* -------------------------------------------------- <<< Equals & HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
