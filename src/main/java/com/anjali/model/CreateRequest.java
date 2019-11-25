package com.anjali.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CreateRequest {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("job")
    @Expose
    private String job;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateRequest() {
    }

    /**
     *
     * @param name
     * @param job
     */
    public CreateRequest(String name, String job) {
        super();
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreateRequest withName(String name) {
        this.name = name;
        return this;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public CreateRequest withJob(String job) {
        this.job = job;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("job", job).toString();
    }

}