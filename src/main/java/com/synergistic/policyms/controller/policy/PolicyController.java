package com.synergistic.policyms.controller.policy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.synergistic.policyms.domain.*;
import com.synergistic.policyms.service.healthPlan.HealthPlanService;
import com.synergistic.policyms.service.member.MemberService;
import com.synergistic.policyms.service.networkProvider.ProviderService;
import com.synergistic.policyms.service.policy.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@RequestMapping("/api/policy")
@RestController
public class PolicyController {

    @Autowired private PolicyService policyService;
    @Autowired private HealthPlanService healthPlanService;
    @Autowired private MemberService memberService;
    @Autowired private ProviderService providerService;

    @CrossOrigin(origins = "http://localhost:4242")
    @RequestMapping("/save")
    public ResponseEntity<Policy> createPolicy(@RequestBody JsonNode node) throws IOException {
        Policy policy = new Policy();
        String healthPlanId = node.get("healthPlanId").asText();

        if(node.get("member") != null){
            JsonNode memberNode = node.get("member");
            JsonNode addressNode = memberNode.get("address");
            ObjectMapper mapper = new ObjectMapper();
            ObjectReader reader = mapper.readerFor(new TypeReference<Address>() {
            });
            Address address = reader.readValue(addressNode);
            Member member = new Member();
            member.setFirstName(memberNode.get("firstName").asText());
            member.setLastName(memberNode.get("lastName").asText());
            member.setEmail(memberNode.get("email").asText());
            member.setPhoneNumber(memberNode.get("phoneNumber").asText());
            member.setBirthDate(LocalDate.parse(memberNode.get("birthDate").asText()));
            member.setAddress(address);
            member.setPrimary(true);
            if(memberNode.get("dependents") != null){
                JsonNode dependentsNode = memberNode.get("dependents");
                List<Member> dependents = new ArrayList<>();
                if(dependentsNode.isArray()){
                    for(JsonNode dependentNode : dependentsNode){
                        Member dependentMember = new Member();
                        String fname = dependentNode.get("firstName").asText();
                        String lname = dependentNode.get("lastName").asText();
                        LocalDate birthDate = LocalDate.parse(dependentNode.get("birthDate").asText());
                        dependentMember.setFirstName(fname);
                        dependentMember.setLastName(lname);
                        dependentMember.setBirthDate(birthDate);
                        dependents.add(dependentMember);
                    }
                    member.setDependents(dependents);
                }

            }
            Member newMember = memberService.createMember(member);
            policy.setPolicyDocuments(createPolicyDocuments());
            policy.setMember(newMember);

        }

        policy.setTotalPremium(node.get("totalPremium").asDouble());
        policy.setApproved(false);
        HealthPlan healthPlan = healthPlanService.getHealthPlan(healthPlanId);
        policy.setHealthPlan(healthPlan);
        policy.setPolicyDescription(healthPlan.getHealthPlanName());
        return ResponseEntity.ok(policyService.createPolicy(policy));
    }

    @RequestMapping("/update")
    public ResponseEntity<Policy> updatePolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.updatePolicy(policy));
    }

    @RequestMapping("/update/docs")
    public ResponseEntity<?> updatePolicyDocuments(@RequestBody JsonNode docs) throws IOException {
        String policyId = docs.get("policyId").asText();
        Policy policy = policyService.getPolicy(policyId);
        JsonNode policyDocuments = docs.get("policyDocuments");
        List<Documents> documents = new ArrayList<>();
        if(policyDocuments.isArray()){
            for(JsonNode policyDocument : policyDocuments){
                ObjectMapper mapper = new ObjectMapper();
                Documents doc = mapper.readValue(policyDocument.toString(), Documents.class);
                documents.add(doc);
            }
        }
        List<Documents> retrievedDocs = policy.getPolicyDocuments();
        for(Documents doc : documents){
            for(Documents retrievedDoc : retrievedDocs){
                if(Objects.equals(doc.getType(), retrievedDoc.getType())&&doc.getUrl()!=null){
                    retrievedDoc.setUrl(doc.getUrl());
                    if(doc.getAccepted() != null){
                        retrievedDoc.setAccepted(doc.getAccepted());
                    }

                }
            }
        }

        policy.setPolicyDocuments(retrievedDocs);
        policyService.updatePolicy(policy);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/delete")
    public ResponseEntity<?> deletePolicy(@RequestParam String policyId) {
        policyService.deletePolicy(policyId);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/find")
    public ResponseEntity<?> getPolicyService(@RequestParam String id) {
        return ResponseEntity.ok(policyService.getPolicy(id));
    }

    @RequestMapping("/approve")
    public ResponseEntity<?> approvePolicy(@RequestParam String id) {
        Policy policy = policyService.getPolicy(id);
        NetworkProvider networkProvider = providerService.getNetworkProvider(id);
        policy.setPrimaryCareProvider(networkProvider);

        policy.setApproved(true);

        return ResponseEntity.ok(policyService.updatePolicy(policy));
    }

    @RequestMapping("/findByIds")
    public ResponseEntity<?> getPoliciesByIds(@RequestBody JsonNode node) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectReader reader = mapper.readerFor(new TypeReference<List<String>>() {
        });
        List<String> policyIds = reader.readValue(node);

        return ResponseEntity.ok(policyService.findAllByPolicyId(policyIds));
    }

    @RequestMapping("/findUnapproved")
    public ResponseEntity<?> getPoliciesUnapproved()  {
        return ResponseEntity.ok(policyService.findUnapprovedPolicies());
    }

    private List<Documents> createPolicyDocuments() {
        String[] s = {"ID", "SIGNED-POLICY", "TYPE1", "TYPE2", "TYPE3"};
        List<Documents> documents = new ArrayList<>();
        for(String s1: s){
            Documents d = new Documents(s1);
            documents.add(d);
        }
        return documents;
    }
}
