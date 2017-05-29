package br.com.contmatic.template;

import br.com.contmatic.empresa.Bairro;
import br.com.contmatic.empresa.BairroType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class BairroTemplateLoader.
 */
public class BairroTemplateLoader implements TemplateLoader {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.six2six.fixturefactory.loader.TemplateLoader#load()
     */
    public void load() {

        Fixture.of(Bairro.class).addTemplate("valid", new Rule() {
            {
                add("codigo", random(Integer.class, range(1, 1000)));
                add("nome", random("Artur Alvim", "Tatuapé", "Penha", "Carrão", "Itaquera"));
                add("tipo", random(BairroType.values()));
                add("tamanho", random(Double.class, range(1000.00, 10000.00)));
                add("populacao", random(Long.class, range(1000, 10000)));
            }
        });
    }

}
