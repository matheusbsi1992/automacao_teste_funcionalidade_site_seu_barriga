package br.com.estudo.real.pages;

import br.com.estudo.real.core.DSL;
import org.openqa.selenium.By;

public class LoginPage {

   public void setEmail(String nomeEmail){
    dsl.escreve("email",nomeEmail);
   }

   public void setPassword(String password){
       dsl.escreve("senha",password);
   }

   public void botaoDeLogin(){
       dsl.clicarBotao(By.xpath("//button[.='Entrar']"));
   }

    private DSL dsl;

    public LoginPage(){
        dsl = new DSL();
    }




}
