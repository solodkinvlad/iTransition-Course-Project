package itransition.solodkin.service;

import itransition.solodkin.model.Tag;
import itransition.solodkin.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Влад on 12.04.2017.
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TagService {

    private final TagRepository tagRepository;

    public Tag findOne(Long tagId) {
        return this.tagRepository.findOne(tagId);
    }

    public List<Tag> findAll() {
        return this.tagRepository.findAll();
    }

    public Tag findByTag(String tag) {
        return this.tagRepository.findByTag(tag);
    }

    @Transactional
    public void save(Tag tag) {
        this.tagRepository.save(tag);
    }

}
