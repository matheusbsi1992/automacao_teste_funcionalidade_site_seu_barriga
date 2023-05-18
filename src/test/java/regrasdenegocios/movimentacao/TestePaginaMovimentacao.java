package regrasdenegocios.movimentacao;

import br.com.estudo.real.core.BaseTest;
import br.com.estudo.real.core.DSL;
import br.com.estudo.real.pages.ContaPage;
import br.com.estudo.real.pages.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePaginaMovimentacao extends BaseTest {

    private MovimentacaoPage movimentacaoPage;
    private DSL dsl;

    @Before
    public void inicializar(){
        dsl = new DSL();
        movimentacaoPage = new MovimentacaoPage();
        BaseTest.nomePasta="TestePaginaMovimentacao";
    }

    @Test
    public void deveTestarOsCamposDeMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();
        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Data da Movimentação é obrigatório",dsl.obterTexto(By.xpath("//li[.='Data da Movimentação é obrigatório']")));
        Assert.assertEquals("Data do pagamento é obrigatório",dsl.obterTexto(By.xpath("//li[.='Data do pagamento é obrigatório']")));
        Assert.assertEquals("Descrição é obrigatório",dsl.obterTexto(By.xpath("//li[.='Descrição é obrigatório']")));
        Assert.assertEquals("Interessado é obrigatório",dsl.obterTexto(By.xpath("//li[.='Interessado é obrigatório']")));
        Assert.assertEquals("Valor é obrigatório",dsl.obterTexto(By.xpath("//li[.='Valor é obrigatório']")));
        Assert.assertEquals("Valor deve ser um número",dsl.obterTexto(By.xpath("//li[.='Valor deve ser um número']")));

    }
    @Test
    public void deveTestarOCampoDeDatadeMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Despesa");
        movimentacaoPage.setMovimentacaoData("data_transacao","15/08/20234");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","Movimento realizado, para o pagamento de conta em aberto.");
        movimentacaoPage.setMovimentacaoInteressado("interessado","Maria Luiza Elena");
        movimentacaoPage.setMovimentacaoValor("valor","250.65");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPendente();

        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Data da Movimentação inválida (DD/MM/YYYY)",dsl.obterTexto(By.xpath("//li[.='Data da Movimentação inválida (DD/MM/YYYY)']")));
        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual",dsl.obterTexto(By.xpath("//li[.='Data da Movimentação deve ser menor ou igual à data atual']")));

    }

    @Test
    public void deveTestarOCampoDeDescricaoMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Despesa");
        movimentacaoPage.setMovimentacaoData("data_transacao","11/05/2023");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","");
        movimentacaoPage.setMovimentacaoInteressado("interessado","Maria Luiza Elena");
        movimentacaoPage.setMovimentacaoValor("valor","250.65");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPendente();

        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Descrição é obrigatório",dsl.obterTexto(By.xpath("//li[.='Descrição é obrigatório']")));

    }

    @Test
    public void deveTestarOCampoDeInteressadoMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Despesa");
        movimentacaoPage.setMovimentacaoData("data_transacao","11/05/2023");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","Pagamento para ser realizado para Maria Luiza");
        movimentacaoPage.setMovimentacaoInteressado("interessado","");
        movimentacaoPage.setMovimentacaoValor("valor","250.65");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPendente();

        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Interessado é obrigatório",dsl.obterTexto(By.xpath("//li[.='Interessado é obrigatório']")));

    }

    @Test
    public void deveTestarOCampoDeValorMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Despesa");
        movimentacaoPage.setMovimentacaoData("data_transacao","11/05/2023");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","Pagamento para ser realizado para Maria Luiza");
        movimentacaoPage.setMovimentacaoInteressado("interessado","Maria Luiza");
        movimentacaoPage.setMovimentacaoValor("valor","");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPendente();

        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Valor é obrigatório",dsl.obterTexto(By.xpath("//li[.='Valor é obrigatório']")));
        Assert.assertEquals("Valor deve ser um número",dsl.obterTexto(By.xpath("//li[.='Valor deve ser um número']")));

    }
    @Test
    public void deveTestarAInsercaoDeMovimentacao(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Receita");
        movimentacaoPage.setMovimentacaoData("data_transacao","12/05/2023");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","Pagamento para ser realizado para Hermógenes José de Andrade");
        movimentacaoPage.setMovimentacaoInteressado("interessado","Hermógenes José de Andrade");
        movimentacaoPage.setMovimentacaoValor("valor","12000.75");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPago();

        movimentacaoPage.botaoDeSalvarMovimentacao();



        Assert.assertEquals("Movimentação adicionada com sucesso!",dsl.obterTexto(By.xpath("//div[.='Movimentação adicionada com sucesso!']")));
    }


    @Test
    public void deveTestarAInsercaoDeMovimentacaoEmHome(){
        movimentacaoPage.botaoDeCriarMovimentacao();

        movimentacaoPage.setMovimentacaoTipo("tipo","Receita");
        movimentacaoPage.setMovimentacaoData("data_transacao","17/05/2023");
        movimentacaoPage.setMovimentacaoDataPagamento("data_pagamento","15/09/2023");
        movimentacaoPage.setMovimentacaoDescricao("descricao","Pagamento para ser realizado para Hermógenes José de Andrade");
        movimentacaoPage.setMovimentacaoInteressado("interessado","Hermógenes José de Andrade");
        movimentacaoPage.setMovimentacaoValor("valor","12000.75");
        movimentacaoPage.setMovimentacaoConta("conta","Conta Nova");
        movimentacaoPage.setPago();

        movimentacaoPage.botaoDeSalvarMovimentacao();

        Assert.assertEquals("Movimentação adicionada com sucesso!",dsl.obterTexto(By.xpath("//div[.='Movimentação adicionada com sucesso!']")));

        movimentacaoPage.clicarBotaoHome();

        String valorRetornado=dsl.reconhecerValorTabela("tabelaSaldo","Conta","Conta Nova","Conta");

        Assert.assertEquals("Conta Nova",valorRetornado);

    }

}