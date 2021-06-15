package tests;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("selenide_android")
public class SuggestionTest extends TestBase {

  @Test
  @DisplayName("Displaying suggestion in wikipedia android app")
  void searchTest() {
    step("Type search", () -> {
      $(MobileBy.AccessibilityId("Search Wikipedia")).click();
      $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("Selenide");
    });
    step("Verify suggestion", () ->
        $$(MobileBy.id("org.wikipedia.alpha:id/search_suggestion"))
            .shouldHave(texts("Did you mean \"selenium\"?")));
  }
}
