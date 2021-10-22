/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.Notifications;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Mbuso Kotob's
 */
public class Notification {

    String productName;
    int stockLeft;
    LocalTime notificationDateTime;
    
    public Notification()
    {
        productName = "";
        stockLeft = 0;
        notificationDateTime = LocalTime.now();
    }

    public Notification(String productName, int stockLeft)
    {
        this.productName = productName;
        this.stockLeft = stockLeft;
        notificationDateTime = LocalTime.now();
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public int getStockLeft()
    {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft)
    {
        this.stockLeft = stockLeft;
    }

    public LocalTime getNotificationDateTime()
    {
        return notificationDateTime;
    }

    public void setNotificationDateTime(LocalTime notificationDateTime)
    {
        this.notificationDateTime = notificationDateTime;
    }

    @Override
    public String toString()
    {
        return "Notification{" + "productName=" + productName + ", stockLeft=" + stockLeft + ", notificationDateTime=" + notificationDateTime + '}';
    }
     
}
