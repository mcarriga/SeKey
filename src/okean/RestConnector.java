package okean;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.URI;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.ws.rs.HttpMethod;
//import javax.xml.ws.rs.HttpMethod;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.message.internal.CookieProvider;
import org.glassfish.jersey.uri.UriComponent;

import logging.KeywordLogger;

public class RestConnector
{
    //private final static Logger Log = LoggerFactory.getLogger(RestConnector.class);

    private String host;
    private String port;
    private String domain;
    private String project;
    private static  MultivaluedMap<String, Object> authentication;
    private static Client client = null;
    
    public MultivaluedMap<String, Object> getAuthHeader()
    {
    		return authentication;
    }

    private Map<String, Cookie> cookies = new HashMap<String, Cookie>();
    private List<Cookie> simpleCookies = new ArrayList<Cookie>();
    
    private HttpClient getClient() {
    		HttpClientBuilder builder =  HttpClientBuilder.create();
    		CookieHandler.setDefault(new CookieManager());
    		return builder.build();
    }
    
    private HttpResponse getResponse(HttpRequest request) throws Exception {
    	HttpHost httpHost = new HttpHost(host);
    		HttpResponse response = getClient().execute(httpHost, request);
    		return response;
    }
    
    public HttpGet getRequest(String path, List<org.apache.http.Header> headers, Map<String, String> queryParams) throws Exception {
    		HttpGet get = new HttpGet(buildUrl(path));
    		for(org.apache.http.Header header : headers) {
    			get.addHeader(header);
    		}
    		return get;
    }
    

    private RestConnector()
    {
    }

    private static class RestConnectorHolder
    {
        static final RestConnector Instance = new RestConnector();
    }

    public static RestConnector instance()
    {
        return RestConnectorHolder.Instance;
    }

    public void init(String host, String port, String domain, String project)
    {
        this.host = host;
        this.port = port;
        this.domain = domain;
        this.project = project;
    }

    public static MultivaluedMap<String, Object> createBasicAuthHeader(String username, String password)
    {
        byte[] credBytes = (username + ":" + password).getBytes();
        String credEncodedString = "Basic " + Base64.encodeBase64String(credBytes);

        MultivaluedMap<String, Object> authHeader = new MultivaluedHashMap<String, Object>();
        authHeader.add(HttpHeaders.AUTHORIZATION, credEncodedString);
        
        authentication = authHeader;
        return authHeader;
    }

    public String host()
    {
        return host;
    }

    public String port()
    {
        return port;
    }

    public String domain()
    {
        return domain;
    }

    public String project()
    {
        return project;
    }

    public String buildUrl(String path) throws Exception
    {
        //if(StringUtils.isNotBlank(host) && StringUtils.isNotBlank(port))
    		if(StringUtils.isNotBlank(host))
        {
            path = path.startsWith("/") ? path.substring(1) : path;

            //return String.format("http://%s:%s/%s", host, port, path);
            return String.format("https://%s/%s", host, path);
        }

        throw new Exception("Host/Port are invalid. Call init() to initialize them properly.");
    }

    public String buildEntityCollectionUrl(String entityType) throws Exception
    {
        if(StringUtils.isNotBlank(domain) && StringUtils.isNotBlank(project))
        {
        		//KeywordLogger.getInstance().info(String.format("Entity collection Url: "+"/qcbin/rest/domains/%s/projects/%s/%s", domain, project, entityType));
            return String.format("/qcbin/rest/domains/%s/projects/%s/%s", domain, project, entityType);
        }

        throw new Exception("Domain/Project are invalid. Call init() to initialize them properly.");
    }

    public String buildEntityUrl(String entityType, String id) throws Exception
    {
    	KeywordLogger.getInstance().info("Entity Url: "+buildEntityCollectionUrl(entityType) + "/" + id);
        return buildEntityCollectionUrl(entityType) + "/" + id;
    }

    public <T> T get(
            String path,
            Class<T> entityType,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams) throws Exception
    {
        //Log.debug("GET: {}", path);

        return call(HttpMethod.GET, path, headers, queryParams, null, entityType);
    }

    public <T> T post(
            String path,
            Class<T> entityType,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload) throws Exception
    {
        //Log.debug("POST: {}", path);

        return call(HttpMethod.POST, path, headers, queryParams, payload, entityType);
    }

    public <T> T post(
            String path,
            Class<T> entityType,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload,
            String contentType) throws Exception
    {
        //Log.debug("POST: {}", path);

        return call(HttpMethod.POST, path, headers, queryParams, payload, contentType, entityType);
    }

    public <T> T put(
            String path,
            Class<T> entityType,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload) throws Exception
    {
        //Log.debug("PUT: {}", path);

        return call(HttpMethod.PUT, path, headers, queryParams, payload, entityType);
    }

    public Response delete(
            String path,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams) throws Exception
    {
        //Log.debug("DELETE: {}", path);

        return call(HttpMethod.DELETE, path, headers, queryParams, null);
    }

