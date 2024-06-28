package com.synergistic.policyms.service.networkProvider;

import com.synergistic.policyms.domain.NetworkProvider;
import com.synergistic.policyms.repository.NetworkProviderRepository;
import com.synergistic.policyms.utils.ConfirmationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired private NetworkProviderRepository networkProviderRepository;
    @Override
    public NetworkProvider save(NetworkProvider networkProvider) {
        return networkProviderRepository.save(networkProvider);
    }

    @Override
    public NetworkProvider update(NetworkProvider networkProvider) {
        return networkProviderRepository.save(networkProvider);
    }

    @Override
    public void delete(NetworkProvider networkProvider) {
        networkProviderRepository.delete(networkProvider);
    }

    @Override
    public NetworkProvider getNetworkProvider(String networkProviderId) {

        NetworkProvider networkProvider = null;
        while(networkProvider == null) {
            String s = ConfirmationGenerator.generate(1);
            networkProvider = networkProviderRepository.findFirstByNetworkProviderLastNameStartsWith(s);
        }
        return networkProvider;
    }
}
