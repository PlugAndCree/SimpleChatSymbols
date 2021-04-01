package it.plugandcree.simplechatsymbols.commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.spigot.libraries.commands.Command;

import it.plugandcree.simplechatsymbols.SimpleChatSymbols;
import it.plugandcree.simplechatsymbols.config.CustomConfig;

public class Help extends Command {

	public Help() {
		super("help", "simplechatsymbols.help", SimpleChatSymbols.getInstance().getLangConfig().noPerm());
	}

	@Override
	public boolean execute(CommandSender sender, org.bukkit.command.Command cmd, List<String> args) {
		CustomConfig lang = SimpleChatSymbols.getInstance().getLangConfig();
		
		sender.sendMessage(lang.getString("messages.help"));
		sender.sendMessage(ChatColor.GRAY + "Version: " + SimpleChatSymbols.getInstance().getDescription().getVersion());
		sender.sendMessage(String.format(lang.getRawString("messages.help-format"), "/simplechatsymbols", "Show the credits"));
		sender.sendMessage(String.format(lang.getRawString("messages.help-format"), "/simplechatsymbols reload", "Reload the plugin"));
		
		return true;
	}
}
