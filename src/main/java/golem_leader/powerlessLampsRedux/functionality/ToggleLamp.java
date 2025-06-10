package golem_leader.powerlessLampsRedux.functionality;

import golem_leader.powerlessLampsRedux.PowerlessLampsRedux;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.block.Block;

import java.util.logging.Level;

public class ToggleLamp {
    public static void toggle (Player player, Block block, PowerlessLampsRedux main) {
        Lightable lightable = (Lightable) block.getBlockData();

        if (lightable.isLit()) {
            main.getLogger().log(Level.INFO, "lit");
        } else {
            main.getLogger().log(Level.INFO, "nyet");
        }
        lightable.setLit(!lightable.isLit());
        block.setBlockData(lightable);
    }

}
