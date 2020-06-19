package io.github._7isenko.selfshooting;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ShootBowListener implements Listener {
    @EventHandler
    public void onShootEvent(EntityShootBowEvent event) {
        Arrow arrow = (Arrow) event.getProjectile();
        LivingEntity entity = event.getEntity();

        // Main part
        arrow.addPassenger(entity);
        Random random = new Random();
        arrow.setColor(Color.fromRGB(random.nextInt(255), random.nextInt(255), random.nextInt(255)));

        // Bonus part
        arrow.setGlowing(true);
        arrow.setBounce(false);
        arrow.setDamage(0);
        arrow.setKnockbackStrength(0);
        arrow.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);

        // Return player's arrow
        if (entity instanceof Player) {
            Player player = (Player) entity;
            SelfShooting.server.getScheduler().runTaskLater(SelfShooting.plugin, () -> {
                player.getInventory().addItem(new ItemStack(Material.ARROW));
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 10, 1);
            }, 100);
        }
    }

}
