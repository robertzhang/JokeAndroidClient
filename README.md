# JokeAndroidClient
It is android client about mvp framework. Maybe, it can help you to know how to use the mvp
这是一个基于MVP框架的应用，可以帮助初学者学习和理解MVP结构，并且还对比了使用EventBus替换回调接口的解决方案。
## 开发环境
* Android studio 1.5.1
* JDK 1.7
* OS X 10.11.1
* Smartisan坚果

## Project Tree
>* cn.robertzhang.joke
	* app
	* config
	* model
		* dao
		* entities
		* helper
	* presenter 
	* ui
		* activity
		* adapter
		* fragment	 
	* utils
	* view
	* widget

## Why build this project？
This project can help you to learn MVP. Maybe could help you know what a good project of framework looks like too.

为什么会开始写这个项目呢？其实是受到一些优秀的开源项目启发，于是本着学习的态度开始了自己开源项目的建立和分享。该项目的名字为《逗逼与文青》，英文名为《DouBi VS WenQ》。在项目中将分别通过两种形式实现内容的展示。什么，为什么要分开它们？因为它们的气质使然。在参考了[StarWars.Android](https://github.com/Yalantis/StarWars.Android)，被她优雅的切换模式和双重人格所吸引。于是逗逼和文青两个角色就此被划分了。
### DouBi
逗逼模块的灵感来源于一款Swift开发的仿”糗事百科“的开源项目[JokeClient-Swift](https://github.com/YANGReal/JokeClient-Swift)，有了数据一切就好办了。在不以私人利益的前提下，对该版本的“糗事”进行逗逼化。在这个模块中，使用了CoordinatorLayout、CollapsingToolbarLayout、Toolbar。他们具体的介绍和使用，感兴趣的朋友可以自行查看相关文档。SmartTabLayout+ViewPage为内容显示。
在DouBi模块中我们对MVP三个模块进行了隔离，采用EventBus来传递消息。这样做的好处在于模块完全解耦，UI，业务逻辑和数据层（因为懒并没有实现数据本地化）完全分开，真正的做到面向接口编程。不过在这里需要注意的是，EventBus在传递消息的时候是通过post中传递对象的类型来判断，Subscribe是否接受该处理。可想而知如果项目复杂度很高时承载消息的类将会有很多，幸好我们对EventMessage做了抽离。当然我们要付出必要的代价。可读性变低，每个类或者大模块间都需要对出口和入口进行定义实现。需要对项目有很深的理解和经验才能做到游刃有余。
### WenQ
文青模块则是借鉴了同为Android开源项目[ONE-Unofficial](https://github.com/Uphie/ONE-Unofficial)，这个项目高仿了ONE，很多布局也是直接拿来用的，当然如果对比你会发现实现的思路是不一样的。ONE-Unofficial中每个小模块中嵌套的都是ViewPager，在内容加载较多的时候会出现卡顿现象，于是我改为使用RecycleView。这样的好处是卡顿感明显减少了。
WenQ采用的是最传统的MVP模式，UI通过调用presenter接口的相关action，presenter对这些操作进行异步处理，结果通过回调的形式返回给UI，UI更新视图。听起来是不是很简单？没错MVP就是因为结构清晰才会被广为流传。
### 总结
个人还是觉得传统MVP的模式使用起来得心应手。对于小项目传统的方式完全可以满足我们的需要。当项目模块越来越多，且模块内部越来越庞大。这个时候我们可以考虑在这些独立模块之间建立EventBus来传递消息，从而保持模块独立性。

## What it is look like
说了半天终于到了你们想看的东西。无图无真相。好吧，满足你们。
### 1、Doubi
![image](https://github.com/robertzhang/TreeTableViewWithSwift/raw/master/screenshots/Screenshot_1.png)
### 2、WenQ
![image](https://github.com/robertzhang/TreeTableViewWithSwift/raw/master/screenshots/Screenshot_2.png)
### 3、菜单
![image](https://github.com/robertzhang/TreeTableViewWithSwift/raw/master/screenshots/Screenshot_3.png)
### 4、关于我
![image](https://github.com/robertzhang/TreeTableViewWithSwift/raw/master/screenshots/Screenshot_4.png)

## Thanks
### Open project
* [SkillCollege](https://github.com/SkillCollege/SimplifyReader)
* [ONE-Unofficial](https://github.com/Uphie/ONE-Unofficial)
* [StarWars.Android](https://github.com/Yalantis/StarWars.Android)
* [JokeClient-Swift](https://github.com/YANGReal/JokeClient-Swift)


### Open source libs
* **Smarttable是table bar的完美解决方案** - compile 'com.ogaclejapan.smarttablayout:library:1.6.0@aar'
* **图片加载和显示** - compile 'com.facebook.fresco:fresco:0.9.0+'
* **EventBus消息处理** - compile 'org.greenrobot:eventbus:3.0.0'
* **Greendao数据库操作** - compile 'de.greenrobot:greendao:2.0.0'
* **Butterknife绑定layout布局文件** - compile 'com.jakewharton:butterknife:7.0.1'

还有一些com.android.support和不常用的可以自行查看他们的作用

## Update Record
* 20160310 - 修改关于我，github，项目的跳转
* 20160309 - 跟新Header显示icon;修改两种模式切换bug;添加网络异常提示;修改使用中出现的bug
* 20160308 - 完成doubi模块，解决数据异常情况下的崩溃问题
* 20160303 - 基本实现WenQ部分内容。待后续完善细节
* 20160229 - 完善逗逼和文青界面，解决主题切换时出现的bug
* 20160226 - add volley helper and json parser utils
* 20160202 - 梳理app的ui结构
* 20160128 - 调整commonlibraris的结构，添加recyclerview封装代码（以后用中文更新）
* 20160121 - add common libraries
	* The ["commonlibraries"](https://github.com/robertzhang/JokeAndroidClient/tree/master/commonlibs) are reusable utils which reference [SkillCollege](https://github.com/SkillCollege/SimplifyReader) library. And I would continuing update the utils code.
* 20160119 - Init project

## GitHub
>  GitHub page: [RobertZhang](https://github.com/robertzhang)  
 GMail: robertzhangsh#gmail.com  
 QQ: 1615349135  
	
## License
Plase see [MIT License](https://github.com/robertzhang/JokeAndroidClient/blob/master/LICENSE). If you feel anything no good, contact me. 
如果有什么问题，请联系我。我会在第一时间修改。


