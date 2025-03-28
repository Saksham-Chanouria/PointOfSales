/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newproject;

/**
 *
 * @author sakshamchanouria
 */
public class Products {
    String name;
    String desc;
    String category;
    String quantity;
    int price;
    String photo;
    public Products(String name,String desc,String category,String quantity, int price, String photo) {
        this.name = name;
        this.desc = desc;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.photo = photo;
    }
}
