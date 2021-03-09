package steampunk.content;

import mindustry.ctype.ContentList;

public class ModLoader implements ContentList {
    private final ContentList[] contents = {
            new SItems(),
            new SUnits(),
            new SBlocks()
    };

    public void load(){
        for(ContentList list : contents){
            list.load();
        }
    }
}
