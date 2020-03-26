package com.intrasoft.stsc.test_cases;

import com.intrasoft.stsc.test_utils.BaseTest;
import org.testng.annotations.Test;

public class TestUI_001_VerifyHomePage extends BaseTest {

    @Test
    public void TC_UI_001_VerifyHomePage() {
        page.home()
                .verifyWorkmark("Wikipedia")
                .verifySlogan("The Free Encyclopedia")
                .verifySearchInput();

    }

}