    private static WebTarget createWebTarget(String uri, Map<String, String> queryParams) throws Exception
    {
        WebTarget webTarget = null;
        SSLContext ssl = SSLContext.getInstance("TLSv1");
        ssl.init(null, new TrustManager[]{new SimpleX509TrustManager()}, new SecureRandom());
        //SSLSocketFactory factory = ssl.getSocketFactory();

        URI u = new URI(uri);
        KeywordLogger.getInstance().info("Uri "+uri.toString());
        
        if(client ==null) {
	        ClientBuilder clientBuilder = ClientBuilder.newBuilder();
	        try {
	            clientBuilder.sslContext(ssl);
	            clientBuilder.hostnameVerifier(new HostnameVerifier() {
	                @Override
	                public boolean verify(String hostname, SSLSession session) {
	                    return true;
	                }
	            });
	        } catch (Exception e) {
	            KeywordLogger.getInstance().error("", e);
	            //throw OurExceptionUtils.wrapInRuntimeExceptionIfNecessary(e);
	        }
	        
	        client = clientBuilder.withConfig(new ClientConfig()).build();
	        CookieProvider provider = new CookieProvider();
        }

        webTarget = client.target(u);

        if (MapUtils.isNotEmpty(queryParams))
        {
            for (Entry<String, String> entry : queryParams.entrySet())
            {
                if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue()))
                {
                    String value = UriComponent.encode(
                            entry.getValue(),
                            UriComponent.Type.QUERY_PARAM_SPACE_ENCODED);

                    webTarget = webTarget.queryParam(entry.getKey(), value);
                }
            }
        }

        return webTarget;
    }

    private static boolean isStatusCodeOK(int statusCode)
    {
        return statusCode >= Status.OK.getStatusCode() &&
               statusCode <= Status.PARTIAL_CONTENT.getStatusCode();
    }
    
    private static boolean isStatusCodeFound(int statusCode) {
    		return statusCode == Status.FOUND.getStatusCode();
    }

    private <T> T call(
            String methodName,
            String path,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload,
            Class<T> entityType) throws Exception
    {
        return call(methodName, path, headers, queryParams, payload, MediaType.APPLICATION_XML, entityType);
    }

    private <T> T call(
            String methodName,
            String path,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload,
            String contentType,
            Class<T> entityType) throws Exception
    {
        Response res = call(methodName, path, headers, queryParams, payload, contentType);

        if(!res.hasEntity())
        {
            return null;
        }
        KeywordLogger.getInstance().info("Media Type: "+res.getMediaType().toString());
        return (T) res.readEntity(entityType);
    }

    private Response call(
            String methodName,
            String path,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload) throws Exception
    {
        return call(methodName, path, headers, queryParams, payload, MediaType.APPLICATION_XML);
    }

    private Response call(
            String methodName,
            String path,
            MultivaluedMap<String, Object> headers,
            Map<String, String> queryParams,
            Object payload,
            String contentType) throws Exception
    {
        WebTarget webTarget = createWebTarget(buildUrl(path), queryParams);
        

        Builder result = webTarget.request().headers(headers);
        
        if (MapUtils.isNotEmpty(cookies))
        {
            for (Entry<String, Cookie> cookie : cookies.entrySet())
            {
                //result = result.cookie(cookie.getValue());
                //result = result.cookie(cookie.getValue().getName(), cookie.getValue().getValue());
            }
            for(Cookie cook : simpleCookies) {
            		result = result.cookie(cook);
            }
        }
        KeywordLogger.getInstance().info("Cookies: "+simpleCookies.toString());
        Response res = null;
        if(payload==null) {
        		res = result.get();
        } else {
        	res = result.method(
                    methodName, Entity.entity(payload, contentType), Response.class);
        }

        int statusCode = res.getStatus();
        KeywordLogger.getInstance().info("Status: "+statusCode);
        KeywordLogger.getInstance().info("New Cookies: "+res.getCookies().toString());
        if (!isStatusCodeOK(statusCode))
        {
        	updateCookies(res.getCookies());
            throw new ResponseException(res, buildUrl(path));
        }
        
        updateCookies(res.getCookies());
        URI x = res.getLocation();
        return res;
    }

    private void updateCookies(Map<String, NewCookie> newCookies)
    {
        if (MapUtils.isNotEmpty(newCookies))
        {
         	for(NewCookie cookie : newCookies.values()) {
         		if(!containsCookie(cookie.getName())) {
         			Cookie cookie2 = new Cookie(cookie.getName(), cookie.getValue());
             		simpleCookies.add(cookie2);
         		} else {
         			updateCookie(cookie.getName(), cookie.getValue());
         		}
         	}
            cookies.putAll(newCookies);
        }
    }
    
    private void updateCookie(String name, String value) {
     	boolean found = false;
     	Cookie cook = null;
	    	for(Cookie cookie : simpleCookies) {
			if(cookie.getName().equalsIgnoreCase(name)) {
				found = true;
				cook = cookie;
			}
	    	}
	    	
	    	if(found) {
	    		simpleCookies.remove(cook);
	    		Cookie newCookie = new Cookie(name, value);
			simpleCookies.add(newCookie);
	    	}
    }
    
    private boolean containsCookie(String cookieName) {
    	boolean found = false;
    		for(Cookie cookie : simpleCookies) {
    			if(cookie.getName().equalsIgnoreCase(cookieName)) {
    				found = true;
    			}
    		}
    		return found;
    }
}
