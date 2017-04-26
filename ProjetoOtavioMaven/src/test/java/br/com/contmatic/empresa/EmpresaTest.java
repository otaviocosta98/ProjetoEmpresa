package br.com.contmatic.empresa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.contmatic.empresa.Empresa;

@FixMethodOrder(MethodSorters.DEFAULT)
public class EmpresaTest {

    Empresa emp;

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
        emp = new Empresa();
        
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

    @Test
    public void nao_deve_aceitar_nome_empresa_nulo() {
        emp.setNome(null);
        assertNull(emp.getNome());
    }

    @Test
    public void nao_deve_aceitar_nome_empresa_vazio() {
        emp.setNome("");
        assertNull(emp.getNome());
    }

    @Test
    public void nao_deve_aceitar_razao_social_nulo() {
        emp.setRazaoSocial(null);
        assertNull(emp.getRazaoSocial());
    }

    @Test
    public void nao_deve_aceitar_razao_social_vazio() {
        emp.setRazaoSocial("");
        assertNull(emp.getRazaoSocial());
    }
    
    @Test
    public void nao_deve_conter_caractere_especial_na_razao_social() {
        emp.setRazaoSocial("abc@");
        assertNull(emp.getRazaoSocial());
    }

    @Test
    public void nao_deve_aceitar_ie_nulo() {
        emp.setIE(null);
        assertNull(emp.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_vazio() {
        emp.setIE("");
        assertNull(emp.getIE());
    }

    @Test
    public void deve_aceitar_um_ie_com_12_caracteres() {
        emp.setIE("123456789951");
        assertNotNull(emp.getIE());
    }

    @Test
    public void nao_deve_aceitar_um_ie_maior_que_12_caracteres() {
        emp.setIE("1234567899510");
        assertNull(emp.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_caracteres() {
        emp.setIE("123456789");
        assertNull(emp.getIE());
    }

    @Test
    public void deve_conter_somente_numeros_no_ie() {
        emp.setIE("1234567899510a");
        assertNull(emp.getIE());
    }

    @Test
    public void nao_deve_aceitar_cnpj_nulo() {
        emp.setCNPJ(null);
        assertNull(emp.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_vazio() {
        emp.setCNPJ("");
        assertNull(emp.getCNPJ());
    }

    @Test
    public void deve_aceitar_cnpj_com_14_caracteres() {
        emp.setCNPJ("91234567898426");
        assertNotNull(emp.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_maior_que_14_caracteres() {
        emp.setCNPJ("012345678984265");
        assertNull(emp.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_cnpj_menor_que_14_caracteres() {
        emp.setCNPJ("0123456789842");
        assertNull(emp.getCNPJ());
    }

    @Test
    public void deve_conter_somente_numeros_no_cnpj() {
        emp.setCNPJ("0123456789842a");
        assertNull(emp.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        emp.setEndereco(null);
        assertNull(emp.getEndereco());
    }

//    @Test
//    public void nao_deve_aceitar_endereco_vazio() {
//        emp.setEndereco("");
//        assertNull(emp.getEndereco());
//    }

    @Test
    public void nao_deve_aceitar_email_nulo() {
        emp.setEmail(null);
        assertNull(emp.getEmail());
    }

    @Test
    public void nao_deve_aceitar_email_vazio() {
        emp.setEmail("");
        assertNull(emp.getEmail());
    }
    
    @Test
    public void deve_conter_algo_antes_do_arroba_no_email() {
        emp.setEmail("@teste.com");
        assertNull(emp.getEmail());
    }
    
    @Test
    public void deve_conter_algo_depois_do_arroba_no_email() {
        emp.setEmail("a@");
        assertNull(emp.getEmail());
    }

    @Test
    public void deve_conter_pelo_menos_1_ponto_apos_arroba_no_email() {
        emp.setEmail("teste@teste.com");
        assertNotNull(emp.getEmail());
    }

    @Test
    public void nao_deve_faltar_ponto_apos_arroba_no_email() {
        emp.setEmail("teste@testecom");
        assertNull(emp.getEmail());
    }

    @Test
    public void deve_conter_somente_1_arroba_no_email() {
        emp.setEmail("teste@teste.com");
        assertNotNull(emp.getEmail());
    }

    @Test
    public void nao_deve_conter_mais_de_1_arroba_no_email() {
        emp.setEmail("teste@@teste.com");
        assertNull(emp.getEmail());
    }

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        emp.setTelefone(null);
        assertNull(emp.getTelefone());
    }

//    @Test
//    public void nao_deve_aceitar_telefone_vazio() {
//        emp.setTelefone("");
//        assertNull(emp.getTelefone());
//    }
//
//    @Test
//    public void deve_conter_8_digitos_no_telefone() {
//        emp.setTelefone("12345678");
//        assertNotNull(emp.getTelefone());
//    }
//
//    @Test
//    public void nao_deve_aceitar_telefone_maior_que_8_digitos() {
//        emp.setTelefone("123456789");
//        assertNull(emp.getTelefone());
//    }
//
//    @Test
//    public void nao_deve_aceitar_telefone_menor_que_8_digitos() {
//        emp.setTelefone("1234567");
//        assertNull(emp.getTelefone());
//    }
//
//    @Test
//    public void deve_conter_somente_numeros_no_telefone() {
//        emp.setTelefone("1234567a");
//        assertNull(emp.getTelefone());
//    }

    @Test
    @Ignore
    public void Ignore_Teste() {
        System.out.println("Ignore");
    }

    @Test(timeout = 2000)
    public void Timeout_Teste() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Timeout");
    }

}
