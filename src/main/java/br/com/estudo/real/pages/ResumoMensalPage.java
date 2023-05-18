package br.com.estudo.real.pages;

import br.com.estudo.real.core.DSL;
import org.openqa.selenium.By;

public class ResumoMensalPage {

    private DSL dsl;

    public ResumoMensalPage(){
        dsl = new DSL();
    }

    public void botaoDeResumoMensal(){
        dsl.clicarBotao(By.xpath("//a[.='Resumo Mensal']"));
    }

    public void setMes(String mes,String valorMes){
        dsl.selecionarCombo(By.id(mes),valorMes);
    }

    public void setAno(String ano,String valorMes){
        dsl.selecionarCombo(By.id(ano),valorMes);
    }

    public void acionarBotaodeBusca(){
        dsl.clicarBotao(By.xpath("//form/input"));
    }

}
