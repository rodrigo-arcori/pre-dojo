package com.predojo.app.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.predojo.app.api.test.MatchTest;
import com.predojo.app.api.test.PlayerTest;
import com.predojo.app.api.test.WeaponTest;
import com.predojo.app.service.test.DataProcessesServiceTest;
import com.predojo.app.service.test.GameLogServiceTest;

/**
 * AppTest init all tests
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    PlayerTest.class,
    WeaponTest.class,
    MatchTest.class,
    DataProcessesServiceTest.class,
    GameLogServiceTest.class,
})
public class AppTest {

}
