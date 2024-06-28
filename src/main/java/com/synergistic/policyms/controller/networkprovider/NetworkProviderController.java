package com.synergistic.policyms.controller.networkprovider;

import com.synergistic.policyms.domain.NetworkProvider;
import com.synergistic.policyms.service.networkProvider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/provider")
public class NetworkProviderController {
    @Autowired private ProviderService providerService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody NetworkProvider networkProvider) {
        return new ResponseEntity<>( providerService.save(networkProvider), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody NetworkProvider networkProvider) {
        return new ResponseEntity<>( providerService.save(networkProvider), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody NetworkProvider networkProvider) {
        providerService.delete(networkProvider);
        return new ResponseEntity<>("Provider Deleted",  HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{networkProvider}", method = RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable String networkProvider) {

        return new ResponseEntity<>(providerService.getNetworkProvider(networkProvider),  HttpStatus.OK);
    }

}
