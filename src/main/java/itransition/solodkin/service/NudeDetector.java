package itransition.solodkin.service;

import org.springframework.stereotype.Service;

@Service
public interface NudeDetector {
    boolean check(String url);
}
