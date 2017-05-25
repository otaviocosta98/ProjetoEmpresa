package br.com.contmatic.template;

import org.joda.time.DateTime;

import br.com.contmatic.empresa.Empresa;
import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Telefone;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EmpresaTemplateLoader implements TemplateLoader {

    public void load(){
        Fixture.of(Empresa.class).addTemplate("valid", new Rule(){
            {
                add("nome", random("Teste1", "Teste2", "Teste3", "Teste4", "Teste5"));
                add("razaoSocial", random("Empresa de Testes", "Empresa de fornecimento de testes", "Especialização em TDD"));
                add("IE", random(Long.class, range(111111111111L, 999999999999L)));
                add("CNPJ", cnpj());
                add("endereco", random(Endereco.class));
                add("telefone", random(Telefone.class));
                add("email", random("teste1@teste.com", "teste2@teste.com.br", "teste3@teste.org", "teste4@teste.net", "teste5@teste.com"));
                add("dataInicio", DateTime.now().plusDays((int)Math.ceil((Math.random()))));
            }
        });
    }
}
