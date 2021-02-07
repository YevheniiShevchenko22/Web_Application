package pl.edu.wszib.iphonestore.session;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Yevhenii Shevchenko at 2/7/21
 * Project name: iphonestore
 **/
class SessionObjectTest {

    @Test
    void getInfoTest() {
        SessionObject sessionObject = new SessionObject();
        String info = "INFO";

        Assert.assertNull(sessionObject.getInfo());
        sessionObject.setInfo(info);
        Assert.assertEquals(info, sessionObject.getInfo());
        Assert.assertNull(sessionObject.getInfo());

    }
}