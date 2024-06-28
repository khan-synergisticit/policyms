package com.synergistic.policyms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("healthplan")
public class HealthPlan {
    @Id
    private String healthPlanId;
    @Field("healthPlanName")
    private String healthPlanName;
    @Field("healthPlanMetalLevel")
    private HealthPlanMetalLevel healthPlanMetalLevel;
    @Field("healthPlanBenefit")
    private String healthPlanBenefit;
    @Field("healthPlanCoverage")
    private String healthPlanCoverage;
    @Field("healthPlanType")
    private HealthPlanType healthPlanType;
    @Field("healthPlanFormulary")
    private String healthPlanFormulary;
    @Field("healthPlanPremium")
    private Double healthPlanPremium;
    @Field("healthPlanDeductible")
    private Double healthPlanDeductible;
    @Field("healthPlanCoPayment")
    private String healthPlanCoPayment;
    @Field("age")
    private Integer age;


    public HealthPlan() {
    }

    public HealthPlan(String healthPlanId, String healthPlanName, HealthPlanMetalLevel healthPlanMetaLevel, HealthPlanType healthPlanType, Double healthPlanPremium, Double healthPlanDeductible, Double maximumLimit) {
        this.healthPlanId = healthPlanId;
        this.healthPlanName = healthPlanName;
        this.healthPlanMetalLevel = healthPlanMetaLevel;
        this.healthPlanType = healthPlanType;
        this.healthPlanPremium = healthPlanPremium;
        this.healthPlanDeductible = healthPlanDeductible;

    }

    public String getHealthPlanId() {
        return healthPlanId;
    }

    public void setHealthPlanId(String healthPlanId) {
        this.healthPlanId = healthPlanId;
    }

    public String getHealthPlanName() {
        return healthPlanName;
    }

    public void setHealthPlanName(String healthPlanName) {
        this.healthPlanName = healthPlanName;
    }


    public HealthPlanType getHealthPlanType() {
        return healthPlanType;
    }

    public void setHealthPlanType(HealthPlanType healthPlanType) {
        this.healthPlanType = healthPlanType;
    }

    public Double getHealthPlanPremium() {
        return healthPlanPremium;
    }

    public void setHealthPlanPremium(Double healthPlanPremium) {
        this.healthPlanPremium = healthPlanPremium;
    }

    public Double getHealthPlanDeductible() {
        return healthPlanDeductible;
    }

    public void setHealthPlanDeductible(Double healthPlanDeductible) {
        this.healthPlanDeductible = healthPlanDeductible;
    }



    public HealthPlanMetalLevel getHealthPlanMetalLevel() {
        return healthPlanMetalLevel;
    }

    public void setHealthPlanMetalLevel(HealthPlanMetalLevel healthPlanMetalLevel) {
        this.healthPlanMetalLevel = healthPlanMetalLevel;
    }

    public String getHealthPlanFormulary() {
        return healthPlanFormulary;
    }

    public void setHealthPlanFormulary(String healthPlanFormulary) {
        this.healthPlanFormulary = healthPlanFormulary;
    }

    public String getHealthPlanCoPayment() {
        return healthPlanCoPayment;
    }

    public void setHealthPlanCoPayment(String healthPlanCoPayment) {
        this.healthPlanCoPayment = healthPlanCoPayment;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHealthPlanBenefit() {
        return healthPlanBenefit;
    }

    public void setHealthPlanBenefit(String healthPlanBenefit) {
        this.healthPlanBenefit = healthPlanBenefit;
    }

    public String getHealthPlanCoverage() {
        return healthPlanCoverage;
    }

    public void setHealthPlanCoverage(String healthPlanCoverage) {
        this.healthPlanCoverage = healthPlanCoverage;
    }
}
