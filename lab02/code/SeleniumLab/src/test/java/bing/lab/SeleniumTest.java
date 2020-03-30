package bing.lab;

import com.li.util.ReadExcel;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SeleniumTest {
    public String userNumber;
    private String passWord;
    private WebDriver driver;
    private InputStream is;
    private ReadExcel reader;
    private List inputs;
    private Logger logger = Logger.getLogger(SeleniumTest.class);

    @Before
    public void setUp(){
        //
//        BasicConfigurator.configure();

        System.setProperty("webdriver.gecko.driver","Tools/geckodriver.exe");
        driver = new FirefoxDriver();
        //读取excel
        File file = new File("E:\\IDEA-workspace\\SeleniumLab\\src\\main\\resources\\bing\\lab\\Selenium+Lab2020.xls");

        try {
            //创建输入流
            is = new FileInputStream(file);
            reader = new ReadExcel();
            inputs = reader.readExcel(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testSelenium(){

        driver.get("http://103.120.226.190/selenium-demo/git-repo");

        logger.info("size:"+inputs.size());
        for(Object row:inputs){
            WebElement user = driver.findElement(By.name("user_number"));
            WebElement  passWord = driver.findElement(By.name("password"));
            WebElement query = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));

            user.sendKeys((String)((List)row).get(0));
            passWord.sendKeys((String)((List)row).get(1));
            query.submit();

            //这里获取的是刷新之前的,需要刷新页面之后在获取内容

            driver.navigate().refresh();
            WebElement result = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
            logger.info(((List)row).get(1)+"-->"+result.getText()+"======:"+((List)row).get(1).equals(result.getText()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    @After
    public void release(){
        if(is != null) try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
    }
}
