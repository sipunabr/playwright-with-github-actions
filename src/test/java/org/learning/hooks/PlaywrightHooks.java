package org.learning.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.learning.base.PlaywrightManager;

public class PlaywrightHooks {

    @Before
    public void setUp() {
        PlaywrightManager.setUp();
    }

    @After
    public void tearDown() {
        PlaywrightManager.tearDown();
    }
}
