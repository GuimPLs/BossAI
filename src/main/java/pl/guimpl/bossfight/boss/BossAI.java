package pl.guimpl.bossfight.boss;

import org.bukkit.Particle;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class BossAI {

    private InteligentyBoss boss;
    private int aktualnaFaza = 1;

    public BossAI(InteligentyBoss boss) {
        this.boss = boss;
    }

    public void aktualizuj() {
        LivingEntity bossEntity = boss.getBossEntity();

        if (bossEntity.getHealth() <= bossEntity.getMaxHealth() * 0.5 && aktualnaFaza == 1) {
            zmienFaze(2);
        }

        if (bossEntity.getHealth() <= bossEntity.getMaxHealth() * 0.2 && aktualnaFaza == 2) {
            zmienFaze(3);
        }

        if (Math.random() < 0.1) {
            wykonajSpecjalnyAtak();
        }
    }

    private void zmienFaze(int nowaFaza) {
        aktualnaFaza = nowaFaza;
        boss.getBossEntity().setCustomName("Faza " + aktualnaFaza + " - Wściekły Boss");
        if (nowaFaza == 2) {
            boss.getBossEntity().setHealth(boss.getBossEntity().getMaxHealth() * 0.7);
        } else if (nowaFaza == 3) {
            boss.getBossEntity().setHealth(boss.getBossEntity().getMaxHealth() * 0.5);
            wykonajSpecjalnyAtak();
        }
    }

    private void wykonajSpecjalnyAtak() {
        double losowaWartosc = Math.random();

        if (losowaWartosc < 0.4) {
            boss.getBossEntity().getWorld().createExplosion(boss.getBossEntity().getLocation(), 4F);
        } else if (losowaWartosc < 0.7) {
            przywolajMiniony();
        } else {
            stworzenieTrujacegoObloku();
        }
    }

    private void przywolajMiniony() {
        for (int i = 0; i < 3; i++) {
            boss.getBossEntity().getWorld().spawnEntity(boss.getBossEntity().getLocation(), EntityType.ZOMBIE);
        }
    }

    private void stworzenieTrujacegoObloku() {
        boss.getBossEntity().getWorld().spawnParticle(Particle.SPELL_MOB, boss.getBossEntity().getLocation(), 100);
    }

    public void analizujGracza(Player gracz) {
        if (gracz.isBlocking()) {
            wykonajSpecjalnyAtak();
        }

        if (gracz.getHealth() < gracz.getMaxHealth() * 0.3) {
            boss.getBossEntity().getWorld().strikeLightning(gracz.getLocation());
        }
    }
}