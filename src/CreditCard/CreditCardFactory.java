/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreditCard;

/**
 *
 * @author zofia-px
 */
public class CreditCardFactory {
    
    public TarjetaDeCredito getCreditCardType(int type) {
        switch (type) {
            case 1:
                return new Nacional();
            case 2:
                return new Regional();
            case 3:
                return new Internacional();
            default:
                throw new AssertionError();
        }
    }
}
