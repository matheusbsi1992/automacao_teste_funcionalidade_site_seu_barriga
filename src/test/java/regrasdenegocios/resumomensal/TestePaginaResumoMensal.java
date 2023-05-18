package regrasdenegocios.resumomensal;

import br.com.estudo.real.core.BaseTest;
import br.com.estudo.real.core.DSL;
import br.com.estudo.real.pages.ResumoMensalPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestePaginaResumoMensal extends BaseTest {

    private DSL dsl;

    private ResumoMensalPage resumoMensalPage;

    @Before
    public void inicializar(){
        dsl = new DSL();
        resumoMensalPage = new ResumoMensalPage();
        BaseTest.nomePasta="TestePaginaResumoMensal";
    }

    @Test
    public void buscarERemoverResumoMensal(){
        resumoMensalPage.botaoDeResumoMensal();

        resumoMensalPage.setMes("mes","Maio");

        resumoMensalPage.setAno("ano","2023");

        resumoMensalPage.acionarBotaodeBusca();

        dsl.clicarBotaoTabela("tabelaExtrato","Descrição","Pagamento para ser realizado para Hermógenes José de Andrade","Ações");

        Assert.assertEquals("Movimentação removida com sucesso!",dsl.obterTexto(By.xpath("//*[.='Movimentação removida com sucesso!']")));

    }


}