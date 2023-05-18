package regrasdenegocios.conta;

import br.com.estudo.real.core.BaseTest;
import br.com.estudo.real.core.DSL;
import br.com.estudo.real.pages.ContaPage;

import org.junit.*;
import org.junit.runners.MethodSorters;

import org.openqa.selenium.By;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePaginaConta extends BaseTest {

    private ContaPage contaPage;
    private DSL dsl;

    @Before
    public void inicializar(){
        dsl = new DSL();
        contaPage = new ContaPage();
        //acessa pagina da conta
        //getComunicacaoDriverChrome().get("https://seubarriga.wcaquino.me/addConta");
        BaseTest.nomePasta="TestePaginaConta";
        //contaPage.clicarBotaoContaAdicionar();
    }

    @Test
    public void deveTestarAInserirContaComNomeEmBranco(){
        contaPage.clicarBotaoContaAdicionar();
        contaPage.setNomeConta("");
        contaPage.botaoDeSalvarConta();

        Assert.assertEquals("Informe o nome da conta",dsl.obterTexto(By.xpath("//div[.='Informe o nome da conta']")));
    }

    @Test
    public void deveTestarAInserirConta(){
        contaPage.clicarBotaoContaAdicionar();
        contaPage.setNomeConta("Conta Movida Nova");
        contaPage.botaoDeSalvarConta();

        Assert.assertEquals("Conta adicionada com sucesso!",dsl.obterTexto(By.xpath("//div[.='Conta adicionada com sucesso!']")));
    }

    @Test
    public void deveTestarAInserirMesmaConta(){
        contaPage.clicarBotaoContaAdicionar();

        contaPage.setNomeConta("Conta Principal");
        contaPage.botaoDeSalvarConta();

        Assert.assertEquals("Já existe uma conta com esse nome!",dsl.obterTexto(By.xpath("//div[.='Já existe uma conta com esse nome!']")));
    }


    @Test
    public void deveTestarEditarConta(){
        contaPage.clicarBotaoContaListar();
        contaPage.botaoDeEditarConta();

        dsl.limparCampo("nome");
        contaPage.setNomeConta("Conta única");
        contaPage.botaoDeSalvarConta();

        Assert.assertEquals("Conta alterada com sucesso!",dsl.obterTexto(By.xpath("//div[.='Conta alterada com sucesso!']")));
    }

    @Test
    public void deveTestarRemoverConta(){
        contaPage.clicarBotaoContaListar();
        dsl.clicarBotaoTabela("tabelaContas","Conta","Conta Nova","Ações");

        Assert.assertEquals("Conta em uso na movimentações",dsl.obterTexto(By.xpath("//div[.='Conta em uso na movimentações']")));
    }





}
