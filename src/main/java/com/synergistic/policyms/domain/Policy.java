package com.synergistic.policyms.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Document("policy")
public class Policy {

    @Id
    private String policyId;

    private String policyDescription;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate policyStartDate;

    private Member member;
    @DocumentReference(lazy = true)
    private HealthPlan healthPlan;
    @DocumentReference(lazy = true)
    private NetworkProvider primaryCareProvider;
    private Boolean isApproved;
    private Double totalPremium;
    private List<Documents> policyDocuments = new ArrayList<>();
    @DocumentReference(lazy = true)
    private List<Message> policyMessages = new ArrayList<>();
    private String status;
    public Policy() {
    }

    public Policy(String policyId, String policyDescription, LocalDate policyStartDate,  Member member, HealthPlan healthPlan, NetworkProvider primaryCareProvider) {
        this.policyId = policyId;
        this.policyDescription = policyDescription;
        this.policyStartDate = policyStartDate;
        this.member = member;
        this.healthPlan = healthPlan;
        this.primaryCareProvider = primaryCareProvider;
    }

    public Policy(String policyId, String policyDescription, LocalDate policyStartDate, Member member, HealthPlan healthPlan, NetworkProvider primaryCareProvider, Boolean isApproved, Double totalPremium, List<Documents> policyDocuments) {
        this.policyId = policyId;
        this.policyDescription = policyDescription;
        this.policyStartDate = policyStartDate;
        this.member = member;
        this.healthPlan = healthPlan;
        this.primaryCareProvider = primaryCareProvider;
        this.isApproved = isApproved;
        this.totalPremium = totalPremium;
        this.policyDocuments = policyDocuments;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyDescription(String policyDescription) {
        this.policyDescription = policyDescription;
    }

    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
    }



    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public HealthPlan getHealthPlan() {
        return healthPlan;
    }

    public void setHealthPlan(HealthPlan healthPlan) {
        this.healthPlan = healthPlan;
    }

    public NetworkProvider getPrimaryCareProvider() {
        return primaryCareProvider;
    }

    public void setPrimaryCareProvider(NetworkProvider primaryCareProvider) {
        this.primaryCareProvider = primaryCareProvider;
    }

    public Boolean getApproved() {
        return isApproved;
    }

    public void setApproved(Boolean approved) {
        isApproved = approved;
    }

    public Double getTotalPremium() {
        return totalPremium;
    }

    public void setTotalPremium(Double totalPremium) {
        this.totalPremium = totalPremium;
    }


    public List<Documents> getPolicyDocuments() {
        return policyDocuments;
    }

    public void setPolicyDocuments(List<Documents> policyDocuments) {
        this.policyDocuments = policyDocuments;
    }

    public List<Message> getPolicyMessages() {
        return policyMessages;
    }

    public void setPolicyMessages(List<Message> policyMessages) {
        this.policyMessages = policyMessages;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
