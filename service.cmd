@echo off

SETLOCAL
REM to be set by the user

set current_dir=%cd%
set app_name=analytic-test
set dist_dir=%tmp%\dist

set war_file=analytic-test-1.2.0.war
set withtests=n
set tests=-DskipTests

set true=1==1
set false=1==0
set deploy_run=%false%
set compile_deploy_run=%false%

set command=%1

rem Empty string call usage
if /i [%command%] == [] goto usage
FOR %%a in (-c c compile) DO IF /i %command%==%%a goto compile
FOR %%a in (-r r run) DO IF /i %command%==%%a goto run
FOR %%a in (-s s stop) DO IF /i %command%==%%a goto stop
FOR %%a in (-cr cr) DO IF /i %command%==%%a goto compile.run
FOR %%a in (-h h help) DO IF /i %command%==%%a goto usage

:compile.run
echo "Compile and run as been called..."
set compile_run=%true%
goto compile
goto end


:compile
echo "Compile has been called..."

rem :PROMPT
rem set /P withtests=Compile With the tests (Y/N) default[N]?
rem if /I %withtests% EQU Y set tests=
rem if /I %withtests% EQU N set tests=-DskipTests
call mvn clean install %tests%

if %compile_run% (
	goto run
)

goto end
rem End compile

:run
echo "Run has been called from path: %cd%."
rem mvn spring-boot:run
java -jar -Dspring.profiles.active=prod .\target\%war_file% 
goto end
rem End run

:stop
echo "Stop the application running under port 8080."
rem netstat -ano | findstr 8080
FOR /F "tokens=*" %%g IN ('netstat -ano ^| findstr 8080') do SET processId=%%g
rem echo %processId%
for /f "tokens=5" %%i in ("%processId%") do set result=%%i
rem echo %result%
taskkill /F /PID %result%
goto end
rem End run

:usage
echo "Usage:";
echo "    %0 -c|c|compile Compile the current project, will ask for tests or not, wrong answer will include the tests by default.";
echo "    %0 -h|h|help    Show the present usage.";
echo "    %0 -r|r|run     Run from current directory using local properties configurations files.";
echo "    %0 -s|s|stop    Stop the application, find process id running under prot 8080.";
echo "    %0 -cr|cr       Compile, Run.";
goto end
rem End usage

:end
EXIT /B 0