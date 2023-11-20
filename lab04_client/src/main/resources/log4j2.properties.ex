#log4j.rootLogger=FATAL, consoleAppender, fileAppender
#
#log4j.appender.consoleAppender=org.apache.log4j.ConsoleAppender
#log4j.appender.consoleAppender.layout=org.apache.log4j.PatternLayout
#log4j.appender.consoleAppender.layout.ConversionPattern=%p\t%d{ISO8601}\t%r\t%c\t[%t]\t%m%n
#log4j.appender.consoleAppender.Target=System.out
#
#log4j.appender.fileAppender=org.apache.log4j.fileAppender
#log4j.appender.fileAppender.layout=org.apache.log4j.PatternLayout
#log4j.appender.fileAppender.layout.ConversionPattern=%p\t%d{ISO8601}\t%r\t%c\t[%t]\t%m%n
#log4j.appender.fileAppender.File=./log.out

log4j.rootLogger=DEBUG, STDOUT
log4j.appender.console.name = STDOUT
log4j.appender.console.type = Console
log4j.appender.console.layout.type = PatternLayout
log4j.appender.console.layout.pattern = %msg%n