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
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;

public class EnderecoTest {

    Endereco endereco;

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
        endereco = Fixture.from(Endereco.class).gimme("valid");
        System.out.println(endereco.toString());;
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("!-Fim Teste-!");
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /* -------------------------------------------------- <<< SetUps e TearDowns ----------------------------------------------------------- */

    /* -------------------------------------------------- Testes >> ----------------------------------------------------------- */

    /* -------------------------------------------------- Logradouro >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_logradouro_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Logradouro não deve ser nulo");
        endereco.setLogradouro(null);
    }

    @Test
    public void nao_deve_aceitar_logradouro_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Logradouro não deve ser vazio");
        endereco.setLogradouro("");
    }

    @Test
    public void nao_deve_aceitar_logradouro_alfanumerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Logradouro deve conter somente palavras");
        endereco.setLogradouro("Rua 9");
    }

    @Test
    public void deve_aceitar_logradouro_somente_com_letras() {
        assertNotNull(endereco.getLogradouro());
    }

    /* -------------------------------------------------- <<< Logradouro ----------------------------------------------------------- */

    /* -------------------------------------------------- Complemento >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_complemento_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Complemento não deve ser nulo");
        endereco.setComplemento(null);
    }

    @Test
    public void nao_deve_aceitar_complemento_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Complemento não deve ser vazio");
        endereco.setComplemento("");
    }
    
    @Test
    public void nao_deve_aceitar_complemento_com_caracteres_especiais() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Complemento deve ser somente alfa-numerico");
        endereco.setComplemento("110!");
    }

    @Test
    public void deve_aceitar_complemento_alfanumerico() {
        assertNotNull(endereco.getComplemento());
    }

    /* -------------------------------------------------- <<< Complemento ----------------------------------------------------------- */

    /* -------------------------------------------------- Numero >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_numero_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Numero não deve ser nulo");
        endereco.setNumero(null);
    }

    @Test
    public void nao_deve_aceitar_numero_vazio() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Numero não deve ser vazio");
        endereco.setNumero("");
    }
    
    @Test
    public void nao_deve_aceitar_numero_com_caracteres_especiais() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Numero deve ser somente alfa-numerico");
        endereco.setNumero("5!b!");
    }

    @Test
    public void deve_aceitar_numero_alfanumerico() {
        assertNotNull(endereco.getNumero());
    }

    /* -------------------------------------------------- <<< Numero ----------------------------------------------------------- */

    /* -------------------------------------------------- Estado >>> ----------------------------------------------------------- */

    @Test
    public void deve_aceitar_estado_nao_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Estado não deve ser nulo");
        endereco.setEstado(null);
    }

    @Test
    public void nao_deve_aceitar_estado_nulo() {
        assertNotNull(endereco.getEstado());
    }

    /* -------------------------------------------------- <<< Estado ----------------------------------------------------------- */

    /* -------------------------------------------------- CEP >>> ----------------------------------------------------------- */

    @Test
    public void nao_deve_aceitar_cep_nulo() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("CEP não deve ser nulo");
        endereco.setCep(null);
    }

    @Test
    public void nao_deve_aceitar_cep_menor_ou_igual_a_zero() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CEP não deve ser vazio");
        endereco.setCep("");
    }
    
    @Test
    public void nao_deve_cep_alfa_numerico() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("CEP não deve ser alfa numerico");
        endereco.setCep("0359101o");
    }

    @Test
    public void deve_aceitar_cep_com_8_digitos() {
        assertNotNull(endereco.getCep());
    }

    /* -------------------------------------------------- <<< CEP ----------------------------------------------------------- */

    /* -------------------------------------------------- ToString >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_to_string_para_objetos_iguais() {
        Endereco endereco2 = endereco;
        assertEquals(endereco.toString(), endereco2.toString());
    }
    
    @Test
    public void deve_ser_invalido_to_string_para_objetos_diferentes() {
        Endereco endereco2 = new Endereco();
        assertNotEquals(endereco.toString(), endereco2.toString());
    }

    /* -------------------------------------------------- <<< ToString ----------------------------------------------------------- */

    /* -------------------------------------------------- HashCode >>> ----------------------------------------------------------- */

    @Test
    public void deve_ser_valido_hashcode_de_valores_iguais(){
        Endereco endereco2 = endereco;
        assertEquals(endereco.hashCode(), endereco2.hashCode());
    }
    
    @Test
    public void nao_deve_ser_valido_hashcode_de_objetos_deferentes(){
        Endereco endereco2 = new Endereco();
        endereco.setLogradouro("Rua Um");
        endereco2.setLogradouro("Rua Dois");
        endereco.setNumero("123");
        endereco2.setNumero("456");
        endereco.setCep("03591048");
        endereco2.setCep("03588790");
        assertThat(endereco.hashCode(), is(not(endereco2.hashCode())));
    }

    /* -------------------------------------------------- <<< HashCode ----------------------------------------------------------- */

    /* -------------------------------------------------- Equals >>> ----------------------------------------------------------- */

    @Test
    public void deve_o_equals_retornar_false_comparando_endereco_a_outro_objeto_que_não_seja_da_clase_endereco() {
        Cidade cidade = new Cidade();
        assertFalse(endereco.equals(cidade));
    }
    
    @Test
    public void deve_o_equals_retornar_true_comparando_ele_mesmo() {
        assertTrue(endereco.equals(endereco));
    }

    @Test
    public void deve_o_equals_retornar_true_comparando_outro_endereco_igual() {
        Endereco endereco2 = endereco;
        assertTrue(endereco.equals(endereco2));
    }

    @Test
    public void deve_o_equals_retornar_false_comparando_outro_endereco_diferente() {
        Endereco endereco2 = new Endereco();
        assertFalse(endereco.equals(endereco2));
    }

    /* -------------------------------------------------- <<< Equals ----------------------------------------------------------- */

    /* -------------------------------------------------- <<< Testes ----------------------------------------------------------- */

}
