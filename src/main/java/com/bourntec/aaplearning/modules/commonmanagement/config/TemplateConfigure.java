package com.bourntec.aaplearning.modules.commonmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;

@Configuration
public class TemplateConfigure {
//	@Primary
//	@Bean 
//	public FreeMarkerConfigurationFactoryBean factoryBean() {
//		FreeMarkerConfigurationFactoryBean bean=new FreeMarkerConfigurationFactoryBean();
//		bean.setTemplateLoaderPath("classpath:/templates");
//		return bean;
//	}
	
	
	@Bean
    public FreeMarkerConfigurer freeMarkerConfigurer(){
        freemarker.template.Configuration configuration = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_19);
        TemplateLoader templateLoader = new ClassTemplateLoader(this.getClass(), "/templates/");
        configuration.setTemplateLoader(templateLoader);
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setConfiguration(configuration);
        return freeMarkerConfigurer;
    }
	
	
//	 @Bean
//	    public SpringTemplateEngine springTemplateEngine() {
//	        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
//	        springTemplateEngine.addTemplateResolver(emailTemplateResolver());
//	        return springTemplateEngine;
//	    }
//
//	    public ClassLoaderTemplateResolver emailTemplateResolver() {
//	        ClassLoaderTemplateResolver emailTemplateResolver = new ClassLoaderTemplateResolver();
//	        emailTemplateResolver.setPrefix("/templates/");
//	        emailTemplateResolver.setSuffix(".html");
//	        emailTemplateResolver.setTemplateMode(TemplateMode.HTML);
//	        emailTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
//	        emailTemplateResolver.setCacheable(false);
//	        return emailTemplateResolver;
//	    }

}

