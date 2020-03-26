package com.intrasoft.stsc.test_cases;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.testng.annotations.Test;

public class TestUI_002_VerifySearchResults extends BaseTest {

    @Test
    public void TestUI_002_VerifySearchResults() {
        page.home()
                .search("intrasoft");

        page.searchResults()
                .verifySearchResultsOpens()
                .verifySearchResultsContent("intrasoft");
    }

}
