package com.sanesong.security.api.service;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanesong.security.api.service.http.HttpClient;

@Component
public class HttpService extends BaseService {

	protected CloseableHttpClient httpClient;
	protected ObjectMapper objectMapper;

	@Override
	@PostConstruct
	public void initialize() {
		httpClient = HttpClient.buildSSLClient(true);
		objectMapper = new ObjectMapper();
	}

	@Override
	@PreDestroy
	public void dispose() {
		try {
			httpClient.close();
		} catch (IOException e) {
			log.error("{}", e);
		}
	}
	
	public String get(final String uri) {
		String result = null;

		try {
			final CloseableHttpResponse httpResponse = HttpClient.get(httpClient, uri);
			result = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}

		return result;
	}
	
	public <T> T getJson(final String uri, final Class<T> clazz) {
		T result = null;

		try {
			final CloseableHttpResponse httpResponse = HttpClient.get(httpClient, uri);
			final String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			if(!ObjectUtils.isEmpty(content)) {
				result = objectMapper.readValue(content, clazz);
			}
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}

		return result;
	}

	public <T> T getJson(final String uri, final Map<String, String> headers, final Class<T> clazz) {
		T result = null;

		try {
			final CloseableHttpResponse httpResponse = HttpClient.get(httpClient, uri, headers);
			final String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			if(!ObjectUtils.isEmpty(content)) {
				result = objectMapper.readValue(content, clazz);
			}
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}

		return result;
	}

	public <T> T post(final String uri, final Map<String, Object> params, final Class<T> clazz) {
		return post(uri, null, params, clazz);
	}

	public <T> T post(final String uri, final Map<String, String> headers, final Map<String, Object> params, final Class<T> clazz) {
		T result = null;

		try {
			final CloseableHttpResponse httpResponse = HttpClient.post(httpClient, uri, headers, params);
			final String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			if(!ObjectUtils.isEmpty(content)) {
				result = objectMapper.readValue(content, clazz);
			}
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}

		return result;
	}

	public <T> T post(final String uri, final String params, final Class<T> clazz) {
		return post(uri, null, params, clazz);
	}

	public <T> T post(final String uri, final Map<String, String> headers, final String params, final Class<T> clazz) {
		T result = null;

		try {
			final CloseableHttpResponse httpResponse = HttpClient.post(httpClient, uri, headers, params);
			final String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			if(!ObjectUtils.isEmpty(content)) {
				result = objectMapper.readValue(content, clazz);
			}
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}

		return result;
	}
	
	public String postJson(final String uri, final Map<String, Object> params) {
		return postJson(uri, null, params);
	}

	public String postJson(final String uri, final Map<String, String> headers, final Map<String, Object> params) {
		String result = null;

		try {
			final String paramsString = CollectionUtils.isEmpty(params) ? null : objectMapper.writeValueAsString(params);
			final CloseableHttpResponse httpResponse = HttpClient.post(httpClient, uri, headers, paramsString);
			result = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}
		
		return result;
	}
	
	public <T> T postJson(final String uri, final Class<T> clazz) {
		return postJson(uri, null, clazz);
	}

	public <T> T postJson(final String uri, final Map<String, Object> params, final Class<T> clazz) {
		return postJson(uri, null, params, clazz);
	}

	public <T> T postJson(final String uri, final Map<String, String> headers, final Map<String, Object> params, final Class<T> clazz) {
		T result = null;

		try {
			final String paramsString = CollectionUtils.isEmpty(params) ? null : objectMapper.writeValueAsString(params);
			final CloseableHttpResponse httpResponse = HttpClient.post(httpClient, uri, headers, paramsString);
			final String content = IOUtils.toString(httpResponse.getEntity().getContent(), "UTF-8");
			if(!ObjectUtils.isEmpty(content)) {
				result = objectMapper.readValue(content, clazz);
			}
			httpResponse.close();
		} catch (ClientProtocolException e) {
			log.error("{}", e);
		} catch (IOException e) {
			log.error("{}", e);
		}
		
		return result;
	}
}
