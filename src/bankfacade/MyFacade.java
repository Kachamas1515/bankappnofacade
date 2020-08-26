/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

;

/**
 *
 * @author amam
 */
public class MyFacade {
    private ArrayList<CustomerIf> customers = new ArrayList();
    MyFacade(){
        ArrayList<AccountIf> cust1Accounts = new ArrayList();
        AccountIf account = new BankAccount(11111);
        account.deposit(500);
        cust1Accounts.add(account);
        account = new BankAccount(22222);
        account.deposit(1000);
        cust1Accounts.add(account);
        CustomerIf customer1 = new BankCustomer("A", cust1Accounts);
        customers.add(customer1);

        ArrayList<AccountIf> cust2Accounts = new ArrayList();
        account = new BankAccount(33333);
        account.deposit(500);
        cust2Accounts.add(account);
        account = new BankAccount(44444);
        account.deposit(1000);
        cust2Accounts.add(account);
        CustomerIf customer2 = new BankCustomer("B", cust2Accounts);
        customers.add(customer2);
    }

    public void doDeposit(double amt, CustomerIf cust, int accNo){
        cust.getAccount(accNo).deposit(amt);
    }

    public AccountIf getBankAccount(CustomerIf cust, int accNo){
        return cust.getAccount(accNo);
    }

    public CustomerIf getBankCustomer(String custName){
        for(CustomerIf cus : customers){
            if(cus.getCustomerName().equals(custName)){
               return cus;
            }
        }
        return null;
    }
}