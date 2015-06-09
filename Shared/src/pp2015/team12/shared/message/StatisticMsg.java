package pp2015.team12.shared.message;

import pp2015.team12.shared.statistics.StatisticsModel;
/**
 *@author Heusser, Caspar
 */
@SuppressWarnings("serial")
public class StatisticMsg extends Message{
	public StatisticsModel getStat() {
		return stat;
	}
	private StatisticsModel stat;
	public  StatisticMsg (int clientID, StatisticsModel stat){
		super(clientID);
		this.stat=stat;
	}
	
}
