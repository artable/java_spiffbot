package com.mycompany.app;
import com.slack.api.bolt.App;
import com.slack.api.bolt.jetty.SlackAppServer;
import com.mycompany.app.Chat;

public class MyApp {
  public static void main(String[] args) throws Exception {
    App app = new App();
    app.command("/xfer", (req, ctx) -> {
      //load text into chat
      Chat chat = new Chat(req.getPayload().getText());
      chat.parseForXfer();
      //TODO database this stuff
      //Create interfaces for usernames (how slack likes em)
      //event api rather than commands
      System.out.println(chat.xferGoal);
      System.out.println(chat.xferNum);
      return ctx.ack("xfer Recorded");
    });
    
    SlackAppServer server = new SlackAppServer(app);
    server.start();
  }
}