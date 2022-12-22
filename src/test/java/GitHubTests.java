import PageObject.LoginPage;
import PageObject.MainPage;
import PageObject.RepositoryPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import readProperties.ConfigProvider;

public class GitHubTests extends BaseTest{
    private String searchingWord = "b0hdan1/HT_2";
    private String testNgVersion = "<version>7.4.0</version>";
    @Test
    public void isLibraryCurrentVersion() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        RepositoryPage repositoryPage = new RepositoryPage();
        loginPage.signIn(ConfigProvider.LOGIN, ConfigProvider.PASSWORD);
        mainPage.inputSearch(searchingWord);
        repositoryPage.clickOnPomFile();
        repositoryPage.printVersionNumbersToConsole();
        Assert.assertEquals(repositoryPage.getTestNgVersion(), testNgVersion);
    }
}
