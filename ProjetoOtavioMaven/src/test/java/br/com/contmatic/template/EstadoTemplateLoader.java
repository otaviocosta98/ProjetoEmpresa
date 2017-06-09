package br.com.contmatic.template;

import br.com.contmatic.empresa.Cidade;
import br.com.contmatic.empresa.Estado;
import br.com.contmatic.empresa.UfType;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

/**
 * The Class EstadoTemplateLoader.
 */
public class EstadoTemplateLoader implements TemplateLoader {

    /*
     * (non-Javadoc)
     * 
     * @see br.com.six2six.fixturefactory.loader.TemplateLoader#load()
     */
    public void load() {

        Fixture.of(Estado.class).addTemplate("valid", new Rule() {
            {
                add("codigo", random(Integer.class, range(1, 1000)));
                add("nome", random("São Paulo", "Rio de Janeiro", "Santa Catarina", "Paraíba", "Rio grando do Sul"));
                add("uf", random((Object[]) UfType.values()));
                add("tamanho", random(Double.class, range(1.0, 10000.0)));
                add("populacao", random(Long.class, range(1, 10000)));
                add("cidade", has(3).of(Cidade.class, "valid"));
            }
        });
    }
}
