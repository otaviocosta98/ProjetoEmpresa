package br.com.contmatic.empresa;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpresaTest {

    Empresa empresa;
    Endereco[] endereco;
    Telefone[] telefone;

    /* -------------------------------------------------- SetUps e TearDowns >>> ----------------------------------------------------------- */

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("-------------Começo Classe Teste------------->");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("<------------Fim Classe teste-----------------");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("!-Começo Teste-!");
        empresa = new Empresa();
        endereco = new Endereco[2];
        telefone = new Telefone[2];

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    @Rule
    public Timeout globalTimeout = Timeout.seconds(5);

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >>> ----------------------------------------------------------- */

    /* -------------------------------------------------- NomeEmpresa >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_nome_empresaresa_nulo() {
        empresa.setNome(null);
        assertNull(empresa.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_empresaresa_vazio() {
        empresa.setNome("");
        assertNull(empresa.getNome());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- RazaoSocial >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        assertNull(empresa.getRazaoSocial());
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        empresa.setRazaoSocial("");
        assertNull(empresa.getRazaoSocial());
    }

    @Test
    public void nao_deve_conter_caractere_especial_na_razao_social() {
        empresa.setRazaoSocial("abc@");
        assertNotEquals("abc@", empresa.getRazaoSocial());
    }

    @Test
    public void deve_aceitar_razao_social_alfanumerico() {
        empresa.setRazaoSocial("abc1236");
        assertEquals("abc1236", empresa.getRazaoSocial());
    }

    /* -------------------------------------------------- <<< NomeEmpresa ----------------------------------------------------------- */

    /* -------------------------------------------------- IE >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_ir_nulo() {
        empresa.setIE(null);
        assertNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_vazio() {
        empresa.setIE("");
        assertThat(empresa.getIE(), is(not("")));
    }

    @Test
    public void deve_aceitar_ie_com_12_caracteres() {
        empresa.setIE("912345678984");
        assertNotNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_maior_que_12_caracteres() {
        empresa.setIE("0123456789842");
        assertNotEquals("0123456789842", empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_caracteres() {
        empresa.setIE("01234567898");
        assertNull(empresa.getIE());
    }

    @Test
    public void deve_conter_somente_numeros_no_ie() {
        empresa.setIE("012345678984");
        assertEquals("012345678984", empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_alfanumerico() {
        empresa.setIE("01234567898b");
        assertNull(empresa.getIE());
    }

    /* -------------------------------------------------- <<< IE ----------------------------------------------------------- */

    /* -------------------------------------------------- CNPJ >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        empresa.setCNPJ(null);
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        empresa.setCNPJ("");
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void deve_aceitar_cnpj_com_14_caracteres() {
        empresa.setCNPJ("91234567898426");
        assertEquals("91234567898426", empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_maior_que_14_caracteres() {
        empresa.setCNPJ("012345678984265");
        assertNotEquals("012345678984265", empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_que_14_caracteres() {
        empresa.setCNPJ("0123456789842");
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void deve_conter_somente_numeros_no_cnpj() {
        empresa.setCNPJ("01234567898420");
        assertThat("01234567898420", is(empresa.getCNPJ()));
    }

    @Test
    public void nao_deve_aceitar_cnpj_alfanumerico() {
        empresa.setCNPJ("0123456789842a");
        assertNull(empresa.getCNPJ());
    }

    /* -------------------------------------------------- <<< CNPJ ----------------------------------------------------------- */

    /* -------------------------------------------------- Endereco >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEndereco(null);
        assertNull(empresa.getEndereco());
    }

    @Test
    public void deve_aceitar_endereco_nao_nulo() {
        empresa.setEndereco(endereco);
        assertSame(endereco, empresa.getEndereco());
    }

    @Test(expected = NullPointerException.class)
    public void deve_ocorrer_uma_exception() {
        empresa.setEndereco(null);
        endereco = empresa.getEndereco();
        endereco[0].toString();
    }

    /* -------------------------------------------------- <<< Endereco ----------------------------------------------------------- */

    /* -------------------------------------------------- Email >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_email_nulo() {
        empresa.setEmail(null);
        assertEquals(null, empresa.getEmail());
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        empresa.setEmail("");
        assertNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_algo_antes_do_arroba_no_email() {
        empresa.setEmail("@teste.com");
        assertThat("@teste.com", is(not(empresa.getEmail())));
    }

    @Test
    public void deve_conter_algo_depois_do_arroba_no_email() {
        empresa.setEmail("a@");
        assertNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_pelo_menos_1_ponto_apos_arroba_no_email() {
        empresa.setEmail("teste@teste.com");
        assertEquals("teste@teste.com", empresa.getEmail());
    }

    @Test
    public void nao_deve_faltar_ponto_apos_arroba_no_email() {
        empresa.setEmail("teste@testecom");
        assertNotEquals("teste@testecom", empresa.getEmail());
    }

    @Test
    public void deve_conter_somente_1_arroba_no_email() {
        empresa.setEmail("teste@teste.com");
        assertNotNull(empresa.getEmail());
    }

    @Test
    public void nao_deve_conter_mais_de_1_arroba_no_email() {
        empresa.setEmail("teste@@teste.com");
        assertNull(empresa.getEmail());
    }

    /* -------------------------------------------------- <<< Email ----------------------------------------------------------- */

    /* -------------------------------------------------- Telefone >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        empresa.setTelefone(null);
        assertNotSame(telefone, empresa.getTelefone());
    }

    @Test
    public void deve_aceitar_telefone_nao_nulo() {
        empresa.setTelefone(telefone);
        assertNotNull(empresa.getTelefone());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */
    
    /* -------------------------------------------------- DataInicio >>> ----------------------------------------------------------- */
    
    @Test
    public void nao_deve_aceitar_data_de_inicio_menor_que_10_05_2017() {
        Date data = new Date(149442000000L);
        System.out.println(data);
        empresa.setDataInicio(data);
        assertNotEquals(data, empresa.getDataInicio());
    }
    
    @Test
    public void deve_aceitar_data_de_inicio_maior_ou_igual_a_10_05_2017() {
        Date data = new Date(System.currentTimeMillis());
        System.out.println(data);
        empresa.setDataInicio(data);
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
    public void deve_ser_valido_to_string() {
        Empresa empresa2 = new Empresa();
        assertThat(empresa.toString(), is(empresa2.toString()));
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_hash_code_ser_igual_a_1742810335_para_cnpj_nulo() {
        empresa.setCNPJ(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_12345678910110_para_cnpj_nao_nulo() {
        empresa.setCNPJ("12345678910110");
        System.out.println(empresa.hashCode());
        assertEquals(32880731, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1742810335_para_ie_nulo() {
        empresa.setIE(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_80804949_para_ie_nao_nulo() {
        empresa.setIE("012345678905");
        System.out.println(empresa.hashCode());
        assertEquals(80804949, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1742810335_para_email_nulo() {
        empresa.setEmail(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_1771062888_para_email_nao_nulo() {
        empresa.setEmail("teste@teste.com");
        System.out.println(empresa.hashCode());
        assertEquals(-1771062888, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1742810335_para_nome_nulo() {
        empresa.setNome(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1160064327_para_nome_nao_nulo() {
        empresa.setNome("Contmatic");
        System.out.println(empresa.hashCode());
        assertEquals(1160064327, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_1742810335_para_razao_social_nulo() {
        empresa.setRazaoSocial(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void deve_o_hash_code_ser_igual_a_menos_77103241_para_razao_social_nao_nulo() {
        empresa.setRazaoSocial("Contmatic");
        System.out.println(empresa.hashCode());
        assertEquals(-77103241, empresa.hashCode());
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(empresa.equals(empresa));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outra_empresa_nula() {
        Empresa empresa2 = new Empresa();
        empresa2 = null;
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_getClass_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        assertFalse(empresa.equals(empresa2.getClass()));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_cnpj_nulo_com_cnpj_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ("01234567895103");
        empresa.setCNPJ(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_cnpj_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_cnpj_nao_nulo_com_cnpj_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ("01234567895103");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_cnpj_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ("01234567895103");
        empresa.setCNPJ("01234567895103");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ie_nulo_com_ie_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE("012345678951");
        empresa.setIE(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ie_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_ie_nao_nulo_com_ie_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE("012345678951");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_ie_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE("012345678951");
        empresa.setIE("012345678951");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_email_nulo_com_email_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail("teste@teste.com");
        empresa.setEmail(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_emails_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_email_nao_nulo_com_email_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail("teste@teste.com");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_emails_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail("teste@teste.com");
        empresa.setEmail("teste@teste.com");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_endereco_nulo_com_endereco_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(endereco);
        empresa.setEndereco(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_enderecos_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_endereco_nao_nulo_com_endereco_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(endereco);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_enderecos_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(endereco);
        empresa.setEndereco(endereco);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nulo_com_nome_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome("Contmatic");
        empresa.setNome(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_nome_nao_nulo_com_nome_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome("Contmatic");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_nomes_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome("Contmatic");
        empresa.setNome("Contmatic");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_razaosocial_nula_com_razaosocial_nao_nula_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial("Contmatic");
        empresa.setRazaoSocial(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_razoessociais_nulas() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_razaosocial_nao_nula_com_razaosocial_nula_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial("Contmatic");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_razoessociais_nao_nulas() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial("Contmatic");
        empresa.setRazaoSocial("Contmatic");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_telefone_nule_com_telefone_nao_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        empresa2.setTelefone(telefone);
        empresa.setTelefone(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_telefones_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        empresa2.setTelefone(null);
        empresa.setTelefone(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_telefone_nao_nulo_com_telefone_nulo_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        empresa2.setTelefone(null);
        empresa.setTelefone(telefone);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambos_telefones_nao_nulos() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        empresa2.setEmail(null);
        empresa.setEmail(null);
        empresa2.setEndereco(null);
        empresa.setEndereco(null);
        empresa2.setNome(null);
        empresa.setNome(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        empresa2.setTelefone(telefone);
        empresa.setTelefone(telefone);
        assertTrue(empresa.equals(empresa2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
