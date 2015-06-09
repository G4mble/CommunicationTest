package pp2015.team12.server.engine;
import java.util.ArrayList;
import java.util.Vector;

import pp2015.team12.shared.character.Monster;
import pp2015.team12.shared.character.PlayerCharacter;
import pp2015.team12.shared.message.CreateMonsterMsg;
import pp2015.team12.shared.message.DamageMsg;
import pp2015.team12.shared.message.EngageFightMsg;
import pp2015.team12.shared.message.FightMsg;
import pp2015.team12.shared.message.Message;
/**
 * Interface for the Kommunication with Server I
 * @author Staufenberg, Thomas, 5820359
 * @author Balduin,Andreas,5800366 
 */
public class SE_II_Controller   {

	private ArrayList<Message> incomingMessageList;
	private boolean messageIsProcessing;
	private MessageHandler messageHandler;
	
	/**
	 * 	Constructor 
	 *  @author Balduin,Andreas,5800366 
	 */
	public SE_II_Controller(MessageHandler messageHandler){
		this.messageIsProcessing = false;
		this.incomingMessageList = new ArrayList<>();
		this.messageHandler = messageHandler;
		
	}
	
	/**
	 * processes outgoing Messages and calls the receiveMessage method of the respective target address
	 * @param paramMessage the Message to be send
	 * @author Staufenberg, Thomas, 5820359
	 * */
	private void sendMessage(Message paramMessage)
	{
		messageHandler.addNewMsg(paramMessage);
	}
	
	/**
	 * called by ServerEngine_I for communication purpose</br>
	 * adds the given Message to a list and starts the handling process if it is not already running
	 * @param paramMessage the Message to receive
	 * @author Staufenberg, Thomas, 5820359
	 * */
	public void receiveMessage(Message paramMessage)
	{
		this.incomingMessageList.add(paramMessage);
		if(!this.messageIsProcessing)
			this.handleMessage();
	}
	/**
	 * called by this.receiveMessage(), iterates over incomingMessageList while not empty</br>
	 * handles all incoming Messages
	 * @author Balduin,Andreas,5800366 
	 */
	public void handleMessage(){
			if(!this.messageIsProcessing)
				this.messageIsProcessing = true;
			while(true)
			{
				Message currentMessage;
				try 
				{
					currentMessage = this.incomingMessageList.remove(0);
				}
				catch(IndexOutOfBoundsException indexExc)
				{
					//stop message handling if there is no message left
					break;
				}
				if (currentMessage instanceof  FightMsg){
					PlayerCharacter player = ((FightMsg) currentMessage).getAttacker();
					Monster monster = ((FightMsg) currentMessage).getDefender();
					int damage = player.damage_Calculation(monster);
					this.sendMessage(new DamageMsg(damage,monster));
				} 
				else if (currentMessage instanceof CreateMonsterMsg){
					// TODO Create Monster
					// Send MonsterListMsg back
					// Set ClientId -1
					Vector<Integer> monsterList = ((CreateMonsterMsg) currentMessage).getMonsterList();
					int levelId = ((CreateMonsterMsg) currentMessage).getLevelId();
					if (monsterList.get(0) == 1){
						Monster[] monsterArray = new Monster[monsterList.get(1)];
						for (int i = 0; i < monsterList.get(1); i++){
							double random = Math.random();
							if (random < (1/3)){
							}
						}
					}
				}  
	
			}
	}
	
	
}
