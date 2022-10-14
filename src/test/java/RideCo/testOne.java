package RideCo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class testOne {

    WebDriver driver;
    ExtentReports extent;
    ExtentSparkReporter spark;


    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @BeforeTest
    public void beforeTest(){
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target");
        extent.attachReporter(spark);

    }



    @Test(description = "Input 10")
    void inputTen(){
        driver.get("http://qascreener.rideco.com:8080");
        //Response response = RestAssured.get("");
        //System.out.println(response.getStatusCode());
        WebElement inputNumber = driver.findElement(By.cssSelector("input[name='number']"));
        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        inputNumber.sendKeys("10");
        submit.click();
        List<WebElement> listOne = driver.findElements(By.xpath("(//tt)[1]"));
        String Actual = null;
        for (int i = 0; i < listOne.size(); i++) {
          Actual = listOne.get(i).getText();
        }
        String expected = "2983557137299388795107192986413907782003447359461";

        Assert.assertTrue(Actual.contains(expected));

        System.out.println(Actual);
        System.out.println(expected);
       // response.prettyPrint();
        ExtentTest test = extent.createTest("Input 10");
        test.log(Status.PASS,"For input 10");



    }


    @Test(description = "Input 15")
    void inputFifteen(){
        driver.get("http://qascreener.rideco.com:8080");
        //Response response = RestAssured.get("");
        //System.out.println(response.getStatusCode());
        WebElement inputNumber = driver.findElement(By.cssSelector("input[name='number']"));
        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        inputNumber.sendKeys("15");
        submit.click();
        WebElement output = driver.findElement(By.xpath("(//tt)[1]"));
         String Actual = output.getText();
        String expected = "40545706088984994368247988223015076920717228050";

        Assert.assertTrue(Actual.contains(expected));

        System.out.println(Actual);
        System.out.println(expected);
        // response.prettyPrint();
        ExtentTest test = extent.createTest("Input 15");
        test.log(Status.PASS,"For input 15");


    }


    @Test(description = "Input 1")
    void inputOne(){
        driver.get("http://qascreener.rideco.com:8080");
        //Response response = RestAssured.get("");
        //System.out.println(response.getStatusCode());
        WebElement inputNumber = driver.findElement(By.cssSelector("input[name='number']"));
        WebElement submit = driver.findElement(By.cssSelector("input[value='Submit']"));
        inputNumber.sendKeys("1");
        submit.click();
        WebElement output = driver.findElement(By.xpath("(//tt)[1]"));
        String Actual = output.getText();
        String expected = "3243625888179112696126389";

        Assert.assertFalse(Actual.contains(expected));

        System.out.println(Actual);
        System.out.println(expected);

        ExtentTest test = extent.createTest("Input 1");
        test.log(Status.PASS,"For input 1");



    }

    @AfterTest
    public void afterTest(){
        extent.flush();
    }
















}
