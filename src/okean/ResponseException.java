package okean;

import javax.ws.rs.core.Response;

@SuppressWarnings("serial")
public class ResponseException extends Exception
{
    private final Response response;
    
    public ResponseException(Response response, String uri)
    {
        super(String.format("Invalid HTTP response code %s; %s", response.getStatus(), uri));
        
        this.response = response;
    }
    
    public Response response()
    {
        return response;
    }
}