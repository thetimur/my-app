package tech.spbsu.views.bot;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import jakarta.annotation.security.PermitAll;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import tech.spbsu.views.MainLayout;

@PageTitle("Bot")
@Route(value = "bot", layout = MainLayout.class)
@PermitAll
@Uses(Icon.class)
public class BotView extends Composite<VerticalLayout> {

    public BotView() {
        HorizontalLayout layoutRow = new HorizontalLayout();
        MessageInput messageInput = new MessageInput();
        VerticalLayout layoutColumn2 = new VerticalLayout();
        MessageList messageList = new MessageList();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.setHeight("min-content");
        messageInput.getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        messageList.setWidth("100%");
        messageList.getStyle().set("flex-grow", "1");
        setMessageListSampleData(messageList);
        getContent().add(layoutRow);
        layoutRow.add(messageInput);
        getContent().add(layoutColumn2);
        layoutColumn2.add(messageList);
    }

    private void setMessageListSampleData(MessageList messageList) {
        MessageListItem message1 = new MessageListItem("Nature does not hurry, yet everything gets accomplished.",
                LocalDateTime.now().minusDays(1).toInstant(ZoneOffset.UTC), "Matt Mambo");
        message1.setUserColorIndex(1);
        MessageListItem message2 = new MessageListItem(
                "Using your talent, hobby or profession in a way that makes you contribute with something good to this world is truly the way to go.",
                LocalDateTime.now().minusMinutes(55).toInstant(ZoneOffset.UTC), "Linsey Listy");
        message2.setUserColorIndex(2);
        messageList.setItems(message1, message2);
    }
}
