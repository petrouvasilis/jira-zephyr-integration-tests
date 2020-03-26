package com.intrasoft.stsc.test_utils;

import com.intrasoft.stsc.web_pages.Home;
import com.intrasoft.stsc.web_pages.SearchResults;

public class Page {

    private Home home;
    private SearchResults searchResults;

    public Home home() {
        synchronized (this) {
            if (home == null) {
                home = new Home();
            }
        }
        return home;
    }

    public SearchResults searchResults() {
        synchronized (this) {
            if (searchResults == null) {
                searchResults = new SearchResults();
            }
        }
        return searchResults;
    }
}
