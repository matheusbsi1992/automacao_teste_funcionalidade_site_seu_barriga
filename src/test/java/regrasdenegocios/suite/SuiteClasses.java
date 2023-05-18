package regrasdenegocios.suite;


import org.junit.AfterClass;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Suite;
import regrasdenegocios.conta.TestePaginaConta;
import regrasdenegocios.login.TestePaginaLogin;
import regrasdenegocios.movimentacao.TestePaginaMovimentacao;
import regrasdenegocios.resumomensal.TestePaginaResumoMensal;

import static br.com.estudo.real.comunicacao.AcessoComunicacao.getEncerrarNavegadorSessao;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        TestePaginaLogin.class,
        TestePaginaConta.class,
        TestePaginaMovimentacao.class,
        TestePaginaResumoMensal.class
        })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuiteClasses {

        @AfterClass
        public static void finalizaTudo(){
                getEncerrarNavegadorSessao();
        }
}
