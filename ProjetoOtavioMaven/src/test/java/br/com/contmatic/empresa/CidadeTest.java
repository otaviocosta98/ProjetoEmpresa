package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class CidadeTest {

    Cidade cidade;
    Bairro bairro;

    /* -------------------------------------------------- SetUps e TearDowns >>> ----------------------------------------------------------- */

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("-------------Começo Classe Teste------------->");
        FixtureFactoryLoader.loadTemplates("br.com.contmatic.template");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("<------------Fim Classe teste-----------------");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("!-Começo Teste-!");
        cidade = Fixture.from(Cidade.class).gimme("valid");
        System.out.println(cidade.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        cidade.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Codigo não deve ser nulo"));
    }
    
    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        cidade.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Codigo deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_codigo_numerico_maior_que_0() {
        assertNotNull(cidade.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        cidade.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        cidade.setNome("");
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome não deve ser vazio"));
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        assertNotNull(cidade.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        cidade.setNome("São Paulo2");
        assertFalse(ValidatorAnnotations.isValid(cidade, "Nome deve conter somente palavras"));
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        cidade.setTamanho(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Tamanho não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_tamanho_menor_ou_igual_a_0() {
        cidade.setTamanho(0.0);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Tamanho deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_tamanho_somente_decimal() {
        assertNotNull(cidade.getTamanho());
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        cidade.setPopulacao(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "População não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        cidade.setPopulacao(0L);
        assertFalse(ValidatorAnnotations.isValid(cidade, "População deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        assertNotNull(cidade.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Bairro >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_bairro_nulo() {
        cidade.setBairro(null);
        assertFalse(ValidatorAnnotations.isValid(cidade, "Bairro não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_bairro_nao_nulo() {
        assertNotNull(cidade.getBairro());
    }

    /* -------------------------------------------------- <<< Bairro ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Cidade cidade2 = cidade;
        assertEquals(cidade.toString(), cidade2.toString());
    }
    
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Cidade cidade2 = new Cidade();
        assertNotEquals(cidade.toString(), cidade2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Cidade cidade2 = cidade;
        assertEquals(cidade.hashCode(), cidade2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Cidade cidade2 = new Cidade();
        cidade2.setCodigo(123);
        assertThat(cidade.hashCode(), is(not(cidade2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_cidade_a_outro_objeto_que_não_seja_da_clase_cidade() {
        Bairro bairro = new Bairro();
        assertFalse(cidade.equals(bairro));
    }
    
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(cidade.equals(cidade));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outra_cidade_igual() {
        Cidade cidade2 = cidade;
        assertTrue(cidade.equals(cidade2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outra_cidade_diferente() {
        Cidade cidade2 = new Cidade();
        assertFalse(cidade.equals(cidade2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
