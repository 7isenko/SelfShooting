package io.github._7isenko.selfshooting;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHitListener implements Listener {
    @EventHandler
    public void onHit(ProjectileHitEvent event) {
        Projectile ent = event.getEntity();
        if (ent instanceof Arrow) {
            SelfShooting.server.getScheduler().runTaskLater(SelfShooting.plugin, ent::remove, 20);
        }
    }
}
