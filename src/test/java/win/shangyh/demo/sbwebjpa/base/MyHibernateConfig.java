package win.shangyh.demo.sbwebjpa.base;

import java.util.Collections;
import java.util.Map;

import org.hibernate.jpa.boot.spi.IntegratorProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.stereotype.Component;

/**
 * MyHibernateConfig
 */
@Component("myHibernateConfig")
public class MyHibernateConfig  implements HibernatePropertiesCustomizer {

    @Autowired
    MetadataExtractorIntegrator integrator;

    @Override
    public void customize(Map<String, Object> hibernateProperties) {
        hibernateProperties.put("hibernate.integrator_provider",
                (IntegratorProvider) () -> Collections.singletonList(integrator));
    }
}