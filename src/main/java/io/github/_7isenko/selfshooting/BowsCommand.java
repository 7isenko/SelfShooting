package io.github._7isenko.selfshooting;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityShootBowEvent;

public class BowsCommand implements CommandExecutor {
    private static boolean started = false;
    private static ShootBowListener listener;
    private static ArrowHitListener listener2;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!started) {
            if (args.length == 0 || args[0].equals("all"))
                listener = new ShootBowListener(true);
            else if (args[0].equalsIgnoreCase("players"))
                listener = new ShootBowListener(false);
            else return false;

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
