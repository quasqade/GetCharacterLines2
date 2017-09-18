package logic;
import common.Character;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Characters {
    private Map<Character, String> charList;

    public Characters()
    {
        charList=new HashMap();
        charList.put(Character.EVERYBODY, "EVERYONE");
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
		charList.put(Character.OOGAMI, "Sakura Oogami");
		charList.put(Character.CELES, "Celestia Ludenberg");
		charList.put(Character.ENOSHIMA, "Junko Enoshima");
		charList.put(Character.FUJISAKI, "Chihiro Fujisaki");
		charList.put(Character.MONOKUMA, "Monokuma");
		charList.put(Character.ENOSHIMA_REAL, "Junko Enoshima (黒幕)"); //means  mastermind
		charList.put(Character.ALTER_EGO, "Alter Ego");
		charList.put(Character.GENOCIDER, "Genocider Shou");
		charList.put(Character.HEADMASTER, "The Headmaster");
		charList.put(Character.NAEGI_MOTHER, "Naegi's Mother");
		charList.put(Character.NAEGI_FATHER, "Naegi's Father");
		charList.put(Character.NAEGI_SISTER, "Naegi's Little Sister");
		charList.put(Character.ISHIMARU_OOWADA, "Ishimaru + Oowada");
		charList.put(Character.DAIA_OOWADA, "Daia Oowada");
		charList.put(Character.NO_NAME, "???");
		charList.put(Character.NARRATION, "Narration");
    }

    public String get(Character character)
    {
    	if (charList.containsKey(character))
    	return charList.get(character);
    	return character.toString();
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

	public boolean contains (String externalName)
	{
		return charList.containsValue(externalName);
	}

	public List<String> getCharacters()
	{
		List<String> list = new ArrayList<>();
		for (Character character: Character.values()
			 )
		{
			if (charList.containsKey(character))
			{
				list.add(charList.get(character));
			}
			else
			{
				list.add(character.toString());
			}
		}
		return list;
	}
}
