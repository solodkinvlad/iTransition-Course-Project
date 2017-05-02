package itransition.solodkin.model;

import java.util.Comparator;

/**
 * Created by Влад on 02.05.2017.
 */
public class TagComparator implements Comparator<Tag> {

    @Override
    public int compare(Tag o1, Tag o2) {
        return Integer.valueOf(o2.getPhotos().size()).compareTo(o1.getPhotos().size());
    }
}
