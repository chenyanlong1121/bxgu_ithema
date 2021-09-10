-- MariaDB dump 10.17  Distrib 10.4.12-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: bxgu
-- ------------------------------------------------------
-- Server version	10.4.12-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ad`
--

DROP TABLE IF EXISTS `ad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad` (
  `uuid` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `time` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad`
--

LOCK TABLES `ad` WRITE;
/*!40000 ALTER TABLE `ad` DISABLE KEYS */;
INSERT INTO `ad` VALUES ('6fc5b91e-122d-47ad-a9fe-4debaa716e40','2020-03-03 14:06:25'),('4b1978a8-20c1-4d3d-a170-e65a71043a32','2020-03-03 14:06:25'),('939be81b-efd1-4e5c-878b-1c4add4e9fa1','2020-03-03 14:06:25'),('965279af-7808-4a38-ab2a-f88221abdf1a','2020-03-03 14:06:25'),('e85f46f8-11f3-4e9c-81ec-981b96d431db','2020-03-03 14:06:26');
/*!40000 ALTER TABLE `ad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exec_chapters`
--

DROP TABLE IF EXISTS `exec_chapters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exec_chapters` (
  `id` int(11) NOT NULL,
  `name_zh_CN` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name_en_US` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exec_chapters`
--

LOCK TABLES `exec_chapters` WRITE;
/*!40000 ALTER TABLE `exec_chapters` DISABLE KEYS */;
INSERT INTO `exec_chapters` VALUES (1,'Android 基础入门','Intro to Android'),(2,'Android UI开发','Android UI development'),(3,'Activity','Activity'),(4,'数据存储','Data storage'),(5,'SQLite 数据库','SQLite database'),(6,'广播接收者','Broadcast receiver'),(7,'服务','Services'),(8,'内容提供者','Content providers'),(9,'网络编程','Network programming'),(10,'高级编程','Advanced programming');
/*!40000 ALTER TABLE `exec_chapters` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exec_en_US`
--

DROP TABLE IF EXISTS `exec_en_US`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exec_en_US` (
  `chapter` int(11) NOT NULL,
  `exec_id` int(11) NOT NULL,
  `exec_desc` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `choice_a` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_b` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_c` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_d` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `answer` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exec_en_US`
--

LOCK TABLES `exec_en_US` WRITE;
/*!40000 ALTER TABLE `exec_en_US` DISABLE KEYS */;
INSERT INTO `exec_en_US` VALUES (1,1,'Android installation package file is referred to as APK, and its suffix is（）.','.exe','.txt','.apk','.app',3),(1,2,'The following options are not part of the ADT Bundle:（）.','Eclipse','SDK','SDK Manager.exe','JDK',4),(1,3,'The application layer is a collection of core applications, mainly including（）.','Event manager','SMS program','Audio driver','Dalvik virtual machine',2),(1,4,'ADB\'s common instructions \"list all devices\" are（）.','adb uninstall','adb install','adb device','adb emulator-avd',3),(1,5,'When creating a program, the Application Name you filled in indicates（）.','application name','project name','project package name','Class name',1),(2,1,'Which of the following properties can be \"on the left of the specified control\" is（）.','android:layout_alignLeft','android:layout_alignParentLeft','android:layout_Left','android:layout_toLeftOf',4),(2,2,'The role of the android: layout_column attribute in the table layout is to specify（）.','rows','columns','Total number of rows','Total number of rows',4),(2,3,'The layout of the scratch game in actual development is written according to （）.','Relative layout','Linear layout','Frame layout','Absolute layout',3),(2,4,'Grid layout is a new layout for Android （）.','3.0','3.1','3.2','4.0',4),(2,5,'In a relative layout, \"is it aligned with the parent layout\" is an attribute（）。','android:layout_alignBottom','android:layout_alignParentBottom','android:layout_alignBaseline','android:layout_below',3),(3,1,'An application contains （） Activity(s) by default.','one','five','ten','Several',1),(3,2,'In the following methods, the activity will not be executed from startup to shutdown is（）.','onCreate()','onStart()','onResume()','onRestart()',4),(3,3,'Among the following components, which cannot be started using Intent is（）.','Activity','Start service','Broadcast','Content provider',4),(3,4,'The startActivityForResult() method receives two parameters, the first is Intent and the second is ().','resultCode','requestCode','request code','data',3),(3,5,'The following description about Activity is wrong（）.','Activity is one of the four major components of Android','Activity has four launch modes','Activity is usually used to start a broadcast event','Activity is like an interface administrator, the user\'s operations on the interface are managed through Activity',3),(4,1,'In the following file operation permissions, the specified file content can be appended is（）.','MODE_PRIVATE','MODE_WORLD_READABLE','MODE_APPEND','MODE_WORLD_WRITEABLE',3),(4,2,'In the following code, the path to get the SD card is（）.','Environment.getSD();','Environment.getExternalStorageState();','Environment.getSD Directory();','Environment.getExternalStorageDirectory();',4),(4,3,'In the following options, the statement about the data stored in the file is wrong（）.','File storage operates on data in the form of streams','File storage can store data in SD card','File storage can store data in memory','File can only be used to store data in Android',4),(4,4,'Of the following options, the description of XML serialization and parsing is reasonable（）。','DOM parsing will store the entire contents of the XML file in memory as a document tree','When serializing objects, you need to use the XmlSerialize serializer, that is, the XmlSerializer class','The startDocument() method of the XmlSerializer class is used to write the start node of the serial number','The startTag() method of the XmlSerializer class is used to set the encoding method of the file',2),(4,5,'\n          If you want to share private data in the program to other applications, you can use（）.','file storage','SharedPreferences','ContentProvider','SQLite',3),(5,1,'After querying with SQLite database, the operation that must be done is（）.','Close the database','Exit directly','Close Cursor','A and C are both right',4),(5,2,'Methods to generate a database and manage the database version using the SQLiteOpenHelper class（）.','getDatabase()','getWriteableDatabase()','getWriteable()','getAbleDatabase()',2),(5,3,'Among the following commands, the commands belonging to SQLite are（）。','shell','push','quit','keytool',2),(5,4,'The following description about the use of ListView is incorrect（）.','To use a ListView, you must pass data to the ListView using an adapter.','To use ListView, the activity corresponding to the layout file must inherit ListActivity','The view layout of each item in ListView can use either the built-in layout or a custom layout','When each item in the ListView is selected, the ItemClick event of the ListView object will be triggered',3),(5,5,'The statement about adaptation is correct（）。','It is mainly used to store data','It is mainly used to bind data to components','It is mainly used to store XML data','It is mainly used to parse data',2),(6,1,'Among the following options, the four major components in Android are（）.','Activity','ContentProvider','Service','A,B and C are all right',4),(6,2,'The following description about ContentResolver is wrong（）.','Can manipulate database data','You must know the package name to operate other application data','Can only manipulate data exposed by ContentProvider','Can manipulate arbitrary data of ContentProvider',3),(6,3,'The following description of the content provider is incorrect（）.','Uri provided must meet specifications','Can provide all data of this application for others to access','Must be registered in the manifest file','authorities attribute must match the package name',2),(6,4,'\n          The methods that inherit from the ContentProvider class do not need to be overridden are（）.','delete()','insert()','onStart()','onUpdate()',3),(6,5,'The following statement about content observers is correct（）.','Can observe any data','Observing other application data requires permissions','Only the data for the specified Uri can be observed','Observing other application data must be registered in the manifest file',3),(7,1,'Which method will be overridden by inheriting BroadcastReceiver（）.','onReceiver()','onUpdate()','onCreate()','onStart()',1),(7,2,'Regarding the role of broadcasting, what is correct is（）.','It is mainly used to receive some messages issued by the system','It can perform time-consuming operations','It can start an Activity','It can help Actvity modify the user interface',1),(7,3,'In the following method, an orderly broadcast is（）.','startBroadcastReceiver()','sendOrderedBroadcast()','sendBroadcast()','sendReceiver()',2),(7,4,'\n          In the manifest file, the nodes used when registering the broadcast are（）.','activity','broadcast','receiver','broadcastreceiver',3),(7,5,'What\'s incorrect about BroadcastReceiver is（）.','Is used to receive broadcast Intents','A broadcast Intent can only be received by a BroadcastReceiver that is subscribed to this broadcast','For ordered broadcasts, system will execute the receivers according to the priority level declared by the receiver','The priority declared by the receiver is declared in the android:priority attribute. The larger, the higher.',2),(8,1,'What method is called every time the service is started（）.','onCreate()','onStart()','onResume()','onStartCommand()',4),(8,2,'Among the following options, the features that are not part of the binding service are（）。','Open with bindService() method','Service closed after caller closed','Must implement ServiceConnection()','Stop service using stopService() method',4),(8,3,'The common feature of Service and Activity is（）.','Is one of the four components','All have onResume() method','Cannot be called remotely','Can customize the beautiful interface',1),(8,4,'In the following methods, what is not part of the Service life cycle is（）.','onResume()','onStart()','onStop()','onDestory',1),(8,5,'\n          Regarding the onCreate() and onStart() methods of the service life cycle, the statement is correct（）.','If the Service is already started, the onCreate() and onStart() methods will be called successively','If the Service is already started, only the onCreate () method will be executed','Only the onCreate() method will be called when first started','If the Service is already started, only the onStart() method will be executed.',4),(9,1,'Among the following options, the key objects that are not in the Handler mechanism are（）.','Content','Handler','MessageQueue','Looper',1),(9,2,'The following communication methods are not provided by the Android system.（）','Socket communication','HTTP communication','URL communication','Ethernet communication',4),(9,3,'About the basic usage of HttpURLConnection to access the network, what is wrong is that（）.','HttpURLConnection object needs to set the way to request the network','HttpURLConnection object needs to set timeout','Need to create the HttpURLConnection object through the new keyword','After accessing the network, you need to close the http link',3),(9,4,'Among the following options, the features that are not part of AsyncHttpClient are（）.','Sending asynchronous HTTP requests','HTTP request occurs outside the UI thread','Internally uses a thread pool to handle concurrent requests','Automatic garbage collection',4),(9,5,'In the following options, about the GET and POST request methods, the description is wrong（）。','There is a limit to the length of a network URL accessed using GET','The HTTP protocol stipulates that the length of a GET request URL does not exceed 2k','POST method has no limit on the length of the URL','The parameters submitted to the server by the GET request method follow the request URL',2),(10,1,'When using MediaPlayer to play mp3 files saved on sdcard（）.','Need to create MediaPlayer using MediaPlayer.create method','Can\'t directly new MediaPlayer','Set the file source directly using the setDataSource method','Call the start method directly, no need to set the file source',3),(10,2,'The following classes that are not related to motion tweens are（）.','TranslateAnimation','FrameAnimation','RotateAnimation','AlphaAnimation',2),(10,3,'What is right about Fragment is（）.','Fragment must be added to the layout file using Fragment control','Fragment has its own interface and life cycle, which can completely replace Activity','The state of a fragment changes as the state of its associated activity changes','When Fragment stops, the Activity associated with it also stops',3),(10,4,'Before MediaPlayer plays the resource, which method needs to be called to complete the preparation（）.','setDataSource','prepare','begin','pause',2),(10,5,'The following belong to the Android animation category are（）.','Tweens','Frame','Draw','Animation',2);
/*!40000 ALTER TABLE `exec_en_US` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exec_zh_CN`
--

DROP TABLE IF EXISTS `exec_zh_CN`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exec_zh_CN` (
  `chapter` int(11) NOT NULL,
  `exec_id` int(11) NOT NULL,
  `exec_desc` varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL,
  `choice_a` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_b` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_c` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choice_d` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `answer` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exec_zh_CN`
--

LOCK TABLES `exec_zh_CN` WRITE;
/*!40000 ALTER TABLE `exec_zh_CN` DISABLE KEYS */;
INSERT INTO `exec_zh_CN` VALUES (1,1,'Android安装包文件简称APK，其后缀名是（）。','.exe','.txt','.apk','.app',3),(1,2,'下列选项中不属于ADT Bundle的是（）。','Eclipse','SDK','SDK Manager.exe','JDK',4),(1,3,'应用程序层是一个核心应用程序的集合，主要包括（）。','活动管理器','短信程序','音频驱动','Dalvik 虚拟机',2),(1,4,'ADB 的常见指令中”列出所有设备“的指令是（）。','adb uninstall','adb install','adb device','adb emulator-avd',3),(1,5,'创建程序时，填写的Application Name表示（）。','应用名称','项目名称','项目的包名','类的名字',1),(2,1,'以下属性中，哪个属性可以“在指定控件左边”是（）。','android:layout_alignLeft','android:layout_alignParentLeft','android:layout_Left','android:layout_toLeftOf',4),(2,2,'表格布局中android:layout_column属性的作用是指定（）。','行数','列数','总行数','总列数',4),(2,3,'实际开发中刮刮乐游戏的布局是按照（）布局写的。','相对布局','线性布局','帧布局','绝对布局',3),(2,4,'网格布局是Android（）新增的布局。','3.0','3.1','3.2','4.0',4),(2,5,'相对布局中，“是否跟父布局对齐”是属性（）。','android:layout_alignBottom','android:layout_alignParentBottom','android:layout_alignBaseline','android:layout_below',3),(3,1,'一个应用程序默认会包含（）个Activity。','1个','5个','10个','若干个',1),(3,2,'下列方法中，Activity从启动到关闭不会执行的是（）。','onCreate()','onStart()','onResume()','onRestart()',4),(3,3,'下列组件中，不能使用Intent启动的是（）。','Activity','启动服务','广播','内容提供者',4),(3,4,'startActivityForResult()方法接收两个参数，第一个是Intent，第二个是（）。','resultCode','requestCode','请求码','data',3),(3,5,'下列关于Activity的描述，错误的是（）。','Activity是Android四大组件之一','Activity有四种启动模式','Activity通常用于开启一个广播事件','Activity就像一个界面管理员，用户在界面上的操作是通过Activity来管理',3),(4,1,'下列文件操作权限中，指定文件内容可以追加的是（）。','MODE_PRIVATE','MODE_WORLD_READABLE','MODE_APPEND','MODE_WORLD_WRITEABLE',3),(4,2,'下列代码中，用于获取SD卡路径的是（）。','Environment.getSD();','Environment.getExternalStorageState();','Environment.getSD Directory();','Environment.getExternalStorageDirectory();',4),(4,3,'下列选项中，关于文件存储数据的说法错误的是（）。','文件存储是以流的形式来操作数据的','文件存储可以讲数据存储到SD卡中','文件存储可以讲数据存储到内存中','Android中只能使用文件存储数据',4),(4,4,'下列选项中，关于XML序列化和解析描述合理的是（）。','DOM解析会将XML文件的所有内容以文档树方式存放在内存中','在序列化对象时，需要使用XmlSerialize序列化器，即XmlSerializer类','XmlSerializer类的startDocument()方法用于写入序列号的开始节点','XmlSerializer类的startTag()方法用于设置文件的编码方式',2),(4,5,'如果要将程序中的私有数据分享给其他应用程序，可以使用的是（）。','文件存储','SharedPreferences','ContentProvider','SQLite',3),(5,1,'使用SQLite数据库进行查询后，必须要做的操作是（）。','关闭数据库','直接退出','关闭Cursor','AC都是',4),(5,2,'使用SQLiteOpenHelper类可以生成一个数据库并可以对数据库版本进行管理的方法（）。','getDatabase()','getWriteableDatabase()','getWriteable()','getAbleDatabase()',2),(5,3,'下列命令中，属于SQLite下的命令是（）。','shell','push','quit','keytool',2),(5,4,'下列关于ListView使用的描述中，不正确的是（）。','要使用ListView，必须为该ListView使用Adapter方式传递数据','要使用ListView，该布局文件对应的Activity必须继承ListActivity','ListView中每一项的视图布局既可以使用内置的布局，也可以使用自定义的布局方式','ListView中每一项被选中时，将会出发ListView对象的ItemClick事件',3),(5,5,'关于适配的说法正确的是（）。','它主要用来存储数据','它主要用来把数据绑定在组件上','它主要用来存储XML数据','它主要用来解析数据',2),(6,1,'下列选项中，属于Android中四大组件的是（）。','Activity','ContentProvider','Service','ABC都是',4),(6,2,'下列关于ContentResolver的描述，错误的是（）。','可以操作数据库数据','操作其他应用数据必须知道包名','只能操作ContentProvider暴漏的数据','可以操作ContentProvider的任意数据',3),(6,3,'下列关于内容提供者的描述，不正确的是（）。','提供的	Uri必须符合规范','可以提供本应用所有数据供别人访问','必须在清单文件中注册','authorities属性必须和包名一致',2),(6,4,'继承ContentProvider类不需要重写的方法是（）。','delete()','insert()','onStart()','onUpdate()',3),(6,5,'下列关于内容观察者的说法，正确的是（）。','可以观察任何数据','观察其他应用数据需要权限','只能观察到指定Uri的数据','观察其他应用数据必须在清单文件中注册',3),(7,1,'继承BroadcastReceiver会重写哪一个方法（）。','onReceiver()','onUpdate()','onCreate()','onStart()',1),(7,2,'关于广播的作用，说法正确的是（）。','它主要用来接收系统发布的一些消息的','它可以进行耗时的操作','它可以启动一个Activity','它可以帮助Actvity修改用户界面',1),(7,3,'下列方法中，用于发送一条有序广播的是（）。','startBroadcastReceiver()','sendOrderedBroadcast()','sendBroadcast()','sendReceiver()',2),(7,4,'在清单文件中，注册广播时使用的节点是（）。','activity','broadcast','receiver','broadcastreceiver',3),(7,5,'关于BroadcastReceiver说法不正确的是（）。','是用来接收广播Intent的','一个广播Intent只能被一个订阅了此广播的BroadcastReceiver所接收','对有序广播，系统会根据接收者声明的优先级别按顺序逐个执行接收者','接收者声明的优先级别在android:priority属性中声明，数值越大优先级别越高',2),(8,1,'每一次启动服务都会调用什么方法（）。','onCreate()','onStart()','onResume()','onStartCommand()',4),(8,2,'下列选项中，不属于绑定服务的特点的是（）。','以bindService()方法开启','调用者关闭后服务关闭','必须实现ServiceConnection()','使用stopService()方法关闭服务',4),(8,3,'Service与Activity的共同点是（）。','都是四大组件之一','都有onResume()方法','都不可以被远程调用','都可以自定义美观界面',1),(8,4,'下列方法中，不属于Service生命周期的是（）。','onResume()','onStart()','onStop()','onDestory',1),(8,5,'关于Service生命周期的onCreate()和onStart()方法，说法正确的是（）。','如果Service已经启动，将先后调用onCreate()和onStart()方法','如果Service已经启动，只会执行onCreate()方法','当第一次启动的时候只会调用onCreate()方法','如果Service已经启动，只会执行onStart()方法，不再执行onCreate()方法',4),(9,1,'下列选项中，不属于Handler机制中的关键对象的是（）。','Content','Handler','MessageQueue','Looper',1),(9,2,'下列通讯方式中，不是Android系统提供的是（）。','Socket通信','HTTP通信','URL通信','以太网通信',4),(9,3,'关于HttpURLConnection访问网络的基本用法，描述错误的是（）。','HttpURLConnection对象需要设置请求网络的方式','HttpURLConnection对象需要设置超时时间','需要通过new关键字来创建HttpURLConnection对象','访问网络完毕需要关闭http链接',3),(9,4,'下列选项中，不属于AsyncHttpClient特点的是（）。','发送异步HTTP请求','HTTP请求发生在UI线程之外','内部采用了线程池来处理并发请求','自动垃圾回收',4),(9,5,'下列选项中，关于GET和POST请求方式，描述错误的是（）。','使用GET方式访问网络URL的长度是有限制的','HTTP协议规定GET方式请求URL的长度不超过2k','POST方式对URL的长度是没有限制的','GET请求方式向服务器提交的参数跟在请求URL后面',2),(10,1,'使用MediaPlayer播放保存在sdcard上的mp3文件时（）。','需要使用MediaPlayer.create方法创建MediaPlayer','不能直接new MediaPlayer即可','直接使用setDataSource方法设置文件源','直接调用start方法，无需设置文件源',3),(10,2,'下列不属于补间动画相关的类是（）。','TranslateAnimation','FrameAnimation','RotateAnimation','AlphaAnimation',2),(10,3,'有关于Fragment说法正确的是（）。','使用Fragment必须在布局文件中加入fragment控件','Fragment有自己的界面和生命周期，可以完全替代Activity','Fragment的状态跟随它所关联的Activity的状态改变而改变','当Fragment停止时，与它关联的Activity也会停止',3),(10,4,'MediaPlayer播放资源前，需要调用哪个方法完成准备工作（）。','setDataSource','prepare','begin','pause',2),(10,5,'下面属于Android动画分类的有（）。','Tweens','Frame','Draw','Animation',2);
/*!40000 ALTER TABLE `exec_zh_CN` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `username` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` char(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nickname` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES ('fff','e10adc3949ba59abbe56e057f20f883e',NULL),('fhh','4673cc5eef319f0db83cd45d89cd7020','Igniculus'),('hfh','e10adc3949ba59abbe56e057f20f883e',NULL),('pjh','e10adc3949ba59abbe56e057f20f883e',NULL),('zpf','e10adc3949ba59abbe56e057f20f883e',NULL);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password_protect`
--

DROP TABLE IF EXISTS `password_protect`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `password_protect` (
  `username` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `question` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `answer` char(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password_protect`
--

LOCK TABLES `password_protect` WRITE;
/*!40000 ALTER TABLE `password_protect` DISABLE KEYS */;
INSERT INTO `password_protect` VALUES ('fhh','Who am I?','b45209495e5e2540fe0a8296ea81db9d');
/*!40000 ALTER TABLE `password_protect` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-20 17:25:20
