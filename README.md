
# Estudo de Caso Automação de Funcionalidades com Selenium WebDriver

Olá, este projeto ajuda a evidenciar o uso de teste de software automatizado ao uso da ferrmaneta Selenium WebDriver.


## Dependências
    
    <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.8.1</version>
    </dependency>
    
    <!-- https://mvnrepository.com/artifact/junit/junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
    </dependency>
    
    <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->

    <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.11.0</version>
    </dependency>



## Como incluir gerar evidências
<b>*</b>Gerando evidências por imagens contidas :
<br>
<b>
--TestePaginaConta
</b>
<br>
<b>
 --TestePaginaLogin
</b>
<br>
<b>
--TestePaginaMovimentacao
</b>
<br>
<b>
--TestePaginaResumoMensal
</b>
<br>
```java
@After
public void finaliza() throws IOException {
    TakesScreenshot screenshot = (TakesScreenshot) getComunicacaoDriverChrome();
    File arquivo = screenshot.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(arquivo,new File(this.nomePasta+File.separator+"screenshot"+File.separator + name.getMethodName() + ".jpg"));

//        if(Propriedades.FINALIZA){
//            getEncerrarNavegadorSessao();
//        }
    }
```
## Padrão de Design utilizados
<b> 
-DSL
</b>
<br>
<b> 
-Page Object
</b>
<br>

## Contato do Autor

- [@Matheus Andrade - Linkedin](https://www.linkedin.com/in/matheus-andrade-5201b0236/)





