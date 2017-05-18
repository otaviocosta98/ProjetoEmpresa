package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
    public void deve_aceitar_codigo_numerico() {
    }

    @Test
    public void nao_deve_aceitar_codigo_menor_ou_igual_a_0() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Codigo deve ser maior que 0");
        bairro.setCodigo(0);
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Nome não deve ser nulo");
        bairro.setNome(null);
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome não deve ser vazio");
        bairro.setNome("");
    }

    @Test
    public void deve_aceitar_nome_somente_com_letras() {
        bairro.setNome("Cohab um");
        assertNotNull(bairro.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_alfa_numerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome deve conter somente palavras");
        bairro.setNome("Cohab 1");
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- Tamanho >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tamanho_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Tamanho não deve ser nulo");
        bairro.setTamanho(null);
    }

    @Test
    public void nao_deve_aceitar_tamanho_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Tamanho não deve ser vazio");
        bairro.setTamanho("");
    }

    @Test
    public void deve_aceitar_tamanho_somente_numerico() {
        bairro.setTamanho("123456.789");
        assertNotNull(bairro.getTamanho());
    }

    @Test
    public void nao_deve_aceitar_tamanho_alfa_numerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Tamanho deve conter somente numeros");
        bairro.setTamanho("123456E");
    }

    /* -------------------------------------------------- <<< Tamanho ----------------------------------------------------------- */

    /* -------------------------------------------------- População >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_populacao_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("População não deve ser nulo");
        bairro.setPopulacao(null);
    }

    @Test
    public void nao_deve_aceitar_populacao_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("População não deve ser vazio");
        bairro.setPopulacao("");
    }

    @Test
    public void deve_aceitar_populacao_somente_numerico() {
        System.out.println(bairro.toString());
        assertNotNull(bairro.getPopulacao());
    }

    @Test
    public void nao_deve_aceitar_populacao_alfa_numerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("População deve conter somente numeros");
        bairro.setPopulacao("123456E");
    }

    /* -------------------------------------------------- <<< População ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Tipo não deve ser nulo");
        bairro.setTipo(null);
    }

    @Test
    public void deve_aceitar_tipo_valido() {
        assertNotNull(bairro.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Bairro bairro2 = new Bairro();
        assertEquals(bairro.toString(), bairro2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo("123");
        bairro2.setCodigo("123");
        assertEquals(bairro.hashCode(), bairro2.hashCode());
    }
    
    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo(null);
        bairro2.setCodigo("123");
        assertNotEquals(bairro.hashCode(), bairro2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Bairro bairro2 = new Bairro();
        bairro.setCodigo("456");
        bairro2.setCodigo("123");
        assertThat(bairro.hashCode(), is(not(bairro2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(bairro.equals(bairro));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_bairro_nulo() {
        Bairro bairro2 = new Bairro();
        bairro2 = null;
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        assertFalse(bairro.equals(bairro2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nulo_com_codigo_nao_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("11");
        bairro.setCodigo(null);
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo(null);
        assertTrue(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_codigo_nao_nulo_com_codigo_nulo_de_outro_bairro() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo(null);
        bairro.setCodigo("00");
        assertFalse(bairro.equals(bairro2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_codigos_nao_nulos() {
        Bairro bairro2 = new Bairro();
        bairro2.setCodigo("00");
        bairro.setCodigo("00");
        assertTrue(bairro.equals(bairro2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
