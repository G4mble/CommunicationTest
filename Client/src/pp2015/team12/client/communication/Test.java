package pp2015.team12.client.communication;

import pp2015.team12.client.ClientCommunication;
import pp2015.team12.client.ClientEngine;

public class Test 
{
	public static void main(String[] args) 
	{
		ClientCom test = new ClientCom(new ClientCommunication(new ClientEngine()));
	}
}