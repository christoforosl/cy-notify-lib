package cy.com.netu.cynotify.config;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.context.annotation.Bean;

/**
 * Configuration class for Freemarker.
 * This class sets up the Freemarker configuration for the application.
 */
@org.springframework.context.annotation.Configuration
public class FreemarkerConfiguration {

    @Bean
    public Configuration getConfiguration() {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        return cfg;
    }
}