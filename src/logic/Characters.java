package logic;
import java.util.HashMap;
import java.util.Map;

public class Characters {
    private Map<InternalCharName, Character> charList;

    public Characters()
    {
        charList=new HashMap();
        charList.put(InternalCharName.NAEGI, new Character(InternalCharName.NAEGI, "Makoto Naegi"));
        //TODO add others
    }

    public Character get(InternalCharName internalCharName)
    {
        return charList.get(internalCharName);
    }
}
