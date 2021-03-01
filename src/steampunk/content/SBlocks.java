package steampunk.content;

import mindustry.content.Fx;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericSmelter;

import static mindustry.type.ItemStack.with;

public class SBlocks implements ContentList {
    public static Block
    //production
    formwork, furnace, blastFurnace, shaftFurnace;


    @Override
    public void load() {
        //region production
        formwork = new GenericSmelter ("formwork"){{
            requirements(Category.crafting, with(SItems.wood, 20, SItems.stone, 20, SItems.clay, 10));

            craftEffect = Fx.burning;

        }};

    }

}
