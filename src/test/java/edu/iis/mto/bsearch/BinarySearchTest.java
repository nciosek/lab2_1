package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    @Test public void searchTestElementExistingInSequence() {
        int[] seq = {7};
        int key = 7;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals(0, searchResult.getPosition());
    }

    @Test public void searchTestElementNotExistingInSequence() {
        int[] seq = {6};
        int key = 7;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals(-1, searchResult.getPosition());
    }

    @Test public void searchTestElementExistingFirstInSequence() {
        int[] seq = {1,2,3,4};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals(0, searchResult.getPosition());
    }

    @Test public void searchTestElementExistingLastInSequence() {
        int[] seq = {1,2,3,4};
        int key = 4;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals(seq.length -1, searchResult.getPosition());
    }

    @Test public void searchTestElementExistingMiddleInSequence(){
        int[] seq = {1,2,3};
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals((seq.length - 1) / 2, searchResult.getPosition());
    }

    @Test public void searchTestElementIsNotExistingInSequence(){
        int[] seq = {1,2,3};
        int key = 7;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertEquals(-1, searchResult.getPosition());
    }
}
