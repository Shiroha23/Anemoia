package com.shiroha23.anemoia.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.player.Player;

public class PhaseEffect extends MobEffect {
    public PhaseEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x3FB9A7);
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity instanceof Player player && !player.isSpectator()) {
            player.noPhysics = true;
            player.setOnGround(false);
            player.fallDistance = 0.0F;
        }
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        super.removeAttributeModifiers(entity, attributes, amplifier);
        if (entity instanceof Player player && !player.isSpectator()) {
            player.noPhysics = false;
        }
    }
}
