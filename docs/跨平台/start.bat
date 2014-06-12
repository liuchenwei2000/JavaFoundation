@echo �������ļ�����Java����ʾ��
@echo off

REM                                                
REM ###############################################
REM # Purpose: sample
REM # Author:  UFIDA��liucw1@ufida.com.cn        
REM #                                              
REM ##############################################

if "%OS%"=="Windows_NT" setlocal

REM �ж�JAVA_HOME�Ƿ���ֵ�����û��ֵ����ʾ����
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

REM ��ʾJAVA_HOME�ĵ�ǰֵ
echo set JAVA_HOME = %JAVA_HOME%

REM ����PATh��ֵΪJAVA_HOME\bin
set PATH=%JAVA_HOME%\bin

REM ����CLASSPATH������.��ʾ�������ڵ��ļ��У���ͬ��jar����;���룬����CLASSPATHֵ��˫���Ű���
set _CLASSPATH=".\lib\fileutil.jar;.\lib\test.jar"

REM ִ��java��������������
java -cp %_CLASSPATH% test.Test

echo. & pause 

:QUIT
if "%OS%"=="Windows_NT" endlocal 