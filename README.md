# Overview


This is the bare bones of a slack bot which I am writing for my workplace. We do a flavor of telemarketing. An important part of our culture is congratulating and keeping track of our coworkers successes. This bot will aid leadership and team individuals in doing that.


{Provide a link to your YouTube demonstration.  It should be a 4-5 minute demo of the software running and a walkthrough of the code.  Focus should be on sharing what you learned about the language syntax.}

[Software Demo Video](http://youtube.link.goes.here)

# Development Environment

VS Code
Java (and several built in libraries)
Bolt-Jetty
Maven
Ngrok tunnel
Slack client


# Useful Websites

* [Ngrok Tunnel](https://ngrok.com/)
* [Slack API docs](https://api.slack.com/)

# Future Work
Update bot to use events API to hunt every chat
Flag parser has several common cases where it will break
Link in a database of some kind for records
Create a runtime database/datastructure that tracks various things over time
Create logic for work activities ("spiffs", the namesake of the bot) and add associated flags
Finally, a giant pile of QA error testing before release.