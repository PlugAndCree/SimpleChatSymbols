package it.plugandcree.simplechatsymbols.events;

import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import it.plugandcree.simplechatsymbols.SimpleChatSymbols;

public class PlayerChat implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		String message = e.getMessage();
		
		HashMap<String, String> symbols = (HashMap<String, String>) SimpleChatSymbols.getInstance().getSymbols();
		
		for(HashMap.Entry<String, String> s : symbols.entrySet()) {
			message = message.replace(s.getKey(), s.getValue());
		}
		e.setMessage(message);
	}
}