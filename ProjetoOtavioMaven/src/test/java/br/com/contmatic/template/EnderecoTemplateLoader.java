package br.com.contmatic.template;

import br.com.contmatic.empresa.Endereco;
import br.com.contmatic.empresa.Estado;
import br.com.contmatic.empresa.RegiaoType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class EnderecoTemplateLoader implements TemplateLoader {

    public void load() {

        Fixture.of(Endereco.class).addTemplate("valid", new Rule() {
            {
                add("logradouro", random("Rua Teste", "Avenida Teste", "Viaduto Teste", "Rodovia Teste"));
                add("numero", random(Integer.class, range(1, 999)));
                add("complemento", random("11a","12b","13c","14d","21e"));
                add("estado", one(Estado.class, "valid"));
                add("cep", regex("(\\d{5}-\\d{3})"));
                add("regiao", random(RegiaoType.values()));
            }

        });
    }

}
