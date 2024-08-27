package pl.guimpl.bossfight;

import org.bukkit.plugin.java.JavaPlugin;
import pl.guimpl.bossfight.komendy.KomendaSpawnBoss;

public class BossFightPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin AI-Controlled Boss Fights został włączony!");
        this.getCommand("spawnBoss").setExecutor(new KomendaSpawnBoss(this));
    }
    @Override
    public void onDisable() {
        getLogger().info("Plugin AI-Controlled Boss Fights został wyłączony.");
    }
}