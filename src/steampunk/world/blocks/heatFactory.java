package steampunk.world.blocks;

import mindustry.graphics.Pal;
import mindustry.type.ItemStack;
import mindustry.ui.Bar;
import multilib.MultiCrafter;
import multilib.Recipe;

public class heatFactory extends MultiCrafter {
    public float heatCapacity, craftTimescl;
    public heatFactory(String name, Recipe[] recs){
        super(name, recs);
    }

    public heatFactory(String name, int recLen){
        super(name, recLen);
    }

    @Override
    public void setBars(){
        super.setBars();
        bars.add("heat", (heatFactoryBuild entity) -> new Bar ("bar.heat", Pal.lightOrange, () -> entity.heat));
    }

    public class heatFactoryBuild extends MultiCrafterBuild{
        public float heat;

        @Override
        public void updateTile(){
            boolean isheated = false;
            for (Recipe rec : recs) {
                ItemStack[] inputStack = rec.input.items;
                if (items.has(inputStack)) isheated = true;
            }
            if (isheated && heat < heatCapacity) heat += edelta();
        }


    }


}
