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

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido hashcode de valores iguais.
     */
    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Cidade cidade2 = cidade;
        assertEquals(cidade.hashCode(), cidade2.hashCode());
    }

    /**
     * Nao deve ser valido hashcode de objetos deferentes.
     */
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes() {
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(123);
        assertThat(cidade.hashCode(), is(not(cidade2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    /**
     * Deve o equals retornar false comparando cidade a outro objeto que não seja da clase cidade.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_cidade_a_outro_objeto_que_não_seja_da_clase_cidade() {
        Bairro bairro = new Bairro();
        assertFalse(cidade.equals(bairro));
    }

    /**
     * Deve o equals retornar true comparando ele mesmo.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(cidade.equals(cidade));
    }

    /**
     * Deve o equals retornar true comparando outra cidade igual.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_outra_cidade_igual() {
        Cidade cidade2 = cidade;
        assertTrue(cidade.equals(cidade2));
    }

    /**
     * Deve o equals retornar false comparando outra cidade diferente.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_outra_cidade_diferente() {
        Cidade cidade2 = new Cidade();
        assertFalse(cidade.equals(cidade2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
