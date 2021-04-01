package it.plugandcree.simplechatsymbols.commands;

import java.util.List;

import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

import it.plugandcree.simplechatsymbols.SimpleChatSymbols;
import it.plugandcree.simplechatsymbols.config.CustomConfig;

public class Reload extends Command {
	
	public Reload() {
		super("reload", "simplechatsymbols.reload", SimpleChatSymbols.getInstance().getLangConfig().noPerm());
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		CustomConfig lang = SimpleChatSymbols.getInstance().getLangConfig();
		
		SimpleChatSymbols.getInstance().reloadConfig();
		sender.sendMessage(lang.getString("messages.reload-complete"));
		return true;
	}
}
