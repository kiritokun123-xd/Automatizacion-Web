package com.nttdata.page;

import org.openqa.selenium.By;

public class LinioLoginPage {

    //Localizadores de elementos
    public static By userInput = By.id("login_form_email");
    public static By passInput = By.id("login_form_password");
    public static By loginButton = By.xpath("//*[@id=\"login-form\"]/form/button");
    public static By productsTitle = By.id("header-profile-user-name");
    public static By bestButton = By.xpath("/html/body/div[4]/main/div[1]/div[1]/div[1]/a[4]");
    public static By productButton = By.xpath("//*[@id=\"catalogue-product-container\"]/div[1]/a[1]");
    public static By carButton = By.xpath("//*[@id=\"buy-now\"]");
    //public static By messageTitle = By.xpath("//*[@id=\"alert-add-to-cart\"]/div/div/div[1]/div/h2[1]");
    public static By messageTitle = By.cssSelector("in");


}
