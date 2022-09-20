package handlers;
import webApp.*;

import java.io.IOException;

public interface MainHandler {
    void process(HttpRequest request , HttpResponse response) throws IOException;
}
