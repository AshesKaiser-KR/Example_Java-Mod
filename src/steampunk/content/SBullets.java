package steampunk.content;

import steampunk.entities.bullet.ballisticMissile;
import mindustry.content.Fx;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.*;
import mindustry.gen.Sounds;
public class SBullets implements ContentList {
    public static BulletType basicMissile;

    @Override
    public void load(){
        basicMissile = new ballisticMissile (2f, 200){{
            shrinkY = 0f;
            width = 4f;
            height = 14f;
            hitSound = Sounds.explosion;
            lifetime = 360f;
            pierceBuilding = true;
            pierceCap = 10;
            maxDamage = damage * 5;
            shootEffect = Fx.missileTrail;
            collides = true;
            accelScl = 0.3f;
            splashDamage = 50;
            splashDamageRadius = 30f;
        }};
    }
}
