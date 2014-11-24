import com.zaxxer.hikari.HikariDataSource
import grails.util.Environment

// Place your Spring DSL code here
beans = {
    switch(Environment.current) {
        case Environment.DEVELOPMENT :
            break
        case Environment.TEST:
            if(System.getProperty("test.in.memory")) break
        default :
            if(System.env.DB == "mysql") {
                dataSource(HikariDataSource) { bean ->
                    bean.destroyMethod = "close"
                    driverClassName = "com.mysql.jdbc.Driver"
                    URI uri = new URI(System.env.DATABASE_URL ?: "mysql://root:root@localhost:3306/portek_hr")
                    String urlString = "jdbc:mysql://"+uri.host+uri.path
                    urlString += "?cachePrepStmts=true&prepStmtCacheSize=250&prepStmtCacheSqlLimit=2048"
                    urlString += "&useServerPrepStmts=true"
                    jdbcUrl = urlString
                    username = uri.userInfo.split(":")[0]
                    password = uri.userInfo.split(":")[1]
                    maximumPoolSize = 10
                    initializationFailFast="true"
                }
            } else {
                dataSource(HikariDataSource) { bean ->
                    bean.destroyMethod = "close"
                    driverClassName = "org.postgresql.Driver"
                    URI uri = new URI(System.env.DATABASE_URL ?: "postgres://postgres:root@localhost:5432/portek_hr")
                    jdbcUrl = "jdbc:postgresql://"+uri.host+uri.path
                    username = uri.userInfo.split(":")[0]
                    password = uri.userInfo.split(":")[1]
                    maximumPoolSize = 17
                    initializationFailFast="true"
                }
            }
    }
}
