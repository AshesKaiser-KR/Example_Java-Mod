package steampunk.content;

import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import multilib.*;
import multilib.Recipe.*;
import steampunk.world.blocks.heatFactory;

import static mindustry.type.ItemStack.with;

public class SBlocks implements ContentList {
    public static Block
    //production
    bonfire, formwork, furnace, blastFurnace, shaftFurnace,
    //environment
    soil, stoneFloor, dirt;


    @Override
    public void load() {
        //region environment
        soil = new Floor("soil"){{
            itemDrop = SItems.wood;
            playerUnmineable = false;
            status = StatusEffects.wet;
            statusDuration = 90f;
            speedMultiplier = 0.8f;
        }};

        dirt = new Floor("dirt"){{
            itemDrop = SItems.dirt;
            playerUnmineable = false;
            status = StatusEffects.muddy;
            statusDuration = 120f;
            speedMultiplier = 0.74f;
        }};

        Blocks.stone = new Floor("stone"){{
            itemDrop = SItems.stone;
            playerUnmineable = false;
        }};

        //region production

        bonfire = new MultiCrafter("bonfire", 2){{
            requirements(Category.crafting, with(SItems.wood, 20, SItems.stone, 10));
            size = 2;
            isSmelter = false;
            addRecipe(
                    new InputContents (with(SItems.wood, 2)),
                    new OutputContents(with(Items.coal, 1)), 90f
            );

            addRecipe(
                    new InputContents(with(SItems.dirt, 2)),
                    new OutputContents(with(SItems.clay, 1)), 70f
            );
        }};
        formwork = new heatFactory("formwork", 3){{
            requirements(Category.crafting, with(SItems.wood, 20, SItems.stone, 20, SItems.clay, 10));
            size = 2;
            heatCapacity = 200f;
            craftTimescl = 0.5f;
            craftTime = 120f;
            isSmelter = true;
            addRecipe(
                    new InputContents (with(SItems.tin, 1, Items.copper, 3)),
                    new OutputContents(with(SItems.bronze, 2)), 120f
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
