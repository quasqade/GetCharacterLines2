package logic;
import common.Character;

import java.util.HashMap;
import java.util.Map;

public class Characters {
    private Map<Character, String> charList;

    public Characters()
    {
        charList=new HashMap();
        charList.put(Character.NAEGI, "Makoto Naegi");
        charList.put(Character.ISHIMARU, "Kiyotaka Ishimaru");
        charList.put(Character.TOGAMI, "Byakuya Togami");
        charList.put(Character.OOWADA, "Mondo Oowada");
		charList.put(Character.KUWATA,  "Leon Kuwata");
		charList.put(Character.YAMADA,  "Hifumi Yamada");
		charList.put(Character.HAGAKURE,  "Yasuhiro Hagakure");
		charList.put(Character.MAIZONO, "Sayaka Maizono");
		charList.put(Character.KIRIGIRI,  "Kyouko Kirigiri");
		charList.put(Character.ASAHINA,  "Aoi Asahina");
		charList.put(Character.FUKAWA, "Touko Fukawa");
        //TODO add others
    }

    public String get(Character character)
    {
        return charList.get(character);
    }

    public Character get(String externalName)
	{
		for (Character internalName: Character.values()
			 )
		{
			if (charList.containsKey(internalName))
			if (charList.get(internalName).equals(externalName))
			{
				return internalName;
			}
		}
		return Character.NO_NAME;
	}
}
