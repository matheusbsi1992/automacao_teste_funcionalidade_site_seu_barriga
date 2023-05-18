package br.com.estudo.real.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


import static br.com.estudo.real.comunicacao.AcessoComunicacao.getComunicacaoDriverChrome;

public class DSL  {

    
    public DSL(){

    }

    public void escreve(String idCampo, String valorCampo){
        escreve(By.id(idCampo),valorCampo);
    }

    public void escreve(By by, String valorCampo){
        getComunicacaoDriverChrome()
                .findElement(by)
                .sendKeys(valorCampo);
    }

    public void limparCampo(String idCampo){
       getComunicacaoDriverChrome().findElement(By.id(idCampo))
                .clear();
    }

    public void limparCampo(By by){
        getComunicacaoDriverChrome().findElement(by)
                .clear();
    }


    public String obterValordoCampo(String idCampo){
        String retornoValor=getComunicacaoDriverChrome()
                .findElement(By.id(idCampo))
                .getAttribute("value");
        return retornoValor;
    }

    public String obterValordoCampo(By by){
        String retornoValor=getComunicacaoDriverChrome()
                .findElement(by)
                .getAttribute("value");
        return retornoValor;
    }

    public void clicarRadioButton(String idCampo){
        clicarBotao(idCampo);
    }

    public void isRetornarCorretoIncorretoRadioButton(By by) {
       List<WebElement> nova =getComunicacaoDriverChrome()
                .findElements(by);
       boolean outraAcerto = false;
       outraAcerto=nova.get(0).isSelected();
       if(outraAcerto==true){
            nova.get(0).click();
        }else {
           nova.get(1).click();
       }
    }
    public boolean isRetornarCorretoIncorretoRadioButton(String idCampo) {
        return getComunicacaoDriverChrome()
                .findElement(By.id(idCampo))
                .isSelected();
    }


    public void selecionarComboPrime(String radical,String valor){
        clicarBotao(By.xpath("//*[@id='"+radical+":option_input']/../..//span"));
//        getComunicacaoDriverChrome()Wait wait = new getComunicacaoDriverChrome()Wait(getComunicacaoDriverChrome(), Duration.ofMillis(10000));
//        //wait.until(ExpectedConditions.alertIsPresent());

        clicarBotao(By.xpath("//*[@id='"+radical+":option_items']//li[.='"+valor+"']"));
    }

    public Select selecionarCombo(By by, String valorCampo){
        WebElement webElement = getComunicacaoDriverChrome()
                .findElement(by);
        Select select = new Select(webElement);
        //select.selectByIndex(1);
        select.selectByVisibleText(valorCampo);
        //select.selectByValue(valorCampo);
        return select;
    }

    public Select selecionarCombo(String xPath, String valorCampo){
        WebElement webElement = getComunicacaoDriverChrome()
                .findElement(By.xpath(xPath));
        Select select = new Select(webElement);

        //select.selectByVisibleText(valorCampo);
        select.selectByIndex(2);
        //select.selectByValue(valorCampo);
        return select;
    }

    public boolean isRetornarCombo(String idCampo, String valorCampo){
        return  selecionarCombo(idCampo,valorCampo)
                .getOptions()
                .stream()
                .anyMatch(webElement -> webElement.getText().equalsIgnoreCase(valorCampo));
    }

    public void clicarBotao(By by){
        getComunicacaoDriverChrome().findElement(by).click();
    }

    public void clicarBotao(String idCampo){
       clicarBotao(By.id(idCampo));
    }


    public void clicarLink(String idCampo){
        getComunicacaoDriverChrome().findElement(By.linkText(idCampo)).click();
    }

    public void clicarLink(By by){
        getComunicacaoDriverChrome().findElement(by).click();
    }

    public String obterTexto(By by){
        return getComunicacaoDriverChrome().findElement(by).getText();
    }

    public String obterTexto(String idCampo){
        return obterTexto(By.id(idCampo));
    }

    /**Alertas*/
    public String alertarObterTexto(){
        Alert alert      = getComunicacaoDriverChrome().switchTo().alert();
        String nomeCampo = alert.getText();
        return nomeCampo;
    }

    public String alertarAceitarComTexto(){
        //getComunicacaoDriverChrome()Wait wait = new getComunicacaoDriverChrome()Wait(getComunicacaoDriverChrome(), Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.alertIsPresent());
        String nomeCampo    = null;
            Alert alert     = getComunicacaoDriverChrome().switchTo().alert();
            nomeCampo       = alert.getText();
            alert.accept();
        return nomeCampo;
    }
    public String alertarNegarComTexto(){
        Alert alert      = getComunicacaoDriverChrome().switchTo().alert();
        String nomeCampo = alert.getText();
        alert.dismiss();
        return nomeCampo;
    }

