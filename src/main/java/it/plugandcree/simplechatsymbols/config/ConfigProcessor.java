package it.plugandcree.simplechatsymbols.config;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigProcessor {
	public static Map<String, String> getSymbols(YamlConfiguration config, String configLine) {
		Map<String, String> symbols = new HashMap<>();
		ConfigurationSection configSection = config.getConfigurationSection(configLine);
		
		for(String key : configSection.getKeys(false)) {
			symbols.put(String.format("[%s]", key), configSection.getString(key));
		}
		
		return symbols;
	}
}
