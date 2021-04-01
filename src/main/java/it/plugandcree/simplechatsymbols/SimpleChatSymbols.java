package it.plugandcree.simplechatsymbols;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.simplechatsymbols.config.CustomConfig;

/**
 * @author Nicola
 *
 */
public class SimpleChatSymbols extends JavaPlugin {
	private static SimpleChatSymbols instance;
	private CustomConfig symbolConfig;
	private CustomConfig langConfig;
	
	@Override
	public void onEnable() {
		instance = this;
		
		reloadConfig();
		
	}
	
	public void reloadConfig() {
		setSymbolConfig(createConfigFile("symbols.yml"));
		setLangConfig(createConfigFile("lang.yml"));
	}
	
	private CustomConfig createConfigFile(String name) {
		File fc = new File(getDataFolder(), name);
		if (!fc.exists()) {
			fc.getParentFile().mkdirs();
			saveResource(name, false);
		}

		CustomConfig configFile = new CustomConfig();
		try {
			configFile.load(fc);
			return configFile;
		} catch (IOException | InvalidConfigurationException e) {
			throw new RuntimeException(e);
		}
	}

	public CustomConfig getSymbolConfig() {
		return symbolConfig;
	}

	public void setSymbolConfig(CustomConfig symbolConfig) {
		this.symbolConfig = symbolConfig;
	}

	public CustomConfig getLangConfig() {
		return langConfig;
	}

	public void setLangConfig(CustomConfig langConfig) {
		this.langConfig = langConfig;
	}

	public static SimpleChatSymbols getInstance() {
		return instance;
	}
}
