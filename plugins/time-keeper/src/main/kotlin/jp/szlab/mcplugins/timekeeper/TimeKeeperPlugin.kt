package jp.szlab.mcplugins.timekeeper

import org.bukkit.plugin.java.JavaPlugin

class TimeKeeperPlugin : JavaPlugin() {
    override fun onEnable() {
        logger.info("TimeKeeper has been enabled.")
    }

    override fun onDisable() {
        logger.info("TimeKeeper has been disabled.")
    }
}
