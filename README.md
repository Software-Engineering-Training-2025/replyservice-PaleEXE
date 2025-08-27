[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/EfrimdjR)

# ReplyService

You need to implement one method:

```java
String reply(String message, ReplyType type)
enum ReplyType { FORMAL, FRIENDLY, CONCISE }
```

The method takes a user message and a reply type and returns the correct reply string.

* If `message` is `null`, empty, or only whitespace → return:
  `Please say something.`
* Otherwise, use the canonical mapping below.
* If the input does not match any known message → return the “any other text” mapping.

## Canonical Inputs & Expected Outputs

| Input                             | FORMAL                                                 | FRIENDLY                                        | CONCISE                       |
| --------------------------------- | ------------------------------------------------------ | ----------------------------------------------- | ----------------------------- |
| `hi`                              | `Hello. How may I assist you today?`                   | `Hey there! 😊 How can I help?`                 | `Hello. How can I help?`      |
| `hello`                           | `Hello. How may I assist you today?`                   | `Hi! 👋 What’s up?`                             | `Hello. How can I help?`      |
| `how are you`                     | `I am functioning properly. How may I assist you?`     | `Doing great! 😄 How can I help?`               | `I’m good. How can I help?`   |
| `i need help`                     | `I can assist with that. Please provide more details.` | `I’ve got you! 🙂 Tell me a bit more.`          | `Share details; I’ll help.`   |
| `can you help me with my account` | `Certainly. Please describe the account issue.`        | `Sure thing! 😊 What’s wrong with the account?` | `Describe the account issue…` |
| `thanks`                          | `You are welcome.`                                     | `Anytime! 🙌`                                   | `You’re welcome.`             |
| `bye`                             | `Goodbye.`                                             | `See you later! 👋`                             | `Goodbye.`                    |
| `what is your name`               | `I am your virtual assistant.`                         | `I’m your helper bot 🤖`                        | `I’m your assistant.`         |
| any other text                    | `Could you clarify your request?`                      | `Could you tell me more?`                       | `Please clarify.`             |
| `null`, `""`, whitespace          | `Please say something.`                                | `Please say something.`                         | `Please say something.`       |

---

