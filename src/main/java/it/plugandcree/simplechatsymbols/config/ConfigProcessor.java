package it.plugandcree.simplechatsymbols.config;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import it.plugandcree.simplechatsymbols.SimpleChatSymbols;

public class ConfigProcessor {
	public static Map<String, String> getSymbols(YamlConfiguration config, String configLine) {
		Map<String, String> symbols = new HashMap<>();
		ConfigurationSection configSection = config.getConfigurationSection(configLine);
		CustomConfig lang = SimpleChatSymbols.getInstance().getLangConfig();
		
		
		for(String key : configSection.getKeys(false)) {
			symbols.put(String.format(lang.getRawString("messages.symbol-format"), key), configSection.getString(key));
		}
		
		return symbols;
	}
}
