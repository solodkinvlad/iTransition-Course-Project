package itransition.solodkin.service;

import itransition.solodkin.model.Provider;
import itransition.solodkin.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService {
    private ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider findByProvidedId(Long providedId) {
        return this.providerRepository.findByProvidedId(providedId);
    }
}
