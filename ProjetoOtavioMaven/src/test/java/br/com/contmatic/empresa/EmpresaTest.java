package br.com.contmatic.empresa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
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
        assertNull(empresa.getRazaoSocial());
    }

    @Test
    public void deve_aceitar_razao_social_alfanumerico() {
        empresa.setRazaoSocial("abc1236");
        assertNotNull(empresa.getRazaoSocial());
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
        assertNull(empresa.getIE());
    }

    @Test
    public void deve_aceitar_ie_com_12_caracteres() {
        empresa.setIE("912345678984");
        assertNotNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_maior_que_12_caracteres() {
        empresa.setIE("0123456789842");
        assertNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_caracteres() {
        empresa.setIE("01234567898");
        assertNull(empresa.getIE());
    }

    @Test
    public void deve_conter_somente_numeros_no_ie() {
        empresa.setIE("012345678984");
        assertNotNull(empresa.getIE());
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
        assertNotNull(empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_maior_que_14_caracteres() {
        empresa.setCNPJ("012345678984265");
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_que_14_caracteres() {
        empresa.setCNPJ("0123456789842");
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void deve_conter_somente_numeros_no_cnpj() {
        empresa.setCNPJ("01234567898420");
        assertNotNull(empresa.getCNPJ());
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
        assertNotNull(empresa.getEndereco());
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
        assertNull(empresa.getEmail());
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        empresa.setEmail("");
        assertNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_algo_antes_do_arroba_no_email() {
        empresa.setEmail("@teste.com");
        assertNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_algo_depois_do_arroba_no_email() {
        empresa.setEmail("a@");
        assertNull(empresa.getEmail());
    }

    @Test
    public void deve_conter_pelo_menos_1_ponto_apos_arroba_no_email() {
        empresa.setEmail("teste@teste.com");
        assertNotNull(empresa.getEmail());
    }

    @Test
    public void nao_deve_faltar_ponto_apos_arroba_no_email() {
        empresa.setEmail("teste@testecom");
        assertNull(empresa.getEmail());
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
        assertNull(empresa.getTelefone());
    }

    @Test
    public void deve_aceitar_telefone_nao_nulo() {
        empresa.setTelefone(telefone);
        assertNotNull(empresa.getTelefone());
    }

    /* -------------------------------------------------- <<< Telefone ----------------------------------------------------------- */

    /* -------------------------------------------------- Ignore >>> ----------------------------------------------------------- */

    @Test
    @Ignore
    public void deve_ignorar_este_Teste() {
        System.out.println("Ignore");
    }

    /* -------------------------------------------------- <<< Ignore ----------------------------------------------------------- */

    /* -------------------------------------------------- Timeout >>> ----------------------------------------------------------- */

    @Test(timeout = 2000)
    public void deve_ter_timeout_de_2_segundos() throws Exception {
        Thread.sleep(2000);
        System.out.println("Timeout");
    }

    /* -------------------------------------------------- <<< Timeout ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string() {
        Empresa empresa2 = new Empresa();
        assertEquals(empresa.toString(), empresa2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void hash_code1() {
        empresa.setCNPJ(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void hash_code2() {
        empresa.setCNPJ("12345678910110");
        System.out.println(empresa.hashCode());
        assertEquals(32880731, empresa.hashCode());
    }

    @Test
    public void hash_code3() {
        empresa.setIE(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void hash_code4() {
        empresa.setIE("012345678905");
        System.out.println(empresa.hashCode());
        assertEquals(80804949, empresa.hashCode());
    }

    @Test
    public void hash_code5() {
        empresa.setEmail(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void hash_code6() {
        empresa.setEmail("teste@teste.com");
        System.out.println(empresa.hashCode());
        assertEquals(-1771062888, empresa.hashCode());
    }

    @Test
    public void hash_code7() {
        empresa.setNome(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void hash_code8() {
        empresa.setNome("Contmatic");
        System.out.println(empresa.hashCode());
        assertEquals(1160064327, empresa.hashCode());
    }

    @Test
    public void hash_code9() {
        empresa.setRazaoSocial(null);
        System.out.println(empresa.hashCode());
        assertEquals(1742810335, empresa.hashCode());
    }

    @Test
    public void hash_code10() {
        empresa.setRazaoSocial("Contmatic");
        System.out.println(empresa.hashCode());
        assertEquals(-77103241, empresa.hashCode());
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_equals() {
        assertTrue(empresa.equals(empresa));
    }

    @Test
    public void deve_ser_valido_equals1() {
        Empresa empresa2 = new Empresa();
        empresa2 = null;
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals2() {
        Empresa empresa2 = new Empresa();
        assertFalse(empresa.equals(empresa2.getClass()));
    }

    @Test
    public void deve_ser_valido_equals3() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ("01234567895103");
        empresa.setCNPJ(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals4() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals5() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ("01234567895103");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals6() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ("01234567895103");
        empresa.setCNPJ("01234567895103");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals7() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE("012345678951");
        empresa.setIE(null);
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals8() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE(null);
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals9() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE(null);
        empresa.setIE("012345678951");
        assertFalse(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals10() {
        Empresa empresa2 = new Empresa();
        empresa2.setCNPJ(null);
        empresa.setCNPJ(null);
        empresa2.setIE("012345678951");
        empresa.setIE("012345678951");
        assertTrue(empresa.equals(empresa2));
    }

    @Test
    public void deve_ser_valido_equals11() {
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
    public void deve_ser_valido_equals12() {
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
    public void deve_ser_valido_equals13() {
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
    public void deve_ser_valido_equals14() {
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
    public void deve_ser_valido_equals15() {
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
    public void deve_ser_valido_equals16() {
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
    public void deve_ser_valido_equals17() {
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
    public void deve_ser_valido_equals18() {
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
    public void deve_ser_valido_equals19() {
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
    public void deve_ser_valido_equals20() {
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
    public void deve_ser_valido_equals21() {
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
    public void deve_ser_valido_equals22() {
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
    public void deve_ser_valido_equals23() {
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
    public void deve_ser_valido_equals24() {
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
    public void deve_ser_valido_equals25() {
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
    public void deve_ser_valido_equals26() {
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
    public void deve_ser_valido_equals27() {
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
    public void deve_ser_valido_equals28() {
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
    public void deve_ser_valido_equals29() {
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
    public void deve_ser_valido_equals30() {
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
