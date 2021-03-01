package steampunk.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class SItems implements ContentList {
    public static Item wood, stone, clay;

    @Override
    public void load(){
        wood = new Item("wood", Color.brown){{
            hardness = 0;
            cost = 0.2f;
            alwaysUnlocked = true;

        }};
    }
}
