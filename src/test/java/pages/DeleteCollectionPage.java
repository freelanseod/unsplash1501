package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeleteCollectionPage {

    public SelenideElement
            titleCollection = $(byText("Test collection")),
            editCollectionButton = $(byCssSelector("a[href*='edit_collection']")),
            deleteCollectionButton = $(byText("Delete Collection")),
            homeButton = $(byTitle("Home — Unsplash")),
            deleteButton = $(byText("Delete"));

    public DeleteCollectionPage() {

    }

    public void clickOnTitleCollectionName(){
        //найти коллекцию
        titleCollection.click();
    }

    public void clickOnEditCollectionButton() {
        //перейти на страницу редактирования
        editCollectionButton.click();
    }

    public void clickOnDeleteCollectionButton(){
        deleteCollectionButton.click();
    }

    public void clickOnAgreeToDeleteButton(){
        deleteButton.click();
    }

    public void checkThatCollectionIsDeleted(String name) {
        open("/@izyaz/collections");
        $(byText(name)).shouldBe(hidden);
        homeButton.click();
    }

}
