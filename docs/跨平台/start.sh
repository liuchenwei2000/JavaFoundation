#!/bin/sh 
#
###############################################
# Purpose: sample
# Author:  UFIDA，liucw1@ufida.com.cn  
#
###############################################

# 判断JAVA_HOME是否有值，如果没设值则提示错误
if [ "${JAVA_HOME}" = "" ] ; then
	echo "Please set JAVA_HOME environment variable first ."
	echo "example: export JAVA_HOME=/opt/jdk1508"
	exit
fi
if [ ! -f ${JAVA_HOME}/bin/java ] ; then
        echo "JAVA_HOME environment variable is invalid ."
        exit
fi

# 设置CLASSPATH，其中.表示自身所在的文件夹，不同的jar包用:隔离
_CLASSPATH=./lib/fileutil.jar:./lib/test.jar

# 执行java命令启动主程序
${JAVA_HOME}/bin/java -cp ${_CLASSPATH} test.Test
