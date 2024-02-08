
import dao.AccountDAO;
import dao.DebtDetailsDAO;
import dao.DebtorDAO;
import model.DebtDetail;
import model.Debtor;
import utils.Hash;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lvhn1
 */
public class test {
    public static void main(String[] args) {
        
        Debtor debtor = new Debtor();
        debtor.setName("John Doe");
        debtor.setAddress("123 Main Street");
        debtor.setPhone("555-1234");
        debtor.setEmail("john.doe@example.com");
        debtor.setTotalDebt(1000.00);
        debtor.setAccountId(2);  // Replace with a valid account ID
        debtor.setCreditorAccountId(2);  // Replace with a valid creditor account ID
        
//        new DebtorDAO().addDebtor(debtor);
        
        DebtDetail debtDetailToAdd = new DebtDetail();
        debtDetailToAdd.setDescription("Sample Description");
        debtDetailToAdd.setDeptType(true);
        debtDetailToAdd.setAmount(100.00);
        debtDetailToAdd.setImage("sample_image.jpg");
        debtDetailToAdd.setDebtor_IdDebtor(1); // Set the debtor ID accordingly
        debtDetailToAdd.setDebtor_account_id(2); // Set the debtor account ID accordingly
        debtDetailToAdd.setInterest_rate_id(1); // Set the interest rate ID accordingly
        
//        new DebtDetailsDAO().addDebtDetail(debtDetailToAdd);

//        System.out.println(new DebtDetailsDAO().deleteDebtDetail(17));
//        System.out.println(new DebtorDAO().getDebtorTotalById(2));
//        System.out.println(new AccountDAO().getAccountById(4));
System.out.println(new Hash().hashPassword("1"));
                
        
    }
}
