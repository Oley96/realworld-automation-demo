package io.demo.realworld.pageobjects.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import io.demo.realworld.pageobjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage extends Page {

    private final SelenideElement followButton = $("follow-btn button");

    @Step("Click follow button")
    public ProfilePage clickFollowButton() {
        followButton.click();
        return this;
    }

    @Step("Verify following")
    public ProfilePage verifyFollowing() {
        followButton.shouldHave(text("Unfollow"));
        return this;
    }

    @Step("Verify unfollowing")
    public ProfilePage verifyUnfollowing() {
        followButton.shouldHave(text("Follow"));
        return this;
    }

    @Step("Click to edit profile button")
    public ProfilePage clickToEditProfile() {
        $(Selectors.byText("Edit Profile Settings")).click();
        return this;
    }

    @Step("Verify bio is {bio}")
    public ProfilePage verifyBioEquals(String bio) {
        $("[ng-bind*='profile.bio']").shouldHave(text(bio));
        return this;
    }
}
