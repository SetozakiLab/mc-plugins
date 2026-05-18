package jp.szlab.mcplugins.timekeeper;

import org.bukkit.plugin.java.JavaPlugin;

public class TimeKeeperPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("TimeKeeper has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("TimeKeeper has been disabled.");
    }
}