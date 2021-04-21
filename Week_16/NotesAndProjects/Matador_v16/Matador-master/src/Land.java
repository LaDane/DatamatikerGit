public class Land extends Property {

    public Land(int id, String label, int cost, int income, int seriesID) {
        super(id, label, cost, income,  seriesID);
    }

    @Override
    public Action getAction(){
      Action a = super.getAction();
      if(owner == Controller.currentPlayer) {
          if (hasMonopoly()) {
              a.setResponseMsg("buy house");
          } else {
              a.setResponseMsg(null);
          }
      }
        return a;
    }

    private boolean hasMonopoly() {
        //todo:
        // Find all properties in series
        // 1. run through all properties,
        // 2.check if the seriesID is identical to this.seriesID,and add those who are to an arrayList
        // 3. Run through this arrayList and check if the owner is the same on all found properties

        for (Property p:Board.all_properties) {
            if (this.seriesID == p.seriesID) {
                if(p.owner != Controller.currentPlayer){
                    return false;
                }
            }
        }
        return true;
    }
}