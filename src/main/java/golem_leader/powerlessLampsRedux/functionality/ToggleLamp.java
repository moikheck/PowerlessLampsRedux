package golem_leader.powerlessLampsRedux.functionality;

import org.bukkit.block.data.Lightable;
import org.bukkit.block.Block;

public class ToggleLamp {
    public static void toggle (Block block) {
        Lightable lightable = (Lightable) block.getBlockData();
        lightable.setLit(!lightable.isLit());
        block.setBlockData(lightable);
    }

}
