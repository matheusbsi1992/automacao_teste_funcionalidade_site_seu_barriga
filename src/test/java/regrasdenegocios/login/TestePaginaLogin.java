package regrasdenegocios.login;

import br.com.estudo.real.core.BaseTest;
import br.com.estudo.real.core.DSL;
import br.com.estudo.real.pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import java.io.IOException;

import static br.com.estudo.real.comunicacao.AcessoComunicacao.getComunicacaoDriverChrome;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePaginaLogin extends BaseTest {

    private LoginPage loginPage;
    private DSL dsl;
    @Before
    public void inicializarPaginaLogin(){
        getComunicacaoDriverChrome().get("https://seubarriga.wcaquino.me/login");
        dsl = new DSL();
        loginPage = new LoginPage();
        BaseTest.nomePasta="TestePaginaLogin";
    }


    @Test
    public void deveTestarEmailemBranco(){
        loginPage.setEmail("");
        loginPage.setPassword("123456");
        loginPage.botaoDeLogin();

        Assert.assertEquals("Email é um campo obrigatório",dsl.obterTexto(By.xpath("//div[.='Email é um campo obrigatório']")));
    }
    @Test
    public void deveTestarSenhaemBranco(){
        loginPage.setEmail("matheusbsi1992@gmail.com");
        loginPage.setPassword("");
        loginPage.botaoDeLogin();

        Assert.assertEquals("Senha é um campo obrigatório",dsl.obterTexto(By.xpath("//div[.='Senha é um campo obrigatório']")));
    }
    @Test
    public void deveTestarEmailESenhaemBranco(){
        loginPage.setEmail("");
        loginPage.setPassword("");
        loginPage.botaoDeLogin();

        Assert.assertEquals("Email é um campo obrigatório",dsl.obterTexto(By.xpath("//div[.='Email é um campo obrigatório']")));
        Assert.assertEquals("Senha é um campo obrigatório",dsl.obterTexto(By.xpath("//div[.='Senha é um campo obrigatório']")));
    }

    @Test
    public void deveTestarEmailESenhaComUsuarioInvalido(){
        loginPage.setEmail("matheusbsi1992@gmail.com");
        loginPage.setPassword("123456");
        loginPage.botaoDeLogin();

        Assert.assertEquals("Problemas com o login do usuário",dsl.obterTexto(By.xpath("//div[.='Problemas com o login do usuário']")));
    }

    @Test
    public void deveTestarEmailESenhaComUsuarioValido(){
        loginPage.setEmail("matheusbsi1992@gmail.com");
        loginPage.setPassword("matheusbsi1992@gmail.com");
        loginPage.botaoDeLogin();

        String valorRetornado = dsl.obterTexto(By.xpath("//div[@class='alert alert-success']"));

        Assert.assertEquals(valorRetornado,dsl.obterTexto(By.xpath("//div[@class='alert alert-success']")));
    }


}
