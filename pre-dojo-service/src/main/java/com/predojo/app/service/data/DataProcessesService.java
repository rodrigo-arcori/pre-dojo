package com.predojo.app.service.data;

import java.util.List;

import com.predojo.app.entity.DataMatch;
import com.predojo.app.entity.GameMatch;
import com.predojo.app.entity.MatchResponse;

/*
 * (non-Javadoc)
 * @see com.predojo.app.service.data.IDataProcesses
 */
public class DataProcessesService implements IDataProcesses {

	private DataMatch dataMatch = new DataMatch();
	
	/*
	 * (non-Javadoc)
	 * @see com.predojo.app.service.data.IDataProcesses#execute(com.predojo.app.entity.GameMatch)
	 */
	@Override
	public void execute( GameMatch gameMatch ) {

		dataMatch.counter( gameMatch );

	}
	
	/*
	 * (non-Javadoc)
	 * @see com.predojo.app.service.data.IDataProcesses#getResponse()
	 */
	@Override
	public List< MatchResponse > getResponse() {
		
		return dataMatch.getResponse();
		
	}

}
