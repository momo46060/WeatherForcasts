# WeatherForcats Android Application

This project was created as a demo project for implementing latest frameworks, Android APIs, tools, and techniques.<br/>
It follows Clean architecture design pattern. Project files are divided into three layers (presentation, domain, and data).<br/><br/>
<p align="center">
<img src="https://blog.cleancoder.com/uncle-bob/images/2012-08-13-the-clean-architecture/CleanArchitecture.jpg" width="500" align="center"><br/>
</p>
<br/>
It contains Production Code, Unit Tests for domain layer classes and ViewModels in presentation layer, and Instrumentation Tests for Room database related classes in data layer.<br/>
You can use it as a reference for using the tools described at the end of this file.<br/>
If you want to contribute to this repository by reviewing my code, refactor it, or add new features, You are almost welcomed.

## Screenshots

<img src="https://i.ibb.co/hmLcm7C/Screenshot-20241004-155451.png" width="200">&nbsp;<img src="https://i.ibb.co/f4Xzf3v/Screenshot-20241004-155638.png" width="200">&nbsp;<img src="https://i.ibb.co/db65h34/Screenshot-20241004-160756.png" width="200">&nbsp;<img src="https://i.ibb.co/mGNz6vV/Screenshot-20241004-160814.png" width="200">

## How to use
* Please check that your device is connected to the internet.
* Tap on Add City button.
* Enter city name as shown in the screenshots above.
* Then city with it's related historical data will be cached in your device. So you can access it later without needing to internet connection.
* You can add cities as much as you want.
* Tab on your city name, then it will navigate to city historical screen.
* Tab on an item from the historical data items to navigate to the details screen.


## Built With

* [Kotlin](https://kotlinlang.org) - As a programming language.
* [Coroutines](https://developer.android.com/kotlin/coroutines) - For multithreading while handling requests to the server and local database.
* [Model-View-ViewModel(MVVM)](https://developer.android.com/topic/architecture) - Offers an implementation of observer design pattern.
* [Retrofit](https://square.github.io/retrofit/) - It is a type-safe REST client for Android, Java and Kotlin developed by Square. The library provides a powerful framework for authenticating and interacting with APIs and sending network requests with OkHttp.
* [Room DB](https://developer.android.com/training/data-storage/room) - To manage SQLite database easily and avoid a lot boilerplate code.
* [Koin](https://insert-koin.io/docs/quickstart/android/) - It is arguably the most used Dependency Injection, or DI, framework for Android. Many Android projects use koin to simplify building and providing dependencies across the app. It gives you the ability to create specific scopes, modules, and components, where each forms a piece of a puzzle: The dependency graph.
* [Clean Architecture](https://www.raywenderlich.com/3595916-clean-architecture-tutorial-for-android-getting-started) - Applying Clean Architecture and Solid Principles to build a robust, maintainable, and testable application.
* [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. For example, you can use a flow to receive live updates from a database. I replaced LiveData objects in ViewModels with StateFlow objects. it is much easier for unit testing.
## License
Please review the following [license agreement](https://bumptech.github.io/glide/dev/open-source-licenses.html)
