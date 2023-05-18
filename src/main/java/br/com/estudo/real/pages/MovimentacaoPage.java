package br.com.estudo.real.pages;

import br.com.estudo.real.core.DSL;
import org.openqa.selenium.By;

public class MovimentacaoPage {

    private DSL dsl;

    public MovimentacaoPage(){
        dsl = new DSL();
    }

    public void setMovimentacaoTipo(String idTipoMovimentacao,String tipoMovimentacao){
            dsl.selecionarCombo(By.id(idTipoMovimentacao),tipoMovimentacao);
    }
    public void setMovimentacaoData(String idDataMovimentacao, String dataMovimentacao){
        dsl.escreve(By.id(idDataMovimentacao),dataMovimentacao);
    }
    public void setMovimentacaoDataPagamento(String idDataPagamento, String dataPagamento){
        dsl.escreve(By.id(idDataPagamento),dataPagamento);
    }
    public void setMovimentacaoDescricao(String idDescricao, String descricao){
        dsl.escreve(By.id(idDescricao),descricao);
    }
    public void setMovimentacaoInteressado(String idInteressado, String interessado){
        dsl.escreve(By.id(idInteressado),interessado);
    }
    public void setMovimentacaoValor(String idInteressado, String valorConta){
        dsl.escreve(By.id(idInteressado),valorConta);
    }
    public void setMovimentacaoConta(String idConta,String conta){
        dsl.selecionarCombo(By.id(idConta),conta);
    }
    public void setPago(){
        dsl.clicarBotao(By.cssSelector("input#status_pago"));
    }
    public void setPendente(){
        //dsl.isRetornarCorretoIncorretoRadioButton(("status_pendente"));
        dsl.clicarRadioButton("status_pendente");
    }
    public void botaoDeSalvarMovimentacao(){
        dsl.clicarBotao(By.xpath("//button[.='Salvar']"));
    }

    public void botaoDeCriarMovimentacao(){
        dsl.clicarBotao(By.xpath("//a[.='Criar Movimentação']"));
    }

    public void clicarBotaoHome(){
        dsl.clicarBotao(By.xpath("//a[.='Home']"));
    }


}
