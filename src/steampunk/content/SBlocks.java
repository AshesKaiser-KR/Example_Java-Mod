package steampunk.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.GenericSmelter;
import multilib.*;
import multilib.Recipe.*;
import steampunk.world.blocks.heatFactory;

import static mindustry.type.ItemStack.with;

public class SBlocks implements ContentList {
    public static Block
    //production
    formwork, furnace, blastFurnace, shaftFurnace,
    //environment
    soil, stoneFloor, dirt;


    @Override
    public void load() {
        //region production
        formwork = new heatFactory ("formwork", 3){{
            requirements(Category.crafting, with(SItems.wood, 20, SItems.stone, 20, SItems.clay, 10));
            size = 2;
            heatCapacity = 200f;
            isSmelter = true;
            addRecipe(
                    new InputContents (with(SItems.tin, 1, Items.copper, 3)),
                    new OutputContents(with(SItems.bronze, 2)), 60f
            );

            addRecipe(
                    new InputContents(with(SItems.wood, 2)),
                    new OutputContents(with(Items.coal, 1)), 40f
            );

            addRecipe(
                    new InputContents(with(SItems.dirt, 2, Liquids.water, 3)),
                    new OutputContents(with(SItems.clay, 1)), 90f

            );

        }};

    }

}
