package ATM;


import java.util.*;
public class AtmCli
{
	static void ATM(Scanner scan,int bal,int AccountNo) {
        do{   
            System.out.println("\n" + "Choose 1 for withdrawl");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.println("\n" + "Choose the Operation" +"\n");
            int SelectedOperation = scan.nextInt();
            System.out.println();
                
            switch(SelectedOperation)
            {
            case 1: 
                System.out.println("Enter Money to Withdraw");
                int Moneywithdraw=scan.nextInt();
                bal=Integer.parseInt(FindCustomerAccount.selectaccount(AccountNo));
                if(Moneywithdraw <= bal && Moneywithdraw >0  && Moneywithdraw !=0)
                {
                   bal -= Moneywithdraw;
                   Updatebalance.BalanceUpdate(AccountNo, bal);
                   System.out.println("Ammount Withdraw Successfully" + "\n" + "Please Collect Your Cash...");
                   System.out.println("Your Account Balance is :" + bal);
                }   
                else 
                {
                   if(Moneywithdraw > bal)
                   {
                   System.out.println("Insufficient Balance");
                   }
                   if (Moneywithdraw <0  ||  Moneywithdraw ==0)
                   {
                      System.out.println("Invalid input");
                   }

                }
                break;
                
              case 2: 
            	  System.out.println("Enter Money to be deposited");
                  int MoneyDeposit= scan.nextInt();
                  if (MoneyDeposit >0 && MoneyDeposit !=0)
                  {
                    bal=Integer.parseInt(FindCustomerAccount.selectaccount(AccountNo));
                    bal += MoneyDeposit;
                    InsertCustomerrecord.insertrecord(bal,AccountNo);
                    System.out.println("Your Money has been successfully Deposited :" + bal); 
                    System.out.println("Your Account Balance is :" + bal);
                  }
                  else
                  {
                     System.out.println("Error occour please try again later");

                  }
               break;
              
             

              case 3:
              bal=Integer.parseInt(FindCustomerAccount.selectaccount(AccountNo));
              System.out.println("Balance :" + bal);
            
              break;

              case 4:
              System.out.println("Thank You for Using ATM");
               
              System.exit(0);
            }
        }
        while(true);	
	
	}
public static void main(String args[])
{
    Scanner scan=new Scanner(System.in);
    int bal=0;
    System.out.println("----------------------");
    System.out.println("WELCOME TO ATM MACHINE");
    System.out.println("----------------------" + "\n");
    
    System.out.println("Enter your Account No.");
    int AccountNo=scan.nextInt();

    if(GetAccountInformation.getInformation(AccountNo)) {
    	AtmCli.ATM(scan,bal,AccountNo);
    }else {
    	System.out.println("Invalid Account Number");
        System.out.println("Enter your Account No.");
        AccountNo=scan.nextInt();
    	AtmCli.ATM(scan,bal,AccountNo);
    }

}
}
	