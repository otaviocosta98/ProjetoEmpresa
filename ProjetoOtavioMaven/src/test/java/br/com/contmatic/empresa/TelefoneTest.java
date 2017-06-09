package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

/**
 * The Class TelefoneTest.
 */
public class TelefoneTest {

    /** The telefone. */
    Telefone telefone;

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
        telefone = Fixture.from(Telefone.class).gimme("valid");
        System.out.println(telefone.toString());
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

    /* -------------------------------------------------- DDD >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar ddd nulo.
     */
    @Test
    public void nao_deve_aceitar_ddd_nulo() {
        telefone.setDdd(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "DDD não deve ser nulo"));
    }

    /**
     * Nao deve aceitar ddd menor ou igual a 0 e maior ou igual a 99.
     */
    @Test
    public void nao_deve_aceitar_ddd_menor_ou_igual_a_0_e_maior_ou_igual_a_99() {
        telefone.setDdd(0);
        assertFalse(ValidatorAnnotations.isValid(telefone, "DDD deve ser entre 11 e 99"));
    }

    /**
     * Deve aceitar somente ddd numerico.
     */
    @Test
    public void deve_aceitar_somente_ddd_numerico() {
        assertNotNull(telefone.getDdd());
    }

    /* -------------------------------------------------- <<< DDD ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar numero nulo.
     */
    @Test
    public void nao_deve_aceitar_numero_nulo() {
        telefone.setNumero(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Numero não deve ser nulo"));
    }

    /**
     * Nao deve aceitar numero menor que 8 ou maior que 9 digitos.
     */
    @Test
    public void nao_deve_aceitar_numero_menor_que_8_ou_maior_que_9_digitos() {
        telefone.setNumero(1234567);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Quantidade de digitos incorretos"));
    }

    /**
     * Deve aceitar numero entre 8 e 9 digitos.
     */
    @Test
    public void deve_aceitar_numero_entre_8_e_9_digitos() {
        assertNotNull(telefone.getNumero());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Ramal >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar ramal nulo.
     */
    @Test
    public void nao_deve_aceitar_ramal_nulo() {
        telefone.setRamal(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Ramal não deve ser nulo"));
    }

    /**
     * Deve aceitar ramal valido.
     */
    @Test
    public void deve_aceitar_ramal_valido() {
        assertNotNull(telefone.getRamal());
    }

    /* -------------------------------------------------- <<< Ramal ----------------------------------------------------------- */

    /* -------------------------------------------------- Tipo >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar tipo nulo.
     */
    @Test
    public void nao_deve_aceitar_tipo_nulo() {
        telefone.setTipo(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Tipo não deve ser nulo"));
    }

    /**
     * Deve aceitar tipo valido.
     */
    @Test
    public void deve_aceitar_tipo_valido() {
        assertNotNull(telefone.getTipo());
    }

    /* -------------------------------------------------- <<< Tipo ----------------------------------------------------------- */

    /* -------------------------------------------------- Responsavel >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar responsavel nulo.
     */
    @Test
    public void nao_deve_aceitar_responsavel_nulo() {
        telefone.setResponsavel(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável não deve ser nulo"));
    }

    /**
     * Nao deve aceitar responsavel vazio.
     */
    @Test
    public void nao_deve_aceitar_responsavel_vazio() {
        telefone.setResponsavel("");
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável não deve ser vazio"));
    }

    /**
     * Nao deve aceitar responsavel com numero.
     */
    @Test
    public void nao_deve_aceitar_responsavel_com_numero() {
        telefone.setResponsavel("contmatic1");
        assertFalse(ValidatorAnnotations.isValid(telefone, "Responsável deve conter somente palavras"));
    }

    /**
     * Deve aceitar somente responsavel com letras.
     */
    @Test
    public void deve_aceitar_somente_responsavel_com_letras() {
        assertNotNull(telefone.getResponsavel());
    }

    /* -------------------------------------------------- <<< Responsavel ----------------------------------------------------------- */

    /* -------------------------------------------------- Operadora >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar operadora nula.
     */
    @Test
    public void nao_deve_aceitar_operadora_nula() {
        telefone.setOperadora(null);
        assertFalse(ValidatorAnnotations.isValid(telefone, "Operadora não deve ser nula"));
    }

    /**
     * Deve aceitar operadora nao nula.
     */
    @Test
    public void deve_aceitar_operadora_nao_nula() {
        assertNotNull(telefone.getOperadora());
    }

    /* -------------------------------------------------- <<< Operadora ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Telefone telefone2 = telefone;
        assertEquals(telefone.toString(), telefone2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Telefone telefone2 = new Telefone();
        assertNotEquals(telefone.toString(), telefone2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals & HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido equals e hashcode para campo codigo.
     */
    @Test
    public void deve_ser_valido_equals_e_hashcode_para_campo_codigo() {
        EqualsVerifier.forClass(Telefone.class).withOnlyTheseFields("numero").suppress(Warning.NONFINAL_FIELDS).verify();
    }

    /* -------------------------------------------------- Equals & HashCode >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
