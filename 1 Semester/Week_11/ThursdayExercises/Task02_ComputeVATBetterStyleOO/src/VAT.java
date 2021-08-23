public class VAT {
    public static double doVAT(double number){
        double VAT = number / 100 * ComputeVATBetterStyleOO.PRCVAT;
        return VAT;
    }
}
