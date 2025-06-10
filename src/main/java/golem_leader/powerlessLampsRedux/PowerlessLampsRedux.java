package golem_leader.powerlessLampsRedux;

import golem_leader.powerlessLampsRedux.listeners.RightClickListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public final class PowerlessLampsRedux extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.saveDefaultConfig();
        registerListeners();
        getLogger().log(Level.INFO, "PowerlessLampsRedux plugin enabled.");

    }

    private void registerListeners() {
        new RightClickListener(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
