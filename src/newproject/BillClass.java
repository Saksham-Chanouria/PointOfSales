/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newproject;

/**
 *
 * @author sakshamchanouria
 */
public class BillClass {
    String BillId,PhoneNo,AdminGmail,Date_time,Payment_Type,Total;

    public BillClass(String BillId, String PhoneNo, String AdminGmail, String Date_time, String Payment_Type, String Total) {
        this.BillId = BillId;
        this.PhoneNo = PhoneNo;
        this.AdminGmail = AdminGmail;
        this.Date_time = Date_time;
        this.Payment_Type = Payment_Type;
        this.Total = Total;
    }
}
