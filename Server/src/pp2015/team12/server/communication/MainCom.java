package pp2015.team12.server.communication;

import pp2015.team12.server.engine.ServerEngine;

public class MainCom
{
	public static void main(String[] args)
	{
		ServerEngine se1 = new ServerEngine();
		ServerCom test = ServerCom.getInstance(se1.getMessageHandler());
	}
}