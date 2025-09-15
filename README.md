# Architecture Template (MVVM)

An example app that should be maintained by relevant updates of architecture.

## Overview

MVVM is a design pattern that follows the principle of separation of concerns, meaning each component of an app has a specific role and responsibility, and does not depend on or interfere with other components. This pattern consists of three layers: the model, the view, and the view model.

## Functional Layers

This example template contains several root-level functional layers that are used to define what the application itself does:

- **dummy**
  - remote data implementation, api-specific interfaces: Retrofit services, Request parameters, Response (JSON transport) objects
- **assay**
  - remote data implementation, parse (in order to use parse please switch to parse branch)
- **product**
  - an example implementation of some features of the current architecture
- **repositories**
  - repositories module
- **services**
  - services module

## Architectural Layers

The architectural layers are transversal subsections of a given functional layer that organize their layer into technical roles:

- **data**
  - business objects, data sources, and repositories go here
- **domain**
  - business logic: Actions, Results, Processors, Reducers
- **presentation**
  - view-specific implementations: Activities, Fragments, ViewModels, ListAdapters, Views, etc...


## MVVM Diagram

To have a general view of the architecture please take a look at the links below.

[MVVM architecture general description](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=mvvm_view_custom.drawio#R7V1Zc9o6G%2F41mem5IOMdfJmlSdqmbZqcr8u5OaOCADcG%2BdiiCf31n2xkY0vCC3gFdzJTJOQFPY9evZukM%2FVq8XrrAmf%2BEU2gfaZIk9cz9fpMIf9Mnfzn16zDGsnY1Mxca7Kpk7cVT9YfSCslWruyJtBLNMQI2dhykpVjtFzCMU7UAddFL8lmU2Qnn%2BqAGeQqnsbA5mu%2FWRM839SOlOG2%2Fg5as3n4ZNkwN98sQNiY%2FhJvDiboJValvj1Tr1yE8ObT4vUK2n7vhf3y7d36m33%2FbNy%2B%2F%2BL9B%2F53%2BeHvT18Hm5vdFLkk%2BgkuXOK9b%2F3neXpz91X79d15uPnyIt1e%2FHw%2FoJdIv4G9ov01WS0Wa%2FqD8TrsRe%2FFWthgSUqXU7TET%2FQbiZSBbc2W5POYvBx0ScVv6GKLAHBBv8DIIbXjuWVP7sEarfyf4GEwfg5Ll3PkWn%2FIbYFNvpJJBfnaxZRLipFo8eRfSR%2FtQo%2B0eQj7RY6q7oGHaZsxsm3geNbP4IX9JgvgzqzlJcIYLcIbodVyAie0FAEdFLCLniPq%2BNfnRIOi5vcGfI1xkaJzC9ECYpd0tRQNNooGHWpyWH7Z8lYe0rp5nLMjWgnoWJlF944e90jGFljOSCdsn6cyz9MEzzMEz1OM5OOATYBfAgwv%2FW704iwkH2I%2FdVsVcLMAT2WOp2ACHJ9vLFNJZ%2BMYK204xTs56TlgbC1n90Gba21b80h%2FrF%2BFyLVTO%2BDD3JpM4DLgCwYY%2FIzGgIOsJQ56Q78kf6TPrqRz%2FUwnL3RFyvK2TP785i6%2BQktCLWAFHIKEry%2FQ56yAXakDN5td6yRoWWRiwY1zKYFqUQgVXtSQPjw6%2FFJEyRwvbPqxKpR1pWGUVQ7la39CeYLub2sMe7RLRXs4qg%2Fte2%2F9%2FWqkX48HwLu7mN4s3OFzOKZjgMIJ0b5okfTbHM3QEthvt7VMl23b3CMf5WCG%2FQUxXtPpH6ww2vam%2Fy18tfD32Ocf%2Fq0IXpvS9Su9c1BYh4Ul%2BbnRRX4hdpVf3F4WlNZ7IeehlTuGKe2oMk20mxmk95sMvzy4f38yZ6v56vOP2cOXd8Z1eD%2B%2FM1N54EIbYOt3UtVN0QIefOZvNQBd26EBhLfYvCi9asuVC9cF61gzOqB2PkcxmefIw6SqmtVeUxmqbt6gVBVD5yTXHbQd6N6j2azXM3LLJFnS6hNKaYMnBuQniF%2BQ%2B0ys25UN3zyTTvTtu6D0Vw9sXmDVnOZIZbqFwQHrQgd5FibGIfQ4IHubtX6bVR3mtCFlWcmcrQQ2q8zYrOqovTbrkKOrtXBsnqcnInCM3NxKsVjzQFuavBlxADoumTTG%2BOggLNWMKQy0yGitCmihGcMbrY%2FhxLLeKA094qUiLjJcax3aMi%2BcqeNb2uVY7NWJ6tUJbZSc3vWcU4Ap7ebJbmVC1zvkAOcno%2FdPnz%2BRmovTdoRHI7k7eoVs7sLy7SuGS88iPXJ0cJY64RQHvU4dQ%2BiV4CNY4YQjDIP0s031s43BzjY5xb9xTLONkKwKR1YXLhCGG7dZkCKCpruo23VJxdMtdUC3ct4RmjkSB1XbozWxAM2P%2BHe5ozVpgiIzWhOmK8WiNamzUcnhmqJRFk3VkwJGN%2BOUyWyvSanNdUNKaX5wTEbIWLlnbCHGKjxj02RXw4Q1GEbJIz2VgWx7NZ2ww9Tm1RBWE0yc8RCFtMuD2Ot71et7QzZYYeTUwI4rWCEkLh%2F9PpVgReo47o5yxwdHtz7shz5sUQHkjYcteB82B%2Fk7Moh72EuFvc7YhfCNeU8wo2OIJXevYdQQv2BVzrzpEKEsOV4Fg%2Fd5xxODj1lc5RREo9xka4vKEWrFvXl%2Bls88pxN23DxPo0J55vlhMKs9zIVgHuWEWSsb5v28MEPGr6dmeGGY9mqG33AkpbavyHGodY6zB69MOIizak7Omu0STbzV620Uil7%2FbSQdWE6OdT1vjPMEPGyilDOicr4JAqq%2B2TZFrs9Yyt9TWJiQPqY7pAjzJnnSriHfvbF82TIF4yNcclKqQ6Y4%2Fo074pTuGUK1aRupAyZT3WhHZN1kAkeGlK4is%2B01Xa5e5VX4LPY%2B2NgeVWggmzkXRkZKzVFs5yHmKh8nP5FUsvSh28rdPMSvzAeMJ2gB%2FJW1R4ZhqcpNcaTr3NFD%2FMq8je0QuUx%2BJ5lxUY93yXg3v6cHb8xQK%2BZIl8JVBmWtWyGIFzbyeyFEOmG%2F7qCxKLGeRzUcCYiy38qDLmmGKr9OxkaEY2fblQdgOQne09%2BchXwY28DzBP7eExFL0RA%2FSHcUka06qcTrjjGpJNYie7lUf35sfrl0AiaryqvBVC0i%2F42h5%2Fne%2BxMVQXpuprVGBPHBGBbNU85FKo6oyEytF9GdZssj9Fb28SU%2FVwalyAKtF0o%2BV5BCSeZefLIGaHEkhQZorVCGE3qHImPSuSErZ7Ho2EA6l6SoZkeALCg9QNci%2FeYroVVEzUKveWbULFSrWpKlo%2FXLOAsCLdgnNlUkNJ1COGINByV96TF3gUIT9nYmEbLRNOaCilZzKtxEtDVUU53gvblavblqGnubq%2FvtF9Ulc1XjswE%2BEs3jYkykgIX5Az5ORIeKRnR3TFWNj5VTbfh0dv4qCcvGjVSN93xSLG9cMFvA5cmaqcXBbNxM1XZ6BG9Wtt0DWhTQFlirO72C7xZgBnt5WxRR0ZbxtSKqd8%2F%2FcHBmbip4mbanlnv1GsWsYdtTYc8wMdJNT6598iySagxJvXsekM7QsB0uEIXd3TGLhkx7s4YM8VD97VlYPgvVdrBwVJCFTHvVrJ6F2s5A3VcLvtATaHsNK6eGJdohvV6d2eycUGnYuW%2FklSlKK2TKUGLdrFLiNLbsC%2FR0376pHtg%2BK3ggS2zCZS3RA73RfTOkfUZGs6sCc8%2B2Srs2SNF5D%2B2F43Dg9zGh6mNCA5ULCol2dT%2FRZXc6734OWPIBZa%2Fb2knNBdGfAtHVYcUrGsGlL8CLnJrlS51GFa%2B9phfp3DSN5BTjH%2B26R2ZNUqJoUc0VspEbdIYqSaYpVaG%2F5Z2l9JZ4Jlh1bJhx%2BC6v79VgFRqNOmrrUJbqoWzaibhdYazMHP%2BsGOkGB9t%2BMFRqIGyjLt39CHsuKQxph6rWMfGbd6Oy8rmcd7bGH7XLy7uJ8Rk77rX33%2B0%2FuvZBcCj1g4t%2BwSCT7MIlij0mn1cun9zcWw01WA0y6yDQch8NMNzLalCZKJRw47I8S4XLtRqE1N1xctkb4HmBWN%2FsW0ZQ8Y5wayuecqnDu5V7lgnfWOFQPdbDjauCsM5tx4RvzKd4JjeC73Fs3Yb%2Bwjfm3Yc7NzHtMSyQO1YriLxrbYUt2%2BohPChZrFYIDQ6rDkQyjciA21wpSaN9LLpiqnXcSkvTGTOPTix9odp%2BDochq%2F4riXSczAsytkBXwz1Nhc0P9k8IERh2kcwJKmfQuGTGKjxjU7eBaolfYdTDXAhmgftIKJjakdzK7m8%2BUDMSurgN0ZUMycQezqDUIJr6jKFinM277FtuB2nZtb2qlu6%2BZ09hl9Mpq5ip7Q%2Bm7Ed38F1SHy8m19dT5%2BPl8%2BDfz%2F928OjsZlN58ua4qdVs8M3LRZZl7ArgzZvSq7ZsKiyw2bxuTUnfKpy7YJClTLKbixe%2FgFmdX82I6WB4rNERk%2FdssLrUT1J0EcJxUrjAmW%2Fys9W3%2Fwc%3D)

[MVVM Workflow](https://www.google.com/search?sca_esv=563961401&sxsrf=AB5stBjyTPY8vj1KyX3rh4PxWk9fUpUIhQ:1694250959614&q=mvvm+android&tbm=isch&source=lnms&sa=X&ved=2ahUKEwj0uO7UmJ2BAxXzKhAIHZ5uBbUQ0pQJegQIChAB&biw=2560&bih=1298&dpr=1)

[Repository And Processor](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=Untitled%20Diagram.drawio#R3VrJcqMwEP0aH%2B2yBHg5JrYzc4hnUklVMjnKoIBSgCghb%2Fn6ESAWIewsToztU6JG3aDX%2FVqtljvGJNj8Yijy5tTBfgf2nU3HmHYgBCboiz%2BJZJtJRqNhJnAZceSkUvBA3rAUSj13SRwcKxM5pT4nkSq0aRhimysyxBhdq9NeqK%2B%2BNUIu1gQPNvJ16RNxuCdXAYel%2FDcmrpe%2FGQzG2ZMA5ZPlSmIPOXRdERmzjjFhlPLsv2AzwX4CXo5Lpnez42nxYQyH%2FCMKT%2B58cTufraw%2FcfQ6m0zfHl9XXTCQH8e3%2BYqxIwCQQ8q4R10aIn9WSq8ZXYYOTsz2xaicc0tpJIRACF8x51vpTbTkVIg8HvjyKd4Q%2Fi9R70FLDp8rj6YbaTodbPNByNm2qpWMn6sPS710lCvGHDF%2BlcSCEIQ0xLnshvh%2BoeHkM2wfxTGxM6GcknxZBlSCzk4HSFFMl8zG%2B1CXgYyYi%2FmeeWYRJoJfmAZYLEvoMewjTlbqdyAZ6G4xr4wF8Y8Mh8%2BExigzvEL%2BUr4qQlufIqcxZG7RQlBfcTPyiRsmiAqAMBOCFWacCG5dyQcBcZwsonBM3tAitZe4I6Ik5OmCrOuONS3QTwzgTaeB%2BFK5pFvVL3tCX0dXmu%2F2e%2F3RSJJ5q7zyw%2FhL43fJaipT6MtLLPxed1DxDQf4THcZozaOY8o0p6ksXnuE44cIpXG7FrlcdeVO%2BLXw3wkoHPQVMMdyuC7TKjClzKuk1Fzt2wMcamDpgd2UFiqwqBh%2BPEO8y%2FwdUFawshqgymVfDVDpqZHqKABrHsjym1Sq7jg1O3WPF%2B7NDWUwaIa%2Biw2G5mBkc0LDFEiBY%2BKaC0po8L18BvpDoDjE%2FJZwsRSb3YGq%2F4PJbthu7TKs1i5FufJe7TJUahdwdrWLeVgGO1LtMtaoH2RHk0sgehb4eyuXwWB4XpVLcUo6%2FYOIwsmScVVagtOlpdEmL%2FMdp8LLtGVwj%2BOIhjG%2BDH5WjvdN%2FBQbsTk2FHrCw%2BiZb70AHmvvLeKyJbp%2BqW3w9a7B2bG81c5BXhHWWT4LOeHbC%2BH4%2FsOu2FCMgXlmW7BxQvX0sbbganpQS3NRRYlCa3%2BSSEd3mBGBfRKjn2wDfB%2FfrQP53nyyM2udAAsc9wAPB82JRIj%2Bcg%2FrPa3zTCU7SrKyXADqEfvAaiE%2FJgA1P3VHxyoe9CLwHkc0JpwyfXdou00Jzbb7lEDvYz3hxVVEWscK9Gv5ATZgBY%2BKVUNsURq0jhQcnhxSepF2x%2FALFisSMMBJsoX17B5vHTqzlqfahy6%2F%2FD3%2BzUFbNwJmjegAjHuWauSjlwJW%2FXZBN%2FXTVYV%2BsZk2Bx%2FnuhfPsp54tz14NhcBYlj%2BQCKbXv7MxJj9Bw%3D%3D)

## The separate code layers of MVVM:
- **Model**: This layer is responsible for the abstraction of the data sources. Model and ViewModel work together to get and save the data.
- **View**: The purpose of this layer is to inform the ViewModel about the user’s action. This layer observes the ViewModel and does not contain any kind of application logic.
- **ViewModel**: It exposes those data streams that are relevant to the View. Moreover, it serves as a link between the Model and the View.


## MVVM Workflow:

The MVVM workflow in Android involves the ViewModel mediating between the Model and the View. The Model manages data and business logic, the ViewModel prepares and manages data for the UI, and the View observes the ViewModel's data and updates the UI accordingly. This separation of concerns and the use of observable data structures make MVVM a powerful architectural pattern for building maintainable and testable Android applications.

## MVVM Advantages:

1. **Separation of Concerns:**
   MVVM promotes a clear separation of concerns, with distinct components for managing data (ViewModel), handling user interface logic (View), and representing the underlying data (Model). This separation enhances code maintainability and testability.

2. **Testability:**
   MVVM facilitates unit testing because the ViewModel, which contains most of the application's business logic, can be tested independently of the UI components. This allows for more comprehensive testing of your app's functionality.

3. **Reusability:**
   ViewModels are designed to be free of Android-specific code, making them highly reusable. You can use the same ViewModel logic in different parts of your app or even in other platforms (e.g., iOS with Swift).

4. **Lifecycle Awareness:**
   MVVM is well-suited for handling Android's complex lifecycle. ViewModels are lifecycle-aware and can hold data that persists across configuration changes (e.g., screen rotations) without the need for complex handling of onSaveInstanceState.

5. **Data Binding:**
   MVVM is often used in conjunction with Android's Data Binding library, which allows for a declarative way of binding UI components to ViewModel data. This reduces boilerplate code and enhances the efficiency of UI updates.

6. **Maintainability:**
   The separation of concerns in MVVM leads to more maintainable code. Developers can work on different aspects of the app independently, making it easier to understand and modify the codebase.

7. **Scalability:**
   MVVM can accommodate large and complex Android applications. As your app grows, you can add more ViewModels to handle different parts of the application, maintaining a clean and organized code structure.

8. **Improved Collaboration:**
   MVVM's clean architecture and separation of concerns can facilitate collaboration between UI designers and developers. Designers can work on the UI layout and data bindings, while developers focus on the ViewModel and business logic.

9. **Better Code Organization:**
   MVVM encourages developers to structure their code in a way that aligns with best practices, making it easier to navigate, refactor, and extend the codebase.

10. **Data Persistence:**
    MVVM can be integrated with various data persistence solutions like Room (for local databases) and Retrofit (for network calls), allowing for efficient data retrieval and storage.

## MVVM Disadvantages:

1. **Complexity:**
   Implementing MVVM can introduce complexity to your codebase, especially for smaller or simpler projects. The pattern involves multiple components (View, ViewModel, and Model), which can be overwhelming for beginners or for projects with limited scope.

2. **Learning Curve:**
   MVVM may have a steeper learning curve for developers who are new to Android development or architectural patterns. Understanding how data flows between the View, ViewModel, and Model components and how to set up data binding can take time to grasp.

3. **Boilerplate Code:**
   MVVM can sometimes lead to increased boilerplate code, particularly when implementing data binding or LiveData. This additional code can make your project larger and more challenging to maintain.

4. **Potential Overhead:**
   The use of data binding and LiveData, which are common in MVVM, can introduce some performance overhead. While these overheads are usually minimal, they can affect performance in resource-constrained scenarios.

5. **Over-Engineering:**
   MVVM might be overkill for smaller or less complex applications. If your project doesn't require extensive separation of concerns, MVVM can lead to unnecessary architectural complexity.

6. **ViewModel State Management:**
   Handling complex UI states in ViewModels can be challenging. As the application grows, managing various UI states, such as loading, empty, error, and content states, within ViewModels can become more complex.

7. **Learning Curve for Data Binding:**
   If you choose to use Android's Data Binding library with MVVM, there can be a learning curve associated with understanding and using data binding effectively.

8. **Compatibility:**
   MVVM may not be the best fit for all Android projects. Some legacy codebases or projects with specific architectural requirements may find it challenging to integrate MVVM seamlessly.

## Conclusion: 
In conclusion, while MVVM offers many advantages in terms of separation of concerns, testability, and maintainability, it is not a one-size-fits-all solution. Developers should carefully consider the requirements of their specific project and weigh the advantages and disadvantages of MVVM against other architectural patterns like MVP, MVC, or Clean Architecture to make an informed decision. The choice of architecture ultimately depends on the project's complexity, team expertise, and long-term maintenance considerations.

## Parse (alternative remote server)

To have a clear view of repositories implemented as an alternative remote source, please set up parse(https://parseplatform.org/) server locally or find something remote and change the params "PARSE_URL", "PARSE_APPLICATION_ID" from build.gradle

## About used libraries
- [Dependency injection(Koin)](https://insert-koin.io)
- [Networking Library(Retrofit2)](https://square.github.io/retrofit/)
- [Logger(Timber)](https://github.com/JakeWharton/timber)
- [Parse](https://parseplatform.org/)

## List of clean architectures
- [MVI XML-based UI](https://github.com/colodinalexandru/MVIViewCustom)
- [MVVM XML-based UI](https://github.com/colodinalexandru/mvvmview)
- [MVI Compose](https://github.com/colodinalexandru/MVICompose)
- [Compose Standard](https://github.com/colodinalexandru/standardcompose)

# Feel free to ask any questions 
## [colodind.alexandru@gmail.com](mailto:colodind.alexandru@gmail.com)
