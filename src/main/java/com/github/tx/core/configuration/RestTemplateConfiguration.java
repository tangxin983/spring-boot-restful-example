package com.github.tx.core.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * 配置RestTemplate
 * 
 * @author tangx
 * @since 2014年12月30日
 */
@Configuration
public class RestTemplateConfiguration {

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		List<HttpMessageConverter<?>> converters = restTemplate.getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
//			if (converter instanceof MappingJackson2HttpMessageConverter) {
//				MappingJackson2HttpMessageConverter mappingJackson2Converter = 
//						(MappingJackson2HttpMessageConverter) converter;
//				List<MediaType> oldMediaTypes = mappingJackson2Converter.getSupportedMediaTypes();
//				List<MediaType> mediaTypes = new ArrayList<MediaType>();
//				for(MediaType mediaType : oldMediaTypes){
//					mediaTypes.add(mediaType);
//				}
//				mediaTypes.add(MediaType.TEXT_HTML);
//				mappingJackson2Converter.setSupportedMediaTypes(mediaTypes);
//			}
//			if (converter instanceof StringHttpMessageConverter) {
//				StringHttpMessageConverter stringConverter = 
//						(StringHttpMessageConverter) converter;
//				List<MediaType> mediaTypes = new ArrayList<MediaType>();
//				mediaTypes.addAll(stringConverter.getSupportedMediaTypes());
//				mediaTypes.add(new MediaType("text", "html", Charset.forName("UTF-8")));
//				stringConverter.setSupportedMediaTypes(mediaTypes);
//			}
		}
		return restTemplate;
	}

}
