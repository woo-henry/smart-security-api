package com.sanesong.security.api.service.http;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public final class HttpClient {
	
	private static final int MAX_TOTAL = 500;             //连接池最大连接数
    private static final int MAX_PER_ROUTE = 100;          //单个路由默认最大连接数
    private static final int REQ_TIMEOUT =  90 * 1000;     //请求超时时间ms
    private static final int CONN_TIMEOUT = 90 * 1000;     //连接超时时间ms
    private static final int SOCK_TIMEOUT = 120 * 1000;    //读取超时时间ms
    
	private static final RequestConfig ENABLE_REDIRECT_REQUEST_CONFIG = RequestConfig.custom()
			.setRedirectsEnabled(true)
			.setConnectionRequestTimeout(REQ_TIMEOUT)
			.setConnectTimeout(CONN_TIMEOUT)
			.setSocketTimeout(SOCK_TIMEOUT)
			.build();
	private static final RequestConfig DISABLE_REDIRECT_REQUEST_CONFIG = RequestConfig.custom()
			.setRedirectsEnabled(false)
			.setConnectionRequestTimeout(REQ_TIMEOUT)
			.setConnectTimeout(CONN_TIMEOUT)
			.setSocketTimeout(SOCK_TIMEOUT)
			.build();

	private HttpClient() { /* static methods only - hide constructor */
	}
	
	private static class CustomTrustStrategy implements TrustStrategy {
		@Override
		public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
			return true;
		}
	}
	
	public static String getRemoteAddress(final HttpServletRequest request) {
		String unknown = "unknown";
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Real-IP");
		}
		if (StringUtils.isEmpty(ip) || unknown.equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
	}

	public static String getHeaderUserAgent(final HttpServletRequest request) {
		return request.getHeader("User-Agent");
	}
	
	public static CloseableHttpClient buildClient(final boolean enableRedirect) {
		return enableRedirect ? buildEnableRedirectClient() : buildDisableRedirectClient();
	}
	
	public static CloseableHttpClient buildSSLClient(final boolean enableRedirect) {
		return enableRedirect ? buildEnableRedirectSSLClient() : buildDisableRedirectSSLClient();
	}
	
	public static CloseableHttpResponse post(final CloseableHttpClient client, final String uri, final Map<String, String> headers, final Map<String, Object> params) throws ClientProtocolException, IOException {
		final HttpPost request = new HttpPost(uri);
		
		if(!CollectionUtils.isEmpty(params)) {
			final List<BasicNameValuePair> pairs = createRequestParameters(params);
			final UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs, "UTF-8");
			request.setEntity(entity);
		}
		
		if(!CollectionUtils.isEmpty(headers)) {
			request.setHeaders(createRequestHeaders(headers));
		}
		
		return client.execute(request);
	}
	
	public static CloseableHttpResponse post(final CloseableHttpClient client, final String uri, final Map<String, String> headers, final String params) throws ClientProtocolException, IOException {
		final HttpPost request = new HttpPost(uri);
		
		if(!ObjectUtils.isEmpty(params)) {
			final StringEntity entity = new StringEntity(params, ContentType.APPLICATION_JSON);
			request.setEntity(entity);
		}
		
		if(!CollectionUtils.isEmpty(headers)) {
			request.setHeaders(createRequestHeaders(headers));
		}

		return client.execute(request);
	}
	
	public static CloseableHttpResponse get(final CloseableHttpClient client, final String uri) throws ClientProtocolException, IOException {
		return get(client, uri, null);
	}
	
	public static CloseableHttpResponse get(final CloseableHttpClient client, final String uri, final Map<String, String> headers) throws ClientProtocolException, IOException {
		final HttpGet request = new HttpGet(uri);
		
		if(!CollectionUtils.isEmpty(headers)) {
			request.setHeaders(createRequestHeaders(headers));
		}
		
		return client.execute(request);
	}
	
	private static CloseableHttpClient buildEnableRedirectSSLClient() {
		CloseableHttpClient result = null;
		
		try {
			result = buildSSLClient(ENABLE_REDIRECT_REQUEST_CONFIG);
		} catch (KeyManagementException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (KeyStoreException e) {
		}
		
		return result;
	}
	
	private static CloseableHttpClient buildDisableRedirectSSLClient() {
		CloseableHttpClient result = null;
		
		try {
			result = buildSSLClient(DISABLE_REDIRECT_REQUEST_CONFIG);
		} catch (KeyManagementException e) {
		} catch (NoSuchAlgorithmException e) {
		} catch (KeyStoreException e) {
		}
		
		return result;
	}
	
	private static CloseableHttpClient buildEnableRedirectClient() {
		final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        
		return HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(ENABLE_REDIRECT_REQUEST_CONFIG).build();
	}
	
	private static CloseableHttpClient buildDisableRedirectClient() {
		final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        
		return HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(DISABLE_REDIRECT_REQUEST_CONFIG).build();
	}
	
	private static CloseableHttpClient buildSSLClient(final RequestConfig config) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		final PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        poolingHttpClientConnectionManager.setMaxTotal(MAX_TOTAL);
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
        
		final SSLContext context = new SSLContextBuilder().loadTrustMaterial(null, new CustomTrustStrategy()).build();
		final SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(
				context, 
				new String[] { "TLSv1", "TLSv1.1", "TLSv1.2" }, 
				null,
				SSLConnectionSocketFactory.getDefaultHostnameVerifier());
        
		return HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).setDefaultRequestConfig(config).setSSLSocketFactory(factory).build();
	}
	
	private static Header[] createRequestHeaders(final Map<String, String> headers) {
		final List<Header> result = new ArrayList<>();
		
		for (final String key : headers.keySet()) {
			final String value = headers.get(key);
			if(ObjectUtils.isEmpty(value)) 
				continue;
			
			final Header header = new BasicHeader(key, value);
			result.add(header);
		}
		
		return result.toArray(new Header[]{});
	}
	
	private static List<BasicNameValuePair> createRequestParameters(final Map<String, Object> params) {
		final List<BasicNameValuePair> result = new ArrayList<>();
		
		for (final String key : params.keySet()) {
			final Object value = params.get(key);
			if(ObjectUtils.isEmpty(value)) 
				continue;
			
			final BasicNameValuePair pair = new BasicNameValuePair(key, value.toString());
			result.add(pair);
		}
		
		return result;
	}
}
