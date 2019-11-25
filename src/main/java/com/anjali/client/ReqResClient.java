package com.anjali.client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.response.Response;
import com.anjali.config.Config;
import com.anjali.config.EndPoint;
import com.anjali.model.*;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.given;

public class ReqResClient {

    private Gson gson;

    public ReqResClient() {
        this.gson = new GsonBuilder().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation().create();
    }

    public HttpResponse<CreateResponse> createUser (String createRequest) {
        String url = Config.baseUrl.concat(EndPoint.CREATE_USER);
        System.out.println("URL is -->"+url);
        Response response= given()
                .header("Content-Type", "application/json")
                .body(createRequest)
                .post(url);
        System.out.println(response.asString());
        return new HttpResponse<CreateResponse>(response,
                gson.fromJson(response.getBody().asString(), CreateResponse.class));

    }
}
