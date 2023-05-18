package br.com.estudo.real.core;


import br.com.estudo.real.pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


import static br.com.estudo.real.comunicacao.AcessoComunicacao.getComunicacaoDriverChrome;
import static br.com.estudo.real.comunicacao.AcessoComunicacao.getEncerrarNavegadorSessao;

public class BaseTest {
    @Rule
    public TestName name = new TestName();

    private LoginPage loginPage = new LoginPage();

    private DSL dsl = new DSL();

    public static String nomePasta="";

    @Before
    public void acessoValidoParaLogin(){
        getComunicacaoDriverChrome().get("https://seubarriga.wcaquino.me/login");
        loginPage.setEmail("matheusbsi1992@gmail.com");
        loginPage.setPassword("matheusbsi1992@gmail.com");
        loginPage.botaoDeLogin();

        String valorRetornado = dsl.obterTexto(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertEquals(valorRetornado,dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));
    }

    @After
    public void finaliza() throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) getComunicacaoDriverChrome();
        File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(arquivo,new File(this.nomePasta+File.separator+"screenshot"+File.separator + name.getMethodName() + ".jpg"));

//        if(Propriedades.FINALIZA){
//            getEncerrarNavegadorSessao();
//        }
    }

    public  String getNomePasta(){
        return this.nomePasta;
    }

    public void setNomePasta(String nomePasta){
        this.nomePasta= nomePasta;
    }



}
