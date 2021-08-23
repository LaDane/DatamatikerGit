public class Board {

    static Field[] fields = new Field[40];
    CardDeck actionCards;

    /**
     * Config data bør læses fra en fil, fx csv med flg. (eller lign.) format
     * <p>
     * id, type, label, cost, income
     * 1, Start, Start,0,4000
     * 2, Land, Rødovrevej, 1200, 100
     * 3, Event, Prøv Lykken, 0, 0
     * 4, Land, Hvidovrevej, 1200, 100
     * 5, Tax, Skat, 4000, 0
     * 6, ShipplingLine, Limfjorden A/S , 4000,1000
     */
    public Board() {
        setFields();
        String[] csv = Util.readCsv("cards.csv");
        actionCards = new CardDeck("cards.csv"); // Lykkekort
    }

    /**
     * This method reads a config file and creates a field instance of the right type
     * for each line in that file.
     */
    private static void setFields() {
        String[] config = Util.readFile("config.csv");
        for (int i = 0; i < config.length; i++) {
            String[] fieldData = config[i].split(",");
            int id = Integer.parseInt(fieldData[0].trim());
            String fieldType = fieldData[1].trim();
            String label = fieldData[2].trim();
            int cost = Integer.parseInt(fieldData[3].trim());
            int income = Integer.parseInt(fieldData[4].trim());

            // Instantiate appropriate type according to fieldType
            Field field = null;
            switch (fieldType) {
                case "Start":
                    field = new Start(id, label, income);
                    break;
                case "Land":
                    field = new Land(id, label, cost, income);
                    break;
                case "Event":
                    field = new Event(id, label);
                    break;
                case "Tax":
                    field = new Tax(id, label, cost);
                    break;
                case "ShippingLine":
                    field = new ShippingLine(id, label, cost, income);
                    break;
            }

            fields[id - 1] = field;

        }
    }

    public Field getField(int index) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].id == index) {
                return fields[i];
            }
        } //hvis den ikke finder et felt med det index return null;

        return null;
    }
}
