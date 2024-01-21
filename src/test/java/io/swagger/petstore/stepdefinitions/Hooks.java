package io.swagger.petstore.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

public class Hooks {

    private static final Logger log = getLogger(io.swagger.petstore.base.BaseTest.class);

    @Before
    public void before(Scenario scenario) {
        log.info("---------------------------------------------------------");
        log.info("S C E N A R I O  '" + scenario.getName() + "'");
        log.info("---------------------------------------------------------");
        log.info("STARTING Scenario");

    }

    @After
    public void after(Scenario scenario) {
        log.info("ENDING Scenario");
        log.info("-------------------------------------------------------------------------------");
        log.info("S C E N A R I O  result '" + scenario.getName() + "' " + scenario.getStatus()); // One of PASSED|UNDEFINED|PENDING|SKIPPED|FAILED
        log.info("--------------------------------------------------------------------------------");

    }

}
