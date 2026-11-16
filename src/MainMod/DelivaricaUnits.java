package MainMod;

import arc.Events;
import arc.graphics.Color;
import mindustry.ai.types.FlyingAI;
import mindustry.ai.types.GroundAI;
import mindustry.content.Fx;
import mindustry.entities.bullet.ArtilleryBulletType;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.gen.MechUnit;
import mindustry.gen.UnitEntity;
import mindustry.graphics.Pal;
import mindustry.type.UnitType;
import mindustry.type.Weapon;

public class DelivaricaUnits {
    public static UnitType side, photon, photonArmored, bunch;

    public static void load() {

        // Side
        side = new UnitType("side"){{
            constructor = UnitEntity::create;
            aiController = FlyingAI::new;

            flying = true;
            speed = 2.6f;
            accel = 0.08f;
            drag = 0.04f;
            rotateSpeed = 5f;
            health = 240f;
            armor = 1f;
            hitSize = 11f;
            engineOffset = 6f;
            engineSize = 2.5f;
            outlineColor = Color.valueOf("36363c");

            weapons.add(new Weapon(name + "-w"){{
                reload = 22f;
                x = 4f;
                y = 1f;
                top = false;
                layerOffset = -0.01f;
                mirror = true;
                ejectEffect = Fx.casing1;

                bullet = new BasicBulletType(4.5f, 18){{
                    width = 7f;
                    height = 9f;
                    lifetime = 35f;
                }};
            }});
        }};

        // Photon
        photon = new UnitType("photon"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            flying = false;
            speed = 0.75f;
            hitSize = 11f;
            health = 420f;
            armor = 2f;
            rotateSpeed = 4f;
            outlineColor = Color.valueOf("36363c");

            mechStride = 4.2f;
            mechFrontSway = 0.25f;
            mechSideSway = 0.35f;
            mechStepParticles = true;

            weapons.add(new Weapon(name + "-w"){{
                reload = 35f;
                x = 4.5f;
                y = 0f;
                top = false;
                layerOffset = -0.01f;
                mirror = true;
                alternate = true;
                rotate = false;
                ejectEffect = Fx.casing1;

                bullet = new ArtilleryBulletType(4f, 18, "shell"){{
                    hitEffect = Fx.flakExplosion;
                    knockback = 0.6f;
                    lifetime = 40f;
                    width = height = 6.5f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 14f;
                    splashDamage = 20f;
                    homingPower = 0.08f;
                    homingRange = 50f;
                    backColor = Pal.gray;
                    frontColor = Color.lightGray;
                    trailColor = Pal.gray;
                }};
            }});
        }};

        // Armored photon
        photonArmored = new UnitType("photon-armored"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            flying = false;
            speed = 0.60f;
            hitSize = 11f;
            health = 620f; // 420 + 200 HP
            armor = 5f;
            rotateSpeed = 4f;
            outlineColor = Color.valueOf("36363c");

            mechStride = 4.2f;
            mechFrontSway = 0.25f;
            mechSideSway = 0.35f;
            mechStepParticles = true;

            weapons.add(new Weapon(photon.name + "-w"){{
                reload = 35f;
                x = 4.5f;
                y = 0f;
                top = false;
                layerOffset = -0.01f;
                mirror = true;
                alternate = true;
                rotate = false;
                ejectEffect = Fx.casing1;

                bullet = new ArtilleryBulletType(4f, 18, "shell"){{
                    hitEffect = Fx.flakExplosion;
                    knockback = 0.6f;
                    lifetime = 40f;
                    width = height = 6.5f;
                    collides = true;
                    collidesTiles = true;
                    splashDamageRadius = 14f;
                    splashDamage = 20f;
                    homingPower = 0.08f;
                    homingRange = 50f;
                    backColor = Pal.gray;
                    frontColor = Color.lightGray;
                    trailColor = Pal.gray;
                }};
            }});
        }};

        Events.on(ClientLoadEvent.class, e -> {
            photonArmored.legRegion = photon.legRegion;
            photonArmored.baseRegion = photon.baseRegion;
            photonArmored.cellRegion = photon.cellRegion;
        });

        // Bunch
        bunch = new UnitType("bunch"){{
            constructor = MechUnit::create;
            aiController = GroundAI::new;

            flying = false;
            speed = 0.55f;
            hitSize = 12f;
            health = 950f;
            armor = 6f;
            rotateSpeed = 3f;
            outlineColor = Color.valueOf("36363c");

            mechStride = 5.5f;
            mechFrontSway = 0.3f;
            mechSideSway = 0.4f;
            mechStepParticles = true;

            weapons.add(new Weapon(name + "-w"){{
                reload = 45f;
                x = 6.5f;
                y = 0f;
                top = false;
                layerOffset = -0.01f;
                mirror = true;
                alternate = true;
                rotate = false;
                ejectEffect = Fx.casing2;

                bullet = new BasicBulletType(5.5f, 35){{
                    width = 9f;
                    height = 12f;
                    lifetime = 35f;
                    splashDamageRadius = 16f;
                    splashDamage = 15f;
                    hitEffect = Fx.blastExplosion;
                    backColor = Pal.lightOrange;
                    frontColor = Color.white;
                }};
            }});
        }};
    }
}
