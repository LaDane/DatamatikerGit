import java.util.ArrayList;

public class Board {

    static Field[] fields = new Field[40];
    CardDeck actionCards;
    protected static ArrayList<Property> all_properties = new ArrayList();

    /**
     * Config data læses fra en fil
     */
    public Board(String [] fields) {
        setFields(fields);
    }
   public void setCards( String [] cards){
        actionCards = new CardDeck(cards);
   }
    /**
     * This method reads a config file and creates a field instance of the right type
     * for each line in that file.
     */
    private static void setFields(String [] config) {

        for (int i = 0; i < config.length; i++) {
            String[] fieldData = config[i].split(",");
            int id = Integer.parseInt(fieldData[0].trim());
            String fieldType = fieldData[1].trim();
            String label = fieldData[2].trim();
            int cost = Integer.parseInt(fieldData[3].trim());
            int income = Integer.parseInt(fieldData[4].trim());
            int seriesID = Integer.parseInt(fieldData[5].trim());

            // Instantiate appropriate type according to fieldType
            Field field = null;
            switch (fieldType) {
                case "Start":
                    field = new Start(id, label, income);
                    break;
                case "Land":
                    field = new Land(id, label, cost, income,seriesID);
                    all_properties.add((Property)field);
                    break;
                case "Brewery":
                    field = new Business(id, label, cost, income,seriesID);
                    all_properties.add((Property)field);
                    break;
                case "Event":
                    field = new Event(id, label);
                    break;
                case "Tax":
                    field = new Tax(id, label, cost);
                    break;
                case "Shippingline":
                    field = new Business(id, label, cost, income,seriesID);
                    all_properties.add((Property)field);
                    break;
                case "Jail":
                     field = new Consequence(id, label);
                    break;
                case "Parkering":
                    field = new Tax(id, label, cost);
                    break;

            }
            fields[id - 1] = field;
        }
    }

    public Field getField(int index) {
        if(fields[index-1]!= null){
            return fields[index-1];
        }
       return null;
      /*  for (int i = 0; i < fields.length; i++) {
            if (fields[i].id == index) {
                return fields[i];
            }
        }
         //hvis den ikke finder et felt med det index return null;
       */


    }
}
