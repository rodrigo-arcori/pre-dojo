package com.predojo.app.service.result;

import java.util.List;

import com.predojo.app.entity.MatchResponse;

public class ScreenResultWriter implements IResultWriter {
	
	private List<MatchResponse> response;
	
	public ScreenResultWriter( List<MatchResponse> response ) {
		this.response = response;
	} 

	@Override
	public void showResult() {
		
		for (MatchResponse matchResponse : response) {
			
			String content = String.format(" Match:%s Player:%s killer:%s Die:%s", 
					matchResponse.getIdMatch(), 
					matchResponse.getPlayerName(),
					matchResponse.getCounterkiller(),
					matchResponse.getCounterDie() );
			
			System.out.println( content );
		}
		

	}

}
