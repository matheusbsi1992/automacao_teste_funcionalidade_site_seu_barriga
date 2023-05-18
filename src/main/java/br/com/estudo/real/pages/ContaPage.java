package br.com.estudo.real.pages;

import br.com.estudo.real.core.DSL;
import org.openqa.selenium.By;

public class ContaPage {

    private DSL dsl;

    public ContaPage(){
        dsl = new DSL();
    }

    public void setNomeConta(String nomeConta){
        dsl.escreve("nome",nomeConta);
    }

    public void botaoDeSalvarConta(){
        dsl.clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public void botaoDeEditarConta(){
        dsl.clicarBotao(By.xpath("//span[@class='glyphicon glyphicon-edit']"));
    }



    public void clicarBotaoContaAdicionar(){
        //nav//ul//a/span
        //span[@class='caret']
        dsl.clicarBotao(By.xpath("//span[@class='caret']"));
        dsl.clicarLink(By.xpath("//a[.='Adicionar']"));
    }
    public void clicarBotaoContaListar(){
        //nav//ul//a/span
        //span[@class='caret']
        dsl.clicarBotao(By.xpath("//span[@class='caret']"));
        dsl.clicarLink(By.xpath("//a[.='Listar']"));
    }
}