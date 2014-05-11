package com.weebly.aksjeffreyonation;
 
/**
 * Author: Bhavneet Pannu
 * under the GPL V3 license
 */


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
 
public class Main extends JavaPlugin implements Listener{
 

	
    private HashMap<String, Date> lastMsg = new HashMap<String, Date>();
    private final float timeDelay = 3;
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }
 
    @Override
    public void onDisable() {
 
    }
 
   

    
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        if(lastMsg.get(p.getName()) != null){
            Date last = lastMsg.remove(p.getName());
            Date now = Calendar.getInstance().getTime();
            long diffMillis = now.getTime() - last.getTime();
            long diffSecs = (diffMillis) / 1000L;
            if(diffSecs < timeDelay){
                onChatspam(event.getPlayer());
                event.setCancelled(true);
            }
        } else {
            lastMsg.put(p.getName(), Calendar.getInstance().getTime());
        }
    }

	private void onChatspam(Player player) {
		// TODO Auto-generated method stub
		
	}


	
 
    }
