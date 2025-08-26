package io.loop.test.day_8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.testng.annotations.Test;

public class T1_login_docuport extends TestBase {

    @Test
    public void test_login_docuport() throws InterruptedException {
        DocuportUtils.login(driver,"client");
        DocuportUtils.logOut(driver);
    }
}
