package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BinarySearchTest {

    @Rule public final ExpectedException expectedException = ExpectedException.none();

    @Test public void searchTestElementExistingInSequence() {
        int[] seq = {7};
        int key = 7;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(0, is(equalTo(searchResult.getPosition())));
    }

    @Test public void searchTestElementNotExistingInSequence() {
        int[] seq = {6};
        int key = 7;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(-1, is(equalTo(searchResult.getPosition())));
    }

    @Test public void searchTestElementExistingFirstInSequence() {
        int[] seq = {1,2,3,4};
        int key = 1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(0, is(equalTo(searchResult.getPosition())));
    }

    @Test public void searchTestElementExistingLastInSequence() {
        int[] seq = {1,2,3,4};
        int key = 4;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(seq.length - 1, is(equalTo(searchResult.getPosition())));
    }

    @Test public void searchTestElementExistingMiddleInSequence(){
        int[] seq = {1,2,3};
        int key = 2;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat((seq.length - 1) / 2, is(equalTo(searchResult.getPosition())));
    }

    @Test public void searchTestElementIsNotExistingInSequence(){
        int[] seq = {};
        int key = 7;

        expectedException.expect(IllegalArgumentException.class);
        BinarySearch.search(key, seq);
    }

    @Test public void searchTestElementIsNegativeNumberInSequence(){
        int[] seq = {-2, -1, 0, 1, 2};
        int key = -1;

        SearchResult searchResult = BinarySearch.search(key, seq);
        Assert.assertThat(1, is(equalTo(searchResult.getPosition())));
    }
}
