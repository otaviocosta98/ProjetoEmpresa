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
                add("numero", random(range(1, 999) + ""));
                add("complemento", random(range(1, 55) + "b"));
                add("estado", one(Estado.class, "valid"));
                add("cep", regex("\\d{8}"));
                add("regiao", random(RegiaoType.values()));
            }

        });
    }

}
