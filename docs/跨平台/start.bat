@echo 批处理文件启动Java程序示例
@echo off
REM
REM ###############################################
REM # Purpose: sample
REM # Author:  UFIDA，liucw1@ufida.com.cn
REM #
REM ##############################################

if "%OS%"=="Windows_NT" setlocal

REM 判断JAVA_HOME是否有值，如果没设值则提示错误
if "%JAVA_HOME%" == "" (
	echo Please set JAVA_HOME environment variable first .
	echo. & pause
	goto QUIT
)
if not exist "%JAVA_HOME%\bin\java.exe" (
	echo JAVA_HOME environment variable is invalid.
	echo. & pause
	goto QUIT
)

REM 显示JAVA_HOME的当前值
echo set JAVA_HOME = %JAVA_HOME%

REM 设置PATh的值为JAVA_HOME\bin
set PATH=%JAVA_HOME%\bin

REM 设置CLASSPATH，其中.表示自身所在的文件夹，不同的jar包用;隔离，整个CLASSPATH值用双引号包括
set _CLASSPATH=".\lib\fileutil.jar;.\lib\test.jar"

REM 执行java命令启动主程序
java -cp %_CLASSPATH% test.Test

echo. & pause

:QUIT
if "%OS%"=="Windows_NT" endlocal