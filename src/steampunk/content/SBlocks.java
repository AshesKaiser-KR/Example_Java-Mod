package steampunk.content;

import arc.struct.Seq;
import mindustry.content.Bullets;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.world.blocks.distribution.StackConveyor;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.units.UnitFactory;
import steampunk.content.SBullets.*;
import arc.graphics.Color;

import static mindustry.type.ItemStack.with;

public class SBlocks implements ContentList {
    public static Block railWay, woodenBlocka, woodenBlockb, pollutedGrass, airBase, RadarMissile;


    @Override
    public void load() {
        railWay = new StackConveyor("railWay"){{
            health = 50;
            size = 1;
            speed = 4f / 45f;
            itemCapacity = 20;
            requirements(Category.distribution, with(Items.copper, 10));
        }};

        woodenBlocka = new Floor("woodenBlocka"){{
            variants = 0;
        }};

        woodenBlockb = new Floor("woodenBlockb"){{
            variants = 0;
        }};

        pollutedGrass = new Floor("pollutedGrass"){{
            variants = 0;
        }};

        RadarMissile = new ItemTurret("radar-missile"){{
            requirements(Category.turret, with(Items.copper, 250, Items.lead, 150, Items.titanium, 80, Items.silicon, 70));
            ammo(
                    Items.copper, SBullets.basicMissile,
                    Items.blastCompound, SBullets.basicMissile
            );
            range = 1500f;
            itemCapacity = 20;
            chargeTime = 40f;
            chargeMaxDelay = 30f;
            chargeEffects = 5;
            recoilAmount = 4f;
            reloadTime = 180f;
            cooldown = 0.05f;
            shootShake = 4f;
            shootEffect = Fx.blastsmoke;
            smokeEffect = Fx.none;
            chargeEffect = Fx.blastsmoke;
            heatColor = Color.crimson;
            size = 3;
            hasItems = true;
            health = 340 * size * size;
            targetAir = false;
            shootSound = Sounds.missile;

            acceptCoolant = false;

        }};

        airBase = new UnitFactory ("airBase"){{
            requirements(Category.units, with(Items.copper, 150, Items.lead, 80, Items.silicon, 100));
            plans = Seq.with(
                    new UnitPlan(SUnits.bomber, 60f * 15, with(Items.silicon, 15))
            );
            size = 3;
            consumes.power(2f);
        }};

        //endregion
    }
}
