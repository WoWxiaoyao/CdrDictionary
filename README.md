# CdrDictionary
一个简单的cdr词达人辅助查询系统。目前已支持手动精准查询单词词义/词组，模糊查询词组/句子来源等。

目前仅用于PC端查询操作，安卓与其他系统能否使用暂未得知。
## 
**友情提示**

* 本项目仅用于学习研究，请各位理性合理使用。
* 该程序的创作初衷为便于单词的查询与理解背诵，摆脱公众号臃肿繁琐的操作。
* ~不要用于竞赛，一旦出现任何问题，后果自负。~(目前来看无法解决全国竞赛的题型)

##
**使用环境**

- [1.java8(必须)](www.java.com)
- [2.库 fasejson(已放入library文件夹中)](https://github.com/alibaba/fastjson)
- [3.cmd托管软件Conemu(推荐使用)](https://conemu.github.io/)

##
**使用方法**

安装java后，放置好数据与jar文件，使用cmd或PowerShell输入以下命令。

    java  -Xms1g -Xmx1g -jar CdrDictionary.jar
*(推荐使用Conemu接管系统cmd,在测试阶段发现系统cmd有可能显示异常)*
内存请根据实际使用情况与词库加载词条大小进行更改，建议最小1G。

**使用集成包内一键启动bat也可以**

##
**功能简介**

    直接输入单词原型/命令0 [精准模式-完整词典-小写]
	    abandon/0 abandon
		    return 系统储存该单词的完整信息(词义/短语/句子)
	命令1 [精准模式-英译中-小写]
		1 abandon
			return 词义(verb 抛弃；放弃)
	命令2 [模糊模式-中译英-null]
		2 抛弃
			return 单词清单(abandon/.../...)
		* 输入部分带有词性请添加1x空格（2 verb 抛弃）
	命令3 [模糊模式-句子综合-精准填写]
		3 abandon
			return 模糊句子清单，精准度（★★☆☆☆）
		3 abandon the ship
			return null
			* 当包含关键词时需要加{},例如如下
		3 {abandon} the ship
			return 高精度模糊句子清单，精准度（★★★★☆）
		3 句首内容,需要区分大小写
			return 高精度模糊句子清单，精准度（★★★★☆）
		3 中文部分/全部句意
			return 高精度模糊句子清单，精准度（★★★☆☆）
			* 由于词库实时更新,中文句意细微改变将螺旋升天~所以最好找关键内容输入以拉高准确率
	命令4 [模糊模式-词组综合-小写]
		使用方法参考命令3
	命令5 [精准模式-词组综合-小写]
		5 abandon
			return abandon ... 词组清单		
##
**关于词库**

*词库目前采用2022年CET4词库，为了减少竞赛滥用不再额外提供其他版本题库。*

##
**关于是否会推出自动模式**

*明确告知:不会推出任何自动类解决竞赛问题的产品。*

*对于课堂任务等非竞赛类自动化产品可使用[Rain-shadow/cdr](https://github.com/Rain-shadow/cdr)*

##
**打赏一下？**

[爱发电](https://afdian.net/@gugugu_null)
