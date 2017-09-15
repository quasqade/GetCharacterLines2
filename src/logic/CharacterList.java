package logic;

import java.util.ArrayList;
import java.util.List;

public class CharacterList {
    private List charList;

    public CharacterList()
    {
        charList=new ArrayList();
        charList.add(new Character(InternalCharName.NAEGI, "Makoto Naegi"));
        //TODO add others
    }
}
