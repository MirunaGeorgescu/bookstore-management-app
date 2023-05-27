package ro.pao.gateways;

import ro.pao.service.BookService;
import ro.pao.service.impl.BookServiceImpl;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Requests {
    private static HttpClient httpClient = HttpClient.newHttpClient();

    private BookService bookService = new BookServiceImpl();

    private List <String> responsesList = new ArrayList<>();
    public void getAllBooksFromURL(){
        String url = "https://books.google.com/books?uid=117522004192189783614&as_coll=1027&hl=ro&source=gbs_lp_bookshelf_list";

        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();
            var httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            responsesList.add(httpResponse.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
