package steampunk.entities.bullet;

import arc.math.geom.Vec2;
import arc.util.Time;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.Bullet;
import mindustry.world.blocks.defense.turrets.Turret;

public class ballisticMissile extends BasicBulletType{
    public float maxDamage = damage * 2;
    public float s, bulletRange;
    public float accelScl = 1;
    public float timer;
    public float ownerTargetVec, ownerTargetX, ownerTargetY;
    public ballisticMissile(float speed, float damage){
        this.speed = speed;
        this.damage = damage;
        hitEffect = Fx.blockExplosionSmoke;
        despawnEffect = Fx.massiveExplosion;
    }

    @Override
    public void update(Bullet b) {
        super.update(b);
        timer += 1f;
        bulletRange = speed * lifetime * (1f - drag);
        if(b.owner() != null && b.owner() instanceof Turret.TurretBuild){
            Vec2 ownerTargetVec = ((Turret.TurretBuild)b.owner()).targetPos;
        }
        if (timer <= 120f){
            b.vel().scl(0.98f * Time.delta);
        }else{
            b.vel().scl(1.035f * Time.delta);
        }

        if (timer >= 360f){
            timer = 0;
        }
    }

    @Override
    public void hit(Bullet b, float x, float y){
        float scl1 = b.vel().len();
        b.damage += Math.min(maxDamage, accelScl * scl1 * scl1);
        super.hit(b,x,y);
    }
}
