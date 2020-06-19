package io.github._7isenko.selfshooting;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class SelfShooting extends JavaPlugin {
    // How to build: Maven/SelfShooting/Lifecycle/package
    public static Plugin plugin;
    public static Server server;

    @Override
    public void onEnable() {
        plugin = this;
        server = getServer();
        this.getCommand("bows").setExecutor(new BowsCommand());
    }

    @Override
    public void onDisable() {
    }
}