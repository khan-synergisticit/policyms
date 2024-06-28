package com.synergistic.policyms.service.networkProvider;

import com.synergistic.policyms.domain.NetworkProvider;

public interface ProviderService {
    NetworkProvider save(NetworkProvider networkProvider);
    NetworkProvider update(NetworkProvider networkProvider);
    void delete(NetworkProvider networkProvider);
    NetworkProvider getNetworkProvider(String networkProviderId);

}
