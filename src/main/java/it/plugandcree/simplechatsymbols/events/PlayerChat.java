package it.plugandcree.simplechatsymbols.events;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import it.plugandcree.simplechatsymbols.SimpleChatSymbols;

public class PlayerChat implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		if(!e.getPlayer().hasPermission("simplechatsymbols.chat")) return;
		
		String message = e.getMessage();
		
		HashMap<String, String> symbols = (HashMap<String, String>) SimpleChatSymbols.getInstance().getSymbols();
		
		for(Entry<String, String> s : symbols.entrySet()) {
			message = message.replace(s.getKey(), s.getValue());
		}
		e.setMessage(message);
	}
}
