package com.synergistic.policyms.domain;

public class Documents {

    private String type;
    private String url;
    private Boolean accepted;

    public Documents() {
    }

    public Documents(String type, String url) {

        this.type = type;
        this.url = url;
        this.accepted = false;
    }

    public Documents(String type) {
        this.type = type;
        this.accepted = false;
        this.url = "";
    }

    public Documents(String type, String url, Boolean accepted) {
        this.type = type;
        this.url = url;
        this.accepted = accepted;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }
}
