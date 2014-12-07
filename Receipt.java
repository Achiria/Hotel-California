/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anthony
 */
public class Receipt
{
    private ReceiptStrategy strategy;
    
    public Receipt(ReceiptStrategy strategy)
    {
        this.strategy = strategy;
    }
    
    public String exectuteStrategy(String currentUser)
    {
        return this.strategy.produce(currentUser);
    }
}
