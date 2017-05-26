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

public class OperadoraTest {

    Operadora operadora;

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
        operadora = Fixture.from(Operadora.class).gimme("valid");
        System.out.println(operadora.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */
    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        operadora.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(operadora, "Codigo não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_codigo_vazio() {
        operadora.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(operadora, "Codigo deve maior que 0"));
    }

    @Test
    public void deve_aceitar_somente_numeros_no_codigo() {
        assertNotNull(operadora.getCodigo());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- Nome >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_nulo() {
        operadora.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(operadora, "Nome não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_nome_vazio() {
        operadora.setNome("");
        assertFalse(ValidatorAnnotations.isValid(operadora, "Nome não deve ser vazio"));
    }

    @Test
    public void deve_aceitar_nome_alfa_numerico() {
        assertNotNull(operadora.getNome());
    }

    /* -------------------------------------------------- <<< Nome ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Operadora operadora2 = operadora;
        assertEquals(operadora.toString(), operadora2.toString());
    }
    
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Operadora operadora2 = new Operadora();
        assertNotEquals(operadora.toString(), operadora2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- hashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Operadora operadora2 = operadora;
        assertEquals(operadora.hashCode(), operadora2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Operadora operadora2 = new Operadora();
        assertThat(operadora.hashCode(), is(not(operadora2.hashCode())));
    }

    /* -------------------------------------------------- <<< hashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_operadora_a_outro_objeto_que_não_seja_da_clase_operadora() {
        Cidade cidade = new Cidade();
        assertFalse(operadora.equals(cidade));
    }
    
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(operadora.equals(operadora));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outro_operadora_igual() {
        Operadora operadora2 = operadora;
        assertTrue(operadora.equals(operadora2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_operadora_diferente() {
        Operadora operadora2 = new Operadora();
        assertFalse(operadora.equals(operadora2));
    }

    /* -------------------------------------------------- <<< equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
