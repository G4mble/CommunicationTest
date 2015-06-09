package pp2015.team12.server.engine;
/**
 * Start and managed all Events like Monster Respawn or HealthPotion
 * 
 * @author Friedrich Murillo, Simon, 5802318
 */
public class EventServer extends Thread
{
//	
//	public static void main(String[] args){
//		startrespawnMonsterEvent(2);
//		useHealthpotion(1);
//	}
	ServerEngine SE;
	
	public EventServer(ServerEngine serverEngine)
	{
		this.SE = serverEngine;
	}
	
	
	private void StartEvents()
	{
		// TODO Auto-generated method stub
		
	}
	/**
	 * Start a Monster Respawn Event
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public static void startrespawnMonsterEvent(int charId)
	{
		System.out.println("Monster "+charId+" ist tot");
		// TODO Monster.setalive false
		try
		{
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Monster "+charId+" wurde wiederbelebt");
		// TODO monster.setalive true
 
	}
	/**
	 * Start a take HealthPotion Event
	 * 
	 * @author Friedrich Murillo, Simon, 5802318
	 */
	public static void useHealthpotion(int charId)
	{
		System.out.println("Heiltrank eingenommen");
		for (int i = 0; i<5; i++)
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Das Leben von Spieler "+charId+" wurde um 10 erhoeht");
			// TODO player[charId] setleben=+10
		}
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				StartEvents();
				Thread.sleep(20);
			} catch (Exception e)
			{
				// TODO: handle exception
			}
		}

	}

	

}
