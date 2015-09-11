package com.predojo.app.service.test;

import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;

import com.predojo.app.service.log.GameLogService;
import com.predojo.app.service.log.IGameLogService;

/**
 * GameLogServiceTest used for validate state object.
 * @author rodrigo.arcori - https://github.com/rodrigo-arcori
 *
 */
public class GameLogServiceTest {
	
	@Test
	public final void validState() throws ExecutionException, InterruptedException {
		
		IGameLogService gameLogService = new GameLogService();
		
		Assert.assertFalse( "Response list is empty", gameLogService.load().isEmpty() );
	}

}
