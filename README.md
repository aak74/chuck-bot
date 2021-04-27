# Telegram Chuck Bot with Apache Camel

This demo shows how easy is to create a chat bot for Telegram using Apache Camel.

Inspired by [this demo](https://github.com/nicolaferraro/camel-k-chuck-bot).

## Create your Bot

Follow the instructions on the [Telegram website to create a new bot](https://core.telegram.org/bots#3-how-do-i-create-a-bot).
Usually the quickest way to do it is to contact directly another Telegram bot that is called **@botfather** from you Telegram client App.

## Set config
Put **authorization token** into src/main/resources/application.properties  

## Playing with the demo

You can open your Telegram chat client and write a message to your bot.

You can send messages to the bot. When you write the word **"chuck"** in one of your message, you'll get a famous quote about **Chuck Norris**.

E.g.

> No one has ever spoken during review of Chuck Norris' code and lived to tell about it.

**NOTE**: we're using a service provided by "The Internet Chuck Norris Database" and we're not responsible for the content it provides. Most of the times we get random funny sentences ;)