    public void alertarEscrever(String valorCampo){
        Alert alert = getComunicacaoDriverChrome().switchTo().alert();
        alert.sendKeys(valorCampo);
        alert.accept();
    }

    /**Frames e Janelas*/
    public void entrarJanela(String idCampo){
        getComunicacaoDriverChrome().switchTo().frame(idCampo);
    }

    public void sairFrame(){
        getComunicacaoDriverChrome().switchTo().defaultContent();
    }

    public void trocarJanela(String idCampo){
        getComunicacaoDriverChrome().switchTo().window(idCampo);
    }

    //****** JS ********//
    public Object executarJS(String cmd, Object... param){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getComunicacaoDriverChrome();
        return  javascriptExecutor.executeScript(cmd,param);
    }

    //*********** Tabela **********//
    public void clicarBotaoTabela(String idTabela,String colunaTabela,String valor,String colunaBotao){
        //---procurar coluna do registro
        WebElement tabela= getComunicacaoDriverChrome().findElement(By.xpath("//table[@id='"+idTabela+"']//thead//tr"));
        int idColuna     = obterIndiceColuna(colunaTabela, tabela);

        System.out.println(tabela.getText()+ " " +idColuna);

        //---encontrar a linha do registro
        int idLinha       = obterIndiceLinha(valor, tabela, idTabela,idColuna);
        //---procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaBotao,tabela);
        //---clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath("//*[@id='"+idTabela+"']//tr["+idLinha+"]//td["+idColunaBotao+"]"));
        //celula.findElement(By.xpath(".//span")).click();
        celula.findElement(By.cssSelector("span.glyphicon.glyphicon-remove-circle")).click();
    }

    public String reconhecerValorTabela(String idTabela,String colunaTabela,String valor,String colunaValor){
        //---procurar coluna do registro
        WebElement tabela= getComunicacaoDriverChrome().findElement(By.xpath("//table[@id='"+idTabela+"']//thead//tr"));
        int idColuna     = obterIndiceColuna(colunaTabela, tabela);

        System.out.println(tabela.getText()+ " " +idColuna);

        //---encontrar a linha do registro
        int idLinha       = obterIndiceLinha(valor, tabela, idTabela,idColuna);
        //---procurar coluna do botao
        int idColunaBotao = obterIndiceColuna(colunaValor,tabela);
        //---clicar no botao da celula encontrada
        WebElement celula = tabela.findElement(By.xpath("//*[@id='"+idTabela+"']//tr["+idLinha+"]//td["+idColunaBotao+"]"));
        //celula.findElement(By.xpath(".//span")).click();
        return celula.getText();
        //celula.findElement(By.cssSelector("span.glyphicon.glyphicon-remove-circle")).click();
    }


    private static int obterIndiceLinha(String valor,WebElement tabela,String idTabela,int idColuna) {
        ///----Analisar este xPath, para pesquisar a linha correta

        List<WebElement> linhas=new ArrayList<WebElement>();
        //WebElement webElement  =tabela.findElement(By.xpath("//tr["+idLinhaEspecifica+"]//td["+ idColuna +"]"));

        linhas=tabela.findElements(By.xpath("//*[@id='"+idTabela+"']/tbody/tr/td["+idColuna+"]"));

        //System.out.println(webElement.getText());

        //List<WebElement> linhas=new ArrayList<WebElement>();
        //linhas.add(webElement);

        int idLinha=-1;

        for (int i = 0; i < linhas.size(); i++) {
            System.out.println(linhas.get(i).getText());
            if(linhas.get(i).getText().equalsIgnoreCase(valor)){
                idLinha = (i + 1);
                break;
            }
        }
        return idLinha;
    }

    private static int obterIndiceColuna(String colunaTabela, WebElement tabela) {
        List<WebElement> colunas= tabela.findElements(By.xpath(".//th"));

        int idColuna=-1;

        for (int i = 0; i < colunas.size(); i++) {
            System.out.println(colunas.get(i).getText());
            if(colunas.get(i).getText().equalsIgnoreCase(colunaTabela)){
                idColuna = (i + 1);
                break;
            }
        }
        return idColuna;
    }

}