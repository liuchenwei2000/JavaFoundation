@echo ???????Java????
@echo off
REM
REM ###############################################
REM # Purpose: sample
REM # Author:  UFIDA?liucw1@ufida.com.cn
REM #
REM ##############################################

if "%OS%"=="Windows_NT" setlocal

REM ??JAVA_HOME???????????????
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

REM ??JAVA_HOME????
echo set JAVA_HOME = %JAVA_HOME%

REM ??PATh???JAVA_HOME\bin
set PATH=%JAVA_HOME%\bin

REM ??CLASSPATH???.??????????????jar??;?????CLASSPATH???????
set _CLASSPATH=".\lib\fileutil.jar;.\lib\test.jar"

REM ??java???????
java -cp %_CLASSPATH% test.Test

echo. & pause 

:QUIT
if "%OS%"=="Windows_NT" endlocal 