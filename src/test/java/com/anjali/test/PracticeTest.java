package com.anjali.test;

import com.google.gson.Gson;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import com.anjali.model.*;
import com.google.gson.Gson;
import com.anjali.client.ReqResClient;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.anjali.client.HttpResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Title;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PracticeTest  {

    private Gson gson;
    private ReqResClient reqResClient;

    public PracticeTest() {
        this.reqResClient = new ReqResClient();
        this.gson = new Gson();
//          ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectStatusCode(200).build();
//          RestAssured.responseSpecification = responseSpecification;
    }
    @Title("Create User")
    @Test
    public void test1() throws Exception {


        CreateRequest createRequest = new CreateRequest();
        createRequest.setJob("qa");
        createRequest.setName("vikas");
        String categoryJson = gson.toJson(createRequest);
        System.out.println(categoryJson);

        HttpResponse<CreateResponse> httpResponse= reqResClient.createUser(categoryJson);
        Assert.assertThat(httpResponse.getModel().getName(), CoreMatchers.containsString("vikas"));


    }
}
