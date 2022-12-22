package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class RepositoryPage extends BasePage{
    public RepositoryPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(), 'pom.xml')]")
    WebElement pomFile;

    @FindBy(xpath = "//td[@id='LC26']")
    WebElement versionOfTestNg;

    @FindBy(xpath = "//td/span[contains(text(), 'artifactId')]/..")
    List<WebElement> libraryNames;

    @FindBy(xpath = "//td/span[contains(text(), 'version')]/..")
    List<WebElement> versionNumbers;

    public void clickOnPomFile() {
        pomFile.click();
    }

    public String getTestNgVersion() {
        return versionOfTestNg.getText().trim();
    }

    public void printVersionNumbersToConsole() {
        ArrayList<String> listOfLibraryNames = new ArrayList<>();
        ArrayList<String> listOfVersionNumbers = new ArrayList<>();
        String tempString = "";
        String deleteWord = "<artifactId>";
        String deleteWord2 = "</artifactId>";
        String deleteWord3 = "<version>";
        String deleteWord4 = "</version>";

        for(WebElement libraryName : libraryNames) {
            tempString = libraryName.getText().trim().replace(deleteWord, "");
            tempString = tempString.replace(deleteWord2, "");
            listOfLibraryNames.add(tempString);
        }

        for(WebElement versionNumber : versionNumbers) {
            tempString = versionNumber.getText().trim().replace(deleteWord3, "");
            tempString = tempString.replace(deleteWord4, "");
            listOfVersionNumbers.add(tempString);
        }

        for(int i = 1; i < listOfLibraryNames.size(); i++){
            System.out.println(listOfLibraryNames.get(i) + " library version is " +listOfVersionNumbers.get(i));
        }
    }

}
