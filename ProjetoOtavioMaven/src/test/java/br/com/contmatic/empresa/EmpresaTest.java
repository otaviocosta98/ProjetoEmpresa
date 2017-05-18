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
    public void nao_deve_aceitar_nome_empresa_nulo() {
        empresa.setNome(null);
        assertNull(empresa.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_empresa_vazio() {
        empresa.setNome("");
        assertNull(empresa.getNome());
    }

    @Test
    public void deve_aceitar_nome_empresa_alfanumerico() {
        empresa.setNome("Teste22");
        assertNotNull(empresa.getNome());
    }

    @Test
    public void deve_aceitar_nome_empresa_somente_com_letras() {
        empresa.setNome("Teste");
        assertNotNull(empresa.getNome());
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
    public void nao_deve_aceitar_data_de_inicio_menor_que_hoje() {
        DateTime data = new DateTime();
        System.out.println(data);
        empresa.setDataInicio(data.minusDays(1));
        assertNotEquals(data, empresa.getDataInicio());
    }

    @Test
    public void deve_aceitar_data_de_inicio_que_hoje() {
        DateTime data = new DateTime();
        System.out.println(data);
        empresa.setDataInicio(data.plusDays(1));
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
    public void deve_ser_valido_hashcode_de_valores_iguais() {
        Empresa empresa2 = new Empresa();
        empresa.setCNPJ("12345678901234");
        empresa.setRazaoSocial("Teste");
        empresa2.setCNPJ("12345678901234");
        empresa2.setRazaoSocial("Teste");
        assertEquals(empresa.hashCode(), empresa2.hashCode());
    }

    @Test
    public void deve_ser_valido_hashcode_de_objeto_nulo() {
        Empresa empresa2 = new Empresa();
        empresa.setCNPJ(null);
        empresa.setRazaoSocial(null);
        empresa2.setCNPJ("12345678901234");
        empresa2.setRazaoSocial("Teste");
        assertNotEquals(empresa.hashCode(), empresa2.hashCode());
    }

    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes() {
        Empresa empresa2 = new Empresa();
        empresa.setCNPJ("12345678901234");
        empresa.setRazaoSocial("Teste");
        empresa2.setCNPJ("43210987654321");
        empresa2.setRazaoSocial("Teste2");
        assertThat(empresa.hashCode(), is(not(empresa2.hashCode())));
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
    public void deve_o_equals_retornar_false_comparando_razaosocial_nula_com_razaosocial_nao_nula_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setRazaoSocial("Contmatic");
        empresa.setRazaoSocial(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_razoessociais_nulas() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_razaosocial_nao_nula_com_razaosocial_nula_de_outra_empresa() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setRazaoSocial(null);
        empresa.setRazaoSocial("Contmatic");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_ambas_razoessociais_nao_nulas() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setRazaoSocial("Contmatic");
        empresa.setRazaoSocial("Contmatic");
        assertTrue(empresa.equals(empresa2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
