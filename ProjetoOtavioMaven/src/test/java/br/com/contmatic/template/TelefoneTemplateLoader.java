package br.com.contmatic.template;

import br.com.contmatic.empresa.Operadora;
import br.com.contmatic.empresa.Telefone;
import br.com.contmatic.empresa.TelefoneType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class TelefoneTemplateLoader.
 */
public class TelefoneTemplateLoader implements TemplateLoader {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.six2six.fixturefactory.loader.TemplateLoader#load()
     */
    public void load() {

        Fixture.of(Telefone.class).addTemplate("valid", new Rule() {
            {
                add("ddd", random(Integer.class, range(11, 99)));
                add("numero", random(Integer.class, range(11111111, 999999999)));
                add("ramal", random(Integer.class, range(100, 1000)));
                add("tipo", random(TelefoneType.values()));
                add("responsavel", random("Eu", "Tu", "Ele", "Nós", "Vós", "Eles"));
                add("operadora", one(Operadora.class, "valid"));
            }
        });
    }

}
