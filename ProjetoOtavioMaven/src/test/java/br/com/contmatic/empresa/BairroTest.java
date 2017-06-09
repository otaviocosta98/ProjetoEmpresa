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
 * The Class BairroTest.
 */
public class BairroTest {

    /** The bairro. */
    Bairro bairro;

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
        bairro = Fixture.from(Bairro.class).gimme("valid");
        System.out.println(bairro.toString());
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
        bairro.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Codigo não pode ser nulo"));
    }

    /**
     * Nao deve aceitar codigo menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        bairro.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Codigo deve ser maior que 0"));
    }

    /**
     * Deve aceitar codigo numerico.
     */
    @Test
    public void deve_aceitar_codigo_numerico() {
        assertNotNull(bairro.getCodigo());
    }
    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar nome nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        bairro.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome não deve ser nulo"));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        bairro.setNome("");
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome não deve ser vazio"));
    }

    /**
     * Deve aceitar nome somente com letras.
     */
    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        assertNotNull(bairro.getNome());
    }

    /**
     * Nao deve aceitar nome alfa numerico.
     */
    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        bairro.setNome("Coahb 1");
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome deve conter somente palavras"));
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    /**
     * Deve aceitar tamanho decimal.
     */
    @Test
    public void deve_aceitar_tamanho_decimal() {
        assertNotNull(bairro.getTamanho());
    }

    /**
     * Nao deve aceitar tamanho menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_tamanho_menor_ou_igual_a_0() {
        bairro.setTamanho(0.0);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tamanho deve ser maior que 0"));
    }

    /**
     * Nao deve aceitar tamanho nulo.
     */
    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        bairro.setTamanho(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tamanho não deve ser nulo"));
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar populacao nulo.
     */
    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        bairro.setPopulacao(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "População não deve ser nulo"));
    }

    /**
     * Nao deve aceitar populacao vazio.
     */
    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        bairro.setPopulacao(0L);
        assertFalse(ValidatorAnnotations.isValid(bairro, "População deve ser maior que 0"));
    }

    /**
     * Deve aceitar populacao somente numerico.
     */
    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        assertNotNull(bairro.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar tipo nulo.
     */
    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        bairro.setTipo(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tipo não deve ser nulo"));
    }

    /**
     * Deve aceitar tipo valido.
     */
    @Test
    public void deve_aceitar_tipo_valido() {
        assertNotNull(bairro.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Bairro bairro2 = bairro;
        assertEquals(bairro.toString(), bairro2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Bairro bairro2 = new Bairro();
        assertNotEquals(bairro.toString(), bairro2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals & HashCode>>> ----------------------------------------------------------- */

    /**
     * Deve ser valido equals e hashcode para campo codigo.
     */
    @Test
    public void deve_ser_valido_equals_e_hashcode_para_campo_codigo() {
        EqualsVerifier.forClass(Bairro.class).withOnlyTheseFields("codigo").suppress(Warning.NONFINAL_FIELDS).verify();
    }

    /* -------------------------------------------------- <<< Equals & HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
