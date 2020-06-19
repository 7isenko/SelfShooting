package io.github._7isenko.selfshooting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.scoreboard.Team;

public class BowsCommand implements CommandExecutor {
    private static boolean started = false;
    private static ShootBowListener listener;
    private static ArrowHitListener listener2;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!started) {
            listener = new ShootBowListener();
            listener2 = new ArrowHitListener();
            SelfShooting.server.getPluginManager().registerEvents(listener, SelfShooting.plugin);
            SelfShooting.server.getPluginManager().registerEvents(listener2, SelfShooting.plugin);
            started = true;
            SelfShooting.server.broadcastMessage("SelfShooting is on");


        } else {
            EntityShootBowEvent.getHandlerList().unregister(listener);
            EntityShootBowEvent.getHandlerList().unregister(listener2);
            listener = null;
            started = false;
            SelfShooting.server.broadcastMessage("SelfShooting is off");
        }
        return true;
    }
}
