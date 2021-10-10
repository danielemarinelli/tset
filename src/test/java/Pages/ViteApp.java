package Pages;

import Tests.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ViteApp extends TestBase {

    @FindBy(xpath ="(.//i[@class='fas fa-pencil-alt'])[1]")
    private WebElement pencilIcon;

    @FindBy(xpath =".//span[text()='Baseprice']")
    private WebElement basePrice;

    @FindBy(xpath =".//input[@id='base-value-input']")
    private WebElement priceField;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[1]")
    private WebElement checkFlag;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[2]")
    private WebElement secondCheckFlag;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[3]")
    private WebElement thirdCheckFlag;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[4]")
    private WebElement fourthCheckFlag;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[5]")
    private WebElement fifthCheckFlag;

    @FindBy(xpath ="(.//i[@class='fas fa-check'])[6]")
    private WebElement sixthCheckFlag;

    @FindBy(xpath =".//span[@class='font-bold']")
    private WebElement sumField;

    @FindBy(xpath =".//input[@id='ghost-label-input']")
    private WebElement labelField;

    @FindBy(xpath ="(.//div[@class='text-right'])[2]")
    private WebElement priceDisplayedAlloy_surcharge;

    @FindBy(xpath ="(.//div[@class='text-right'])[3]")
    private WebElement priceDisplayedScrap_surcharge;

    @FindBy(xpath ="(.//div[@class='text-right'])[4]")
    private WebElement priceDisplayedInternal_surcharge;

    @FindBy(xpath ="(.//div[@class='text-right'])[5]")
    private WebElement priceDisplayedExternal_surcharge;

    @FindBy(xpath ="(.//div[@class='text-right'])[6]")
    private WebElement priceDisplayedStorage_surcharge;

    @FindBy(xpath ="(.//i[@class='fas fa-trash-alt'])[4]")
    private WebElement trashInternalSurcharge;

    @FindBy(xpath =".//span[text()='Internal surcharge']")
    private WebElement internalSurcharge;

    @FindBy(xpath =".//input[@id='ghost-value-input']")
    private WebElement spriceField;

    @FindBy(xpath ="(.//i[@class='fas fa-pencil-alt'])[6]")
    private WebElement sixthPencilIcon;

    @FindBy(xpath ="((.//div[@class='flex-grow flex flex-col'])[6]/input)[1]")
    private WebElement sixthLabelField;

    @FindBy(xpath =".//p[@class='inline text-red-800 font-semibold']")
    private WebElement msgWhenShortLabelIcon;

    @FindBy(xpath =".//span[text()='Scrap surcharge']")
    private WebElement scrap;

    @FindBy(xpath ="(.//i[@class='fas fa-pencil-alt'])[3]")
    private WebElement thirdPencilIcon;

    @FindBy(xpath ="(.//div[@class='w-1/3 flex flex-col'])[3]/input")
    private WebElement thirdPrice;

    @FindBy(xpath =".//p[@class='inline text-red-800 font-semibold']")
    private WebElement msgNegativePrice;

    @FindBy(xpath =".//span[text()='Alloy surcharge']")
    private WebElement alloy;

    @FindBy(xpath ="(.//i[@class='fas fa-pencil-alt'])[2]")
    private WebElement secondPencilIcon;

    @FindBy(xpath ="(.//div[@class='w-1/3 flex flex-col'])[2]/input")
    private WebElement secondPrice;

    public ViteApp(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String basePriceModified() throws InterruptedException {
        basePrice.click();
        pencilIcon.click();
        priceField.click();
        priceField.clear();
        priceField.sendKeys("5");
        checkFlag.click();
        Thread.sleep(1500);
        return sumField.getText();
    }

    public String addPricesFromTestData() throws InterruptedException {
        //adding  Alloy surcharge
        labelField.click();
        labelField.clear();
        labelField.sendKeys("Alloy surcharge");
        labelField.sendKeys(Keys.TAB);
        spriceField.clear();
        spriceField.sendKeys("2.15");
        secondCheckFlag.click();
        Thread.sleep(1000);
        Assert.assertEquals(priceDisplayedAlloy_surcharge.getText(),"2.15");
        //adding  Scrap surcharge
        labelField.click();
        labelField.clear();
        labelField.sendKeys("Scrap surcharge");
        labelField.sendKeys(Keys.TAB);
        spriceField.clear();
        spriceField.sendKeys("3.14");
        thirdCheckFlag.click();
        Thread.sleep(1000);
        Assert.assertEquals(priceDisplayedScrap_surcharge.getText(),"3.14");
        //adding Internal surcharge
        labelField.click();
        labelField.clear();
        labelField.sendKeys("Internal surcharge");
        labelField.sendKeys(Keys.TAB);
        spriceField.clear();
        spriceField.sendKeys("0.7658");
        fourthCheckFlag.click();
        Thread.sleep(1000);
        Assert.assertEquals(priceDisplayedInternal_surcharge.getText(),"0.77");
        //adding External surcharge
        labelField.click();
        labelField.clear();
        labelField.sendKeys("External surcharge");
        labelField.sendKeys(Keys.TAB);
        spriceField.clear();
        spriceField.sendKeys("1");
        fifthCheckFlag.click();
        Thread.sleep(1000);
        Assert.assertEquals(priceDisplayedExternal_surcharge.getText(),"1.0");
        //adding Storage surcharge
        labelField.click();
        labelField.clear();
        labelField.sendKeys("Storage surcharge");
        labelField.sendKeys(Keys.TAB);
        spriceField.clear();
        spriceField.sendKeys("0.3");
        sixthCheckFlag.click();
        Thread.sleep(1000);
        Assert.assertEquals(priceDisplayedStorage_surcharge.getText(),"0.3");

        return sumField.getText();
    }

    public String trashButton() throws InterruptedException {
        addPricesFromTestData();
        internalSurcharge.click();
        trashInternalSurcharge.click();
        Thread.sleep(1500);
        return sumField.getText();
    }

    public String changeLabel() throws InterruptedException {
        addPricesFromTestData();
        sixthPencilIcon.click();
        sixthLabelField.clear();
        sixthLabelField.sendKeys("T");
        Thread.sleep(1500);
        return msgWhenShortLabelIcon.getText();
    }

    public String negativePrice() throws InterruptedException {
        addPricesFromTestData();
        scrap.click();
        thirdPencilIcon.click();
        thirdPrice.clear();
        thirdPrice.sendKeys("-2.15");
        Thread.sleep(1500);
        return msgNegativePrice.getText();
    }

    public String newTotalPrice() throws InterruptedException {
        addPricesFromTestData();
        alloy.click();
        secondPencilIcon.click();
        secondPrice.clear();
        secondPrice.sendKeys("1.79");
        secondCheckFlag.click();
        Thread.sleep(1500);
        System.out.println(sumField.getText());
        return sumField.getText();
    }

}
