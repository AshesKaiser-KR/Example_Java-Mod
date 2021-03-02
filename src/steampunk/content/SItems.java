package steampunk.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class SItems implements ContentList {
    public static Item
    //stone age
    wood, stone, dirt, clay,
    //bronze age
    tin, bronze;

    @Override
    public void load(){
        wood = new Item("wood", Color.brown){{
            hardness = 0;
            cost = 0.2f;
            alwaysUnlocked = true;

        }};

        stone = new Item("wood", Color.gray){{
            hardness = 0;
            cost = 0.2f;
            alwaysUnlocked = true;
        }};

        dirt = new Item("dirt", Color.valueOf("9b7653")){{
            hardness = 0;
            cost = 0.1f;
            alwaysUnlocked = true;
        }};

        clay = new Item("clay", Color.lightGray){{
            hardness = 0;
            flammability = 0.3f;
            cost = 0.1f;
            alwaysUnlocked = false;
        }};

        tin = new Item("tin", Color.valueOf("d3d4d5")){{
            hardness = 2;
            cost = 0.3f;
            alwaysUnlocked = false;
        }};

        bronze = new Item("bronze", Color.valueOf("cd7f32")){{
            hardness = 3;
            cost = 0.5f;
        }};

    }
}
