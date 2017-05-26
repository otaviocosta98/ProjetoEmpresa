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
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class TelefoneTest {

    Telefone telefone;

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
        telefone = Fixture.from(Telefone.class).gimme("valid");
        System.out.println(telefone.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- DDD >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ddd_nulo() {
        telefone.setDdd(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "DDD não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_ddd_menor_ou_igual_a_0_e_maior_ou_igual_a_99() {
        telefone.setDdd(0);
        assertFalse(ValidatorAnnotations.isValid(telefone, "DDD deve ser entre 11 e 99"));
    }

    @Test
    public void deve_aceitar_somente_ddd_numerico() {
        assertNotNull(telefone.getDdd());
    }

    /* -------------------------------------------------- <<< DDD ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        telefone.setNumero(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Numero não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_numero_menor_que_8_ou_maior_que_9_digitos() {
        telefone.setNumero(1234567);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Quantidade de digitos incorretos"));
    }

    @Test
    public void deve_aceitar_numero_entre_8_e_9_digitos() {
        assertNotNull(telefone.getNumero());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Ramal >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ramal_nulo() {
        telefone.setRamal(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Ramal não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_ramal_valido() {
        assertNotNull(telefone.getRamal());
    }

    /* -------------------------------------------------- <<< Ramal ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        telefone.setTipo(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Tipo não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_tipo_valido() {
        assertNotNull(telefone.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- Responsavel >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_responsavel_nulo() {
        telefone.setResponsavel(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_responsavel_vazio() {
        telefone.setResponsavel("");
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável não deve ser vazio"));
    }

    @Test
    public void nao_deve_aceitar_responsavel_com_numero() {
        telefone.setResponsavel("contmatic1");
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável deve conter somente palavras"));
    }

    @Test
    public void deve_aceitar_somente_responsavel_com_letras() {
        assertNotNull(telefone.getResponsavel());
    }

    /* -------------------------------------------------- <<< Responsavel ----------------------------------------------------------- */

    /* -------------------------------------------------- Operadora >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_operadora_nula() {
        telefone.setOperadora(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Operadora não deve ser nula"));
    }

    @Test
    public void deve_aceitar_operadora_nao_nula() {
        assertNotNull(telefone.getOperadora());
    }

    /* -------------------------------------------------- <<< Operadora ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Telefone telefone2 = telefone;
        assertEquals(telefone.toString(), telefone2.toString());
    }

    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Telefone telefone2 = new Telefone();
        assertNotEquals(telefone.toString(), telefone2.toString());
    }

    /* -------------------------------------------------- <<< ToString  ----------------------------------------------------------- */

    /* -------------------------------------------------- hashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Telefone telefone2 = telefone;
        assertEquals(telefone.hashCode(), telefone2.hashCode());
    }

    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_diferentes() {
        Telefone telefone2 = new Telefone();
        telefone.setNumero(12345678);
        telefone2.setNumero(123456789);
        assertThat(telefone.hashCode(), is(not(telefone2.hashCode())));
    }

    /* -------------------------------------------------- <<< hashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_telefone_a_outro_objeto_que_não_seja_da_clase_telefone() {
        Cidade cidade = new Cidade();
        assertFalse(telefone.equals(cidade));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(telefone.equals(telefone));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outro_telefone_igual() {
        Telefone telefone2 = telefone;
        assertTrue(telefone.equals(telefone2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_telefone_diferente() {
        Telefone telefone2 = new Telefone();
        assertFalse(telefone.equals(telefone2));
    }

    /* -------------------------------------------------- equals >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
