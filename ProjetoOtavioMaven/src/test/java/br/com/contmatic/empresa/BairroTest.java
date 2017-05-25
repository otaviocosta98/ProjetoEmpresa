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

public class BairroTest {

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
        bairro = Fixture.from(Bairro.class).gimme("valid");
        System.out.println(bairro.toString());
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
        bairro.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Codigo não pode ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        bairro.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Codigo deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_codigo_numerico() {
        assertNotNull(bairro.getCodigo());
    }
    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        bairro.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        bairro.setNome("");
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome não deve ser vazio"));
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        assertNotNull(bairro.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        bairro.setNome("Coahb 1");
        assertFalse(ValidatorAnnotations.isValid(bairro, "Nome deve conter somente palavras"));
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void deve_aceitar_tamanho_decimal() {
        assertNotNull(bairro.getTamanho());
    }
    
    @Test
    public void nao_deve_aceitar_tamanho_menor_ou_igual_a_0() {
        bairro.setTamanho(0.0);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tamanho deve ser maior que 0"));
    }
    
    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        bairro.setTamanho(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tamanho não deve ser nulo"));
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        bairro.setPopulacao(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "População não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        bairro.setPopulacao(0L);
        assertFalse(ValidatorAnnotations.isValid(bairro, "População deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        assertNotNull(bairro.getPopulacao());
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        bairro.setTipo(null);
        assertFalse(ValidatorAnnotations.isValid(bairro, "Tipo não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_tipo_valido() {
        assertNotNull(bairro.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Bairro bairro2 = bairro;
        assertEquals(bairro.toString(), bairro2.toString());
    }
    
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Bairro bairro2 = new Bairro();
        assertNotEquals(bairro.toString(), bairro2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Bairro bairro2 = bairro;
        assertEquals(bairro.hashCode(), bairro2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo(456);
        bairro2.setCodigo(123);
        assertThat(bairro.hashCode(), is(not(bairro2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_bairro_a_outro_objeto_que_não_seja_da_clase_bairro() {
        Cidade cidade = new Cidade();
        assertFalse(bairro.equals(cidade));
    }
    
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(bairro.equals(bairro));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outro_bairro_igual() {
        Bairro bairro2 = bairro;
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_bairro_diferente() {
        Bairro bairro2 = new Bairro();
        assertFalse(bairro.equals(bairro2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
