public class Controller {
    public void runController() {
        double userIn = Dialog.doDiag();
        double moms = VAT.doVAT(userIn);
        View.doView(moms,ComputeVATBetterStyleOO.MSG);
    }
}
