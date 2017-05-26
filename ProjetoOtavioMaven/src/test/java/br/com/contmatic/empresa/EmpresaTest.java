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

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

    Empresa empresa;

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
        empresa = Fixture.from(Empresa.class).gimme("valid");
        System.out.println(empresa.toString());
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */
    
    /* -------------------------------------------------- Codigo >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_codigo_nulo() {
        empresa.setCodigo(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Codigo não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_codigo_menor_que_0() {
        empresa.setCodigo(0);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Codigo deve ser maior que 0"));
    }

    @Test
    public void deve_aceitar_codigo_valido() {
        assertNotNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< Codigo ----------------------------------------------------------- */


    /* -------------------------------------------------- NomeEmpresa >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_empresa_nulo() {
        empresa.setNome(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Nome não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_nome_empresa_vazio() {
        empresa.setNome("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Nome não deve ser vazio"));
    }

    @Test
    public void deve_aceitar_nome_empresa_alfa_numerico() {
        assertNotNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- RazaoSocial >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social não deve ser nula"));
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social não deve ser vazia"));
    }
    
    @Test
    public void nao_deve_aceitar_razao_social_com_caracteres_especiais() {
        empresa.setRazaoSocial("Teste!");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Razão Social deve conter somente caracteres alfa-numericos"));
    }

    @Test
    public void deve_aceitar_razao_social_alfanumerico() {
        assertNotNull(empresa.getRazaoSocial());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- IE >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ir_nulo() {
        empresa.setIE(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social não deve ser nula"));
    }

    @Test
    public void nao_deve_aceitar_ie_menor_ou_igual_a_0() {
        empresa.setIE(0L);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social deve ser maior que zero"));
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_digitos() {
        empresa.setIE(12345678909L);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Inscrição Social deve ter 12 digitos"));
    }

    @Test
    public void deve_aceitar_ie_com_12_caracteres() {
        assertNotNull(empresa.getIE());
    }

    /* -------------------------------------------------- <<< IE ----------------------------------------------------------- */

    /* -------------------------------------------------- CNPJ >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCNPJ(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ não deve ser nulo"));
    }
    
    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCNPJ("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ não deve ser vazio"));
    }

    @Test
    public void nao_deve_aceitar_cnpj_alfa_numerico() {
        empresa.setCNPJ("0123456789012A");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ deve conter somente numeros"));
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_ou_maior_que_14() {
        empresa.setCNPJ("0123456789012");
        assertFalse(ValidatorAnnotations.isValid(empresa, "CNPJ deve contem 14 digitos"));
    }

    @Test
    public void deve_aceitar_cnpj_com_14_caracteres() {
        assertNotNull(empresa.getCNPJ());
    }

    /* -------------------------------------------------- <<< CNPJ ----------------------------------------------------------- */

    /* -------------------------------------------------- Endereco >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEndereco(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Endereço não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo() {
        assertNotNull(empresa.getEndereco());
    }

    /* -------------------------------------------------- <<< Endereco ----------------------------------------------------------- */

    /* -------------------------------------------------- Email >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_email_nulo() {
        empresa.setEmail(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email não deve ser nulo"));
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        empresa.setEmail("");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email não deve ser vazio"));
    }

    @Test
    public void nao_deve_aceitar_email_invalido() {
        empresa.setEmail("@teste");
        assertFalse(ValidatorAnnotations.isValid(empresa, "Email deve ser válido"));
    }

    @Test
    public void deve_aceitar_email_valido() {
        assertNotNull(empresa.getEmail());
    }

    /* -------------------------------------------------- <<< Email ----------------------------------------------------------- */

    /* -------------------------------------------------- Telefone >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        empresa.setTelefone(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Telefone não deve ser nulo"));
    }

    @Test
    public void deve_aceitar_telefone_nao_nulo() {
        assertNotNull(empresa.getTelefone());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */

    /* -------------------------------------------------- DataInicio >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_data_de_inicio_nula() {
        empresa.setDataInicio(null);
        assertFalse(ValidatorAnnotations.isValid(empresa, "Data de Início não deve ser nula"));
    }
    
    @Test
    public void nao_deve_aceitar_data_de_inicio_menor_que_hoje() {
        DateTime data = new DateTime();
        empresa.setDataInicio(data.minusDays(1));
        assertFalse(ValidatorAnnotations.isValid(empresa, "Data de Início deve ser maior que hoje"));
    }

    @Test
    public void deve_aceitar_data_de_inicio_que_hoje() {
        assertNotNull(empresa.getDataInicio());
    }

    /* -------------------------------------------------- <<< DataInicio ----------------------------------------------------------- */

    /* -------------------------------------------------- Ignore >>> ----------------------------------------------------------- */

    @Test
    @Ignore
    public void deve_ignorar_este_Teste() {
        System.out.println("Ignore este teste");
    }

    /* -------------------------------------------------- <<< Ignore ----------------------------------------------------------- */

    /* -------------------------------------------------- Timeout >>> ----------------------------------------------------------- */

    @Test
    public void deve_ter_timeout_de_2_segundos() throws Exception {
        empresa.setCNPJ("00000000000000");
        assertEquals("00000000000000", empresa.getCNPJ());
        TimeUnit.SECONDS.sleep(2);
    }

    /* -------------------------------------------------- <<< Timeout ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Empresa empresa2 = empresa;
        assertEquals(empresa.toString(), empresa2.toString());
    }
    
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Empresa empresa2 = new Empresa();
        assertNotEquals(empresa.toString(), empresa2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Empresa empresa2 = empresa;
        assertEquals(empresa.hashCode(), empresa2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Empresa empresa2 = new Empresa();
        assertThat(empresa.hashCode(), is(not(empresa2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_empresa_a_outro_objeto_que_não_seja_da_clase_empresa() {
        Cidade cidade = new Cidade();
        assertFalse(empresa.equals(cidade));
    }
    
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(empresa.equals(empresa));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outro_empresa_igual() {
        Empresa empresa2 = empresa;
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_empresa_diferente() {
        Empresa empresa2 = new Empresa();
        assertFalse(empresa.equals(empresa2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
