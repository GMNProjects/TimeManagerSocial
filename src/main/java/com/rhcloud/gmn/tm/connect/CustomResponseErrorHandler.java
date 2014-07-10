package com.rhcloud.gmn.tm.connect;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rhcloud.gmn.tm.api.entity.RESTError;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.social.support.ClientHttpRequestFactorySelector;
import org.springframework.social.support.FormMapHttpMessageConverter;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by niaz on 20.06.14.
 */
public class CustomResponseErrorHandler implements ResponseErrorHandler {


    private ResponseErrorHandler errorHandler = new DefaultResponseErrorHandler();

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return errorHandler.hasError(clientHttpResponse);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        if (clientHttpResponse.getStatusText().equals("Unauthorized")) {
            throw new RestClientException(getErrorMsg(clientHttpResponse));
        }
        RESTError restError = objectMapper.readValue(clientHttpResponse.getBody(), RESTError.class);
        try {
            errorHandler.handleError(clientHttpResponse);
        } catch (RestClientException scx) {
            throw new RestClientException(restError.getError_description());
        }
    }

    /**
     *
     * @return
     */
    private RestTemplate createRestTemplate() {
        ClientHttpRequestFactory requestFactory = ClientHttpRequestFactorySelector.getRequestFactory();
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(2);
        converters.add(new FormHttpMessageConverter());
        converters.add(new FormMapHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        restTemplate.setMessageConverters(converters);
        return restTemplate;
    }

    private String getErrorMsg (ClientHttpResponse clientHttpResponse) {
        return clientHttpResponse.getHeaders().getFirst("WWW-Authenticate").split(", ")[2].split("=")[1].split("\"")[1];
    }

}