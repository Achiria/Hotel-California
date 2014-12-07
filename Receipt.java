
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
