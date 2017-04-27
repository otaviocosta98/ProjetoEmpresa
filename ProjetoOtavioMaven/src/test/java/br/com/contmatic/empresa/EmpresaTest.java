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

    Empresa empresa;

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
        
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }

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
    public void nao_deve_aceitar_ie_nulo() {
        empresa.setIE(null);
        assertNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_vazio() {
        empresa.setIE("");
        assertNull(empresa.getIE());
    }

    @Test
    public void deve_aceitar_um_ie_com_12_caracteres() {
        empresa.setIE("123456789951");
        assertNotNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_um_ie_maior_que_12_caracteres() {
        empresa.setIE("1234567899510");
        assertNull(empresa.getIE());
    }

    @Test
    public void nao_deve_aceitar_ie_menor_que_12_caracteres() {
        empresa.setIE("123456789");
        assertNull(empresa.getIE());
    }

    @Test
    public void deve_conter_somente_numeros_no_ie() {
        empresa.setIE("1234567899510a");
        assertNull(empresa.getIE());
    }

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
        empresa.setCNPJ("0123456789842a");
        assertNull(empresa.getCNPJ());
    }

    @Test
    public void nao_deve_aceitar_endereco_nulo() {
        empresa.setEndereco(null);
        assertNull(empresa.getEndereco());
    }

//    @Test
//    public void nao_deve_aceitar_endereco_vazio() {
//        empresa.setEndereco("");
//        assertNull(empresa.getEndereco());
//    }

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

    @Test
    public void nao_deve_aceitar_telefone_nulo() {
        empresa.setTelefone(null);
        assertNull(empresa.getTelefone());
    }

//    @Test
//    public void nao_deve_aceitar_telefone_vazio() {
//        empresa.setTelefone("");
//        assertNull(empresa.getTelefone());
//    }
//
//    @Test
//    public void deve_conter_8_digitos_no_telefone() {
//        empresa.setTelefone("12345678");
//        assertNotNull(empresa.getTelefone());
//    }
//
//    @Test
//    public void nao_deve_aceitar_telefone_maior_que_8_digitos() {
//        empresa.setTelefone("123456789");
//        assertNull(empresa.getTelefone());
//    }
//
//    @Test
//    public void nao_deve_aceitar_telefone_menor_que_8_digitos() {
//        empresa.setTelefone("1234567");
//        assertNull(empresa.getTelefone());
//    }
//
//    @Test
//    public void deve_conter_somente_numeros_no_telefone() {
//        empresa.setTelefone("1234567a");
//        assertNull(empresa.getTelefone());
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
