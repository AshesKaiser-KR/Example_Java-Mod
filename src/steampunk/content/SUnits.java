package steampunk.content;

import mindustry.content.Fx;
import mindustry.content.StatusEffects;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.BombBulletType;
import mindustry.annotations;
import mindustry.gen.Sounds;
import mindustry.gen.UnitEntity;
import mindustry.gen.Unitc;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.*;

public class SUnits implements ContentList {
    //plane
    public static @EntityDef({Unitc.class}) UnitType bomber;
    //endregion

    @Override
    public void load(){
        //region air attack
        bomber = new UnitType("bomber"){{
            constructor = UnitEntity::create;
            health = 500;
            speed = 2f;
            accel = 0.1f;
            drag = 0.02f;
            flying = true;
            hitSize = 10f;
            targetAir = false;
            engineOffset = 7.5f;
            range = 200f;
            faceTarget = false;
            armor = 3.5f;
            targetFlag = BlockFlag.factory;
            commandLimit = 5;
            circleTarget = true;

            weapons.add(new Weapon(){{
                minShootVelocity = 0.9f;
                x = 3.5f;
                shootY = 0f;
                reload = 11f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                inaccuracy = 10f;
                ignoreRotation = true;
                shootSound = Sounds.boom;
                bullet = new BombBulletType (40f, 35f){{
                    width = 8f;
                    height = 16f;
                    hitEffect = Fx.massiveExplosion;
                    shootEffect = Fx.artilleryTrail;
                    smokeEffect = Fx.rocketSmokeLarge;

                    status = StatusEffects.blasted;
                    statusDuration = 75f;
                }};
            }});
        }};
    }
}
