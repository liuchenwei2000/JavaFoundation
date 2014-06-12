#!/bin/sh 
#
###############################################
# Purpose: sample
# Author:  UFIDA��liucw1@ufida.com.cn  
#
###############################################

# �ж�JAVA_HOME�Ƿ���ֵ�����û��ֵ����ʾ����
if [ "${JAVA_HOME}" = "" ] ; then
	echo "Please set JAVA_HOME environment variable first ."
	echo "example: export JAVA_HOME=/opt/jdk1508"
	exit
fi
if [ ! -f ${JAVA_HOME}/bin/java ] ; then
        echo "JAVA_HOME environment variable is invalid ."
        exit
fi

# ����CLASSPATH������.��ʾ�������ڵ��ļ��У���ͬ��jar����:����
_CLASSPATH=./lib/fileutil.jar:./lib/test.jar

# ִ��java��������������
${JAVA_HOME}/bin/java -cp ${_CLASSPATH} test.Test
