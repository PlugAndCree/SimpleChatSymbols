package it.plugandcree.simplechatsymbols;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import it.plugandcree.simplechatsymbols.commands.MainCommand;
import it.plugandcree.simplechatsymbols.config.ConfigProcessor;
import it.plugandcree.simplechatsymbols.config.CustomConfig;
import it.plugandcree.simplechatsymbols.events.PlayerChat;

/**
 * @author Nicola
 *
 */
public class SimpleChatSymbols extends JavaPlugin {
	private static SimpleChatSymbols instance;
	private CustomConfig symbolConfig;
	private CustomConfig langConfig;
	private Map<String, String> symbols;

	@Override
	public void onEnable() {
		instance = this;

		reloadConfig();
		
		new MainCommand().register(this);
		
		getServer().getPluginManager().registerEvents(new PlayerChat(), this);
	
	
	}

	public void reloadConfig() {
		setSymbolConfig(createConfigFile("symbols.yml"));
		setLangConfig(createConfigFile("lang.yml"));

		setSymbols(ConfigProcessor.getSymbols(getSymbolConfig(), "symbols"));
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

	public Map<String, String> getSymbols() {
		return symbols;
	}

	public void setSymbols(Map<String, String> symbols) {
		this.symbols = symbols;
	}
}
