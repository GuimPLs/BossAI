package pl.guimpl.bossfight.komendy;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.guimpl.bossfight.BossFightPlugin;
import pl.guimpl.bossfight.boss.InteligentyBoss;

public class KomendaSpawnBoss implements CommandExecutor {

    private BossFightPlugin plugin;

    public KomendaSpawnBoss(BossFightPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player gracz = (Player) sender;
            InteligentyBoss boss = new InteligentyBoss(gracz.getWorld(), gracz.getLocation());
            gracz.sendMessage("Boss został stworzony!");
            return true;
        }
        sender.sendMessage("Tylko gracze mogą używać tej komendy.");
        return false;
    }
}
