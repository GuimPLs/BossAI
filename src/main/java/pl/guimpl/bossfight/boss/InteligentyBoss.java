package pl.guimpl.bossfight.boss;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

public class InteligentyBoss {

    private LivingEntity bossEntity;
    private BossAI bossAI;

    public InteligentyBoss(World world, Location location) {
        this.bossEntity = (LivingEntity) world.spawnEntity(location, EntityType.WITHER);
        this.bossAI = new BossAI(this);
    }

    public LivingEntity getBossEntity() {
        return bossEntity;
    }

    public void aktualizujAI() {
        bossAI.aktualizuj();
    }

    public void zniszcz() {
        if (bossEntity != null) {
            bossEntity.remove();
        }
    }
}