package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
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
    Endereco endereco;
    Telefone telefone;
    Set<Endereco> enderecoSet;
    Set<Telefone> telefoneSet;

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
        endereco = Fixture.from(Endereco.class).gimme("valid");
        telefone = Fixture.from(Telefone.class).gimme("valid");
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

    /* -------------------------------------------------- NomeEmpresa >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_empresa_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Nome não deve ser nulo");
        empresa.setNome(null);
    }

    @Test
    public void nao_deve_aceitar_nome_empresa_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Nome não deve ser vazio");
        empresa.setNome("");
    }

    @Test
    public void deve_aceitar_nome_empresa_alfa_numerico() {
        assertNotNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- RazaoSocial >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Razão Social não deve ser nula");
        empresa.setRazaoSocial(null);
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Razão Social não deve ser vazia");
        empresa.setRazaoSocial("");
    }

    @Test
    public void deve_aceitar_razao_social_alfanumerico() {
        assertNotNull(empresa.getRazaoSocial());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- IE >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ir_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Inscrição Social não deve ser nula");
        empresa.setIE(null);
    }

    @Test
    public void nao_deve_aceitar_ie_menor_ou_igual_a_0() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Inscrição Social deve ser maior que zero");
        empresa.setIE(0L);
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_digitos() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Inscrição Social deve ter 12 digitos");
        empresa.setIE(12345678909L);
    }

    @Test
    public void deve_aceitar_ie_com_12_caracteres() {
        assertNotNull(empresa.getIE());
    }

    /* -------------------------------------------------- <<< IE ----------------------------------------------------------- */

    /* -------------------------------------------------- CNPJ >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("CNPJ não deve ser nulo");
        empresa.setCNPJ(null);
    }

    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CNPJ não deve ser vazia");
        empresa.setCNPJ("");
    }

    @Test
    public void nao_deve_aceitar_cnpj_alfa_numerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CNPJ deve conter somente numeros");
        empresa.setCNPJ("0123456789012A");
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_ou_igual_a_0() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CNPJ deve contem 14 digitos");
        empresa.setCNPJ("0123456789012");
    }

    @Test
    public void deve_aceitar_cnpj_com_14_caracteres() {
        assertNotNull(empresa.getCNPJ());
    }

    /* -------------------------------------------------- <<< CNPJ ----------------------------------------------------------- */

    /* -------------------------------------------------- Endereco >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Endereço não deve ser nulo");
        empresa.setEndereco(null);
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo() {
        enderecoSet = new HashSet<>();
        enderecoSet.add(endereco);
        empresa.setEndereco(enderecoSet);
        assertNotNull(empresa.getEndereco());
    }

    /* -------------------------------------------------- <<< Endereco ----------------------------------------------------------- */

    /* -------------------------------------------------- Email >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_email_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Email não deve ser nulo");
        empresa.setEmail(null);
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email não deve ser vazio");
        empresa.setEmail("");
    }

    @Test
    public void deve_conter_algo_antes_do_arroba_no_email() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email deve ser válido");
        empresa.setEmail("@teste");
    }

    @Test
    public void deve_conter_algo_depois_do_arroba_no_email() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email deve ser válido");
        empresa.setEmail("teste@");
    }

    @Test
    public void nao_deve_faltar_ponto_apos_arroba_no_email() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email deve ser válido");
        empresa.setEmail("teste@teste.com");
    }

    @Test
    public void nao_deve_conter_mais_de_1_arroba_no_email() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Email deve ser válido");
        empresa.setEmail("teste@@teste.com");
    }

    @Test
    public void deve_conter_somente_1_arroba_no_email() {
        assertNotNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_pelo_menos_1_ponto_apos_arroba_no_email() {
        assertNotNull(empresa.getEmail());
    }

    /* -------------------------------------------------- <<< Email ----------------------------------------------------------- */

    /* -------------------------------------------------- Telefone >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Telefone não deve ser nulo");
        empresa.setTelefone(null);
    }

    @Test
    public void deve_aceitar_telefone_nao_nulo() {
        telefoneSet = new HashSet<>();
        telefoneSet.add(telefone);
        empresa.setTelefone(telefoneSet);
        assertNotNull(empresa.getTelefone());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */

    /* -------------------------------------------------- DataInicio >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_data_de_inicio_menor_que_hoje() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Data de Início deve ser maior que hoje");
        DateTime data = new DateTime();
        empresa.setDataInicio(data.minusDays(1));
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
        empresa.setRazaoSocial("Teste");
        empresa2.setRazaoSocial("Teste2");
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
