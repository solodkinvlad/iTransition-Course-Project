package itransition.solodkin.model;

import java.util.Comparator;

/**
 * Created by Влад on 01.05.2017.
 */
public class CloudPhotoComparator implements Comparator<CloudPhoto> {
    @Override
    public int compare(CloudPhoto o1, CloudPhoto o2) {
         return Integer.valueOf(o2.getUserSet().size()).compareTo(o1.getUserSet().size());
    }
}
