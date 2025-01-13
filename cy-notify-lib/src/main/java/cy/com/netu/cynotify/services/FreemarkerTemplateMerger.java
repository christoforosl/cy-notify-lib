package cy.com.netu.cynotify.services;

import freemarker.template.Template;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freemarker.template.Configuration;

/**
 * marges a Freemarker template with a model
 * @author christoforosl
*/
@Service
public class FreemarkerTemplateMerger {

    private final Configuration freemarkerConfiguration;

    @Autowired
    public FreemarkerTemplateMerger(Configuration configuration) {
        this.freemarkerConfiguration = configuration;
    }

    public String merge(final String templateText, @SuppressWarnings("rawtypes") final Map model) throws Exception {

        try (Writer out = new StringWriter()) {

            final Template template = new Template("MessageText", new StringReader(templateText), freemarkerConfiguration);
            template.process(model, out);

            final String emailText = out.toString();
            return emailText;
        }

    }

}
