package com.synergistic.policyms.controller.healthplan;

import com.fasterxml.jackson.databind.JsonNode;
import com.synergistic.policyms.domain.HealthPlan;
import com.synergistic.policyms.domain.HealthPlanMetalLevel;
import com.synergistic.policyms.domain.PageInfo;
import com.synergistic.policyms.service.healthPlan.HealthPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/healthplan")
public class HealthPlanController {
    @Autowired private HealthPlanService healthPlanService;

    PageInfo healthPlanPageInfo = new PageInfo(0, 10, "healthPlanName", "asc");

    @RequestMapping("/save")
    public ResponseEntity<?> saveHealthPlan(@RequestBody HealthPlan healthPlan) {
        return new ResponseEntity<>(healthPlanService.createHealthPlan(healthPlan), HttpStatus.CREATED);
    }
    @RequestMapping("/update")
    public ResponseEntity<?> updateHealthPlan(@RequestBody HealthPlan healthPlan) {
        return new ResponseEntity<>(healthPlanService.updateHealthPlan(healthPlan), HttpStatus.OK);
    }
    @RequestMapping("/delete")
    public ResponseEntity<?> deleteHealthPlan(@RequestBody HealthPlan healthPlan) {
        healthPlanService.deleteHealthPlan(healthPlan);
        return new ResponseEntity<>("Health Plan Deleted", HttpStatus.OK);
    }

    @RequestMapping("/find/{id}")
    public ResponseEntity<?> findHealthPlanById(@PathVariable String id) {
        return new ResponseEntity<>(healthPlanService.getHealthPlan(id), HttpStatus.OK);
    }

    @RequestMapping("/findAll")
    public ResponseEntity<?> findALLHealthPlan() {
        return new ResponseEntity<>(healthPlanService.getHealthPlans(), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:4242")
    @PostMapping(value = "/find")
    public ResponseEntity<?> findHealthPlanByQuery(@RequestBody JsonNode jsonNode) {
        String coverage = jsonNode.get("coverage").asText();
        HealthPlanMetalLevel level = HealthPlanMetalLevel.valueOf(jsonNode.get("metalType").asText());
        Integer age = jsonNode.get("age").asInt();
        Double premium = jsonNode.path("premium").asDouble();
        Page<HealthPlan> healthPlans = healthPlanService.query(healthPlanPageInfo,  level, age, premium, coverage);

        return new ResponseEntity<>(healthPlans.getContent(), HttpStatus.OK);
    }
}
