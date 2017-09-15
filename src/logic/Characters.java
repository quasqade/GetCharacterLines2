package logic;
import java.util.HashMap;
import java.util.Map;

public class Characters {
    private Map<InternalCharName, Character> charList;

    public Characters()
    {
        charList=new HashMap();
        charList.put(InternalCharName.NAEGI, new Character(InternalCharName.NAEGI, "Makoto Naegi"));
        charList.put(InternalCharName.ISHIMARU, new Character(InternalCharName.ISHIMARU, "Kiyotaka Ishimaru"));
        charList.put(InternalCharName.TOGAMI, new Character(InternalCharName.TOGAMI, "Byakuya Togami"));
        charList.put(InternalCharName.OOWADA, new Character(InternalCharName.OOWADA, "Mondo Oowada"));
		charList.put(InternalCharName.KUWATA, new Character(InternalCharName.KUWATA, "Leon Kuwata"));
		charList.put(InternalCharName.YAMADA, new Character(InternalCharName.YAMADA, "Hifumi Yamada"));
		charList.put(InternalCharName.HAGAKURE, new Character(InternalCharName.HAGAKURE, "Yasuhiro Hagakure"));
		charList.put(InternalCharName.MAIZONO, new Character(InternalCharName.MAIZONO, "Sayaka Maizono"));
		charList.put(InternalCharName.KIRIGIRI, new Character(InternalCharName.KIRIGIRI, "Kyouko Kirigiri"));
		charList.put(InternalCharName.ASAHINA, new Character(InternalCharName.ASAHINA, "Aoi Asahina"));
		charList.put(InternalCharName.FUKAWA, new Character(InternalCharName.FUKAWA, "Touko Fukawa"));
        //TODO add others
    }

    public Character get(InternalCharName internalCharName)
    {
        return charList.get(internalCharName);
    }
}
