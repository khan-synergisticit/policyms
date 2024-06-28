package com.synergistic.policyms.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("networkprovider")
public class NetworkProvider {
    @Id
    private String networkProviderId;
    private String networkProviderLastName;
    private String networkProviderFirstName;
    private String networkProviderCredential;

    public NetworkProvider() {
    }

    public NetworkProvider(String networkProviderId) {
        this.networkProviderId = networkProviderId;
    }

    public String getNetworkProviderId() {
        return networkProviderId;
    }

    public void setNetworkProviderId(String networkProviderId) {
        this.networkProviderId = networkProviderId;
    }

    public String getNetworkProviderLastName() {
        return networkProviderLastName;
    }

    public void setNetworkProviderLastName(String networkProviderLastName) {
        this.networkProviderLastName = networkProviderLastName;
    }

    public String getNetworkProviderFirstName() {
        return networkProviderFirstName;
    }

    public void setNetworkProviderFirstName(String networkProviderFirstName) {
        this.networkProviderFirstName = networkProviderFirstName;
    }

    public String getNetworkProviderCredential() {
        return networkProviderCredential;
    }

    public void setNetworkProviderCredential(String networkProviderCredential) {
        this.networkProviderCredential = networkProviderCredential;
    }
}
