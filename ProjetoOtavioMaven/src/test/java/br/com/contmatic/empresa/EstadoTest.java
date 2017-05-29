package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EstadoTest.
 */
public class EstadoTest {

    /** The estado. */
    Estado estado;

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
        estado = Fixture.from(Estado.class).gimme("valid");
        System.out.println(estado.toString());
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

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar codigo nulo.
     */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        estado.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "Codigo não deve ser nulo"));
    }

    /**
     * Nao deve aceitar codigo menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        estado.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(estado, "Codigo deve ser maior que 0"));
    }

    /**
     * Deve aceitar codigo numerico.
     */
    @Test
    public void deve_aceitar_codigo_numerico() {
        assertNotNull(estado.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar nome nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_nulo() {
        estado.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "Nome não deve ser nulo"));
    }

    /**
     * Nao deve aceitar nome vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_vazio() {
        estado.setNome("");
        assertFalse(ValidatorAnnotations.isValid(estado, "Nome não deve ser vazio"));
    }

    /**
     * Nao deve aceitar nome alfa numerico.
     */
    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        estado.setNome("Sao Paulo2");
        assertFalse(ValidatorAnnotations.isValid(estado, "Nome deve conter somente palavras"));
    }

    /**
     * Deve aceitar nome somente com letras.
     */
    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        assertNotNull(estado.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- UF >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar uf nulo.
     */
    @Test
    public void nao_deve_aceitar_uf_nulo() {
        estado.setUf(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "UF não deve ser nulo"));
    }

    /**
     * Deve aceitar uf valido.
     */
    @Test
    public void deve_aceitar_uf_valido() {
        assertNotNull(estado.getUf());
    }

    /* -------------------------------------------------- <<< UF ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar tamanho nulo.
     */
    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        estado.setTamanho(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "Tamanho não deve ser nulo"));
    }

    /**
     * Nao deve aceitar tamanho menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_tamanho_menor_ou_igual_a_0() {
        estado.setTamanho(0.0);
        assertFalse(ValidatorAnnotations.isValid(estado, "Tamanho deve ser maior que 0"));
    }

    /**
     * Deve aceitar tamanho somente numerico.
     */
    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        assertNotNull(estado.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- Populacao >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar populacao nulo.
     */
    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        estado.setPopulacao(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "População não deve ser nulo"));
    }

    /**
     * Nao deve aceitar populacao menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_populacao_menor_ou_igual_a_0() {
        estado.setPopulacao(0L);
        assertFalse(ValidatorAnnotations.isValid(estado, "População deve ser maior que 0"));
    }

    /**
     * Deve aceitar populacao somente numerico.
     */
    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        assertNotNull(estado.getPopulacao());
    }

    /* -------------------------------------------------- <<< Populacao ----------------------------------------------------------- */

    /* -------------------------------------------------- Cidade >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar cidade nulo.
     */
    @Test
    public void nao_deve_aceitar_cidade_nulo() {
        estado.setCidade(null);
        assertFalse(ValidatorAnnotations.isValid(estado, "Cidade não deve ser nula"));
    }

    /**
     * Deve aceitar cidade nao nula.
     */
    @Test
    public void deve_aceitar_cidade_nao_nula() {
        assertNotNull(estado.getCidade());
    }

    /* -------------------------------------------------- <<< Cidade ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Estado estado2 = estado;
        assertEquals(estado.toString(), estado2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Estado estado2 = new Estado();
        assertNotEquals(estado.toString(), estado2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido hashcode de valores iguais.
     */
    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Estado estado2 = estado;
        assertEquals(estado.hashCode(), estado2.hashCode());
    }

    /**
     * Nao deve ser valido hashcode de objetos deferentes.
     */
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes() {
        Estado estado2 = new Estado();
        estado.setCodigo(456);
        estado2.setCodigo(123);
        assertThat(estado.hashCode(), is(not(estado2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    /**
     * Deve o equals retornar false comparando estado a outro objeto que não seja da clase estado.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_estado_a_outro_objeto_que_não_seja_da_clase_estado() {
        Cidade cidade = new Cidade();
        assertFalse(estado.equals(cidade));
    }

    /**
     * Deve o equals retornar true comparando ele mesmo.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(estado.equals(estado));
    }

    /**
     * Deve o equals retornar true comparando outro estado igual.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_outro_estado_igual() {
        Estado estado2 = estado;
        assertTrue(estado.equals(estado2));
    }

    /**
     * Deve o equals retornar false comparando outro estado diferente.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_outro_estado_diferente() {
        Estado estado2 = new Estado();
        assertFalse(estado.equals(estado2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
