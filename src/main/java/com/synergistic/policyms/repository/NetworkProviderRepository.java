package com.synergistic.policyms.repository;

import com.synergistic.policyms.domain.NetworkProvider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NetworkProviderRepository extends MongoRepository<NetworkProvider, String> {
    NetworkProvider findFirstByNetworkProviderLastNameStartsWith(String networkProviderLastNameBeginsWith);

}
