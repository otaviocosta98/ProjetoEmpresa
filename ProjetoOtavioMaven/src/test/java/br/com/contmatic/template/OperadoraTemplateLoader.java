package br.com.contmatic.template;

import br.com.contmatic.empresa.Operadora;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class OperadoraTemplateLoader.
 */
public class OperadoraTemplateLoader implements TemplateLoader {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.six2six.fixturefactory.loader.TemplateLoader#load()
     */
    public void load() {

        Fixture.of(Operadora.class).addTemplate("valid", new Rule() {
            {
                add("codigo", random(Integer.class, range(1, 4)));
                add("nome", random("Claro", "Tim", "Vivo", "Oi"));
            }
        });
    }

}
