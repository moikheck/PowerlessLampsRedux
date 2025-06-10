package golem_leader.powerlessLampsRedux.listeners;
import golem_leader.powerlessLampsRedux.functionality.ToggleLamp;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import golem_leader.powerlessLampsRedux.PowerlessLampsRedux;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Objects;
import java.util.logging.Level;

public class RightClickListener implements Listener {
    private final boolean usesPermissions;
    private final PowerlessLampsRedux main;

    public RightClickListener(PowerlessLampsRedux plugin) {
        main = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        usesPermissions = Objects.equals(plugin.getConfig().getString("uses-permissions"), "true");
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        main.getLogger().log(Level.INFO, p.toString());
        boolean isBlock = event.getAction().equals(Action.RIGHT_CLICK_BLOCK);


        if (event.getHand() == EquipmentSlot.OFF_HAND) {
            main.getLogger().log(Level.INFO, "hand");
            return;
        }
        if (!isBlock || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            return;
        }
        if (event.getClickedBlock() == null) {
            return;
        }
        if (!p.hasPermission("lamp.toggle") && usesPermissions) {
            return;
        }
        if (!p.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            return;
        }
        if (event.getClickedBlock().getBlockData().getMaterial() != Material.REDSTONE_TORCH &&
                event.getClickedBlock().getBlockData().getMaterial() != Material.REDSTONE_LAMP &&
                !event.getClickedBlock().getBlockData().getMaterial().name().contains("copper_bulb")) {
            return;
        }

        ToggleLamp.toggle(p, event.getClickedBlock(), main);

    }
}
