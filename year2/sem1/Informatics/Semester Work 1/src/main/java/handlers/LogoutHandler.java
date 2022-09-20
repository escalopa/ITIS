package handlers;

import webApp.HttpRequest;
import webApp.HttpResponse;

import java.io.IOException;

public class LogoutHandler implements MainHandler {
    @Override
    public void process(HttpRequest request, HttpResponse response) throws IOException {
        request.setSession(null);
        for (String cookie : response.getCookies().keySet()){
            response.getCookies().put(cookie,response.getCookies().get(cookie).replaceAll("\\d+","0"));
        }
        new RootHandler().process(request,response);
    }
}
