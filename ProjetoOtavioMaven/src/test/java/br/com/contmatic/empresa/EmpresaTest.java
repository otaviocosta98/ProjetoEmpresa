package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

/**
 * The Class EmpresaTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

    /** The empresa. */
    Empresa empresa;

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
        empresa = Fixture.from(Empresa.class).gimme("valid");
        System.out.println(empresa.toString());
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

    /** The global timeout. */
    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

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
        empresa.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Codigo não deve ser nulo"));
    }

    /**
     * Nao deve aceitar codigo menor que 0.
     */
    @Test
    public void nao_deve_aceitar_codigo_menor_que_0() {
        empresa.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Codigo deve ser maior que 0"));
    }

    /**
     * Deve aceitar codigo valido.
     */
    @Test
    public void deve_aceitar_codigo_valido() {
        assertNotNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */

    /* -------------------------------------------------- NomeEmpresa >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar nome empresa nulo.
     */
    @Test
    public void nao_deve_aceitar_nome_empresa_nulo() {
        empresa.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Nome não deve ser nulo"));
    }

    /**
     * Nao deve aceitar nome empresa vazio.
     */
    @Test
    public void nao_deve_aceitar_nome_empresa_vazio() {
        empresa.setNome("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Nome não deve ser vazio"));
    }

    /**
     * Deve aceitar nome empresa alfa numerico.
     */
    @Test
    public void deve_aceitar_nome_empresa_alfa_numerico() {
        assertNotNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- RazaoSocial >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar razao social nulo.
     */
    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social não deve ser nula"));
    }

    /**
     * Nao deve aceitar razao social vazio.
     */
    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social não deve ser vazia"));
    }

    /**
     * Nao deve aceitar razao social com caracteres especiais.
     */
    @Test
    public void nao_deve_aceitar_razao_social_com_caracteres_especiais() {
        empresa.setRazaoSocial("Teste!");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social deve conter somente caracteres alfa-numericos"));
    }

    /**
     * Deve aceitar razao social alfanumerico.
     */
    @Test
    public void deve_aceitar_razao_social_alfanumerico() {
        assertNotNull(empresa.getRazaoSocial());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- IE >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar ir nulo.
     */
    @Test
    public void nao_deve_aceitar_ir_nulo() {
        empresa.setIE(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social não deve ser nula"));
    }

    /**
     * Nao deve aceitar ie menor ou igual a 0.
     */
    @Test
    public void nao_deve_aceitar_ie_menor_ou_igual_a_0() {
        empresa.setIE(0L);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social deve ser maior que zero"));
    }

    /**
     * Nao deve aceitar ie menor que 12 digitos.
     */
    @Test
    public void nao_deve_aceitar_ie_menor_que_12_digitos() {
        empresa.setIE(12345678909L);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social deve ter 12 digitos"));
    }

    /**
     * Deve aceitar ie com 12 caracteres.
     */
    @Test
    public void deve_aceitar_ie_com_12_caracteres() {
        assertNotNull(empresa.getIE());
    }

    /* -------------------------------------------------- <<< IE ----------------------------------------------------------- */

    /* -------------------------------------------------- CNPJ >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar cnpj nulo.
     */
    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCNPJ(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ não deve ser nulo"));
    }

    /**
     * Nao deve aceitar cnpj vazio.
     */
    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCNPJ("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ não deve ser vazio"));
    }

    /**
     * Nao deve aceitar cnpj alfa numerico.
     */
    @Test
    public void nao_deve_aceitar_cnpj_alfa_numerico() {
        empresa.setCNPJ("0123456789012A");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ deve conter somente numeros"));
    }

    /**
     * Nao deve aceitar cnpj menor ou maior que 14.
     */
    @Test
    public void nao_deve_aceitar_cnpj_menor_ou_maior_que_14() {
        empresa.setCNPJ("0123456789012");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ deve contem 14 digitos"));
    }

    /**
     * Deve aceitar cnpj com 14 caracteres.
     */
    @Test
    public void deve_aceitar_cnpj_com_14_caracteres() {
        assertNotNull(empresa.getCNPJ());
    }

    /* -------------------------------------------------- <<< CNPJ ----------------------------------------------------------- */

    /* -------------------------------------------------- Endereco >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar endereco nulo.
     */
    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEndereco(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Endereço não deve ser nulo"));
    }

    /**
     * Deve aceitar endereco nao nulo.
     */
    @Test
    public void deve_aceitar_endereco_nao_nulo() {
        assertNotNull(empresa.getEndereco());
    }

    /* -------------------------------------------------- <<< Endereco ----------------------------------------------------------- */

    /* -------------------------------------------------- Email >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar email nulo.
     */
    @Test
    public void nao_deve_aceitar_email_nulo() {
        empresa.setEmail(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email não deve ser nulo"));
    }

    /**
     * Nao deve aceitar email vazio.
     */
    @Test
    public void nao_deve_aceitar_email_vazio() {
        empresa.setEmail("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email não deve ser vazio"));
    }

    /**
     * Nao deve aceitar email invalido.
     */
    @Test
    public void nao_deve_aceitar_email_invalido() {
        empresa.setEmail("@teste");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email deve ser válido"));
    }

    /**
     * Deve aceitar email valido.
     */
    @Test
    public void deve_aceitar_email_valido() {
        assertNotNull(empresa.getEmail());
    }

    /* -------------------------------------------------- <<< Email ----------------------------------------------------------- */

    /* -------------------------------------------------- Telefone >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar telefone nulo.
     */
    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        empresa.setTelefone(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Telefone não deve ser nulo"));
    }

    /**
     * Deve aceitar telefone nao nulo.
     */
    @Test
    public void deve_aceitar_telefone_nao_nulo() {
        assertNotNull(empresa.getTelefone());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */

    /* -------------------------------------------------- DataInicio >>> ----------------------------------------------------------- */

    /**
     * Nao deve aceitar data de inicio nula.
     */
    @Test
    public void nao_deve_aceitar_data_de_inicio_nula() {
        empresa.setDataInicio(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Data de Início não deve ser nula"));
    }

    /**
     * Nao deve aceitar data de inicio menor que hoje.
     */
    @Test
    public void nao_deve_aceitar_data_de_inicio_menor_que_hoje() {
        DateTime data = new DateTime();
        empresa.setDataInicio(data.minusDays(1));
        assertFalse(ValidatorAnnotations.isValid(empresa, "Data de Início deve ser maior que hoje"));
    }

    /**
     * Deve aceitar data de inicio que hoje.
     */
    @Test
    public void deve_aceitar_data_de_inicio_que_hoje() {
        assertNotNull(empresa.getDataInicio());
    }

    /* -------------------------------------------------- <<< DataInicio ----------------------------------------------------------- */

    /* -------------------------------------------------- Ignore >>> ----------------------------------------------------------- */

    /**
     * Deve ignorar este teste.
     */
    @Test
    @Ignore
    public void deve_ignorar_este_Teste() {
        System.out.println("Ignore este teste");
    }

    /* -------------------------------------------------- <<< Ignore ----------------------------------------------------------- */

    /* -------------------------------------------------- Timeout >>> ----------------------------------------------------------- */

    /**
     * Deve ter timeout de 2 segundos.
     *
     * @throws Exception the exception
     */
    @Test
    public void deve_ter_timeout_de_2_segundos() throws Exception {
        empresa.setCNPJ("00000000000000");
        assertEquals("00000000000000", empresa.getCNPJ());
        TimeUnit.SECONDS.sleep(2);
    }

    /* -------------------------------------------------- <<< Timeout ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido to string para objetos iguais.
     */
    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Empresa empresa2 = empresa;
        assertEquals(empresa.toString(), empresa2.toString());
    }

    /**
     * Deve ser invalido to string para objetos diferentes.
     */
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Empresa empresa2 = new Empresa();
        assertNotEquals(empresa.toString(), empresa2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    /**
     * Deve ser valido hashcode de valores iguais.
     */
    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Empresa empresa2 = empresa;
        assertEquals(empresa.hashCode(), empresa2.hashCode());
    }

    /**
     * Nao deve ser valido hashcode de objetos deferentes.
     */
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes() {
        Empresa empresa2 = new Empresa();
        assertThat(empresa.hashCode(), is(not(empresa2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    /**
     * Deve o equals retornar false comparando empresa a outro objeto que não seja da clase empresa.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_empresa_a_outro_objeto_que_não_seja_da_clase_empresa() {
        Cidade cidade = new Cidade();
        assertFalse(empresa.equals(cidade));
    }

    /**
     * Deve o equals retornar true comparando ele mesmo.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(empresa.equals(empresa));
    }

    /**
     * Deve o equals retornar true comparando outro empresa igual.
     */
    @Test
    public void deve_o_equals_retornar_true_comparando_outro_empresa_igual() {
        Empresa empresa2 = empresa;
        assertTrue(empresa.equals(empresa2));
    }

    /**
     * Deve o equals retornar false comparando outro empresa diferente.
     */
    @Test
    public void deve_o_equals_retornar_false_comparando_outro_empresa_diferente() {
        Empresa empresa2 = new Empresa();
        assertFalse(empresa.equals(empresa2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
