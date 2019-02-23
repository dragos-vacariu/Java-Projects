/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project25;

public class Product {
    private String name;
    private double Price;
    public Product(String NewName, double NewPrice)
    {
        this.name = NewName;
        this.Price = NewPrice;
    }
    //Getters:
    public String GetName()
    {
        return this.name;
    }
    public double GetPrice()
    {
        return this.Price;
    }
    public String GetType()
    {
        return "Product";
    }
}
